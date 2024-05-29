package dk.sdu.snem.core.serialization;

import java.time.Instant;

public record DataPointMetadata(
    String id,
    Instant timestamp,
    String unit,
    Double measurement,
    String satelliteId,
    String sensor) {}
