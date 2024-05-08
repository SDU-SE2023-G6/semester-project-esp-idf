package dk.sdu.snem.core.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Document
@NoArgsConstructor
@Data
public class Satellite {
  private @MongoId ObjectId id;
  private @NotBlank String name;

  @DocumentReference
  private  @Indexed @Nullable Area area;
  @DocumentReference
  private @Indexed @Nullable DeviceType deviceType;
  private @Indexed @NotNull SatelliteStatus status = SatelliteStatus.PENDING;

  @Getter
  @Schema(enumAsRef = true)
  public enum SatelliteStatus {
    ONLINE("ONLINE"),
    OFFLINE("OFFLINE"),
    ERROR("ERROR"),
    PENDING("PENDING");

    private final String value;

    SatelliteStatus(String value) {
      this.value = value;
    }
  }
}
