package dk.sdu.snem.core.serialization;

import java.util.List;
import lombok.Data;

@Data
public class DeviceTypeMetadata {
  private String name;
  private List<SensorInstantiationMetadata> sensors;
}
