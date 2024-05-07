package dk.sdu.snem.core.repo;

import dk.sdu.snem.core.model.Satellite;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SatelliteRepository extends MongoRepository<Satellite, ObjectId> {
  
}
