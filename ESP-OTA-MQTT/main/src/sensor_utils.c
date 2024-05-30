
#include "sensor_utils.h"

#include "shared_snem_library.h"
#include "target_device_type.h"
#include "mqtt_routine.h"
#include "http_routine.h"

#include <sys/time.h>
#include <stdio.h>
#include <stdlib.h>
#include <time.h>

#include "freertos/task.h"
#include "freertos/event_groups.h"

#include "esp_spiffs.h"
#include "esp_log.h"
#include "esp_spiffs.h"
#include "esp_mac.h"
#include "cJSON.h"


const char * T_SENSOR = "SENSOR_ROUTINE";

const char *sensor1 = "/spiffs/temperature.txt";
const char *sensor2 = "/spiffs/humidity.txt";

int logged_count = 0;

int64_t xx_time_get_time() {
	struct timeval tv;
	gettimeofday(&tv, NULL);
	return (tv.tv_sec * 1000LL + (tv.tv_usec / 1000LL));
}


void read_and_delete_file(esp_mqtt_client_handle_t client, const char* sensor_path) {

    esp_err_t ret = ESP_FAIL;
    // Open the file for reading
    FILE* f = fopen(sensor_path, "r");
    if (f == NULL) {
        ESP_LOGE("FILE", "Failed to open file for reading");
        return;
    }

    if (client == NULL) {
        ESP_LOGE("MQTT", "MQTT client not initialized");
        return;
    } else {
        ESP_LOGI("MQTT", "MQTT client initialized");
    }

    // Read the contents of the file

    char line[128];
    while (fgets(line, sizeof(line), f) != NULL) {
        printf("%s", line);  // Print each line read from the file
        long long time ;
        float data;
        int scanned = sscanf(line, "%lld,%f", &time, &data);
        if (scanned < 2) {
            ESP_LOGE("FILE", "Error reading file");
            ESP_LOGI("FILE", "Scanned count %d, dTime: %lld, Data: %f", 
                        scanned, time, data);
            continue;
        } else {
            char timestamp[10];
            sprintf(timestamp, "%" PRId64, time);

            char unit[10];
            sprintf(unit, "C");
            
            uint8_t base_mac_addr[6] = {0}; // MAC address of the ESP32
            esp_read_mac(base_mac_addr, ESP_MAC_WIFI_STA);
            char mac_addr[32] = {0};
            sprintf(mac_addr, "%02x%02x%02x%02x%02x%02x", 
                base_mac_addr[0], base_mac_addr[1], base_mac_addr[2], 
                base_mac_addr[3], base_mac_addr[4], base_mac_addr[5]);

            char float_data[10];
            sprintf(float_data, "%.2f", data);

            cJSON *root = cJSON_CreateObject();
            cJSON_AddStringToObject(root, "value", float_data);
            cJSON_AddStringToObject(root, "unit", "C");
            cJSON_AddStringToObject(root, "sensor", sensor_path);
            cJSON_AddStringToObject(root, "timestamp", timestamp);
            cJSON_AddStringToObject(root, "satellite_mac_address", mac_addr);

            char output_data[1024];
            sprintf(output_data, "%s", cJSON_PrintUnformatted(root));

            esp_mqtt_client_publish(client, "satellite/data", output_data, 0, 0, 0);

            cJSON_Delete(root);
        }
    }

    // Close the file

    fclose(f);
    size_t total = 0, used = 0;
    ret = esp_spiffs_info(NULL, &total, &used);
    if (ret != ESP_OK) {
        ESP_LOGE("SPIFFS", "Failed to get SPIFFS partition information (%s)", esp_err_to_name(ret));
    } else {
        ESP_LOGI("SPIFFS", "Partition size: total: %d, used: %d", total, used);
    }

    // Delete the file
    if (remove(sensor_path) == 0) {
        ESP_LOGI("FILE", "File successfully deleted");
    } else {
        ESP_LOGE("FILE", "Error deleting file");
    }
}

void log_sensor_data(const char* sensor_path, const char* data) {
    FILE* f = fopen(sensor_path, "a");
    if (f == NULL) {
        ESP_LOGE("SENSOR", "Failed to open file for writing");
        return;
    }
    ESP_LOGI(T_SENSOR, "Logging data for %s", sensor_path);
    char data_to_log[128];
    sprintf(data_to_log, "%" PRId64 ",%s\n", xx_time_get_time(), data);
    fprintf(f, "%s", data_to_log);
    fclose(f);

    logged_count++;
    ESP_LOGI("SENSOR", "Logged count %d", logged_count);
}

void create_sensor_name(char* sensor_path_buffer, SensorInstantiation *_sensor) {
    char sensor_path_prefix[10] = "spiffs";

    sprintf(sensor_path_buffer, "/%s/%s/%s.txt", 
        sensor_path_prefix, _sensor->name, _sensor->sensor->name);
}

// calculate the sampling rate in milliseconds
int timeDurationToMs(TimeDuration duration) {
    switch (duration.unit) {
        case SECOND:
            return duration.value * 1000;
        case MINUTE:
            return duration.value * 60000;
        case HOUR:
            return duration.value * 3600000;
        case DAY:
            return duration.value * 86400000;
    }
    return 0;

}


void run_sensor(void *pvParameter) {
    SensorInstantiation *sensor_t = (SensorInstantiation *) pvParameter;

    ESP_LOGI(T_SENSOR, "Running sensor %s", sensor_t->name);

    while (1) {
        sensor_t->sensor->readerFunction(sensor_t);
        for (int index = 0; index < sensor_t->sensor->outCount; index++) {
            char sensor_path[215];
            create_sensor_name(sensor_path, sensor_t);
            char _char_reading[6] = {0};
            sprintf(_char_reading, "%.2f", sensor_t->readings[index]);
            log_sensor_data(sensor_path, _char_reading);
        }

        vTaskDelay(timeDurationToMs(sensor_t->samplingRate) / portTICK_PERIOD_MS);
    }

}


void sensor_routine(void *pvParameter)
{
    
    ESP_LOGI(T_SENSOR, "Sensor routine started");
    
    TaskHandle_t read_sensor = NULL;

    for (int i = 0; i < base_device_type.sensorCount; i++) {
        ESP_LOGI(T_SENSOR, "Starting routine for %s", base_device_type.sensorInstantiations[i]->name);
        void *void_sensor_t = (void*) base_device_type.sensorInstantiations[i];

        SensorInstantiation *_sensor_t = (SensorInstantiation*) void_sensor_t; 

        ESP_LOGI(T_SENSOR, "Test mem %s", _sensor_t->name);
        xTaskCreate(&run_sensor,
                    "sensor_routine", 8192, 
                    (void*) base_device_type.sensorInstantiations[i],
                     5, &read_sensor);
    }

    while(1) {

        constrain_device_type(&base_device_type);

        if (logged_count > 10) {
            ESP_LOGI(T_SENSOR, "STARTING TO SEND DATA. SUSPENDING SENSOR.");
            vTaskSuspend(read_sensor);
            for (int i = 0; i < base_device_type.sensorCount; i++) {
                char sensor_path[215];
                create_sensor_name(sensor_path, base_device_type.sensorInstantiations[i]);
                read_and_delete_file(client, sensor_path);
            }
            logged_count = 0;

            // TODO: Do it somewhere else later
            ESP_LOGI(T_SENSOR, "Sending heartbeat");
            send_heartbeat(client);
            ESP_LOGI(T_SENSOR, "Checking for OTA update");
            if(check_for_ota_update() == ESP_OK) {
                ESP_LOGI(T_SENSOR, "OTA update found. Rebooting...");
            }

            ESP_LOGI(T_SENSOR, "RESUMING SENSOR");
            vTaskResume(read_sensor);
        }
        vTaskDelay(1000 / portTICK_PERIOD_MS);
    }
}
