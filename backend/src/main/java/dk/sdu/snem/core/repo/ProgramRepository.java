package dk.sdu.snem.core.repo;

import dk.sdu.snem.core.model.Program;
import java.util.Optional;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProgramRepository extends MongoRepository<Program, ObjectId> {
  Optional<Program> findFirstByOrderByCreatedDateDesc();
}
