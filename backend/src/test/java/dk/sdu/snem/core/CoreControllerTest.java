package dk.sdu.snem.core;

import static dk.sdu.snem.core.CoreController.*;
import static net.bytebuddy.matcher.ElementMatchers.is;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import dk.sdu.snem.core.model.*;
import dk.sdu.snem.core.model.Log.LogType;
import dk.sdu.snem.core.repo.*;

import java.nio.charset.StandardCharsets;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import dk.sdu.snem.core.CoreController.AreaMetadata;
import dk.sdu.snem.core.model.Satellite.SatelliteStatus;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

@SpringBootTest
@AutoConfigureMockMvc
class CoreControllerTest {

  @Autowired
  private AreaRepository areaRepo;
  @Autowired
  private DeviceTypeRepository deviceTypeRepo;
  @Autowired
  private SatelliteRepository satelliteRepo;
  @Autowired
  private LogRepository logRepo;
  @Autowired
  private DataPointRepository dataPointRepo;
  @Autowired
  private BinaryRepository binaryRepo;
  @Autowired
  private ObjectMapper objectMapper;
  @Autowired
  private ProgramRepository programRepo;
  @Autowired
  private MockMvc mockMvc;

  @BeforeEach
  void setUp() {
    areaRepo.deleteAll();
    deviceTypeRepo.deleteAll();
    satelliteRepo.deleteAll();
    logRepo.deleteAll();;
    dataPointRepo.deleteAll();
    programRepo.deleteAll();
    binaryRepo.deleteAll();
  }

  @AfterEach
  void tearDown() {
    areaRepo.deleteAll();
    deviceTypeRepo.deleteAll();
    satelliteRepo.deleteAll();
    logRepo.deleteAll();;
    dataPointRepo.deleteAll();
    programRepo.deleteAll();
    binaryRepo.deleteAll();
  }

  @Nested
  class getAreas {
    @Test
    void returnsListOfAreas() throws Exception {
      // Arrange
      Area area1 = new Area();
      area1.setName("Area 1");
      Area area2 = new Area();
      area2.setName("Area 2");
      areaRepo.saveAll(List.of(area1, area2));

      // Act
      MvcResult result = mockMvc.perform(get("/areas")
              .contentType(MediaType.APPLICATION_JSON))
          .andExpect(status().isOk())
          .andReturn();

      // Assert
      List<AreaMetadata>
          areas = objectMapper.readValue(result.getResponse().getContentAsString(), new TypeReference<>() {});
      assertThat(areas.size()).isEqualTo(2);
      assertThat(areas.get(0).name()).isEqualTo("Area 1");
      assertThat(areas.get(1).name()).isEqualTo("Area 2");
    }

    @Test
    void returnsEmptyList() throws Exception {
      // Act
      MvcResult result = mockMvc.perform(get("/areas")
              .contentType(MediaType.APPLICATION_JSON))
          .andExpect(status().isOk())
          .andReturn();

      // Assert
      List<AreaMetadata> areas = objectMapper.readValue(result.getResponse().getContentAsString(), new TypeReference<>() {});
      assertThat(areas.size()).isEqualTo(0);
    }
  }


  @Nested
  class AddAreaTests {
    @Test
    void addsNewAreaSuccessfully() throws Exception {
      // Arrange
      AreaMetadata newArea = new AreaMetadata(null, "New Area");

      // Act
      MvcResult result = mockMvc.perform(post("/area")
              .contentType(MediaType.APPLICATION_JSON)
              .content(objectMapper.writeValueAsString(newArea)))
          .andExpect(status().isOk())
          .andReturn();

      // Assert
      List<Area> areas = areaRepo.findAll();
      assertThat(areas.size()).isEqualTo(1);
      assertThat(areas.get(0).getName()).isEqualTo("New Area");

      // Verify returned AreaMetadata
      String responseContent = result.getResponse().getContentAsString();
      AreaMetadata returnedArea = objectMapper.readValue(responseContent, AreaMetadata.class);
      assertThat(returnedArea.name()).isEqualTo("New Area");
      assertThat(returnedArea.id()).isNotNull(); // Assuming it should not be null
    }

    @Test
    void addingAreaWithEmptyNameFails() throws Exception {
      // Arrange
      AreaMetadata newArea = new AreaMetadata(null, "");

      // Act
      mockMvc.perform(post("/area")
              .contentType(MediaType.APPLICATION_JSON)
              .content(objectMapper.writeValueAsString(newArea)))
          .andExpect(status().isUnprocessableEntity()); // Expecting bad request due to empty name
    }

    @Test
    void addingAreaWithExistingNameSucceeds() throws Exception {
      // Arrange
      AreaMetadata existingArea = new AreaMetadata(null, "Existing Area");
      Area area = new Area();
      area.setName(existingArea.name());
      areaRepo.save(area);

      AreaMetadata newArea = new AreaMetadata(null, existingArea.name());

      // Act
      MvcResult result = mockMvc.perform(post("/area")
              .contentType(MediaType.APPLICATION_JSON)
              .content(objectMapper.writeValueAsString(newArea)))
          .andExpect(status().isOk())
          .andReturn();

      // Assert
      List<Area> areas = areaRepo.findAll();
      assertThat(areas.size()).isEqualTo(2); // Expecting 2 areas with the same name
      assertThat(areas.stream().map(Area::getName).collect(Collectors.toList()))
          .contains(existingArea.name());

      // Verify returned AreaMetadata
      String responseContent = result.getResponse().getContentAsString();
      AreaMetadata returnedArea = objectMapper.readValue(responseContent, AreaMetadata.class);
      assertThat(returnedArea.name()).isEqualTo(existingArea.name());
      assertThat(returnedArea.id()).isNotNull();
      assertThat(returnedArea.id()).isNotEqualTo(existingArea.id());
    }


  }

  @Nested
  class GetAreaByIdTests {
    @Test
    void getAreaById() throws Exception {
      // Arrange
      Area area = new Area();
      area.setName("Test Area");
      area = areaRepo.save(area);

      // Act
      MvcResult result = mockMvc.perform(get("/area/{areaId}", area.getId().toHexString())
              .contentType(MediaType.APPLICATION_JSON))
          .andExpect(status().isOk())
          .andReturn();

      // Assert
      String responseContent = result.getResponse().getContentAsString();
      AreaMetadata returnedArea = objectMapper.readValue(responseContent, AreaMetadata.class);
      assertThat(returnedArea.name()).isEqualTo("Test Area");
      assertThat(returnedArea.id()).isEqualTo(area.getId().toHexString());
    }

    @Test
    void getAreaByInvalidId() throws Exception {
      // Act
      mockMvc.perform(get("/area/{areaId}", ObjectId.get().toHexString())
              .contentType(MediaType.APPLICATION_JSON))
          .andExpect(status().isNotFound());
    }
  }

  @Nested
  class DeleteAreaByIdTests {
    @Test
    void deleteAreaById() throws Exception {
      // Arrange
      Area area = new Area();
      area.setName("Test Area");
      area = areaRepo.save(area);

      // Act
      mockMvc.perform(delete("/area/{areaId}", area.getId().toHexString())
              .contentType(MediaType.APPLICATION_JSON))
          .andExpect(status().isOk());

      // Assert
      assertThat(areaRepo.findById(area.getId())).isEmpty();
    }

    @Test
    void deleteAreaByInvalidId() throws Exception {
      // Act
      mockMvc.perform(delete("/area/{areaId}", ObjectId.get().toHexString())
              .contentType(MediaType.APPLICATION_JSON))
          .andExpect(status().isNotFound());
    }

    @Test
    void deleteAreaLinkedToSatellitesFails() throws Exception {
      // Arrange
      Area area = new Area();
      area.setName("Linked Area");
      area = areaRepo.save(area);

      Satellite satellite = new Satellite();
      satellite.setName("Test Satellite");
      satellite.setArea(area);
      satellite.setDeviceMACAddress(ObjectId.get().toHexString());
      satelliteRepo.save(satellite);

      // Act
      mockMvc.perform(delete("/area/{areaId}", area.getId().toHexString())
              .contentType(MediaType.APPLICATION_JSON))
          .andExpect(status().isConflict());
    }

  }

  @Nested
  class GetBinaryTests {
    @Test
    void getBinaryByMacAddressSuccessfully() throws Exception {
      // Arrange
      DeviceType deviceType = new DeviceType();
      deviceType.setName("Device Type 1");

      Binary newBinary = createAndSaveBinary("1234", new byte[]{1, 2, 3, 4}, deviceType);


      deviceType.setBinary(newBinary);
      deviceType = deviceTypeRepo.save(deviceType);

      Satellite satellite1 = new Satellite();
      satellite1.setName("Satellite 1");
      satellite1.setDeviceType(deviceType);
      satellite1.setDeviceMACAddress(ObjectId.get().toHexString());
      satelliteRepo.save(satellite1);


      // Act
      MvcResult result = mockMvc.perform(get("/program/binary-discovery/{deviceMac}", satellite1.getDeviceMACAddress()))
              .andExpect(status().isOk())
              .andReturn();

      // Assert
      List<Binary> binaries = binaryRepo.findAll();
      assertThat(binaries.size()).isEqualTo(1);
      assertThat(binaries.get(0).getBinaryHash()).isEqualTo("1234");
      assertThat(binaries.get(0).getId()).isEqualTo(newBinary.getId());

      String responseContent = result.getResponse().getContentAsString();
      BinaryVersion version = objectMapper.readValue(responseContent, new TypeReference<>() {});
      assertThat(version).isNotNull();
      assertThat(version.binaryId()).isEqualTo(newBinary.getId().toHexString());
      assertThat(version.binaryHash()).isEqualTo("1234");
    }

    @Test
    void getBinarySuccessfully() throws Exception {
      // Arrange
      DeviceType deviceType = new DeviceType();
      deviceType.setName("Device Type 1");
      Binary newBinary = createAndSaveBinary("1234", new byte[]{1, 2, 3, 4}, deviceType);


      // Act
      MvcResult result = mockMvc.perform(get("/program/binary/{binaryId}", newBinary.getId().toString())
                      .contentType(MediaType.APPLICATION_OCTET_STREAM))
              .andExpect(status().isOk())
              .andReturn();


      // Assert
      List<Binary> binaries = binaryRepo.findAll();
      assertThat(binaries.size()).isEqualTo(1);
      assertThat(binaries.get(0).getBinaryHash()).isEqualTo("1234");


      // Verify returned binary
      byte[] responseBytes = result.getResponse().getContentAsByteArray();
      assertThat(responseBytes).isEqualTo(new byte[]{1, 2, 3, 4});
    }
  }

  @Nested
  class GetSatellitesInAreaTests {
    @Test
    void getSatellitesInArea() throws Exception {
      // Arrange
      Area area = new Area();
      area.setName("Test Area");
      area = areaRepo.save(area);

      Satellite satellite1 = new Satellite();
      satellite1.setName("Satellite 1");
      satellite1.setArea(area);
      satellite1.setDeviceMACAddress(ObjectId.get().toHexString());
      satelliteRepo.save(satellite1);

      Satellite satellite2 = new Satellite();
      satellite2.setName("Satellite 2");
      satellite2.setArea(area);
      satellite2.setDeviceMACAddress(ObjectId.get().toHexString());
      satelliteRepo.save(satellite2);

      // Act
      MvcResult result = mockMvc.perform(get("/area/satellites")
              .param("areaId", area.getId().toHexString())
              .contentType(MediaType.APPLICATION_JSON))
          .andExpect(status().isOk())
          .andReturn();

      // Assert
      String responseContent = result.getResponse().getContentAsString();
      List<SatelliteMetadata> satellites = objectMapper.readValue(responseContent, new TypeReference<>() {});
      assertThat(satellites.size()).isEqualTo(2);
      assertThat(satellites.get(0).name()).isEqualTo("Satellite 1");
      assertThat(satellites.get(0).areaId()).isEqualTo(area.getId().toHexString());
      assertThat(satellites.get(1).name()).isEqualTo("Satellite 2");
      assertThat(satellites.get(1).areaId()).isEqualTo(area.getId().toHexString());
    }

    @Test
    void getSatellitesInArea_FindThoseWithoutArea() throws Exception {
      // Arrange
      Satellite satellite1 = new Satellite();
      satellite1.setName("Satellite 1");
      satellite1.setDeviceMACAddress(ObjectId.get().toHexString());
      satelliteRepo.save(satellite1);


      Area area = new Area();
      area.setName("Test Area");
      area = areaRepo.save(area);

      Satellite satellite2 = new Satellite();
      satellite2.setName("Satellite 2");
      satellite2.setArea(area);
      satellite2.setDeviceMACAddress(ObjectId.get().toHexString());
      satelliteRepo.save(satellite2);

      // Act
      MvcResult result = mockMvc.perform(get("/area/satellites")
              .contentType(MediaType.APPLICATION_JSON))
          .andExpect(status().isOk())
          .andReturn();

      // Assert
      String responseContent = result.getResponse().getContentAsString();
      List<SatelliteMetadata> satellites = objectMapper.readValue(responseContent, new TypeReference<>() {});
      assertThat(satellites.size()).isEqualTo(1);
      assertThat(satellites.get(0).name()).isEqualTo("Satellite 1");
      assertThat(satellites.get(0).areaId()).isNull();
    }

    @Test
    void getSatellitesInAreaWithNoSatellites() throws Exception {
      // Arrange
      Area area = new Area();
      area.setName("Empty Area");
      area = areaRepo.save(area);

      // Act
      MvcResult result = mockMvc.perform(get("/area/satellites")
              .param("areaId", area.getId().toHexString())
              .contentType(MediaType.APPLICATION_JSON))
          .andExpect(status().isOk())
          .andReturn();

      // Assert
      String responseContent = result.getResponse().getContentAsString();
      List<SatelliteMetadata> satellites = objectMapper.readValue(responseContent, new TypeReference<>() {});
      assertThat(satellites.size()).isEqualTo(0);
    }
  }

  @Nested
  class GetSatellitesTests {

    @Test
    void getSatellites() throws Exception {
      // Arrange
      Area area1 = new Area();
      area1.setName("Area 1");
      area1 = areaRepo.save(area1);

      Area area2 = new Area();
      area2.setName("Area 2");
      area2 = areaRepo.save(area2);

      DeviceType deviceType = new DeviceType();
      deviceType.setName("Device Type 1");
      deviceType = deviceTypeRepo.save(deviceType);

      Satellite satellite1 = new Satellite();
      satellite1.setName("Satellite 1");
      satellite1.setArea(area1);
      satellite1.setDeviceType(deviceType);
      satellite1.setDeviceMACAddress(ObjectId.get().toHexString());
      satelliteRepo.save(satellite1);

      Satellite satellite2 = new Satellite();
      satellite2.setName("Satellite 2");
      satellite2.setArea(area2);
      satellite2.setDeviceType(deviceType);
      satellite2.setDeviceMACAddress(ObjectId.get().toHexString());
      satelliteRepo.save(satellite2);

      // Act
      MvcResult result = mockMvc.perform(get("/satellites")
              .contentType(MediaType.APPLICATION_JSON))
          .andExpect(status().isOk())
          .andReturn();

      // Assert
      String responseContent = result.getResponse().getContentAsString();
      List<SatelliteMetadata> satellites = objectMapper.readValue(responseContent, new TypeReference<>() {});
      assertThat(satellites.size()).isEqualTo(2);
      assertThat(satellites.get(0).name()).isEqualTo("Satellite 1");
      assertThat(satellites.get(0).areaId()).isEqualTo(area1.getId().toHexString());
      assert satellites.get(0).deviceTypeId() != null;
      assertThat(satellites.get(0).deviceTypeId()).isEqualTo(deviceType.getId().toHexString());
      assertThat(satellites.get(1).name()).isEqualTo("Satellite 2");
      assertThat(satellites.get(1).areaId()).isEqualTo(area2.getId().toHexString());
      assert satellites.get(1).deviceTypeId() != null;
      assertThat(satellites.get(1).deviceTypeId()).isEqualTo(deviceType.getId().toHexString());
    }

    @Test
    void getSatellitesWithNoSatellites() throws Exception {
      // Act
      MvcResult result = mockMvc.perform(get("/satellites")
              .contentType(MediaType.APPLICATION_JSON))
          .andExpect(status().isOk())
          .andReturn();

      // Assert
      String responseContent = result.getResponse().getContentAsString();
      List<SatelliteMetadata> satellites = objectMapper.readValue(responseContent, new TypeReference<>() {});
      assertThat(satellites.size()).isEqualTo(0);
    }
  }


  @Nested
  class GetSatelliteByIdTests {

    @Test
    void getSatelliteById() throws Exception {
      // Arrange
      Area area = new Area();
      area.setName("Test Area");
      area = areaRepo.save(area);

      DeviceType deviceType = new DeviceType();
      deviceType.setName("Device Type");
      deviceType = deviceTypeRepo.save(deviceType);

      Satellite satellite = new Satellite();
      satellite.setDeviceMACAddress(ObjectId.get().toHexString());
      satellite.setName("Test Satellite");
      satellite.setArea(area);
      satellite.setDeviceType(deviceType);
      satellite.setDeviceMACAddress(ObjectId.get().toHexString());
      satellite = satelliteRepo.save(satellite);

      // Act
      MvcResult result = mockMvc.perform(get("/satellite/{satelliteId}", satellite.getId().toHexString())
              .contentType(MediaType.APPLICATION_JSON))
          .andExpect(status().isOk())
          .andReturn();

      // Assert
      String responseContent = result.getResponse().getContentAsString();
      SatelliteMetadata
          returnedSatellite = objectMapper.readValue(responseContent, SatelliteMetadata.class);
      assertThat(returnedSatellite.name()).isEqualTo("Test Satellite");
      assertThat(returnedSatellite.macAddress()).isEqualTo(satellite.getDeviceMACAddress());
      assertThat(returnedSatellite.areaId()).isEqualTo(area.getId().toHexString());
      assert returnedSatellite.deviceTypeId() != null;
      assertThat(returnedSatellite.deviceTypeId()).isEqualTo(deviceType.getId().toHexString());
    }

    @Test
    void getSatelliteByInvalidId() throws Exception {
      // Act
      mockMvc.perform(get("/satellite/{satelliteId}", ObjectId.get().toHexString())
              .contentType(MediaType.APPLICATION_JSON))
          .andExpect(status().isNotFound());
    }
  }

  @Nested
  class EditSatelliteTests {

    @Test
    void editSatellite() throws Exception {
      // Arrange
      Area area = new Area();
      area.setName("Test Area");
      area = areaRepo.save(area);

      DeviceType deviceType = new DeviceType();
      deviceType.setName("Device Type");
      deviceType = deviceTypeRepo.save(deviceType);

      Satellite satellite = new Satellite();
      satellite.setName("Original Satellite");
      satellite.setArea(area);
      satellite.setDeviceMACAddress(ObjectId.get().toHexString());
      satellite.setDeviceType(deviceType);
      satellite = satelliteRepo.save(satellite);

      SatelliteMetadata updatedMetadata = new SatelliteMetadata(
          satellite.getId().toHexString(),
          satellite.getDeviceMACAddress(),
          "Updated Satellite",
          SatelliteStatus.PENDING_METADATA,
          area.getId().toHexString(),
          deviceType.getId().toHexString()
      );

      // Act
      mockMvc.perform(put("/satellite")
              .contentType(MediaType.APPLICATION_JSON)
              .content(objectMapper.writeValueAsString(updatedMetadata)))
          .andExpect(status().isOk());

      // Assert
      Optional<Satellite> updatedSatelliteOpt = satelliteRepo.findById(satellite.getId());
      assertThat(updatedSatelliteOpt.isPresent()).isTrue();
      var updatedSatellite = updatedSatelliteOpt.get();
      assertThat(updatedSatellite.getName()).isEqualTo("Updated Satellite");
      assert updatedSatellite.getArea() != null;
      assertThat(updatedSatellite.getArea().getName()).isEqualTo("Test Area");
      assert updatedSatellite.getDeviceType() != null;
      assertThat(updatedSatellite.getDeviceType().getName()).isEqualTo("Device Type");
    }
    @Test
    void editSatelliteUnsetAreaAndDeviceType() throws Exception {
      // Arrange
      Area area = new Area();
      area.setName("Test Area");
      area = areaRepo.save(area);

      DeviceType deviceType = new DeviceType();
      deviceType.setName("Device Type");
      deviceType = deviceTypeRepo.save(deviceType);

      Satellite satellite = new Satellite();
      satellite.setName("Original Satellite");
      satellite.setArea(area);
      satellite.setDeviceType(deviceType);
      satellite.setDeviceMACAddress(ObjectId.get().toHexString());
      satellite = satelliteRepo.save(satellite);

      SatelliteMetadata updatedMetadata = new SatelliteMetadata(
          satellite.getId().toHexString(),
          satellite.getDeviceMACAddress(),
          "Updated Satellite",
          satellite.getStatus(),
          null, // Unset area
          null  // Unset device type
      );

      // Act
      mockMvc.perform(put("/satellite")
              .contentType(MediaType.APPLICATION_JSON)
              .content(objectMapper.writeValueAsString(updatedMetadata)))
          .andExpect(status().isOk());

      // Assert
      Optional<Satellite> updatedSatelliteOpt = satelliteRepo.findById(satellite.getId());
      assertThat(updatedSatelliteOpt.isPresent()).isTrue();
      var updatedSatellite = updatedSatelliteOpt.get();
      assertThat(updatedSatellite.getName()).isEqualTo("Updated Satellite");
      assertThat(updatedSatellite.getArea()).isNull(); // Area should be unset
      assertThat(updatedSatellite.getDeviceType()).isNull(); // Device type should be unset
    }

    @Test
    void editSatelliteWithInvalidId() throws Exception {
      // Arrange
      SatelliteMetadata invalidMetadata = new SatelliteMetadata(
          ObjectId.get().toHexString(),
          ObjectId.get().toHexString(),
          "Updated Satellite",
          SatelliteStatus.PENDING_METADATA,
          ObjectId.get().toHexString(),
          ObjectId.get().toHexString()
      );

      // Act
      mockMvc.perform(put("/satellite")
              .contentType(MediaType.APPLICATION_JSON)
              .content(objectMapper.writeValueAsString(invalidMetadata)))
          .andExpect(status().isNotFound());
    }
  }

  @Nested
  class EditAreaTests {

    @Test
    void editArea() throws Exception {
      // Arrange
      Area area = new Area();
      area.setName("Original Area");
      area = areaRepo.save(area);

      AreaMetadata updatedMetadata = new AreaMetadata(
          area.getId().toHexString(),
          "Updated Area"
      );

      // Act
      mockMvc.perform(put("/area/{areaId}", area.getId().toHexString())
              .contentType(MediaType.APPLICATION_JSON)
              .content(objectMapper.writeValueAsString(updatedMetadata)))
          .andExpect(status().isOk());

      // Assert
      Optional<Area> updatedAreaOpt = areaRepo.findById(area.getId());
      assertThat(updatedAreaOpt.isPresent()).isTrue();
      var updatedArea = updatedAreaOpt.get();
      assertThat(updatedArea.getName()).isEqualTo("Updated Area");
    }

    @Test
    void editAreaWithInvalidId() throws Exception {
      // Arrange
      AreaMetadata invalidMetadata = new AreaMetadata(
          ObjectId.get().toHexString(),
          "Updated Area"
      );

      // Act
      mockMvc.perform(put("/core/area/{areaId}", ObjectId.get().toHexString())
              .contentType(MediaType.APPLICATION_JSON)
              .content(objectMapper.writeValueAsString(invalidMetadata)))
          .andExpect(status().isNotFound());
    }
  }

  @Nested
  class GetDataPointsBySatelliteTests {

    @Test
    void getDataPointsBySatellite() throws Exception {
      // Arrange
      Satellite satellite = createAndSaveSatellite("Test Satellite", "Test Area", "Test Device Type");

      DataPoint dataPoint1 = createAndSaveDataPoint(satellite, Instant.now(), "m/s", 10.0, "Sensor1");
      DataPoint dataPoint2 = createAndSaveDataPoint(satellite, Instant.now(), "°C", 25.0, "Sensor2");

      // Act
      MvcResult result = mockMvc.perform(get("/satellite/{satelliteId}/data-points", satellite.getId().toHexString())
              .contentType(MediaType.APPLICATION_JSON))
          .andExpect(status().isOk())
          .andReturn();

      // Assert
      String responseContent = result.getResponse().getContentAsString(StandardCharsets.UTF_8);
      List<DataPointMetadata> dataPoints = objectMapper.readValue(responseContent, new TypeReference<>() {});
      assertThat(dataPoints.size()).isEqualTo(2);

      for (int i = 0; i < dataPoints.size(); i++) {
        DataPointMetadata metadata = dataPoints.get(i);
        DataPoint dataPoint = i == 0 ? dataPoint2 : dataPoint1;

        // Truncate timestamps to milliseconds precision
        Instant truncatedMetadataTimestamp = metadata.timestamp().truncatedTo(ChronoUnit.MILLIS);
        Instant truncatedDataPointTimestamp = dataPoint.getTimestamp().truncatedTo(ChronoUnit.MILLIS);

        assertThat(truncatedMetadataTimestamp).isEqualTo(truncatedDataPointTimestamp);
        assertThat(metadata.unit()).isEqualTo(dataPoint.getUnit());
        assertThat(metadata.measurement()).isEqualTo(dataPoint.getMeasurement());
        assertThat(metadata.satelliteId()).isEqualTo(satellite.getId().toHexString());
        assertThat(metadata.sensor()).isEqualTo(dataPoint.getSensor());
      }
    }

  }

  @Nested
  class GetLogsBySourceTests {

    @Test
    void getLogsBySource_Satellite() throws Exception {
      // Arrange
      Satellite satellite = createAndSaveSatellite("Test Satellite", "Test Area", "Test Device Type");

      Log log1 = createAndSaveLog(satellite, Instant.now(), "Log message 1", LogType.INFO);
      Log log2 = createAndSaveLog(satellite, Instant.now(), "Log message 2", LogType.WARNING);
      Log log3 = createAndSaveLog(null, Instant.now(), "Log message 3", LogType.WARNING);

      // Act
      MvcResult result = mockMvc.perform(get("/logs/system")
              .param("source", satellite.getId().toHexString())
              .contentType(MediaType.APPLICATION_JSON))
          .andExpect(status().isOk())
          .andReturn();

      // Assert
      String responseContent = result.getResponse().getContentAsString(StandardCharsets.UTF_8);
      List<LogMetadata> logs = objectMapper.readValue(responseContent, new TypeReference<>() {});

      assertThat(logs.size()).isEqualTo(2);

      for (int i = 0; i < logs.size(); i++) {
        LogMetadata metadata = logs.get(i);
        Log log = i == 0 ? log2 : log1;

        assertThat(metadata.id()).isEqualTo(log.getId().toHexString());
        Instant truncatedMetadataTimestamp = metadata.timestamp().truncatedTo(ChronoUnit.MILLIS);
        Instant truncatedDataPointTimestamp = log.getTimestamp().truncatedTo(ChronoUnit.MILLIS);
        assertThat(truncatedMetadataTimestamp).isEqualTo(truncatedDataPointTimestamp);
        assertThat(metadata.message()).isEqualTo(log.getMessage());
        assertThat(metadata.source()).isEqualTo(satellite.getId().toHexString());
        assertThat(metadata.type()).isEqualTo(log.getType());
      }
    }

    @Test
    void getLogsBySource_System() throws Exception {
      // Arrange
      Satellite satellite = createAndSaveSatellite("Test Satellite", "Test Area", "Test Device Type");

      Log log1 = createAndSaveLog(null, Instant.now(), "Log message 1", LogType.INFO);
      Log log2 = createAndSaveLog(null, Instant.now(), "Log message 2", LogType.WARNING);
      Log log3 = createAndSaveLog(satellite, Instant.now(), "Log message 3", LogType.WARNING);

      // Act
      MvcResult result = mockMvc.perform(get("/logs/system")
              .contentType(MediaType.APPLICATION_JSON))
          .andExpect(status().isOk())
          .andReturn();

      // Assert
      String responseContent = result.getResponse().getContentAsString(StandardCharsets.UTF_8);
      List<LogMetadata> logs = objectMapper.readValue(responseContent, new TypeReference<>() {});

      assertThat(logs.size()).isEqualTo(2);

      for (int i = 0; i < logs.size(); i++) {
        LogMetadata metadata = logs.get(i);
        Log log = i == 0 ? log2 : log1;

        assertThat(metadata.id()).isEqualTo(log.getId().toHexString());
        Instant truncatedMetadataTimestamp = metadata.timestamp().truncatedTo(ChronoUnit.MILLIS);
        Instant truncatedDataPointTimestamp = log.getTimestamp().truncatedTo(ChronoUnit.MILLIS);
        assertThat(truncatedMetadataTimestamp).isEqualTo(truncatedDataPointTimestamp);
        assertThat(metadata.message()).isEqualTo(log.getMessage());
        assertThat(metadata.source()).isNull();
        assertThat(metadata.type()).isEqualTo(log.getType());
      }
    }

    @Test
    void getLogsBySatellite_OnlyReturnRelated() throws Exception {
      // Arrange
      Satellite satelliteUnrelated = createAndSaveSatellite("Test Satellite", "Test Area", "Test Device Type");
      createAndSaveLog(satelliteUnrelated, Instant.now(), "Log message 1", LogType.INFO);
      createAndSaveLog(satelliteUnrelated, Instant.now(), "Log message 2", LogType.WARNING);

      Satellite satellite = createAndSaveSatellite("Test Satellite", "Test Area", "Test Device Type 2");
      Log log1 = createAndSaveLog(satellite, Instant.now(), "Log message 1", LogType.INFO);
      Log log2 = createAndSaveLog(satellite, Instant.now(), "Log message 2", LogType.WARNING);

      // Act
      MvcResult result = mockMvc.perform(get("/logs/system")
              .param("source", satellite.getId().toHexString())
              .contentType(MediaType.APPLICATION_JSON))
          .andExpect(status().isOk())
          .andReturn();

      // Assert
      String responseContent = result.getResponse().getContentAsString(StandardCharsets.UTF_8);
      List<LogMetadata> logs = objectMapper.readValue(responseContent, new TypeReference<>() {});

      assertThat(logs.size()).isEqualTo(2);

      for (int i = 0; i < logs.size(); i++) {
        LogMetadata metadata = logs.get(i);
        Log log = i == 0 ? log2 : log1;

        assertThat(metadata.id()).isEqualTo(log.getId().toHexString());
        Instant truncatedMetadataTimestamp = metadata.timestamp().truncatedTo(ChronoUnit.MILLIS);
        Instant truncatedDataPointTimestamp = log.getTimestamp().truncatedTo(ChronoUnit.MILLIS);
        assertThat(truncatedMetadataTimestamp).isEqualTo(truncatedDataPointTimestamp);
        assertThat(metadata.message()).isEqualTo(log.getMessage());
        assertThat(metadata.source()).isEqualTo(satellite.getId().toHexString());
        assertThat(metadata.type()).isEqualTo(log.getType());
      }
    }

  }

  @Nested
  class GetLogsTests {

    @Test
    void getLogs_ReturnsAllLogs() throws Exception {
      // Arrange
      Satellite satellite1 = createAndSaveSatellite("Satellite 1", "Area 1", "Device Type 1");
      Satellite satellite2 = createAndSaveSatellite("Satellite 2", "Area 2", "Device Type 2");

      Log log1 = createAndSaveLog(satellite1, Instant.now(), "Log message 1", LogType.INFO);
      Log log2 = createAndSaveLog(satellite2, Instant.now(), "Log message 2", LogType.WARNING);
      Log log3 = createAndSaveLog(null, Instant.now(), "Log message 2", LogType.UNSPECIFIED);
      List<Log> expectedLogs = List.of(log1, log2, log3);

      // Act
      MvcResult result = mockMvc.perform(get("/logs")
              .contentType(MediaType.APPLICATION_JSON))
          .andExpect(status().isOk())
          .andReturn();

      // Assert
      String responseContent = result.getResponse().getContentAsString(StandardCharsets.UTF_8);
      List<LogMetadata> logs = objectMapper.readValue(responseContent, new TypeReference<>() {});

      assertThat(logs.size()).isEqualTo(3);

      for (int i = 0; i < logs.size(); i++) {
        LogMetadata metadata = logs.get(i);
        Log log = expectedLogs.get(i);

        assertThat(metadata.id()).isEqualTo(log.getId().toHexString());
        Instant truncatedMetadataTimestamp = metadata.timestamp().truncatedTo(ChronoUnit.MILLIS);
        Instant truncatedDataPointTimestamp = log.getTimestamp().truncatedTo(ChronoUnit.MILLIS);
        assertThat(truncatedMetadataTimestamp).isEqualTo(truncatedDataPointTimestamp);
        assertThat(metadata.message()).isEqualTo(log.getMessage());
        if(log.getSatellite() != null) {
          assert metadata.source() != null;
          assertThat(metadata.source()).isEqualTo(log.getSatellite().getId().toHexString());
        } else {
          assertThat(metadata.source()).isNull();
        }
        assertThat(metadata.type()).isEqualTo(log.getType());
      }
    }

  }

  @Nested
  class GetDataPointsTests {

    @Test
    void getDataPoints_ReturnsAllDataPoints() throws Exception {
      // Arrange
      Satellite satellite1 = createAndSaveSatellite("Satellite 1", "Area 1", "Device Type 1");
      Satellite satellite2 = createAndSaveSatellite("Satellite 2", "Area 2", "Device Type 2");

      DataPoint dataPoint1 = createAndSaveDataPoint(satellite1, Instant.now(), "m/s", 10.0, "Sensor 1");
      DataPoint dataPoint2 = createAndSaveDataPoint(satellite2, Instant.now(), "°C", 25.0, "Sensor 2");

      // Act
      MvcResult result = mockMvc.perform(get("/data-points")
              .contentType(MediaType.APPLICATION_JSON))
          .andExpect(status().isOk())
          .andReturn();

      // Assert
      String responseContent = result.getResponse().getContentAsString(StandardCharsets.UTF_8);
      List<DataPointMetadata> dataPoints = objectMapper.readValue(responseContent, new TypeReference<>() {});

      assertThat(dataPoints.size()).isEqualTo(2);

      for (int i = 0; i < dataPoints.size(); i++) {
        DataPointMetadata metadata = dataPoints.get(i);
        DataPoint dataPoint = i == 0 ? dataPoint1 : dataPoint2;

        assertThat(metadata.id()).isEqualTo(dataPoint.getId().toHexString());
        Instant truncatedMetadataTimestamp = metadata.timestamp().truncatedTo(ChronoUnit.MILLIS);
        Instant truncatedDataPointTimestamp = dataPoint.getTimestamp().truncatedTo(ChronoUnit.MILLIS);
        assertThat(truncatedMetadataTimestamp).isEqualTo(truncatedDataPointTimestamp);
        assertThat(metadata.unit()).isEqualTo(dataPoint.getUnit());
        assertThat(metadata.measurement()).isEqualTo(dataPoint.getMeasurement());
        assertThat(metadata.satelliteId()).isEqualTo(dataPoint.getSatellite().getId().toHexString());
        assertThat(metadata.sensor()).isEqualTo(dataPoint.getSensor());
      }
    }

  }

  @Nested
  class GetDataPointsFromSometimeAgoTests {

    @Test
    void getDataPointsFromSometimeAgo_ReturnsDataPointsWithinGivenTimeframe() throws Exception {
      // Arrange
      Satellite satellite = createAndSaveSatellite("Satellite 1", "Area 1", "Device type 1"); // Create a satellite
      Instant now = Instant.now();
      int hoursAgo = 24; // Example: retrieving data points from the last 24 hours

      DataPoint dataPointWithinRange = createAndSaveDataPoint(satellite, now.minus(12, ChronoUnit.HOURS), "m/s", 10.0, "Sensor 1");
      DataPoint dataPointOutOfRange = createAndSaveDataPoint(satellite, now.minus(25, ChronoUnit.HOURS), "m/s", 10.0, "Sensor 2");

      // Act
      MvcResult result = mockMvc.perform(get("/data-points/hours/{hoursAgo}", hoursAgo)
              .contentType(MediaType.APPLICATION_JSON))
          .andExpect(status().isOk())
          .andReturn();

      // Assert
      String responseContent = result.getResponse().getContentAsString(StandardCharsets.UTF_8);
      List<DataPointMetadata> dataPoints = objectMapper.readValue(responseContent, new TypeReference<>() {});

      assertThat(dataPoints.size()).isEqualTo(1); // Only one data point within the last 24 hours
      assertThat(dataPoints.get(0).id()).isEqualTo(dataPointWithinRange.getId().toHexString());
    }

  }

  @Nested
  class GetProgramTests {
    @Test
    void getProgramMetadata_ReturnsProgramMetadata() throws Exception {
      // Arrange
      Program program = new Program(); // Create a program object
      program.setStatus(Program.ProgramStatus.CHANGED);
      program.setCompiled(Instant.now());
      program.setIteration(10L);
      programRepo.save(program);


      // Act
      MvcResult result = mockMvc.perform(get("/program/metadata")
              .contentType(MediaType.APPLICATION_JSON))
          .andExpect(status().isOk())
          .andReturn();

      // Assert
      String responseContent = result.getResponse().getContentAsString(StandardCharsets.UTF_8);
      ProgramMetadata programMetadata = objectMapper.readValue(responseContent, ProgramMetadata.class);

      assertThat(programMetadata.id()).isEqualTo(program.getId().toHexString());
      assertThat(programMetadata.status()).isEqualTo(program.getStatus());
      assert programMetadata.compiled() != null;
      assert program.getCompiled() != null;
      assertThat(programMetadata.compiled().truncatedTo(ChronoUnit.MILLIS)).isEqualTo(program.getCompiled().truncatedTo(ChronoUnit.MILLIS));
      assertThat(programMetadata.iteration()).isEqualTo(program.getIteration());
    }
  }

  Satellite createAndSaveSatellite(String name, String areaName, String deviceTypeName) {
    Area area = new Area();
    area.setName(areaName);
    area = areaRepo.save(area);

    DeviceType deviceType = new DeviceType();
    deviceType.setName(deviceTypeName);
    deviceType = deviceTypeRepo.save(deviceType);

    Satellite satellite = new Satellite();
    satellite.setName(name);
    satellite.setArea(area);
    satellite.setDeviceType(deviceType);
    satellite.setDeviceMACAddress(ObjectId.get().toHexString());
    return satelliteRepo.save(satellite);
  }

  Log createAndSaveLog(Satellite satellite, Instant timestamp, String message, LogType type) {
    Log log = new Log();
    log.setSatellite(satellite);
    log.setTimestamp(timestamp);
    log.setMessage(message);
    log.setType(type);
    return logRepo.save(log);
  }

  private DataPoint createAndSaveDataPoint(Satellite satellite, Instant timestamp, String unit, Double measurement, String sensor) {
    DataPoint dataPoint = new DataPoint();
    dataPoint.setSatellite(satellite);
    dataPoint.setTimestamp(timestamp);
    dataPoint.setUnit(unit);
    dataPoint.setMeasurement(measurement);
    dataPoint.setSensor(sensor);
    return dataPointRepo.save(dataPoint);
  }

  private Binary createAndSaveBinary(String hash, byte[] compiledBinary, DeviceType deviceType) {
    Binary binary = new Binary();
    binary.setId(ObjectId.get());
    binary.setBinaryHash(hash);
    binary.setCompiledBinary(compiledBinary);
    binary.setDeviceType(deviceType);

    Instant compilationTime = Instant.now();
    binary.setCompilationTime(compilationTime);
    return binaryRepo.save(binary);
  }
}