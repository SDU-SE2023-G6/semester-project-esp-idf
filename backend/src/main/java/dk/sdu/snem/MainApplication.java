package dk.sdu.snem;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/** Application entrypoint. */
@SpringBootApplication
@OpenAPIDefinition(
    servers = @Server(url = "${server.servlet.contextPath}", description = "Default Server URL"))
public class MainApplication {

  public static void main(String[] args) {
    SpringApplication.run(MainApplication.class, args);
  }
}
