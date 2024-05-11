package dk.sdu.snem.core.serialization;

import lombok.Data;

@Data
public class DataPointMessage {
  private Double value;
  private String unit;
  private String sensor;
  private Long timestamp;
  private String satelliteMacAddress;
}
