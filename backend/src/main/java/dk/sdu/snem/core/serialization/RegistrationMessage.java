package dk.sdu.snem.core.serialization;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RegistrationMessage {
  @JsonProperty("satellite_mac_address")
  @JsonAlias("satellite_mac_address")
  private String satelliteMacAddress;
}
