package dk.sdu.snem.core.serialization;

import java.util.ArrayList;
import java.util.List;
import lombok.Data;

@Data
public class SensorMetadata {
  private String name;
  private String reader;
  private List<String> units = new ArrayList<>();
  private List<String> pins = new ArrayList<>();
  private List<String> ou = new ArrayList<>();
}
