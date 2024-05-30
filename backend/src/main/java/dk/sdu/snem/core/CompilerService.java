package dk.sdu.snem.core;

import static dk.sdu.snem.core.model.Program.ProgramStatus.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import dk.sdu.snem.core.model.Binary;
import dk.sdu.snem.core.model.DeviceType;
import dk.sdu.snem.core.model.Program;
import dk.sdu.snem.core.model.ReaderFunction;
import dk.sdu.snem.core.repo.BinaryRepository;
import dk.sdu.snem.core.repo.DeviceTypeRepository;
import dk.sdu.snem.core.repo.ProgramRepository;
import dk.sdu.snem.core.repo.ReaderFunctionRepository;
import dk.sdu.snem.core.serialization.DeviceTypeMetadata;
import dk.sdu.snem.core.serialization.GeneratedCodeMetadata;
import dk.sdu.snem.core.serialization.SensorInstantiationMetadata;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.Instant;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Stream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import org.apache.commons.lang3.NotImplementedException;
import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
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
  private static final Logger log = LoggerFactory.getLogger(CompilerService.class);
  private final RestTemplate restTemplate;
  private final ProgramRepository programRepo;
  private final DeviceTypeRepository deviceTypeRepo;
  private final BinaryRepository binaryRepo;
  private final ObjectMapper objectMapper;
  private final ReaderFunctionRepository readerRepo;
  private final String compilerFolder;

  /** Base compiler project. */
  private final String baseCompilerProjectFolder;

  /** Where to insert generated files into the base compiler project. */
  private final String codeInsertionLocation;
  /** Where to store the first build at (used for fast later builds) */
  private final String prebuildCompileFolder;

  private final String xtextHost;
  private final CompilerService asyncSelf;
  private final Map<String, String> compilerEnvironmentVariables;

  public CompilerService(
      RestTemplate restTemplate,
      ProgramRepository programRepo,
      DeviceTypeRepository deviceTypeRepo,
      BinaryRepository binaryRepo,
      ObjectMapper objectMapper,
      ReaderFunctionRepository readerRepo,
      @Value("${compiler.folder}") String compilerFolder,
      @Value("${compiler.project.location}") String baseCompilerProjectFolder,
      @Value("${compiler.project.insert}") String codeInsertionLocation,
      @Value("${compiler.project.prebuild.location}") String prebuildCompileFolder,
      @Value("${compiler.xtext.host}") String xtextHost,
      @Lazy CompilerService asyncSelf,
      @Value("${external.server.url}") String externalServerUrl,
      @Value("${external.broker.url}") String externalBrokerUrl,
      @Value("${external.firmware.upgrade.url}") String externalFirmwareUpgradeUrl) {
    this.restTemplate = restTemplate;
    this.programRepo = programRepo;
    this.deviceTypeRepo = deviceTypeRepo;
    this.binaryRepo = binaryRepo;
    this.objectMapper = objectMapper;
    this.readerRepo = readerRepo;
    this.compilerFolder = compilerFolder;
    this.codeInsertionLocation = codeInsertionLocation;
    this.xtextHost = xtextHost;
    this.asyncSelf = asyncSelf;
    this.prebuildCompileFolder = prebuildCompileFolder;
    this.baseCompilerProjectFolder = baseCompilerProjectFolder;
    this.compilerEnvironmentVariables = Map.of(
        "EXAMPLE_FIRMWARE_UPGRADE_URL", externalFirmwareUpgradeUrl,
        "BROKER_URL", externalServerUrl,
        "SERVER_URL", externalBrokerUrl
    );
  }

  public static void compile(String directory, Map<String, String> environmentVariables) throws IOException, InterruptedException {
    ProcessBuilder processBuilder = new ProcessBuilder(List.of("./auto-build.sh"));
    processBuilder.environment().putAll(environmentVariables);
    processBuilder.directory(new File(directory));
    Process process;
    try {
      process = processBuilder.start();
    } catch (Exception e) {
      e.printStackTrace();
      throw e;
    }

    BufferedReader outputReader =
        new BufferedReader(new InputStreamReader(process.getInputStream()));
    String line;
    while ((line = outputReader.readLine()) != null) {
      log.info(line);
    }

    BufferedReader errorReader =
        new BufferedReader(new InputStreamReader(process.getErrorStream()));
    while ((line = errorReader.readLine()) != null) {
      log.info(line);
    }

    int exitCode = process.waitFor();
    log.info("Compiling completed");

    if (exitCode != 0) {
      throw new RuntimeException("Program failed unexpectedly");
    }
  }

  private static void copyFolderAndContents(File source, File destination) throws IOException {
    if (source.isDirectory()) {
      if (!destination.exists()) {
        destination.mkdirs();
      }

      String[] files = source.list();
      if (files == null) {
        return;
      }
      for (String file : files) {
        File srcFile = new File(source, file);
        File destFile = new File(destination, file);
        copyFolderAndContents(srcFile, destFile);
      }
    } else {
      if (!destination.getParentFile().exists()) {
        destination.getParentFile().mkdirs();
      }
      Files.copy(source.toPath(), destination.toPath(), StandardCopyOption.REPLACE_EXISTING);
    }
  }

  private static TargetFilesAndReaders extractTargetFilesAndReaders(
      GeneratedCodeMetadata metadata, DeviceTypeMetadata target) {
    Set<String> targetFiles =
        new HashSet<>(
            List.of(
                "shared_snem_library.c",
                "shared_snem_library.h",
                target.getName() + "_device_type.c",
                target.getName() + "_device_type.h"));

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
                  return Stream.of(x.getName() + "_sensor.c", x.getName() + "_sensor.h");
                })
            .toList());

    return new TargetFilesAndReaders(targetFiles, readers);
  }

  private static String bytesToSha256Hash(byte[] bytes) {
    MessageDigest digest;
    try {
      digest = MessageDigest.getInstance("SHA-256");
    } catch (NoSuchAlgorithmException e) {
      throw new RuntimeException(e);
    }

    digest.update(bytes);
    byte[] hash = digest.digest();

    StringBuilder hexString = new StringBuilder();
    for (byte b : hash) {
      String hex = Integer.toHexString(0xff & b);
      if (hex.length() == 1) hexString.append('0');
      hexString.append(hex);
    }

    return hexString.toString();
  }

  @Async
  public void compileProgramSafely(Program programInput) {
    Program program = new Program();
    program.setDslCode(programInput.getDslCode());
    program.setIteration(program.getIteration() + 1);
    program.setStatus(GENERATING_CODE);
    programRepo.save(program);

    final byte[] generatedZipFile;
    try {
      generatedZipFile = generateCodeFromDsl(program.getDslCode());
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
            .map(x -> asyncSelf.compileBinary(program, generatedZipFile, metadata, x))
            .toList();

    try {
      CompletableFuture.allOf(compileFutures.toArray(new CompletableFuture[0])).get();
    } catch (InterruptedException | ExecutionException e) {
      program.setStatus(ERROR_COMPILING_BINARIES);
      programRepo.save(program);
      return;
    }

    program.setCompiled(Instant.now());
    program.setStatus(COMPILED_COMPLETELY);
    programRepo.save(program);
  }

  @Async
  public void compileProgramDestructively(Program program) {
    if (program.getStatus() != CODE_GENERATED_REQUIRES_OVERRIDE) {
      throw new RuntimeException("Can't override when not required.");
    }
    throw new NotImplementedException("Override not yet implemented.");
  }

  @Async
  public CompletableFuture<Void> compileBinary(
      Program program,
      byte[] codeGeneratedZipFile,
      GeneratedCodeMetadata metadata,
      DeviceTypeMetadata target) {
    final DeviceType deviceType =
        deviceTypeRepo
            .findByName(target.getName())
            .orElseGet(
                () -> {
                  var newDeviceType = new DeviceType();
                  newDeviceType.setName(target.getName());
                  deviceTypeRepo.save(newDeviceType);
                  return newDeviceType;
                });

    final Binary binary = new Binary();
    binary.setId(ObjectId.get());
    binary.setProgram(program);
    binary.setDeviceType(deviceType);
    log.info("Starting compile with id %s".formatted(binary.getId().toHexString()));

    Optional<Binary> oldBinary =
        binaryRepo.findFirstByDeviceTypeAndWithdrawnOrderByCompilationTimeDesc(deviceType, false);
    oldBinary.ifPresent(value -> binary.setVersion(value.getVersion() + 1));

    TargetFilesAndReaders targets = extractTargetFilesAndReaders(metadata, target);
    List<ReaderFunction> readers = readerRepo.findByNameIn(targets.readers());
    if (readers.size() != targets.readers().size()) {
      log.warn("Failed to find all readers");
      return CompletableFuture.failedFuture(new RuntimeException("Unable to find reader function"));
    } else {
      log.info("Writing %d readers: %s".formatted(
        readers.size(),
        readers.stream().map(ReaderFunction::getName).toList()
        ));
    }

    File baseProjectFolder = new File(baseCompilerProjectFolder);
    boolean baseProjectExists =
        baseProjectFolder.exists() && baseProjectFolder.isDirectory();
    final String destinationFolder = compilerFolder + binary.getId().toHexString();
    final File destFolder = new File(destinationFolder);
    final String generatedCodeInsertFolder =
        baseProjectExists
            ? destinationFolder + codeInsertionLocation
            : destinationFolder;
    if (baseProjectExists) {
      try {
        copyFolderAndContents(new File(baseCompilerProjectFolder), destFolder);
      } catch (IOException e) {
        log.warn(
            "Failed to copy base compiler project at %s destination is %s"
                .formatted(baseCompilerProjectFolder, destinationFolder));
        FileSystemUtils.deleteRecursively(destFolder);
        return CompletableFuture.failedFuture(e);
      }
    }

    int filesFound =
        extractFilesToFolder(
            codeGeneratedZipFile, targets.files.stream().toList(), generatedCodeInsertFolder);
    if (filesFound != targets.files().size()) {
      log.warn("Failed to find required files");
      return CompletableFuture.failedFuture(
          new RuntimeException("Was unable to find all expected files"));
    }

    int readersFound = readers.stream().map(x ->
            extractFilesToFolder(
                x.getSourceFiles(),
                List.of(x.getName() + "_reader.h", x.getName() + "_reader.c"),
                generatedCodeInsertFolder))
      .reduce(0, Integer::sum);
    if (readersFound != readers.size() * 2) {
      log.warn("Failed to find all reader files");
      return CompletableFuture.failedFuture(
          new RuntimeException("Was unable to find all reader files"));
    }

    try {
      log.info("Starting compile of C code");
      compile(destinationFolder, compilerEnvironmentVariables);
    } catch (IOException | InterruptedException | RuntimeException e) {
      log.error("Compiling failed", e);
      //FileSystemUtils.deleteRecursively(destFolder);
      return CompletableFuture.failedFuture(e);
    }

    try {
      byte[] compiledBinary =
          Files.readAllBytes(Paths.get(destinationFolder + "/build/ESP-OTA-MQTT.bin"));
      binary.setCompiledBinary(compiledBinary);
      binary.setBinaryHash(bytesToSha256Hash(compiledBinary));
    } catch (IOException e) {
      log.error("Locating compiled binary failed", e);
      FileSystemUtils.deleteRecursively(destFolder);
      return CompletableFuture.failedFuture(e);
    }

    FileSystemUtils.deleteRecursively(destFolder);

    binary.setCompilationTime(Instant.now());
    binaryRepo.save(binary);
    deviceType.setBinary(binary);
    deviceTypeRepo.save(deviceType);

    return CompletableFuture.completedFuture(null);
  }

  public byte[] compileBaseProject() {
    ObjectId id = ObjectId.get();
    log.info("Starting base compile with id %s".formatted(id.toHexString()));

    File baseCompilerProjectFolderFile = new File(baseCompilerProjectFolder);
    boolean baseProjectExists =
        baseCompilerProjectFolderFile.exists() && baseCompilerProjectFolderFile.isDirectory();
    final File destFolder = new File(prebuildCompileFolder);
    if (baseProjectExists) {
      try {

        FileSystemUtils.deleteRecursively(destFolder);
        copyFolderAndContents(new File(baseCompilerProjectFolder), destFolder);
      } catch (IOException e) {
        log.warn(
            "Failed to copy base compiler project at %s destination is %s"
                .formatted(baseCompilerProjectFolder, prebuildCompileFolder));
        FileSystemUtils.deleteRecursively(destFolder);
        throw new RuntimeException(e);
      }
    } else {
      throw new RuntimeException("Base compiler project does not exist");
    }

    try {
      log.info("Starting compile of C code");
      compile(prebuildCompileFolder, compilerEnvironmentVariables);
    } catch (IOException | InterruptedException | RuntimeException e) {
      log.error("Compiling failed", e);
      FileSystemUtils.deleteRecursively(destFolder);
      throw new RuntimeException(e);
    }

    byte[] compiledBinary;
    try {
      compiledBinary =
          Files.readAllBytes(Paths.get(prebuildCompileFolder + "/build/ESP-OTA-MQTT.bin"));
    } catch (IOException e) {
      log.error("Locating compiled binary failed", e);
      FileSystemUtils.deleteRecursively(destFolder);
      throw new RuntimeException(e);
    }


    log.info("Base compile completed");
    return compiledBinary;
  }

  private int extractFilesToFolder(
      byte[] codeGeneratedZipFile, List<String> fileNames, String destinationFolder) {
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

  private byte[] generateCodeFromDsl(String dslContent) {
    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.TEXT_PLAIN);

    HttpEntity<String> requestEntity = new HttpEntity<>(dslContent, headers);

    ResponseEntity<byte[]> responseEntity =
        restTemplate.exchange(
            "http://" + xtextHost + ":8081/generate-code",
            HttpMethod.POST,
            requestEntity,
            byte[].class);

    if (responseEntity.getStatusCode() == HttpStatus.OK) {
      return responseEntity.getBody();
    } else {
      // Handle error cases
      return null;
    }
  }

  record TargetFilesAndReaders(Set<String> files, Set<String> readers) {}
}
