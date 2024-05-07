package dk.sdu.snem.core.model;


import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.Instant;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Document
@NoArgsConstructor
@Data
public class DataPoint {
  private @MongoId ObjectId id;

  private @NotNull Instant timestamp;
  private @NotNull ObjectId deviceId;
  private @NotNull String sensor;

  private @NotNull Double measurement;
  private @NotBlank String unit;

  private @CreatedDate Instant createdDate;
}
