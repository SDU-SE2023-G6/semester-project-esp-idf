#ifndef MQTT_ROUTINE_H
#define MQTT_ROUTINE_H

static const char *T_MQTT = "mqtt5_example";

esp_mqtt_client_handle_t client = NULL;

uint8_t base_mac_addr[6] = {0}; // MAC address of the ESP32
char device_update_topic[50] = {0}; // Topic for receiving OTA updates
char device_heartbeat_topic[50] = {0};


#define USE_PROPERTY_ARR_SIZE   sizeof(user_property_arr)/sizeof(esp_mqtt5_user_property_item_t)


static void mqtt5_app_start(void);

#endif