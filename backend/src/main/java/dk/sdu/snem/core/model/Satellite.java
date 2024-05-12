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
  private @Nullable String name;
  @Indexed(unique = true)
  private @NotBlank String deviceMACAddress;

  @DocumentReference
  private  @Indexed @Nullable Area area;
  @DocumentReference
  private @Indexed @Nullable DeviceType deviceType;
  private @Indexed @NotNull SatelliteStatus status = SatelliteStatus.PENDING_METADATA;

  public Satellite(String name, String deviceMACAddress) {
    this.name = name;
    this.deviceMACAddress = deviceMACAddress;
  }

  @Getter
  @Schema(enumAsRef = true)
  public enum SatelliteStatus {
    ONLINE("ONLINE"),
    OFFLINE("OFFLINE"),
    ERROR("ERROR"),
    UPDATING("UPDATING"),
    PENDING_METADATA("PENDING_METADATA"),
    PENDING_VERSION_CHECK("PENDING_VERSION_CHECK");

    private final String value;

    SatelliteStatus(String value) {
      this.value = value;
    }
  }
}
