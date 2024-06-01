package dk.sdu.snem;

import com.mongodb.lang.NonNull;
import dk.sdu.snem.core.CoreController;
import dk.sdu.snem.core.model.Program;
import dk.sdu.snem.core.model.ReaderFunction;
import dk.sdu.snem.core.repo.ProgramRepository;
import dk.sdu.snem.core.repo.ReaderFunctionRepository;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;
import org.springframework.data.mongodb.core.mapping.event.ValidatingMongoEventListener;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.format.FormatterRegistry;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/** Misc. configuration of the application. */
@Configuration
@EnableAsync
@EnableMongoAuditing
@OpenAPIDefinition
public class ApplicationConfig implements WebMvcConfigurer {
  private static final Logger logger = LoggerFactory.getLogger(ApplicationConfig.class);


  private final MongoDatabaseFactory databaseFactory;
  private final MappingMongoConverter mongoConverter;
  private final ReaderFunctionRepository readerFunctionRepo;
  private final ProgramRepository programRepo;

  public ApplicationConfig(
      MongoDatabaseFactory databaseFactory,
      MappingMongoConverter mongoConverter,
      ReaderFunctionRepository readerFunctionRepo, ProgramRepository programRepo) {
    this.databaseFactory = databaseFactory;
    this.mongoConverter = mongoConverter;
    this.readerFunctionRepo = readerFunctionRepo;
    this.programRepo = programRepo;
  }

  @Bean
  CommandLineRunner defaultReaderSeeder() {
    return args -> {

      PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
      try {
        logger.info("Finding default reader functions");
        Resource[] directories = resolver.getResources("classpath:/sampleReaders/*");
        if (directories.length == 0) {
          logger.warn("Found no default reader functions");
        }
        for (Resource directory : directories) {

          ReaderFunction readerFunction =
              readerFunctionRepo
                  .findByName(directory.getFilename())
                  .orElseGet(
                      () -> {
                        var function = new ReaderFunction();
                        function.setName(directory.getFilename());
                        return readerFunctionRepo.save(function);
                      });
          logger.info("Saving reader function %s".formatted(readerFunction.getName()));
          Resource[] files =
              resolver.getResources("classpath:/sampleReaders/" + directory.getFilename() + "/*");
          byte[] allFilesAsZip = zipFiles(files);
          readerFunction.setSourceFiles(allFilesAsZip);
          readerFunctionRepo.save(readerFunction);
        }
        logger.info("Done searching for reader functions");
      } catch (IOException e) {
        logger.error("Failure reading reader functions", e);
      }
    };
  }

  @Bean
  public RestTemplate restTemplate() {
    return new RestTemplate();
  }

  @Override
  public void addFormatters(FormatterRegistry registry) {
    registry.addConverter(new Formatters.StringToObjectIdConverter());
    registry.addConverter(new Formatters.StringToObjectIdArrayConverter());
  }

  @Override
  public void addCorsMappings(CorsRegistry registry) {
    registry
        .addMapping("/**") // Allow CORS for all endpoints
        .allowedOrigins("*") // Allow requests from any origin
        .allowedMethods("*") // Allow all HTTP methods
        .allowedHeaders("*"); // Allow all headers
  }

  @Bean
  public ValidatingMongoEventListener validatingMongoEventListener() {
    return new ValidatingMongoEventListener(validator());
  }

  @Bean
  public LocalValidatorFactoryBean validator() {
    return new LocalValidatorFactoryBean();
  }

  @Bean
  public GridFsTemplate gridFsTemplate() throws Exception {
    return new GridFsTemplate(databaseFactory, mongoConverter);
  }

  @Bean
  public OpenAPI baseOpenAPI() {
    return new OpenAPI()
        .info(
            new Info()
                .title("SNEM API")
                .version("1.0.0")
                .description("Documentation for SNEM API."));
  }

  /** Contains various formatters and converters. */
  public static class Formatters {
    /** Convert hex-string to ObjectId. */
    public static class StringToObjectIdConverter implements Converter<String, ObjectId> {
      /**
       * Convert hex-string to object id.
       *
       * @param source hex-string
       * @return object id
       */
      @Override
      public ObjectId convert(@NonNull String source) {
        try {
          return new ObjectId(source);
        } catch (Exception e) {
          // Likely IllegalArgumentException due to string not being a hex-string
          throw new IllegalArgumentException(e.getMessage());
        }
      }
    }

    /** Convert hex-string list to ObjectId list. */
    public static class StringToObjectIdArrayConverter implements Converter<String[], ObjectId[]> {
      /**
       * Convert hex-string to object id.
       *
       * @param source hex-string
       * @return object id
       */
      @Override
      public ObjectId[] convert(@NonNull String[] source) {
        try {
          return Arrays.stream(source).map(ObjectId::new).toArray(ObjectId[]::new);
        } catch (Exception e) {
          // Likely IllegalArgumentException due to string not being a hex-string
          throw new IllegalArgumentException(e.getMessage());
        }
      }
    }
  }

  private byte[] zipFiles(Resource[] files) throws IOException {
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    try (ZipOutputStream zos = new ZipOutputStream(baos)) {
      for (Resource file : files) {
        if (file.isReadable() && file.isFile()) {
          ZipEntry zipEntry = new ZipEntry(Objects.requireNonNull(file.getFilename()));
          zos.putNextEntry(zipEntry);
          zos.write(file.getInputStream().readAllBytes());
          zos.closeEntry();
        }
      }
    }
    return baos.toByteArray();
  }
}
