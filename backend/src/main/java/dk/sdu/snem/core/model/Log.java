package dk.sdu.snem.core.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.Instant;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Document
@NoArgsConstructor
@Data
public class Log {
  private @MongoId ObjectId id;
  private @NotNull Instant timestamp;
  private @Nullable String message;
  private @Nullable ObjectId satellite;

  private @NotNull LogType type = LogType.UNSPECIFIED;

  @Getter
  @Schema(enumAsRef = true)
  public enum LogType {
    UNSPECIFIED("UNSPECIFIED"),
    INFO("INFO"),
    WARNING("WARNING"),
    HEARTBEAT("HEARTBEAT");
    private final String stringValue;

    LogType(String stringValue) {
      this.stringValue = stringValue;
    }
  }
}
