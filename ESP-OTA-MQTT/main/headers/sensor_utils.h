#ifndef SENSOR_UTILS_H // Double header include guard
#define SENSOR_UTILS_H

#include <stdint.h>
#include <stdio.h>
#include "mqtt_client.h"

void log_sensor_data(const char* sensor_path, const char* data);

void sensor_routine(void *pvParameter);

void read_and_delete_file(esp_mqtt_client_handle_t client, const char* sensor_path);

int64_t xx_time_get_time();

#endif