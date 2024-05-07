package dk.sdu.snem.core.model;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Document
@NoArgsConstructor
@Data
public class Area {
  private @MongoId ObjectId id;
  private @NotBlank String name;
}
