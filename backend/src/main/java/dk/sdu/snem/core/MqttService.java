package dk.sdu.snem.core;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import dk.sdu.snem.MqttConfig.MqttInboundDataPointsGateway;
import dk.sdu.snem.MqttConfig.MqttInboundRegistrationGateway;
import dk.sdu.snem.MqttConfig.MqttInboundLogsGateway;
import dk.sdu.snem.core.model.DataPoint;
import dk.sdu.snem.core.model.Log;
import dk.sdu.snem.core.model.Satellite;
import dk.sdu.snem.core.repo.DataPointRepository;
import dk.sdu.snem.core.repo.LogRepository;
import dk.sdu.snem.core.repo.SatelliteRepository;
import dk.sdu.snem.core.serialization.DataPointMessage;
import dk.sdu.snem.core.serialization.GeneratedCodeMetadata;
import dk.sdu.snem.core.serialization.LogMessage;
import dk.sdu.snem.core.serialization.RegistrationMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class MqttService {
  private static final Logger logger = LoggerFactory.getLogger(MqttService.class);

  private final LogRepository logRepo;
  private final SatelliteRepository satelliteRepo;
  private final DataPointRepository dataPointRepo;
  private final MqttInboundLogsGateway logsGateway;
  private final MqttInboundDataPointsGateway dataPointsGateway;
  private final MqttInboundRegistrationGateway registrationGateway;
  private final ObjectMapper mapper;


  public MqttService(
      LogRepository logRepo,
      SatelliteRepository satelliteRepo,
      DataPointRepository dataPointRepo,
      @Qualifier("mqttConfig.MqttInboundLogsGateway")
      MqttInboundLogsGateway logsGateway,
      @Qualifier("mqttConfig.MqttInboundRegistrationGateway")
      MqttInboundRegistrationGateway registrationGateway,
      @Qualifier("mqttConfig.MqttInboundDataPointsGateway") MqttInboundDataPointsGateway dataPointsGateway,
      ObjectMapper mapper) {
    this.logRepo = logRepo;
    this.satelliteRepo = satelliteRepo;
    this.dataPointRepo = dataPointRepo;
    this.logsGateway = logsGateway;
    this.dataPointsGateway = dataPointsGateway;
    this.registrationGateway = registrationGateway;
    this.mapper = mapper;
  }

  @ServiceActivator(inputChannel = "mqttInboundLogsChannel")
  public void handleLogMessage(String logPayload) {
    LogMessage message;
    try {
      message = mapper.readValue(logPayload, LogMessage.class);
    } catch (JsonProcessingException e) {
      logger.warn("Failed to deserialize log message", e);
      return;
    }

    Satellite satellite = satelliteRepo.findByDeviceMACAddress(message.getSatelliteMacAddress());
    if (satellite == null) {
      logger.warn("Received log message from unknown satellite: {}", message.getSatelliteMacAddress());
      return;
    }

    Instant timestamp = Instant.ofEpochMilli(message.getTimestamp().longValue() * 1000);

    Log log = new Log();
    log.setMessage(message.getMessage());
    log.setType(message.getType());
    log.setTimestamp(timestamp);
    log.setSatellite(satellite);

    logRepo.save(log);
    logger.info(log.toString());


    logger.info(message.toString());
    System.out.println(logPayload);

  }

  @ServiceActivator(inputChannel = "mqttInboundDataPointsChannel")
  public void handleDataPointMessage(String dataPointPayload) {
    DataPointMessage message;
    try {
      message = mapper.readValue(dataPointPayload, DataPointMessage.class);
    } catch (JsonProcessingException e) {
      logger.warn("Failed to deserialize dataPoint message", e);
      return;
    }

    Satellite satellite = satelliteRepo.findByDeviceMACAddress(message.getSatelliteMacAddress());
    if (satellite == null) {
      logger.warn("Received log message from unknown satellite: {}", message.getSatelliteMacAddress());
      return;
    }

    Instant timestamp = Instant.ofEpochMilli(message.getTimestamp().longValue() * 1000);

    DataPoint dataPoint = new DataPoint();
    dataPoint.setUnit(message.getUnit());
    dataPoint.setMeasurement(message.getValue());
    dataPoint.setTimestamp(timestamp);
    dataPoint.setSensor(message.getSensor());
    dataPoint.setSatellite(satellite);
    dataPoint.setCreatedDate(Instant.now());

    dataPointRepo.save(dataPoint);

    logger.info(dataPoint.toString());
    System.out.println(dataPointPayload);
  }

  @ServiceActivator(inputChannel = "mqttInboundRegistrationChannel")
  public void handleRegistrationMessage(String registrationPayload) {
    RegistrationMessage registrationMessage;
    try {
      registrationMessage = mapper.readValue(registrationPayload, RegistrationMessage.class);
    } catch (JsonProcessingException e) {
      logger.warn("Failed to deserialize registration message", e);
      return;
    }

    Satellite satellite = new Satellite();
    satellite.setDeviceMACAddress(registrationMessage.getSatelliteMacAddress());

    satelliteRepo.save(satellite);

    logger.info(registrationMessage.toString());
    System.out.println(registrationPayload);
  }
}
