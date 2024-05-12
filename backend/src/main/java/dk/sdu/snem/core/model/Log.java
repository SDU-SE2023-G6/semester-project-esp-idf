package dk.sdu.snem.core.model;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.models.security.SecurityScheme;
import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.Instant;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Document
@NoArgsConstructor
@Data
public class Log {
  private @MongoId ObjectId id;
  private @Indexed @NotNull Instant timestamp;
  private @Nullable String message;
  @DocumentReference(lazy = true)
  private @Indexed @Nullable Satellite satellite;

  private @Indexed @NotNull LogType type = LogType.UNSPECIFIED;

  @Getter
  @Schema(enumAsRef = true)
  public enum LogType {
    UNSPECIFIED("UNSPECIFIED"),
    ERROR("ERROR"),
    INFO("INFO"),
    WARNING("WARNING"),
    HEARTBEAT("HEARTBEAT"),
    UPDATE_DOWNLOAD_START("UPDATE_DOWNLOAD_START"),
    UPDATE_DOWNLOAD_COMPLETE("UPDATE_DOWNLOAD_COMPLETE"),
    UPDATE_START("UPDATE_START"),
    UPDATE_COMPLETE("UPDATE_COMPLETE"),
    UPDATE_SUCCESS("UPDATE_SUCCESS"),
    UPDATE_FAIL("UPDATE_FAIL"),
    UPDATE_ROLLBACK_START("UPDATE_ROLLBACK_START"),
    UPDATE_ROLLBACK_SUCCESS("UPDATE_ROLLBACK_SUCCESS"),
    UPDATE_ROLLBACK_FAIL("UPDATE_ROLLBACK_FAIL");

    private final String stringValue;

    LogType(String stringValue) {
      this.stringValue = stringValue;
    }
  }
}
