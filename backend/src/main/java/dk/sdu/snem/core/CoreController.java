package dk.sdu.snem.core;

import dk.sdu.snem.core.model.*;
import dk.sdu.snem.core.repo.*;
import dk.sdu.snem.exceptions.ConflictException;
import dk.sdu.snem.exceptions.NotFoundException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotNull;
import org.bson.types.ObjectId;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Instant;
import java.util.List;
import java.util.Optional;

@RequestMapping("")
@RestController
public class CoreController {

  private final SatelliteRepository satelliteRepo;
  private final AreaRepository areaRepo;
  private final DeviceTypeRepository deviceTypeRepo;
  private final DataPointRepository dataPointsRepo;
  private final LogRepository logsRepo;
  private final ProgramRepository programRepo;
  private final CompilerService compilerService;

  public CoreController(
      SatelliteRepository deviceRepo,
      AreaRepository areaRepo,
      DataPointRepository dataPointsRepo,
      LogRepository logsRepo,
      DeviceTypeRepository deviceTypeRepo,
      ProgramRepository programRepo, CompilerService compilerService) {
    this.satelliteRepo = deviceRepo;
    this.areaRepo = areaRepo;
    this.deviceTypeRepo = deviceTypeRepo;
    this.dataPointsRepo = dataPointsRepo;
    this.logsRepo = logsRepo;
    this.programRepo = programRepo;
    this.compilerService = compilerService;
  }

  @GetMapping("/areas")
  @Tag(name = "Area")
  @ResponseBody
  @Operation(summary = "Get all areas.")
  public List<AreaMetadata> getAreas() {
    return areaRepo.findAll().stream()
        .map(area -> new AreaMetadata(area.getId().toHexString(), area.getName()))
        .toList();
  }

  @PostMapping("/area")
  @Tag(name = "Area")
  @Operation(summary = "Add new area.")
  public AreaMetadata addArea(@RequestBody AreaMetadata areaMetadata) {
    Area newArea = new Area();
    newArea.setName(areaMetadata.name());
    areaRepo.save(newArea);

    return new AreaMetadata(newArea.getId().toHexString(), newArea.getName());
  }

  @GetMapping("/area/{areaId}")
  @Tag(name = "Area")
  @ResponseBody
  @Operation(summary = "Get area by ID.")
  public AreaMetadata getAreaById(@PathVariable String areaId) {
    Area area = areaRepo.findById(new ObjectId(areaId)).orElseThrow(NotFoundException::new);
    return new AreaMetadata(area.getId().toHexString(), area.getName());
  }

  @DeleteMapping("/area/{areaId}")
  @Tag(name = "Area")
  @Operation(summary = "Delete area by ID.")
  public void deleteAreaById(@PathVariable String areaId) {
    Area area = areaRepo.findById(new ObjectId(areaId)).orElseThrow(NotFoundException::new);

    if (satelliteRepo.existsByArea(area)) {
      throw new ConflictException("Area is still linked to satellites, remove before deleting.");
    }

    areaRepo.delete(area);
  }

  @PutMapping("/area/{areaId}")
  @Tag(name = "Area")
  @Operation(summary = "Edit area.")
  public void editArea(@PathVariable String areaId, @RequestBody AreaMetadata areaMetadata) {
    Area area = areaRepo.findById(new ObjectId(areaId)).orElseThrow(NotFoundException::new);
    area.setName(areaMetadata.name());
    areaRepo.save(area);
  }

  @GetMapping("/area/{areaId}/satellites")
  @Tag(name = "Area")
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
                    satellite.getStatus(),
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
  @Tag(name = "Satellite")
  @ResponseBody
  @Operation(summary = "Get satellites")
  public List<SatelliteMetadata> getSatellites() {
    return satelliteRepo.findAll().stream()
        .map(
            x ->
                new SatelliteMetadata(
                    x.getId().toHexString(),
                    x.getName(),
                    x.getStatus(),
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
  @Tag(name = "Satellite")
  @ResponseBody
  @Operation(summary = "Get satellite by ID.")
  public SatelliteMetadata getSatelliteById(@PathVariable String satelliteId) {
    Satellite satellite =
        satelliteRepo.findById(new ObjectId(satelliteId)).orElseThrow(NotFoundException::new);
    return new SatelliteMetadata(
        satellite.getId().toHexString(),
        satellite.getName(),
        satellite.getStatus(),
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
  @Tag(name = "Satellite")
  @Operation(summary = "Edit satellite.")
  public void editSatellite(@RequestBody SatelliteMetadata satelliteMetadata) {
    final Area area =
        satelliteMetadata.area() == null
            ? null
            : areaRepo
                .findById(new ObjectId(satelliteMetadata.area().id()))
                .orElseThrow(NotFoundException::new);
    final DeviceType type =
        satelliteMetadata.deviceTypeMetadata() == null
            ? null
            : deviceTypeRepo
                .findById(new ObjectId(satelliteMetadata.deviceTypeMetadata().id()))
                .orElseThrow(NotFoundException::new);

    final Satellite satellite =
        satelliteRepo
            .findById(new ObjectId(satelliteMetadata.id()))
            .orElseThrow(NotFoundException::new);

    satellite.setArea(area);
    satellite.setDeviceType(type);
    satellite.setName(satelliteMetadata.name());

    satelliteRepo.save(satellite);
  }

  @GetMapping("/satellite/{satelliteId}/data-points")
  @Tag(name = "Satellite")
  @ResponseBody
  @Operation(summary = "Get all data points for a satellite.")
  public List<DataPointMetadata> getDataPointsBySatellite(@PathVariable String satelliteId) {
    return dataPointsRepo.findAllBySatellite_Id(new ObjectId(satelliteId)).stream()
        .map(
            dataPoint ->
                new DataPointMetadata(
                    dataPoint.getId().toHexString(),
                    dataPoint.getTimestamp(),
                    dataPoint.getUnit(),
                    dataPoint.getMeasurement(),
                    satelliteId,
                    dataPoint.getSensor()))
        .toList();
  }

  @GetMapping("/satellite/{satelliteId}/logs")
  @Tag(name = "Satellite")
  @ResponseBody
  @Operation(summary = "Get all logs for a satellite.")
  public List<LogMetadata> getLogsBySatellite(@PathVariable String satelliteId) {
    return logsRepo.findAllBySatellite_Id(new ObjectId(satelliteId)).stream()
        .map(
            log ->
                new LogMetadata(
                    log.getId().toHexString(),
                    log.getTimestamp(),
                    log.getMessage(),
                    satelliteId,
                    log.getType()))
        .toList();
  }

  @PostMapping("/satellite/register")
  @Tag(name = "Satellite")
  @ResponseBody
  @Operation(summary = "Register a ESP Satellite.")
  @ApiResponses(value = {
          @ApiResponse(responseCode = "200", description = "Device has already been registered."),
          @ApiResponse(responseCode = "201", description = "Device has been registered for the first time."),
          @ApiResponse(responseCode = "400", description = "Error creating satellite.")
  })
  public ResponseEntity<SatelliteRegisterResponseDTO> satelliteRegister(@RequestBody SatelliteRegisterDTO satellite) {
    try {
      Satellite currentSatellite = satelliteRepo.findByDeviceMACAddress(satellite.deviceMACAddress());

      // Device exists
      SatelliteRegisterResponseDTO satelliteRegisterResponseDTO = new SatelliteRegisterResponseDTO(true);

      if (currentSatellite != null) {
        // TODO: Decide if there should be more actions for when a device registers itself.
        return new ResponseEntity<>(satelliteRegisterResponseDTO, HttpStatusCode.valueOf(201));
      }

      var s = new Satellite(satellite.deviceName(), satellite.deviceMACAddress());
      this.satelliteRepo.save(s);
      return new ResponseEntity<>(satelliteRegisterResponseDTO, HttpStatusCode.valueOf(200));

    } catch (Exception e) {
      System.out.println("Failed to add Satellite.");
      return new ResponseEntity<>(
              new SatelliteRegisterResponseDTO(false),
              HttpStatusCode.valueOf(400)
      );
    }
  }


  @GetMapping("/logs")
  @Tag(name = "Logs")
  @ResponseBody
  @Operation(summary = "Get all Logs.")
  public List<LogMetadata> getLogs() {
    return logsRepo.findAll().stream()
        .map(
            log ->
                new LogMetadata(
                    log.getId().toHexString(),
                    log.getTimestamp(),
                    log.getMessage(),
                    (log.getSatellite() == null || log.getSatellite().getId() == null)
                        ? null
                        : log.getSatellite().getId().toHexString(),
                    log.getType()))
        .toList();
  }

  @GetMapping("/data-points")
  @Tag(name = "Data points")
  @ResponseBody
  @Operation(summary = "Get all Data points.")
  public List<DataPointMetadata> getDataPoints() {
    return dataPointsRepo.findAll().stream()
        .map(
            dataPoint ->
                new DataPointMetadata(
                    dataPoint.getId().toHexString(),
                    dataPoint.getTimestamp(),
                    dataPoint.getUnit(),
                    dataPoint.getMeasurement(),
                    dataPoint.getSatellite().getId().toHexString(),
                    dataPoint.getSensor()))
        .toList();
  }


  @GetMapping("/device-types")
  @Tag(name = "Device Type")
  @ResponseBody
  @Operation(summary = "Get device types of satellites.")
  public List<DeviceTypeMetadata> getDeviceTypes() {
    return deviceTypeRepo.findAll().stream()
        .map(x -> new DeviceTypeMetadata(x.getId().toHexString(), x.getName()))
        .toList();
  }

  @GetMapping("/binary/{binaryName}")
  @Tag(name = "Download a binary")
  @ResponseBody
  @Operation
  public ResponseEntity<byte[]> downloadBinary() {
    Path p = Paths.get("/home/henriko/Documents/courses/semester-project-esp-idf/_old/bins/hello-world.bin");
    File file = new File(p.toUri());
    if (!file.exists()) {
      return new ResponseEntity<>(null, HttpStatusCode.valueOf(404));
    }
    byte[] byteArray = new byte[(int) file.length()];
    try (FileInputStream inputStream = new FileInputStream(file)) {
      inputStream.read(byteArray);
    } catch (FileNotFoundException e) {
      throw new RuntimeException(e);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }

    return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
            "attachment; filename=\"" + file.getName() + "\"").body(byteArray);
  }

  @PutMapping("/program")
  @Tag(name = "Program")
  @ResponseBody
  @Operation(summary = "Update program DSL definition")
  public void saveProgramDslContent(@RequestBody ProgramDslContent dslCode) {
    Program program = getFirstProgramOrCreate();
    program.setDslCode(dslCode.dslText());
    programRepo.save(program);
  }

  @GetMapping("/program")
  @Tag(name = "Program")
  @ResponseBody
  @Operation(summary = "Get program DSL definition")
  public ProgramDslContent getProgramDslContent() {
    return new ProgramDslContent(getFirstProgramOrCreate().getDslCode());
  }
  public record ProgramDslContent(String dslText) {};

  @GetMapping("/program/status")
  @Tag(name = "Program")
  @ResponseBody
  @Operation(summary = "Get program status")
  public ProgramStatusProjection getProgramStatus() {
    var program = getFirstProgramOrCreate();
    return new ProgramStatusProjection(program.getId().toHexString(), program.getStatus());
  }

  @PostMapping("/program/compile")
  @Tag(name = "Program")
  @ResponseBody
  @Operation(summary = "Get program DSL definition")
  public ProgramStatusProjection compileProgram() {
    var program = getFirstProgramOrCreate();
    compilerService.compileProgramSafely(program);
    return new ProgramStatusProjection(program.getId().toHexString(), program.getStatus());
  }

  @PostMapping("/program/compile/override")
  @Tag(name = "Program")
  @ResponseBody
  @Operation(summary = "Continue compilation despite warnings")
  public ProgramStatusProjection compileProgramContinueDestructively() {
    var program = getFirstProgramOrCreate();
    compilerService.compileProgramDestructively(program);
    return new ProgramStatusProjection(program.getId().toHexString(), program.getStatus());
  }
  public record ProgramStatusProjection(String id, Program.ProgramStatus status) {};

  @NotNull
  private Program getFirstProgramOrCreate() {
    // TODO: 5/9/24 Doesn't support more users or programs for now lmaooo
    Optional<Program> programOpt = programRepo.findAll().stream().findFirst();
    if (programOpt.isEmpty()) {
      var program = new Program();
      programRepo.save(program);
      programOpt = Optional.of(program);
    }
    return programOpt.get();
  }

  public record SatelliteMetadata(
      String id,
      String name,
      Satellite.SatelliteStatus status,
      AreaMetadata area,
      @Nullable DeviceTypeMetadata deviceTypeMetadata) {}

  public record AreaMetadata(String id, String name) {}

  public record DeviceTypeMetadata(String id, String name) {}

  public record DataPointMetadata(
      String id,
      Instant timestamp,
      String unit,
      Double measurement,
      String satelliteId,
      String sensor) {}

  public record LogMetadata(
      String id,
      Instant timestamp,
      String message,
      @Nullable String satelliteId,
      Log.LogType type) {}


  public record SatelliteRegisterResponseDTO(
          boolean success
  ) {}

  public record SatelliteRegisterDTO(
          String deviceName,
          String deviceMACAddress) {}
}

