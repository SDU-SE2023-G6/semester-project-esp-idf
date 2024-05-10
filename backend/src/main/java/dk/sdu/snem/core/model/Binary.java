package dk.sdu.snem.core.model;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotNull;
import java.time.Instant;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Document
@NoArgsConstructor
@Data
public class Binary {
  private @MongoId ObjectId id;
  @DocumentReference(lazy = true)
  private @NotNull DeviceType deviceType;
  /** The binary running on the device type. */
  private @Nullable byte[] compiledBinary;
  private @Nullable String binaryHash;
  /** The related DSL definition. */
  @DocumentReference(lazy = true)
  private @Indexed @Nullable Program program;
  /** Version used to identify program iteration */
  private long version = 1;
  @Indexed
  private @NotNull Instant compilationTime;
  @Indexed
  private boolean withdrawn = false;
}