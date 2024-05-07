package dk.sdu.snem.core.repo;

import dk.sdu.snem.core.model.Log;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LogRepository extends MongoRepository<Log, ObjectId> {}
