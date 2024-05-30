#ifndef MQTT_ROUTINE_H
#define MQTT_ROUTINE_H

#include "mqtt_client.h"

extern esp_mqtt_client_handle_t client;

// const char *device_update_topic_template = "devices/%02X%02X%02X%02X%02X%02X/update";

#define USE_PROPERTY_ARR_SIZE   sizeof(user_property_arr)/sizeof(esp_mqtt5_user_property_item_t)

esp_err_t register_device(esp_mqtt_client_handle_t client);

void mqtt_app_start(void);

void send_heartbeat();

#endif