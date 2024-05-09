package dk.sdu.snem.core;

import static dk.sdu.snem.core.model.Program.ProgramStatus.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import dk.sdu.snem.core.model.Binary;
import dk.sdu.snem.core.model.DeviceType;
import dk.sdu.snem.core.model.Program;
import dk.sdu.snem.core.model.ReaderFunction;
import dk.sdu.snem.core.serialization.DeviceTypeMetadata;
import dk.sdu.snem.core.serialization.GeneratedCodeMetadata;
import dk.sdu.snem.core.serialization.SensorInstantiationMetadata;
import dk.sdu.snem.core.repo.BinaryRepository;
import dk.sdu.snem.core.repo.DeviceTypeRepository;
import dk.sdu.snem.core.repo.ProgramRepository;
import dk.sdu.snem.core.repo.ReaderFunctionRepository;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Instant;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Stream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.client.RestTemplate;

@Service
public class CompilerService {

  private final RestTemplate restTemplate;
  private final ProgramRepository programRepo;
  private final DeviceTypeRepository deviceTypeRepo;
  private final BinaryRepository binaryRepo;
  private final ObjectMapper objectMapper;
  private final ReaderFunctionRepository readerRepo;
  private final String compilerFolder;
  private final String xtextHost;

  public CompilerService(
      RestTemplate restTemplate,
      ProgramRepository programRepo,
      DeviceTypeRepository deviceTypeRepo,
      BinaryRepository binaryRepo,
      ObjectMapper objectMapper, ReaderFunctionRepository readerRepo,
      @Value("${compiler.folder}") String compilerFolder,
      @Value("${compiler.xtext.host}") String xtextHost
      ) {
    this.restTemplate = restTemplate;
    this.programRepo = programRepo;
    this.deviceTypeRepo = deviceTypeRepo;
    this.binaryRepo = binaryRepo;
    this.objectMapper = objectMapper;
    this.readerRepo = readerRepo;
    this.compilerFolder = compilerFolder;
    this.xtextHost = xtextHost;
  }

  @Async
  public void compileProgramSafely(Program program) {
    program.setStatus(GENERATING_CODE);
    programRepo.save(program);

    final byte[] generatedZipFile;
    try {
      generatedZipFile = generateCodeFromDSL(program.getDslCode());
    } catch (Exception e) {
      program.setStatus(ERROR_GENERATING_CODE);
      programRepo.save(program);
      return;
    }
    program.setGeneratedCodeAsZipFile(generatedZipFile);

    final GeneratedCodeMetadata metadata = getGeneratedCodeMetadata(generatedZipFile);
    program.setGeneratedCodeMetadata(metadata);
    // TODO: 5/9/24 Depending on generated code metadata require manual override

    if (metadata == null || metadata.getDeviceTypes() == null) {
      program.setStatus(ERROR_GENERATING_CODE);
      programRepo.save(program);
      return;
    }

    program.setStatus(CODE_GENERATED);
    programRepo.save(program);

    program.setStatus(COMPILING_BINARIES);
    programRepo.save(program);
    List<CompletableFuture<Void>> compileFutures =
        metadata.getDeviceTypes().stream()
            .map(x -> compileBinary(program, generatedZipFile, metadata, x))
            .toList();

    try {
      CompletableFuture.allOf(compileFutures.toArray(new CompletableFuture[0])).get();
    } catch (InterruptedException | ExecutionException e) {
      program.setStatus(ERROR_COMPILING_BINARIES);
      programRepo.save(program);
      return;
    }

    program.setLastCompiled(Instant.now());
    program.setDslCodeCompiled(program.getDslCode());
    program.setStatus(COMPILED_COMPLETELY);
    programRepo.save(program);
  }

  @Async
  public void compileProgramDestructively(Program program) {
    if (program.getStatus() != CODE_GENERATED_REQUIRES_OVERRIDE) {
      throw new RuntimeException("Can't override when not required.");
    }
  }

  private CompletableFuture<Void> compileBinary(
      Program program,
    byte[] codeGeneratedZipFile, GeneratedCodeMetadata metadata, DeviceTypeMetadata target) {

    DeviceType deviceType =
        deviceTypeRepo
            .findByName(target.getName())
            .orElseGet(
                () -> {
                  var newDeviceType = new DeviceType();
                  newDeviceType.setName(target.getName());
                  deviceTypeRepo.save(newDeviceType);
                  return newDeviceType;
                });

    Binary binary = new Binary();
    binary.setId(ObjectId.get());
    binary.setProgram(program);
    binary.setDeviceType(deviceType);

    Optional<Binary> oldBinary = binaryRepo.findFirstByDeviceTypeAndWithdrawnOrderByCompilationTimeDesc(deviceType, false);
    oldBinary.ifPresent(value -> binary.setVersion(value.getVersion() + 1));


    TargetFilesAndReaders targets = extractTargetFilesAndReaders(metadata, target);
    List<ReaderFunction> readers = readerRepo.findByNameIn(targets.readers());
    if (readers.size() != targets.readers().size()) {
      return CompletableFuture.failedFuture(new RuntimeException("Unable to find reader function"));
    }


    String destinationFolder = compilerFolder+binary.getId().toHexString();
    int filesFound = extractFilesToFolder(codeGeneratedZipFile, targets.files.stream().toList(), destinationFolder);
    if (filesFound != targets.files().size()) {
      return CompletableFuture.failedFuture(new RuntimeException("Was unable to find all expected files"));
    }
    readers.forEach(x -> extractFilesToFolder(x.getSourceFiles(), List.of(
        x.getName()+"_reader.h",
        x.getName()+"_reader.c"
    ), destinationFolder));



    try {
      compile(destinationFolder, deviceType.getName()+"_build.mk");
    } catch (IOException | InterruptedException | RuntimeException e) {
      File folderToDelete = new File(destinationFolder);
      FileSystemUtils.deleteRecursively(folderToDelete);
      return CompletableFuture.failedFuture(e);
    }

    try {
      byte[] compiledLibrary = Files.readAllBytes(Paths.get(destinationFolder+"/build/"+deviceType.getName()+"_device.so"));
      binary.setCompiledBinary(compiledLibrary);
    } catch (IOException e) {
      return CompletableFuture.failedFuture(e);
    }


    File folderToDelete = new File(destinationFolder);
    FileSystemUtils.deleteRecursively(folderToDelete);

    binary.setCompilationTime(Instant.now());
    binaryRepo.save(binary);
    deviceType.setBinary(binary);
    deviceTypeRepo.save(deviceType);

    return CompletableFuture.completedFuture(null);
  }

  public static void compile(String directory, String targetMakefile) throws IOException, InterruptedException {
    ProcessBuilder processBuilder = new ProcessBuilder(List.of("make", "-f", targetMakefile));
    processBuilder.directory(new File(directory));
    Process process = processBuilder.start();

    BufferedReader outputReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
    String line;
    while ((line = outputReader.readLine()) != null) {
      System.out.println(line); // Print compiler output
    }

    BufferedReader errorReader = new BufferedReader(new InputStreamReader(process.getErrorStream()));
    while ((line = errorReader.readLine()) != null) {
      System.err.println("Error: " + line); // Print compilation errors
    }

    int exitCode = process.waitFor();

    if (exitCode == 0) {
      System.out.println("C program compiled successfully!");
    } else {
      throw new RuntimeException("Program failed unexpectedly");
    }
  }

  private static TargetFilesAndReaders extractTargetFilesAndReaders(GeneratedCodeMetadata metadata, DeviceTypeMetadata target) {
    Set<String> targetFiles = new HashSet<>(List.of(
        "shared_snem_library.c",
        "shared_snem_library.h",
        target.getName() + "_device_type.c",
        target.getName() + "_device_type.h",
        target.getName() + "_build.mk"
        ));

    Set<String> readers = new HashSet<>();
    targetFiles.addAll(
        target.getSensors().stream()
            .map(SensorInstantiationMetadata::getSensor)
            .map(
                instance ->
                    metadata.getSensors().stream()
                        .filter(x -> x.getName().equals(instance))
                        .findFirst())
            .filter(Optional::isPresent)
            .map(Optional::get)
            .flatMap(
                x -> {
                  readers.add(x.getReader());
                  return Stream.of(
                      x.getName() + "_sensor.c",
                      x.getName() + "_sensor.h");
                })
            .toList());

    return new TargetFilesAndReaders(targetFiles, readers);
  }

  private int extractFilesToFolder(byte[] codeGeneratedZipFile, List<String> fileNames, String destinationFolder) {
    try {
      ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(codeGeneratedZipFile);
      ZipInputStream zipInputStream = new ZipInputStream(byteArrayInputStream);

      int filesFound = 0;
      ZipEntry entry;
      while ((entry = zipInputStream.getNextEntry()) != null) {
        for (String fileName : fileNames) {
          if (fileName.equals(entry.getName())) {
            filesFound++;
            File outputFile = new File(destinationFolder, entry.getName());
            outputFile.getParentFile().mkdirs();

            // Write entry to output file
            FileOutputStream fos = new FileOutputStream(outputFile);
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = zipInputStream.read(buffer)) != -1) {
              fos.write(buffer, 0, bytesRead);
            }
            fos.close();
            zipInputStream.closeEntry();
          }
        }
      }

      zipInputStream.close();
      return filesFound;
    } catch (IOException e) {
      e.printStackTrace();
    }
    return 0;
  }


  private GeneratedCodeMetadata getGeneratedCodeMetadata(byte[] codeGeneratedZipFile) {
    try {
      ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(codeGeneratedZipFile);
      ZipInputStream zipInputStream = new ZipInputStream(byteArrayInputStream);

      ZipEntry entry;
      while ((entry = zipInputStream.getNextEntry()) != null) {
        if ("output.json".equals(entry.getName())) {
          StringBuilder stringBuilder = new StringBuilder();
          byte[] buffer = new byte[1024];
          int bytesRead;
          while ((bytesRead = zipInputStream.read(buffer)) != -1) {
            stringBuilder.append(new String(buffer, 0, bytesRead));
          }

          String value = stringBuilder.toString();

          GeneratedCodeMetadata metadata =
              objectMapper.readValue(value, GeneratedCodeMetadata.class);
          zipInputStream.close();
          return metadata;
        }
      }

      zipInputStream.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return null;
  }

  private byte[] generateCodeFromDSL(String dslContent) {
    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.TEXT_PLAIN);

    HttpEntity<String> requestEntity = new HttpEntity<>(dslContent, headers);

    ResponseEntity<byte[]> responseEntity =
        restTemplate.exchange(
            "http://"+xtextHost+":8081/generate-code", HttpMethod.POST, requestEntity, byte[].class);

    if (responseEntity.getStatusCode() == HttpStatus.OK) {
      return responseEntity.getBody();
    } else {
      // Handle error cases
      return null;
    }
  }

  record TargetFilesAndReaders(Set<String> files, Set<String> readers) {}

}
