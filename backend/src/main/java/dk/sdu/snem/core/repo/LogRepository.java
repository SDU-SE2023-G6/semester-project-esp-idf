package dk.sdu.snem.core.repo;

import dk.sdu.snem.core.model.Log;
import java.util.List;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LogRepository extends MongoRepository<Log, ObjectId> {
  List<Log> findAllBySatellite_Id(ObjectId satelliteId);
}
