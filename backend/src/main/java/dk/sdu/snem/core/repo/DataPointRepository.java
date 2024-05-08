package dk.sdu.snem.core.repo;

import dk.sdu.snem.core.model.DataPoint;
import java.util.List;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DataPointRepository extends MongoRepository<DataPoint, ObjectId> {
  List<DataPoint> findAllBySatellite_Id(ObjectId satelliteId);
}
