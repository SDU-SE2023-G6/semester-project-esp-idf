package dk.sdu.snem.core.model;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotNull;
import java.time.Instant;
import java.util.Arrays;
import java.util.Objects;
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
  private @Nullable String compileOutput;
  private @Nullable String compileErrors;
  private @Nullable Boolean compileFailed;
  /** The related DSL definition. */
  @DocumentReference(lazy = true)
  private @Indexed @Nullable Program program;
  /** Version used to identify program iteration */
  private long version = 1;
  @Indexed
  private @Nullable Instant compilationTime;
  @Indexed
  private boolean withdrawn = false;

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Binary binary = (Binary) o;
    return version == binary.version && withdrawn == binary.withdrawn &&
        Objects.equals(id, binary.id) && Objects.equals(deviceType.getId(), binary.deviceType.getId()) &&
        Arrays.equals(compiledBinary, binary.compiledBinary) &&
        Objects.equals(binaryHash, binary.binaryHash) &&
        Objects.equals(compileOutput, binary.compileOutput) &&
        Objects.equals(compileErrors, binary.compileErrors) &&
        Objects.equals(compileFailed, binary.compileFailed) &&
        Objects.equals(program, binary.program) &&
        Objects.equals(compilationTime, binary.compilationTime);
  }

  @Override
  public int hashCode() {
    int result =
        Objects.hash(id, deviceType.getId(), binaryHash, compileOutput, compileErrors, compileFailed,
            program, version, compilationTime, withdrawn);
    result = 31 * result + Arrays.hashCode(compiledBinary);
    return result;
  }

  @Override
  public String toString() {
    return "Binary{" +
        "id=" + id.toHexString() +
        ", deviceType=" + deviceType.getId().toHexString() +
        ", compiledBinary=" + compiledBinary != null ? Arrays.toString(compiledBinary) : "null" +
        ", binaryHash='" + binaryHash + '\'' +
        ", compileOutput='" + compileOutput + '\'' +
        ", compileErrors='" + compileErrors + '\'' +
        ", compileFailed=" + compileFailed +
        ", program=" + program +
        ", version=" + version +
        ", compilationTime=" + compilationTime +
        ", withdrawn=" + withdrawn +
        '}';
  }
}