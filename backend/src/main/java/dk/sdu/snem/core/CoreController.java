package dk.sdu.snem.core;

import dk.sdu.snem.core.repo.SatelliteRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Nullable;
import java.util.List;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Core")
@RequestMapping("/core")
@RestController
public class CoreController {

  private final SatelliteRepository satelliteRepo;

  public CoreController(SatelliteRepository deviceRepo) {
    this.satelliteRepo = deviceRepo;
  }

  @RequestMapping(
      value = "/devices",
      produces = {"application/json"},
      method = RequestMethod.GET)
  @ResponseBody
  @Operation(summary = "Register new user.")
  public List<SatelliteMetadata> getSatellites() {
    return satelliteRepo.findAll().stream()
        .map(
            x ->
                new SatelliteMetadata(
                    x.getId().toHexString(),
                    x.getName(),
                    new AreaMetadata(x.getId().toHexString(), x.getName()),
                    x.getDeviceType() == null
                        ? null
                        : new DeviceTypeMetadata(
                            x.getDeviceType().getId().toHexString(), x.getDeviceType().getName())))
        .toList();
  }

  public record SatelliteMetadata(
      String id, String name, AreaMetadata area, @Nullable DeviceTypeMetadata deviceTypeMetadata) {}

  public record AreaMetadata(String id, String name) {}

  public record DeviceTypeMetadata(String id, String name) {}
}
