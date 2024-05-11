package dk.sdu.snem;

import java.net.InetAddress;
import java.net.UnknownHostException;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.IntegrationComponentScan;
import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.config.EnableIntegration;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.mqtt.core.DefaultMqttPahoClientFactory;
import org.springframework.integration.mqtt.inbound.MqttPahoMessageDrivenChannelAdapter;
import org.springframework.integration.mqtt.support.DefaultPahoMessageConverter;
import org.springframework.messaging.MessageChannel;

@Configuration
@EnableIntegration
@IntegrationComponentScan
public class MqttConfig {
  @Value("${mqtt.broker.host}")
  private String mqttBrokerHost;

  @Value("${mqtt.broker.port}")
  private int mqttBrokerPort;


  @Bean
  public MessageChannel mqttInboundLogsChannel() {
    return new DirectChannel();
  }

  @Bean("mqttInboundLogs")
  public IntegrationFlow mqttInboundLogs() {
    return IntegrationFlow.from(mqttInbound("satellite/logs"))
        .channel(mqttInboundLogsChannel())
        .get();
  }

  @MessagingGateway(defaultRequestChannel = "mqttInboundLogsChannel")
  public interface MqttInboundLogsGateway {
    void sendMessage(String payload);
  }


  @Bean
  public MessageChannel mqttInboundRegistrationChannel() {
    return new DirectChannel();
  }

  @Bean("mqttInboundRegistration")
  public IntegrationFlow mqttInboundRegistration() {
    return IntegrationFlow.from(mqttInbound("satellite/register"))
            .channel(mqttInboundRegistrationChannel())
            .get();
  }

  @MessagingGateway(defaultRequestChannel = "mqttInboundRegistrationChannel")
  public interface MqttInboundRegistrationGateway {
    void sendMessage(String payload);
  }


  @Bean
  public MessageChannel mqttInboundDataPointsChannel() {
    return new DirectChannel();
  }

  @Bean("mqttInboundDataPoints")
  public IntegrationFlow mqttInboundDataPoints() {
    return IntegrationFlow.from(mqttInbound("satellite/data"))
        .channel(mqttInboundDataPointsChannel())
        .get();
  }

  @MessagingGateway(defaultRequestChannel = "mqttInboundDataPointsChannel")
  public interface MqttInboundDataPointsGateway {
    void sendMessage(String payload);
  }



  private MqttPahoMessageDrivenChannelAdapter mqttInbound(String topic) {
    String clientId = MqttClient.generateClientId();
    MqttPahoMessageDrivenChannelAdapter adapter = new MqttPahoMessageDrivenChannelAdapter(clientId, mqttClientFactory(), topic);
    adapter.setCompletionTimeout(5000);
    adapter.setConverter(new DefaultPahoMessageConverter());
    adapter.setQos(1);
    return adapter;
  }


  @Bean
  public DefaultMqttPahoClientFactory mqttClientFactory() {
    DefaultMqttPahoClientFactory factory = new DefaultMqttPahoClientFactory();
    MqttConnectOptions options = new MqttConnectOptions();

    InetAddress address = null;
    try {
      address = InetAddress.getByName(mqttBrokerHost);
    } catch (UnknownHostException e) {
      throw new RuntimeException(e);
    }
    System.out.println("IP Address of " + mqttBrokerHost + ": " + address.getHostAddress());
    options.setServerURIs(new String[]{String.format("tcp://%s:%d", address.getHostAddress(), mqttBrokerPort)});
    factory.setConnectionOptions(options);
    return factory;
  }


}
