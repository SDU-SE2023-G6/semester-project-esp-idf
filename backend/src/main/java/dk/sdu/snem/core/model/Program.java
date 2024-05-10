package dk.sdu.snem.core.model;

import dk.sdu.snem.core.serialization.GeneratedCodeMetadata;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotNull;
import java.time.Instant;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Document
@NoArgsConstructor
@Data
public class Program {
  private @MongoId ObjectId id;
  private @NotNull String dslCode = defaultStartDslCode;
  /** Last compiled DSL code */
  private @Nullable String dslCodeCompiled;
  /** Code and metadata generated from DSL as zip file. */
  private @Nullable byte[] generatedCodeAsZipFile;
  /** Metadata from code generation. */
  private @Nullable GeneratedCodeMetadata generatedCodeMetadata;
  private @NotNull ProgramStatus status = ProgramStatus.UNCHANGED;
  private @Nullable Instant lastCompiled;

  /** Version used for concurrency validation. */
  private @Version Long version;
  private @CreatedDate Instant createdDate;
  private @LastModifiedDate Instant lastModifiedDate;

  @Getter
  @Schema(enumAsRef = true)
  public enum ProgramStatus {
    UNCHANGED("UNCHANGED"),
    CHANGED("CHANGED"),
    GENERATING_CODE("GENERATING_CODE"),
    ERROR_GENERATING_CODE("ERROR_GENERATING_CODE"),
    CODE_GENERATED("CODE_GENERATED"),
    CODE_GENERATED_REQUIRES_OVERRIDE("CODE_GENERATED_REQUIRES_OVERRIDE"),
    COMPILING_BINARIES("COMPILING_BINARIES"),
    ERROR_COMPILING_BINARIES("ERROR_COMPILING_BINARIES"),
    COMPILED_COMPLETELY("COMPILED"),
    ERROR_UNEXPECTED("ERROR_UNEXPECTED");
    private final String val;

    ProgramStatus(String val) {
      this.val = val;
    }
  }

  public void setDslCode(@NotNull String dslCode) {
    this.status = ProgramStatus.CHANGED;
    this.dslCode = dslCode;
  }


  static String defaultStartDslCode = """
sensor DHT11 {
	units: C, A
	reader: dht11Reader
	pins: data, ref
	out: temp, humidity
	
}

sensor light {
	units: Lux
	reader: lightResReader
	pins: pin
	out: value
}


deviceType HTL {
	DHT11 outside {
		pins: 1, 2
		(temp > 20) {
			samplingRate: 2s
		}
	}
	light top {
		pins: 3
		samplingRate: 2s
		
		(value > 20) {
			samplingRate: 2s
		}
		
		(outside.temp = 90.0) {
			samplingRate: 4d
		}
		
		(((outside.temp = 90.12) AND (value > 200)) OR ((outside.temp = 90.0) AND (value > 20))) {
			samplingRate: 4d
		}
		
	}
	
	heartBeatPolicy: 10s
	
}
  """;

  /*
  private CompilationState compileState = CompilationState.NOT_STARTED;
  private String compileLog;

  @Schema(enumAsRef = true)
  public enum CompilationState {
    NOT_STARTED,
    COMPILING,
    ERROR,
    FINISHED
  }
   */

}
