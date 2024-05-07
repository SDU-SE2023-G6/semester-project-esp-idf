package dk.sdu.snem.core.model;

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

}
