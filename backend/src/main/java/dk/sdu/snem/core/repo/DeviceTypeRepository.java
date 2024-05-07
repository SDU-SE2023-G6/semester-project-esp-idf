package dk.sdu.snem.core.repo;

import dk.sdu.snem.core.model.DeviceType;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DeviceTypeRepository extends MongoRepository<DeviceType, ObjectId> {

}
