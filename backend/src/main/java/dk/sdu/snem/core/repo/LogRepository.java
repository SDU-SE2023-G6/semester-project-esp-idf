package dk.sdu.snem.core.repo;

import dk.sdu.snem.core.model.DataPoint;
import dk.sdu.snem.core.model.Log;
import dk.sdu.snem.core.model.Satellite;
import jakarta.validation.constraints.NotNull;
import java.time.Instant;
import java.util.List;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LogRepository extends MongoRepository<Log, ObjectId> {
  List<Log> findAllBySatellite_IdOrderByTimestampDesc(ObjectId satelliteId);
  List<Log> findAllByTimestampAfterOrderByTimestampDesc(@NotNull Instant timestamp);
  List<Log> findAllBySatelliteIsNullOrderByTimestampDesc();
}
