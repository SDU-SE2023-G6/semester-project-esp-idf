package dk.sdu.snem.core;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import dk.sdu.snem.MqttConfig.MqttInboundDataPointsGateway;
import dk.sdu.snem.MqttConfig.MqttInboundRegistrationGateway;
import dk.sdu.snem.MqttConfig.MqttInboundLogsGateway;
import dk.sdu.snem.core.repo.LogRepository;
import dk.sdu.snem.core.serialization.GeneratedCodeMetadata;
import dk.sdu.snem.core.serialization.LogMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.stereotype.Service;

@Service
public class MqttService {
  private static final Logger logger = LoggerFactory.getLogger(MqttService.class);

  private final LogRepository logRepo;
  private final MqttInboundLogsGateway logsGateway;
  private final MqttInboundDataPointsGateway dataPointsGateway;
  private final MqttInboundRegistrationGateway registrationGateway;
  private final ObjectMapper mapper;


  public MqttService(
      LogRepository logRepo,
      @Qualifier("mqttConfig.MqttInboundLogsGateway")
      MqttInboundLogsGateway logsGateway,
      @Qualifier("mqttConfig.MqttInboundRegistrationGateway")
      MqttInboundRegistrationGateway registrationGateway,
      @Qualifier("mqttConfig.MqttInboundDataPointsGateway") MqttInboundDataPointsGateway dataPointsGateway,
      ObjectMapper mapper) {
    this.logRepo = logRepo;
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

    logger.info(message.toString());
  }

  @ServiceActivator(inputChannel = "mqttInboundDataPointsChannel")
  public void handleDataPointMessage(String dataPointPayload) {
    System.out.println(dataPointPayload);
  }

  @ServiceActivator(inputChannel = "mqttInboundRegistrationChannel")
  public void handleRegistrationMessage(String registrationPayload) {
    System.out.println(registrationPayload);
  }


}
