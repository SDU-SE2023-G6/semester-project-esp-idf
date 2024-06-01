package dk.sdu.snem.core.repo;

import dk.sdu.snem.core.model.Area;
import dk.sdu.snem.core.model.Satellite;
import java.util.List;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;


public interface SatelliteRepository extends MongoRepository<Satellite, ObjectId> {
  @Query(value = "{ 'deviceMACAddress': ?0 }", fields = "{ 'id': 1 }")
  Satellite findIdByDeviceMACAddress(String address);

  List<Satellite> findAllByArea_Id(ObjectId areaId);
  List<Satellite> findAllByAreaIsNull();

  Satellite findByDeviceMACAddress(String address);

  boolean existsByArea(Area area);
}
