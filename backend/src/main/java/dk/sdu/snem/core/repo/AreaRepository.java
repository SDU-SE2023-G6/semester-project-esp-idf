package dk.sdu.snem.core.repo;

import dk.sdu.snem.core.model.Area;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AreaRepository extends MongoRepository<Area, ObjectId> {
  
}
