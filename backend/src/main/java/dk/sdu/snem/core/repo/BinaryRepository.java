package dk.sdu.snem.core.repo;

import dk.sdu.snem.core.model.Binary;
import dk.sdu.snem.core.model.DeviceType;
import jakarta.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BinaryRepository extends MongoRepository<Binary, ObjectId> {
  Optional<Binary> findFirstByDeviceTypeAndWithdrawnOrderByCompilationTimeDesc(
      @NotNull DeviceType deviceType, boolean withdrawn);
}
