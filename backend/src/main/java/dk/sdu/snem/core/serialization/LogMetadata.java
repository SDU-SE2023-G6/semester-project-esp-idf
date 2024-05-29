package dk.sdu.snem.core.serialization;

import dk.sdu.snem.core.model.Log;
import jakarta.annotation.Nullable;
import java.time.Instant;

public record LogMetadata(
    String id, Instant timestamp, String message, @Nullable String source, Log.LogType type) {}
