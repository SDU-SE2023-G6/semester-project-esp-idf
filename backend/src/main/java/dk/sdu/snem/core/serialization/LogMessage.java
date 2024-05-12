package dk.sdu.snem.core.serialization;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import dk.sdu.snem.core.model.Log;
import jakarta.annotation.Nullable;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class LogMessage {
  private String message;
  private Log.LogType type;
  private long timestamp;
  @Nullable
  @JsonProperty("next_heartbeat")
  @JsonAlias("next_heartbeat")
  private Long nextHeartbeat;
  @JsonProperty("satellite_mac_address")
  @JsonAlias("satellite_mac_address")
  private String satelliteMacAddress;
}
