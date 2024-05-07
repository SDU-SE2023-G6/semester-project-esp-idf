package dk.sdu.snem.core;

import static net.bytebuddy.matcher.ElementMatchers.is;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import dk.sdu.snem.core.CoreController.AreaMetadata;
import dk.sdu.snem.core.model.Area;
import dk.sdu.snem.core.model.DeviceType;
import dk.sdu.snem.core.model.Satellite;
import dk.sdu.snem.core.repo.AreaRepository;
import dk.sdu.snem.core.repo.DeviceTypeRepository;
import dk.sdu.snem.core.repo.SatelliteRepository;
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
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
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
  private ObjectMapper objectMapper;
  @Autowired
  private MockMvc mockMvc;

  @BeforeEach
  void setUp() {
    areaRepo.deleteAll();
    deviceTypeRepo.deleteAll();
    satelliteRepo.deleteAll();
  }

  @AfterEach
  void tearDown() {
    areaRepo.deleteAll();
    deviceTypeRepo.deleteAll();
    satelliteRepo.deleteAll();
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
      MvcResult result = mockMvc.perform(get("/core/areas")
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
      MvcResult result = mockMvc.perform(get("/core/areas")
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
      MvcResult result = mockMvc.perform(post("/core/area")
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
      mockMvc.perform(post("/core/area")
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
      MvcResult result = mockMvc.perform(post("/core/area")
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
      MvcResult result = mockMvc.perform(get("/core/area/{areaId}", area.getId().toHexString())
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
      mockMvc.perform(get("/core/area/{areaId}", ObjectId.get().toHexString())
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
      mockMvc.perform(delete("/core/area/{areaId}", area.getId().toHexString())
              .contentType(MediaType.APPLICATION_JSON))
          .andExpect(status().isOk());

      // Assert
      assertThat(areaRepo.findById(area.getId())).isEmpty();
    }

    @Test
    void deleteAreaByInvalidId() throws Exception {
      // Act
      mockMvc.perform(delete("/core/area/{areaId}", ObjectId.get().toHexString())
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
      satelliteRepo.save(satellite);

      // Act
      mockMvc.perform(delete("/core/area/{areaId}", area.getId().toHexString())
              .contentType(MediaType.APPLICATION_JSON))
          .andExpect(status().isConflict());
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
      satelliteRepo.save(satellite1);

      Satellite satellite2 = new Satellite();
      satellite2.setName("Satellite 2");
      satellite2.setArea(area);
      satelliteRepo.save(satellite2);

      // Act
      MvcResult result = mockMvc.perform(get("/core/area/{areaId}/satellites", area.getId().toHexString())
              .contentType(MediaType.APPLICATION_JSON))
          .andExpect(status().isOk())
          .andReturn();

      // Assert
      String responseContent = result.getResponse().getContentAsString();
      List<CoreController.SatelliteMetadata> satellites = objectMapper.readValue(responseContent, new TypeReference<>() {});
      assertThat(satellites.size()).isEqualTo(2);
      assertThat(satellites.get(0).name()).isEqualTo("Satellite 1");
      assertThat(satellites.get(0).area().name()).isEqualTo("Test Area");
      assertThat(satellites.get(1).name()).isEqualTo("Satellite 2");
      assertThat(satellites.get(1).area().name()).isEqualTo("Test Area");
    }

    @Test
    void getSatellitesInAreaWithNoSatellites() throws Exception {
      // Arrange
      Area area = new Area();
      area.setName("Empty Area");
      area = areaRepo.save(area);

      // Act
      MvcResult result = mockMvc.perform(get("/core/area/{areaId}/satellites", area.getId().toHexString())
              .contentType(MediaType.APPLICATION_JSON))
          .andExpect(status().isOk())
          .andReturn();

      // Assert
      String responseContent = result.getResponse().getContentAsString();
      List<CoreController.SatelliteMetadata> satellites = objectMapper.readValue(responseContent, new TypeReference<>() {});
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
      satelliteRepo.save(satellite1);

      Satellite satellite2 = new Satellite();
      satellite2.setName("Satellite 2");
      satellite2.setArea(area2);
      satellite2.setDeviceType(deviceType);
      satelliteRepo.save(satellite2);

      // Act
      MvcResult result = mockMvc.perform(get("/core/satellites")
              .contentType(MediaType.APPLICATION_JSON))
          .andExpect(status().isOk())
          .andReturn();

      // Assert
      String responseContent = result.getResponse().getContentAsString();
      List<CoreController.SatelliteMetadata> satellites = objectMapper.readValue(responseContent, new TypeReference<>() {});
      assertThat(satellites.size()).isEqualTo(2);
      assertThat(satellites.get(0).name()).isEqualTo("Satellite 1");
      assertThat(satellites.get(0).area().name()).isEqualTo("Area 1");
      assert satellites.get(0).deviceTypeMetadata() != null;
      assertThat(satellites.get(0).deviceTypeMetadata().name()).isEqualTo("Device Type 1");
      assertThat(satellites.get(1).name()).isEqualTo("Satellite 2");
      assertThat(satellites.get(1).area().name()).isEqualTo("Area 2");
      assert satellites.get(1).deviceTypeMetadata() != null;
      assertThat(satellites.get(1).deviceTypeMetadata().name()).isEqualTo("Device Type 1");
    }

    @Test
    void getSatellitesWithNoSatellites() throws Exception {
      // Act
      MvcResult result = mockMvc.perform(get("/core/satellites")
              .contentType(MediaType.APPLICATION_JSON))
          .andExpect(status().isOk())
          .andReturn();

      // Assert
      String responseContent = result.getResponse().getContentAsString();
      List<CoreController.SatelliteMetadata> satellites = objectMapper.readValue(responseContent, new TypeReference<>() {});
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
      satellite.setName("Test Satellite");
      satellite.setArea(area);
      satellite.setDeviceType(deviceType);
      satellite = satelliteRepo.save(satellite);

      // Act
      MvcResult result = mockMvc.perform(get("/core/satellite/{satelliteId}", satellite.getId().toHexString())
              .contentType(MediaType.APPLICATION_JSON))
          .andExpect(status().isOk())
          .andReturn();

      // Assert
      String responseContent = result.getResponse().getContentAsString();
      CoreController.SatelliteMetadata
          returnedSatellite = objectMapper.readValue(responseContent, CoreController.SatelliteMetadata.class);
      assertThat(returnedSatellite.name()).isEqualTo("Test Satellite");
      assertThat(returnedSatellite.area().name()).isEqualTo("Test Area");
      assert returnedSatellite.deviceTypeMetadata() != null;
      assertThat(returnedSatellite.deviceTypeMetadata().name()).isEqualTo("Device Type");
    }

    @Test
    void getSatelliteByInvalidId() throws Exception {
      // Act
      mockMvc.perform(get("/core/satellite/{satelliteId}", ObjectId.get().toHexString())
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
      satellite.setDeviceType(deviceType);
      satellite = satelliteRepo.save(satellite);

      CoreController.SatelliteMetadata updatedMetadata = new CoreController.SatelliteMetadata(
          satellite.getId().toHexString(),
          "Updated Satellite",
          new AreaMetadata(area.getId().toHexString(), area.getName()),
          new CoreController.DeviceTypeMetadata(deviceType.getId().toHexString(), deviceType.getName())
      );

      // Act
      mockMvc.perform(put("/core/satellite")
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
      satellite = satelliteRepo.save(satellite);

      CoreController.SatelliteMetadata updatedMetadata = new CoreController.SatelliteMetadata(
          satellite.getId().toHexString(),
          "Updated Satellite",
          null, // Unset area
          null  // Unset device type
      );

      // Act
      mockMvc.perform(put("/core/satellite")
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
      CoreController.SatelliteMetadata invalidMetadata = new CoreController.SatelliteMetadata(
          ObjectId.get().toHexString(),
          "Updated Satellite",
          new AreaMetadata(ObjectId.get().toHexString(), "Invalid Area"),
          new CoreController.DeviceTypeMetadata(ObjectId.get().toHexString(), "Invalid Device Type")
      );

      // Act
      mockMvc.perform(put("/core/satellite")
              .contentType(MediaType.APPLICATION_JSON)
              .content(objectMapper.writeValueAsString(invalidMetadata)))
          .andExpect(status().isNotFound());
    }
  }
}