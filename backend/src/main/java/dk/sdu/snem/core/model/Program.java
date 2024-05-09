package dk.sdu.snem.core.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.Binary;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Document
@NoArgsConstructor
@Data
public class Program {

  private @MongoId ObjectId id;

  private @NotBlank String name;

  private @Nullable String dslCode;
  private @Nullable String cCode;
  private @Nullable Binary[] compiledBinary;
  private @Nullable String binaryHash;

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
