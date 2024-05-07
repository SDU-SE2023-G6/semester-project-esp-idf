package dk.sdu.snem.core;

import dk.sdu.snem.core.repo.DeviceRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Nullable;
import java.util.List;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Core")
@RequestMapping("/core")
@RestController
public class CoreController {

  private final DeviceRepository deviceRepo;

  public CoreController(DeviceRepository deviceRepo) {
    this.deviceRepo = deviceRepo;
  }

  @RequestMapping(
      value = "/devices",
      produces = {"application/json"},
      method = RequestMethod.GET)
  @ResponseBody
  @Operation(summary = "Register new user.")
  public List<DeviceMetadata> getDevices() {
    return deviceRepo.findAll().stream()
        .map(
            x ->
                new DeviceMetadata(
                    x.getId().toHexString(),
                    x.getName(),
                    new AreaMetadata(x.getId().toHexString(), x.getName()),
                    x.getDeviceType() == null
                        ? null
                        : new DeviceTypeMetadata(
                            x.getDeviceType().getId().toHexString(), x.getDeviceType().getName())))
        .toList();
  }

  public record DeviceMetadata(
      String id, String name, AreaMetadata area, @Nullable DeviceTypeMetadata deviceTypeMetadata) {}

  public record AreaMetadata(String id, String name) {}

  public record DeviceTypeMetadata(String id, String name) {}
}
