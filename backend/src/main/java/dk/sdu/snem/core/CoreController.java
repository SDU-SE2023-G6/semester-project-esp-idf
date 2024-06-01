package dk.sdu.snem.core;

import dk.sdu.snem.core.model.*;
import dk.sdu.snem.core.repo.*;
import dk.sdu.snem.exceptions.ConflictException;
import dk.sdu.snem.exceptions.NotFoundException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.List;
import org.apache.juli.logging.LogFactory;
import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("")
@RestController
public class CoreController {

  private static final Logger logger = LoggerFactory.getLogger(CoreController.class);
  private final SatelliteRepository satelliteRepo;
  private final AreaRepository areaRepo;
  private final DeviceTypeRepository deviceTypeRepo;
  private final DataPointRepository dataPointsRepo;
  private final LogRepository logsRepo;
  private final ProgramRepository programRepo;
  private final CompilerService compilerService;
  private final BinaryRepository binaryRepo;

  public CoreController(
      SatelliteRepository deviceRepo,
      AreaRepository areaRepo,
      DataPointRepository dataPointsRepo,
      LogRepository logsRepo,
      DeviceTypeRepository deviceTypeRepo,
      ProgramRepository programRepo,
      CompilerService compilerService,
      BinaryRepository binaryRepo) {
    this.satelliteRepo = deviceRepo;
    this.areaRepo = areaRepo;
    this.deviceTypeRepo = deviceTypeRepo;
    this.dataPointsRepo = dataPointsRepo;
    this.logsRepo = logsRepo;
    this.programRepo = programRepo;
    this.compilerService = compilerService;
    this.binaryRepo = binaryRepo;
  }

  @NotNull
  private static LogMetadata mapLogMetadata(Log log) {
    return new LogMetadata(
        log.getId().toHexString(),
        log.getTimestamp(),
        log.getMessage(),
        (log.getSatellite() == null || log.getSatellite().getId() == null)
            ? null
            : log.getSatellite().getId().toHexString(),
        log.getType());
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

  @GetMapping("/area/satellites")
  @Tag(name = "Area")
  @ResponseBody
  @Operation(summary = "Get all satellites in an area.")
  public List<SatelliteMetadata> getSatellitesInArea(@RequestParam(required = false) @Nullable String areaId) {
    List<Satellite> satellites =
        areaId == null
            ? satelliteRepo.findAllByAreaIsNull()
            : satelliteRepo.findAllByArea_Id(new ObjectId(areaId));
    return satellites.stream()
        .map(CoreController::mapSatelliteMetadata)
        .toList();
  }

  @NotNull
  private static SatelliteMetadata mapSatelliteMetadata(Satellite satellite) {
    return new SatelliteMetadata(
        satellite.getId().toHexString(),
        satellite.getDeviceMACAddress(),
        satellite.getName(),
        satellite.getStatus(),
        satellite.getArea() == null
            ? null
            : satellite.getArea().getId().toHexString(),
        satellite.getDeviceType() == null
            ? null
            : satellite.getDeviceType().getId().toHexString());
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
        .map(CoreController::mapSatelliteMetadata)
        .toList();
  }

  @GetMapping("/satellite/{satelliteId}")
  @Tag(name = "Satellite")
  @ResponseBody
  @Operation(summary = "Get satellite by ID.")
  public SatelliteMetadata getSatelliteById(@PathVariable String satelliteId) {
    Satellite satellite =
        satelliteRepo.findById(new ObjectId(satelliteId)).orElseThrow(NotFoundException::new);
    return mapSatelliteMetadata(satellite);
  }

  @DeleteMapping("/satellite/{satelliteId}")
  @Tag(name = "Satellite")
  @ResponseBody
  @Operation(summary = "Delete satellite by ID.")
  public void deleteSatelliteById(@PathVariable String satelliteId) {
    satelliteRepo.deleteById(new ObjectId(satelliteId));
  }

  @PutMapping("/satellite")
  @Tag(name = "Satellite")
  @Operation(summary = "Edit satellite.")
  public void editSatellite(@RequestBody SatelliteMetadata satelliteMetadata) {
    final Area area =
        satelliteMetadata.areaId() == null
            ? null
            : areaRepo
                .findById(new ObjectId(satelliteMetadata.areaId()))
                .orElseThrow(NotFoundException::new);
    final DeviceType type =
        satelliteMetadata.deviceTypeId() == null
            ? null
            : deviceTypeRepo
                .findById(new ObjectId(satelliteMetadata.deviceTypeId()))
                .orElseThrow(NotFoundException::new);

    final Satellite satellite =
        satelliteRepo
            .findById(new ObjectId(satelliteMetadata.id()))
            .orElseThrow(NotFoundException::new);

    if (satellite.getStatus() == Satellite.SatelliteStatus.PENDING_METADATA) {
      satellite.setStatus(Satellite.SatelliteStatus.UPDATING);
    }

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
    return dataPointsRepo.findAllBySatellite_IdOrderByTimestampDesc(new ObjectId(satelliteId)).stream()
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

  @GetMapping("/satellite/{satelliteId}/device-type-id")
  @Tag(name = "Satellite")
  @ResponseBody
  @Operation(summary = "Get satellite device type id.")
  public SatelliteDeviceTypeId getSatelliteDeviceType(@PathVariable String satelliteId) {
    DeviceType deviceType =
        satelliteRepo
            .findById(new ObjectId(satelliteId))
            .orElseThrow(NotFoundException::new)
            .getDeviceType();
    if (deviceType == null) {
      throw new NotFoundException("Satellite does not have a device type set.");
    }
    return new SatelliteDeviceTypeId(deviceType.getName());
  }

  @PostMapping("/satellite/register")
  @Tag(name = "Satellite")
  @ResponseBody
  @Operation(summary = "Register a ESP Satellite.")
  @ApiResponses(
      value = {
        @ApiResponse(responseCode = "200", description = "Device has already been registered."),
        @ApiResponse(
            responseCode = "201",
            description = "Device has been registered for the first time."),
        @ApiResponse(responseCode = "400", description = "Error creating satellite.")
      })
  public ResponseEntity<SatelliteRegisterResponseDTO> satelliteRegister(
      @RequestBody SatelliteRegisterDTO satellite) {
    try {
      Satellite currentSatellite =
          satelliteRepo.findByDeviceMACAddress(satellite.deviceMACAddress());

      // Device exists
      SatelliteRegisterResponseDTO satelliteRegisterResponseDTO =
          new SatelliteRegisterResponseDTO(true);

      if (currentSatellite != null) {
        // TODO: Decide if there should be more actions for when a device registers itself.
        return new ResponseEntity<>(satelliteRegisterResponseDTO, HttpStatusCode.valueOf(201));
      }

      var s = new Satellite(satellite.deviceName(), satellite.deviceMACAddress());
      this.satelliteRepo.save(s);
      return new ResponseEntity<>(satelliteRegisterResponseDTO, HttpStatusCode.valueOf(200));

    } catch (Exception e) {
      logger.info("Failed to add Satellite.");
      return new ResponseEntity<>(
          new SatelliteRegisterResponseDTO(false), HttpStatusCode.valueOf(400));
    }
  }

  @GetMapping("/logs")
  @Tag(name = "Logs")
  @ResponseBody
  @Operation(summary = "Get all Logs.")
  public List<LogMetadata> getLogs() {
    return logsRepo.findAll().stream()
        .map(CoreController::mapLogMetadata)
        .toList();
  }

  @GetMapping("/logs/system")
  @Tag(name = "Logs")
  @ResponseBody
  @Operation(summary = "Get all logs for a given source. Expects null or no input to get system logs.")
  public List<LogMetadata> getLogsBySatellite(@RequestParam(required = false) @Nullable String source) {
    List<Log> logs = source == null
        ? logsRepo.findAllBySatelliteIsNullOrderByTimestampDesc()
        : logsRepo.findAllBySatellite_IdOrderByTimestampDesc(new ObjectId(source));
    return logs.stream()
        .map(
            log ->
                new LogMetadata(
                    log.getId().toHexString(),
                    log.getTimestamp(),
                    log.getMessage(),
                    source,
                    log.getType()))
        .toList();
  }

  @GetMapping("/logs/hours/{hoursAgo}")
  @Tag(name = "Logs")
  @ResponseBody
  @Operation(summary = "Get logs since some amount of hours ago.")
  public List<LogMetadata> getLogsFromSometimeAgo(@PathVariable Integer hoursAgo) {
    return logsRepo
        .findAllByTimestampAfterOrderByTimestampDesc(Instant.now().minus(hoursAgo, ChronoUnit.HOURS))
        .stream()
        .map(CoreController::mapLogMetadata)
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

  @GetMapping("/data-points/hours/{hoursAgo}")
  @Tag(name = "Data points")
  @ResponseBody
  @Operation(summary = "Get all Data points.")
  public List<DataPointMetadata> getDataPointsFromSometimeAgo(@PathVariable Integer hoursAgo) {
    return dataPointsRepo
        .findAllByTimestampAfterOrderByTimestampDesc(Instant.now().minus(hoursAgo, ChronoUnit.HOURS))
        .stream()
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
        .map(CoreController::mapDeviceType)
        .toList();
  }

  @NotNull
  private static DeviceTypeMetadata mapDeviceType(DeviceType x) {
    return new DeviceTypeMetadata(x.getId().toHexString(), x.getName(), x.isDeprecated());
  }

  @GetMapping("/device-type/{deviceTypeId}")
  @Tag(name = "Device Type")
  @ResponseBody
  @Operation(summary = "Get device types of satellites by ID.")
  public DeviceTypeMetadata getDeviceTypeById(@PathVariable String deviceTypeId) {
    return mapDeviceType(deviceTypeRepo.findById(new ObjectId(deviceTypeId)).orElseThrow(NotFoundException::new));
  }

  @GetMapping("/program/metadata")
  @Tag(name = "Program")
  @ResponseBody
  @Operation(summary = "Get program metadata")
  public ProgramMetadata getProgramMetadata() {
    var program = getLatestProgramOrCreateOne();
    return new ProgramMetadata(
        program.getId().toHexString(),
        program.getStatus(),
        program.getCompiled(),
        program.getIteration(),
        program.getCreatedDate(),
        program.getLastModifiedDate());
  }

  @PutMapping("/program/content")
  @Tag(name = "Program")
  @ResponseBody
  @Operation(summary = "Update program DSL definition")
  public void saveProgramDslContent(@RequestBody ProgramDslContent dslCode) {
    Program program = getLatestProgramOrCreateOne();
    program.setDslCode(dslCode.dslText());
    programRepo.save(program);
  }

  @GetMapping("/program/content")
  @Tag(name = "Program")
  @ResponseBody
  @Operation(summary = "Get program DSL definition")
  public ProgramDslContent getProgramDslContent() {
    return new ProgramDslContent(getLatestProgramOrCreateOne().getDslCode());
  }

  @GetMapping("/program/status")
  @Tag(name = "Program")
  @ResponseBody
  @Operation(summary = "Get program status")
  public ProgramStatusProjection getProgramStatus() {
    var program = getLatestProgramOrCreateOne();
    return new ProgramStatusProjection(program.getId().toHexString(), program.getStatus());
  }

  @PostMapping("/program/compile")
  @Tag(name = "Program")
  @ResponseBody
  @Operation(summary = "Get program DSL definition")
  public ProgramStatusProjection compileProgram() {
    var program = getLatestProgramOrCreateOne();
    compilerService.compileProgramSafely(program);
    return new ProgramStatusProjection(program.getId().toHexString(), program.getStatus());
  }

  @PostMapping("/program/compile/override")
  @Tag(name = "Program")
  @ResponseBody
  @Operation(summary = "Continue compilation despite warnings")
  public ProgramStatusProjection compileProgramContinueDestructively() {
    var program = getLatestProgramOrCreateOne();
    compilerService.compileProgramDestructively(program);
    return new ProgramStatusProjection(program.getId().toHexString(), program.getStatus());
  }

  @GetMapping("/program/binary-discovery/{deviceMac}")
  @Tag(name = "Program")
  @ResponseBody
  @Operation
  public ResponseEntity<BinaryVersion> provideBinaryVersion(@PathVariable String deviceMac) {
    Satellite currentSatellite = satelliteRepo.findByDeviceMACAddress(deviceMac);
    DeviceType currentDeviceType = currentSatellite.getDeviceType();
      assert currentDeviceType != null;
      Binary currentBinary = currentDeviceType.getBinary();

   return ResponseEntity.ok()
           .contentType(MediaType.APPLICATION_JSON)
           .body(new BinaryVersion(currentBinary.getId().toHexString(), currentBinary.getBinaryHash()));
  }

  @GetMapping("/program/binary/{binaryId}")
  @Tag(name = "Program")
  @ResponseBody
  @Operation
  public ResponseEntity<byte[]> downloadBinary(@PathVariable String binaryId) {
    Binary binary = binaryRepo.findById(new ObjectId(binaryId)).orElseThrow(NotFoundException::new);

    return ResponseEntity.ok()
            .contentType(MediaType.APPLICATION_OCTET_STREAM)
            .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + binaryId + "\"")
            .body(binary.getCompiledBinary());
  }

  @NotNull
  private Program getLatestProgramOrCreateOne() {
    return programRepo
        .findFirstByOrderByCreatedDateDesc()
        .orElseGet(() -> programRepo.save(new Program()));
  }

  public record ProgramMetadata(
      String id,
      Program.ProgramStatus status,
      @Nullable Instant compiled,
      Long iteration,
      Instant createdDate,
      Instant lastModifiedDate) {}

  public record SatelliteDeviceTypeId(String id) {}

  public record ProgramDslContent(String dslText) {}

  public record ProgramStatusProjection(String id, Program.ProgramStatus status) {}

  public record SatelliteMetadata(
      String id,
      String macAddress,
      String name,
      Satellite.SatelliteStatus status,
      String areaId,
      String deviceTypeId) {}

  public record AreaMetadata(String id, @NotBlank @Parameter(required = true) String name) {}

  public record BinaryVersion(String binaryId, String binaryHash) {}

  public record DeviceTypeMetadata(String id, String name, boolean deprecated) {}

  public record DataPointMetadata(
      String id,
      Instant timestamp,
      String unit,
      Double measurement,
      String satelliteId,
      String sensor) {}

  public record LogMetadata(
      String id, Instant timestamp, String message, @Nullable String source, Log.LogType type) {}

  public record SatelliteRegisterResponseDTO(boolean success) {}

  public record SatelliteRegisterDTO(String deviceName, String deviceMACAddress) {}

  public record BinaryMetadata(String hash) {}
}
