package dk.sdu.snem.core.model;


import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.Instant;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Document
@NoArgsConstructor
@Data
public class ReaderFunction {
  private @MongoId ObjectId id;
  @Indexed(unique = true)
  private @NotBlank String name;
  private byte[] compiledLibrary;
  private byte[] sourceFiles;

  /** Version used for concurrency validation. */
  private @Version Long version;
  private @CreatedDate Instant createdDate;
  private @LastModifiedDate Instant lastModifiedDate;
}