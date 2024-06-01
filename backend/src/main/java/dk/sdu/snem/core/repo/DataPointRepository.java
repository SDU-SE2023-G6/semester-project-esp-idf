package dk.sdu.snem.core.repo;

import dk.sdu.snem.core.model.DataPoint;
import dk.sdu.snem.core.model.Log;
import dk.sdu.snem.core.serialization.DataPointMetadata;
import dk.sdu.snem.core.serialization.LogMetadata;
import jakarta.validation.constraints.NotNull;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.bson.BsonNull;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DataPointRepository extends MongoRepository<DataPoint, ObjectId> {
  List<DataPoint> findAllBySatellite_IdOrderByTimestampDesc(ObjectId satelliteId);
  List<DataPoint> findAllByTimestampAfterOrderByTimestampDesc(@NotNull Instant timestamp);

  default List<DataPointMetadata> getAllProjectedMetadata(MongoTemplate template) {
    return template.getCollection(template.getCollectionName(DataPoint.class))
        .aggregate(getProjectedMetadataPipeline(), DataPointMetadata.class)
        .into(new ArrayList<>());
  }
  default List<DataPointMetadata> getProjectedMetadataSomeHoursAgo(int hoursAgo, MongoTemplate template) {
    var match =
        new Document(
            "$match",
            new Document(
                "$expr",
                new Document(
                    "$gt",
                    Arrays.asList(
                        "$timestamp",
                        new Document(
                            "$dateSubtract",
                            new Document("startDate", "$$NOW")
                                .append("unit", "minute")
                                .append("amount", hoursAgo))))));
    var pipeline = getProjectedMetadataPipeline();
    pipeline.add(0, match);

    return template.getCollection(template.getCollectionName(DataPoint.class))
        .aggregate(pipeline, DataPointMetadata.class)
        .into(new ArrayList<>());
  }

  private List<Document> getProjectedMetadataPipeline() {
    var lookup =
        new Document(
            "$lookup",
            new Document("from", "satellite")
                .append("localField", "satellite")
                .append("foreignField", "_id")
                .append("as", "satellite"));
    var unwind =
        new Document(
            "$unwind",
            new Document("path", "$satellite").append("preserveNullAndEmptyArrays", true));
    var sort = new Document("$sort", new Document("timestamp", -1L));

    var project =
        new Document("$project",
            new Document("id",
                new Document("$toString", "$_id"))
                .append("timestamp", 1L)
                .append("unit", 1L)
                .append("sensor", 1L)
                .append("measurement", 1L)
                .append("satelliteId",
                    new Document("$toString", "$satellite._id")));

    return new ArrayList<>(List.of(lookup, unwind, sort, project));
  }
}
