package dk.sdu.snem.core.repo;

import dk.sdu.snem.core.model.ReaderFunction;
import jakarta.validation.constraints.NotBlank;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ReaderFunctionRepository extends MongoRepository<ReaderFunction, ObjectId> {
  List<ReaderFunction> findByNameIn(Collection<@NotBlank String> name);
  Optional<ReaderFunction> findByName(@NotBlank String name);
}
