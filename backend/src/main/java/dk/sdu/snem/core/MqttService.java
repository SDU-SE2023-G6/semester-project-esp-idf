package dk.sdu.snem.core;

import dk.sdu.snem.MqttConfig.MqttInboundDataPointsGateway;
import dk.sdu.snem.MqttConfig.MqttInboundLogsGateway;
import dk.sdu.snem.core.repo.LogRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.stereotype.Service;

@Service
public class MqttService {

  private final LogRepository logRepo;
  private final MqttInboundLogsGateway logsGateway;

  private final MqttInboundDataPointsGateway dataPointsGateway;

  public MqttService(
      LogRepository logRepo,
      @Qualifier("mqttConfig.MqttInboundLogsGateway")
      MqttInboundLogsGateway logsGateway,
      @Qualifier("mqttConfig.MqttInboundDataPointsGateway") MqttInboundDataPointsGateway dataPointsGateway) {
    this.logRepo = logRepo;
    this.logsGateway = logsGateway;
    this.dataPointsGateway = dataPointsGateway;
  }

  @ServiceActivator(inputChannel = "mqttInboundLogsChannel")
  public void handleLogMessage(String logPayload) {
    System.out.println(logPayload);
  }

  @ServiceActivator(inputChannel = "mqttInboundDataPointsChannel")
  public void handleDataPointMessage(String dataPointPayload) {
    System.out.println(dataPointPayload);
  }



}