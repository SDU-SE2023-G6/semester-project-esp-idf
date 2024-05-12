package dk.sdu.snem.core.serialization;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class DataPointMessage {
  private Double value;
  private String unit;
  private String sensor;
  private long timestamp;
  @JsonProperty("satellite_mac_address")
  @JsonAlias("satellite_mac_address")
  private String satelliteMacAddress;
}
