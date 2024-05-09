package dk.sdu.snem.core.serialization;

import dk.sdu.snem.core.serialization.DeviceTypeMetadata;
import dk.sdu.snem.core.serialization.SensorMetadata;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;

@Data
public class GeneratedCodeMetadata {
  private List<DeviceTypeMetadata> deviceTypes = new ArrayList<>();
  private List<SensorMetadata> sensors = new ArrayList<>();
}
