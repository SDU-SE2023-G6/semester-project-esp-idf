package dk.sdu.snem;

import dk.sdu.snem.core.CompilerService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PreCompileConfig {
  private final CompilerService compilerService;

  public PreCompileConfig(CompilerService compilerService) {
    this.compilerService = compilerService;
  }

  @Bean
  public byte[] initialDeviceImage(){
      return null;
  }
}
