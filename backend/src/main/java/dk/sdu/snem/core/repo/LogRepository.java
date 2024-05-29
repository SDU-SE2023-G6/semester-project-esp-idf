package dk.sdu.snem.core.repo;

import static org.springframework.data.mongodb.core.aggregation.Aggregation.newAggregation;

import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoCollection;
import dk.sdu.snem.core.model.Log;
import dk.sdu.snem.core.serialization.LogMetadata;
import jakarta.validation.constraints.NotNull;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.bson.BsonNull;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LogRepository extends MongoRepository<Log, ObjectId> {

  List<Log> findAllBySatellite_IdOrderByTimestampDesc(ObjectId satelliteId);
  List<Log> findAllByTimestampAfterOrderByTimestampDesc(@NotNull Instant timestamp);
  List<Log> findAllBySatelliteIsNullOrderByTimestampDesc();

  default List<LogMetadata> getAllProjectedMetadata(MongoTemplate template) {
    return template.getCollection(template.getCollectionName(Log.class))
        .aggregate(getProjectedMetadataPipeline(), LogMetadata.class)
        .into(new ArrayList<>());
  }
  default List<LogMetadata> getProjectedMetadataSomeHoursAgo(int hoursAgo, MongoTemplate template) {

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

    return template.getCollection(template.getCollectionName(Log.class))
        .aggregate(pipeline, LogMetadata.class)
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
        new Document(
            "$project",
            new Document("id", new Document("$toString", "$_id"))
                .append("timestamp", 1L)
                .append("message", 1L)
                .append(
                    "source",
                    new Document(
                        "$cond",
                        new Document(
                            "if",
                            new Document(
                                "$or",
                                Arrays.asList(
                                    new Document(
                                        "$eq", Arrays.asList("$satellite", new BsonNull())),
                                    new Document(
                                        "$eq",
                                        Arrays.asList("$satellite._id", new BsonNull())))))
                            .append("then", "system")
                            .append("else", "$satellite.name")))
                .append("type", "$type"));

    return new ArrayList<>(List.of(lookup, unwind, sort, project));
  }
}
