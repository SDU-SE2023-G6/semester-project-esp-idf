package dk.sdu.snem;

import com.mongodb.lang.NonNull;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.servers.Server;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import java.util.Arrays;
import org.bson.types.ObjectId;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.format.FormatterRegistry;
import org.springframework.integration.annotation.IntegrationComponentScan;
import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.mqtt.core.DefaultMqttPahoClientFactory;
import org.springframework.integration.mqtt.inbound.MqttPahoMessageDrivenChannelAdapter;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;
import org.springframework.data.mongodb.core.mapping.event.ValidatingMongoEventListener;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.messaging.MessageChannel;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.mqtt.support.DefaultPahoMessageConverter;

/** Misc. configuration of the application. */
@Configuration
@EnableAsync
@EnableMongoAuditing
@OpenAPIDefinition
public class ApplicationConfig implements WebMvcConfigurer {

  private final MongoDatabaseFactory databaseFactory;
  private final MappingMongoConverter mongoConverter;

  public ApplicationConfig(MongoDatabaseFactory databaseFactory, MappingMongoConverter mongoConverter) {
    this.databaseFactory = databaseFactory;
    this.mongoConverter = mongoConverter;
  }


  @Override
  public void addFormatters(FormatterRegistry registry) {
    registry.addConverter(new Formatters.StringToObjectIdConverter());
    registry.addConverter(new Formatters.StringToObjectIdArrayConverter());
  }

  @Override
  public void addCorsMappings(CorsRegistry registry) {
    registry.addMapping("/**")  // Allow CORS for all endpoints
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


}
