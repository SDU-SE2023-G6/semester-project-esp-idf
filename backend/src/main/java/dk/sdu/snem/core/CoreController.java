package dk.sdu.snem.core;

import dk.sdu.snem.core.model.Area;
import dk.sdu.snem.core.model.DeviceType;
import dk.sdu.snem.core.model.Satellite;
import dk.sdu.snem.core.repo.AreaRepository;
import dk.sdu.snem.core.repo.DeviceTypeRepository;
import dk.sdu.snem.core.repo.SatelliteRepository;
import dk.sdu.snem.exceptions.ConflictException;
import dk.sdu.snem.exceptions.NotFoundException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Nullable;
import java.util.List;
import org.bson.types.ObjectId;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Core")
@RequestMapping("/core")
@RestController
public class CoreController {

  private final SatelliteRepository satelliteRepo;
  private final AreaRepository areaRepo;
  private final DeviceTypeRepository deviceTypeRepo;

  public CoreController(
      SatelliteRepository deviceRepo,
      AreaRepository areaRepo,
      DeviceTypeRepository deviceTypeRepo) {
    this.satelliteRepo = deviceRepo;
    this.areaRepo = areaRepo;
    this.deviceTypeRepo = deviceTypeRepo;
  }

  @GetMapping("/areas")
  @ResponseBody
  @Operation(summary = "Get all areas.")
  public List<AreaMetadata> getAreas() {
    return areaRepo.findAll().stream()
        .map(area -> new AreaMetadata(area.getId().toHexString(), area.getName()))
        .toList();
  }

  @PostMapping("/area")
  @Operation(summary = "Add new area.")
  public AreaMetadata addArea(@RequestBody AreaMetadata areaMetadata) {
    Area newArea = new Area();
    newArea.setName(areaMetadata.name());
    areaRepo.save(newArea);

    return new AreaMetadata(newArea.getId().toHexString(), newArea.getName());
  }

  @GetMapping("/area/{areaId}")
  @ResponseBody
  @Operation(summary = "Get area by ID.")
  public AreaMetadata getAreaById(@PathVariable String areaId) {
    Area area = areaRepo.findById(new ObjectId(areaId))
        .orElseThrow(NotFoundException::new);
    return new AreaMetadata(area.getId().toHexString(), area.getName());
  }

  @DeleteMapping("/area/{areaId}")
  @Operation(summary = "Delete area by ID.")
  public void deleteAreaById(@PathVariable String areaId) {
    Area area = areaRepo.findById(new ObjectId(areaId))
        .orElseThrow(NotFoundException::new);

    if (satelliteRepo.existsByArea(area)) {
      throw new ConflictException("Area is still linked to satellites, remove before deleting.");
    }

    areaRepo.delete(area);
  }

  @GetMapping("/area/{areaId}/satellites")
  @ResponseBody
  @Operation(summary = "Get all satellites in an area.")
  public List<SatelliteMetadata> getSatellitesInArea(@PathVariable String areaId) {
    List<Satellite> satellites = satelliteRepo.findAllByArea_Id(new ObjectId(areaId));
    return satellites.stream()
        .map(
            satellite ->
                new SatelliteMetadata(
                    satellite.getId().toHexString(),
                    satellite.getName(),
                    satellite.getArea() == null
                        ? null
                        : new AreaMetadata(
                        satellite.getArea().getId().toHexString(),
                        satellite.getArea().getName()),
                    satellite.getDeviceType() == null
                        ? null
                        : new DeviceTypeMetadata(
                        satellite.getDeviceType().getId().toHexString(),
                        satellite.getDeviceType().getName())))
        .toList();
  }


  @RequestMapping(
      value = "/satellites",
      produces = {"application/json"},
      method = RequestMethod.GET)
  @ResponseBody
  @Operation(summary = "Get satellites")
  public List<SatelliteMetadata> getSatellites() {
    return satelliteRepo.findAll().stream()
        .map(
            x ->
                new SatelliteMetadata(
                    x.getId().toHexString(),
                    x.getName(),
                    x.getArea() == null
                        ? null
                        : new AreaMetadata(x.getId().toHexString(), x.getArea().getName()),
                    x.getDeviceType() == null
                        ? null
                        : new DeviceTypeMetadata(
                            x.getDeviceType().getId().toHexString(), x.getDeviceType().getName())))
        .toList();
  }

  @GetMapping("/satellite/{satelliteId}")
  @ResponseBody
  @Operation(summary = "Get satellite by ID.")
  public SatelliteMetadata getSatelliteById(@PathVariable String satelliteId) {
    Satellite satellite = satelliteRepo.findById(new ObjectId(satelliteId))
        .orElseThrow(NotFoundException::new);
    return new SatelliteMetadata(
        satellite.getId().toHexString(),
        satellite.getName(),
        satellite.getArea() == null
            ? null
            : new AreaMetadata(
                satellite.getArea().getId().toHexString(), satellite.getArea().getName()),
        satellite.getDeviceType() == null
            ? null
            : new DeviceTypeMetadata(
                satellite.getDeviceType().getId().toHexString(),
                satellite.getDeviceType().getName()));
  }

  @PutMapping("/satellite")
  @Operation(summary = "Edit satellite.")
  public void editSatellite(@RequestBody SatelliteMetadata satelliteMetadata) {
    final Area area =
        satelliteMetadata.area() == null
            ? null
            : areaRepo.findById(new ObjectId(satelliteMetadata.area().id()))
            .orElseThrow(NotFoundException::new);
    final DeviceType type =
        satelliteMetadata.deviceTypeMetadata() == null
            ? null
            : deviceTypeRepo
                .findById(new ObjectId(satelliteMetadata.deviceTypeMetadata().id()))
                .orElseThrow(NotFoundException::new);

    final Satellite satellite =
        satelliteRepo.findById(new ObjectId(satelliteMetadata.id()))
            .orElseThrow(NotFoundException::new);

    satellite.setArea(area);
    satellite.setDeviceType(type);
    satellite.setName(satelliteMetadata.name());

    satelliteRepo.save(satellite);
  }


  public record SatelliteMetadata(
      String id, String name, AreaMetadata area, @Nullable DeviceTypeMetadata deviceTypeMetadata) {}

  public record AreaMetadata(String id, String name) {}

  public record DeviceTypeMetadata(String id, String name) {}
}