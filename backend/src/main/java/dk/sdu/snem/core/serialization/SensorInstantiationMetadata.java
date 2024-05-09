package dk.sdu.snem.core.serialization;

import java.util.ArrayList;
import java.util.List;
import lombok.Data;

@Data
public class SensorInstantiationMetadata {
  private String name;
  private String sensor;
  private List<Integer> pins = new ArrayList<>();
  private String samplingRate;
}
