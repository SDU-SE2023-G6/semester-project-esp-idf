package dk.sdu.snem.core.repo;

import dk.sdu.snem.core.model.Area;
import dk.sdu.snem.core.model.Satellite;
import java.util.List;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SatelliteRepository extends MongoRepository<Satellite, ObjectId> {
  List<Satellite> findAllByArea_Id(ObjectId areId);
  boolean existsByArea(Area area);
}
