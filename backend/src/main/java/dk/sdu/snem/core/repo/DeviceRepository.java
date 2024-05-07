package dk.sdu.snem.core.repo;

import dk.sdu.snem.core.model.Device;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DeviceRepository extends MongoRepository<Device, ObjectId> {
  
}
