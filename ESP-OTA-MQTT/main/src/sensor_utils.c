
#include "sensor_utils.h"

#include "shared_snem_library.h"
#include "target_device_type.h"
#include "mqtt_routine.h"
#include "http_routine.h"
#include "ota_routine.h"

#include <sys/time.h>
#include <stdio.h>
#include <stdlib.h>
#include <time.h>

#include "freertos/task.h"
#include "freertos/event_groups.h"

#include "freertos/semphr.h"

#include "esp_wifi.h"
#include "esp_spiffs.h"
#include "esp_log.h"
#include "esp_spiffs.h"
#include "esp_mac.h"
#include "cJSON.h"

const char *T_SENSOR = "SENSOR_ROUTINE";

const char *sensor1 = "/spiffs/temperature.txt";
const char *sensor2 = "/spiffs/humidity.txt";

int LOGGED_COUNT = 0;

SemaphoreHandle_t lock;


int64_t xx_time_get_time()
{
    struct timeval tv;
    gettimeofday(&tv, NULL);
    return (tv.tv_sec + (tv.tv_usec / 1000LL));
}

static esp_err_t wifi_enable_power_save() {
    ESP_LOGI(T_SENSOR, "Enabling Wi-Fi power-saving mode.");
    return esp_wifi_set_ps(WIFI_PS_MAX_MODEM);
}

static esp_err_t wifi_disable_power_save() {
    ESP_LOGI(T_SENSOR, "Disabling Wi-Fi power-saving mode.");
    return esp_wifi_set_ps(WIFI_PS_NONE);
}

void set_wifi(bool on) {
    return;
    int wifi_tries = 0;

    esp_err_t wifi_enable_res = NULL;
    while (wifi_enable_res != ESP_OK)
    {
        if (on)
        {
            wifi_enable_res = wifi_enable_power_save();
        }
        else
        {
            wifi_enable_res = wifi_disable_power_save();
        }
        if (wifi_enable_res != ESP_OK)
        {
            wifi_tries += 1;
            if (wifi_tries > 5)
            {
                ESP_LOGE(T_SENSOR, "Failed to enable power save mode");
                ESP_ERROR_CHECK(wifi_enable_res);
            }
            ESP_LOGE(T_SENSOR, "Failed to enable power save mode");
            vTaskDelay(5000 / portTICK_PERIOD_MS);
        }
    }
    wifi_tries = 0;
}

static esp_err_t set_mqtt(bool on)
{
    return ESP_OK;
    bool mqtt_done = false;
    while (!mqtt_done)
    {
        if (on)
        {
            ESP_LOGI(T_SENSOR, "\n Enabling MQTT \n");
            mqtt_app_start();
        }
        else
        {
            ESP_LOGI(T_SENSOR, "\n Disabling MQTT \n");
            //();
        }
        vTaskDelay(5000 / portTICK_PERIOD_MS);
    }
    return ESP_OK;
}

void read_and_delete_file(
    esp_mqtt_client_handle_t _client,
    const char *sensor_path,
    SensorInstantiation *_sensor)
{

    ESP_LOGI("FILE", "Reading file %s", sensor_path);

    esp_err_t ret = ESP_FAIL;
    // Open the file for reading
    FILE *f = fopen(sensor_path, "r");
    if (f == NULL) {
        ESP_LOGE("FILE", "Failed to open file for reading");
        return;
    }

    if (_client == NULL) {
        ESP_LOGE("MQTT", "MQTT client not initialized");
        //set_mqtt(true);
    }
    else {
        ESP_LOGI("MQTT", "MQTT client initialized");
    }

    // Read the contents of the file

    char line[128];
    while (fgets(line, sizeof(line), f) != NULL)
    {
        printf("%s", line); // Print each line read from the file
        long long time;
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

            char mac_addr[32] = {0};
            copy_mac_address(mac_addr);

            char float_data[10];
            sprintf(float_data, "%.2f", data);

            cJSON *root = cJSON_CreateObject();
            cJSON_AddStringToObject(root, "value", float_data);
            cJSON_AddStringToObject(root, "unit", _sensor->sensor->units[0]);
            cJSON_AddStringToObject(root, "sensor", _sensor->sensor->name);
            cJSON_AddStringToObject(root, "timestamp", timestamp);
            cJSON_AddStringToObject(root, "satellite_mac_address", mac_addr);

            char output_data[1024];
            sprintf(output_data, "%s", cJSON_PrintUnformatted(root));
            esp_mqtt_client_publish(_client, "satellite/data", output_data, 0, 0, 0);

            cJSON_Delete(root);
        }
    }

    // Close the file

    fclose(f);
    size_t total = 0, used = 0;
    ret = esp_spiffs_info(NULL, &total, &used);
    if (ret != ESP_OK) {
        ESP_LOGE("SPIFFS", "Failed to get SPIFFS partition information (%s)", esp_err_to_name(ret));
    }
    else {
        ESP_LOGI("SPIFFS", "Partition size: total: %d, used: %d", total, used);
    }

    // Delete the file
    if (remove(sensor_path) == 0) {
        ESP_LOGI("FILE", "File successfully deleted");
    }
    else {
        ESP_LOGE("FILE", "Error deleting file");
    }
}

void log_sensor_data(const char *sensor_path, const char *data) {
    FILE *f = fopen(sensor_path, "a");
    if (f == NULL)
    {
        ESP_LOGE("SENSOR", "Failed to open %s for writing", sensor_path);
        return;
    }
    ESP_LOGI(T_SENSOR, "Logging data for %s", sensor_path);
    char data_to_log[128];
    sprintf(data_to_log, "%" PRId64 ",%s\n", xx_time_get_time(), data);
    fprintf(f, "%s", data_to_log);
    fclose(f);

    LOGGED_COUNT++;
    ESP_LOGI("SENSOR", "Logged count %d", LOGGED_COUNT);
}

void create_sensor_name(char *sensor_path_buffer, SensorInstantiation *_sensor) {
    char sensor_path_prefix[10] = "spiffs";

    sprintf(sensor_path_buffer, "/%s/%s/%s.txt",
            sensor_path_prefix, _sensor->name, _sensor->sensor->name);
}

// calculate the sampling rate in milliseconds
int timeDurationToMs(TimeDuration duration) {
    switch (duration.unit)
    {
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
    SensorInstantiation *sensor_t = (SensorInstantiation *)pvParameter;

    ESP_LOGI(T_SENSOR, "Running sensor %s", sensor_t->name);

    while (1)
    {
        sensor_t->sensor->readerFunction(sensor_t);
        for (int index = 0; index < sensor_t->sensor->outCount; index++)
        {
            char sensor_path[215];
            create_sensor_name(sensor_path, sensor_t);
            char _char_reading[6] = {0};
            sprintf(_char_reading, "%.2f", sensor_t->readings[index]);
            log_sensor_data(sensor_path, _char_reading);
        }

        vTaskDelay(timeDurationToMs(sensor_t->samplingRate) / portTICK_PERIOD_MS);
    }
}

void set_reading_state(bool on, int size, TaskHandle_t *taskHandles) {
    for (int i = 0; i < size; i++)
    {
        if (on)
        {
            vTaskResume(taskHandles[i]);
        }
        else
        {
            vTaskSuspend(taskHandles[i]);
        }
    }

}

void sensor_routine(void *pvParameter) {
    ESP_LOGI(T_SENSOR, "Sensor routine started");

    TaskHandle_t read_sensor = NULL;
    lock = xSemaphoreCreateMutex();

    TaskHandle_t taskHandles[base_device_type.sensorCount];
    // START SENSORS IN BACKGROUND AND ADD `read_sensor` AS TASK HANDLE
    for (int i = 0; i < base_device_type.sensorCount; i++)
    {

        taskHandles[i] = NULL;

        ESP_LOGI(T_SENSOR, "Starting routine for %s", base_device_type.sensorInstantiations[i]->name);
        void *void_sensor_t = (void *)base_device_type.sensorInstantiations[i];

        SensorInstantiation *_sensor_t = (SensorInstantiation *)void_sensor_t;

        ESP_LOGI(T_SENSOR, "Test mem %s", _sensor_t->name);
        xTaskCreate(&run_sensor,
                    "sensor_routine", 8192,
                    (void *)base_device_type.sensorInstantiations[i],
                    5, &taskHandles[i]);
    }

    while (1){

        constrain_device_type(&base_device_type);
        //set_mqtt(true);

        // CHECK BATCH policy
        if (LOGGED_COUNT > base_device_type.batchSizePolicy + 1) {

            ESP_LOGI("SENSOR", "Disabling sensor \n");
            set_reading_state(false, base_device_type.sensorCount, taskHandles);

            ESP_LOGI("\n > 10", "LOGGED COUNT IS LESS THAN 10. COUNT IS: %d \n", LOGGED_COUNT);

            // HANDLE WIFI AND SEND DATA

            // ENABLE WIFI OR DIE TRYING

            ESP_LOGI("\nDEBUG", "TAKING LOCK \n");
            xSemaphoreTake(lock, portMAX_DELAY);

            //set_wifi(true);

            ESP_LOGI("\nDEBUG", "SHOULD SAY MQTT STARTING");

            //set_mqtt(true);
            ESP_LOGI("\nDEBUG", "RELEASING LOCK\n");


            xSemaphoreGive(lock);

            for (int i = 0; i < base_device_type.sensorCount; i++)
            {
                char sensor_path[215];
                create_sensor_name(sensor_path, base_device_type.sensorInstantiations[i]);
                read_and_delete_file(
                    MQTT_CLIENT,
                    sensor_path,
                    base_device_type.sensorInstantiations[i]);
            }
            LOGGED_COUNT = 0;

            vTaskDelay(5000 / portTICK_PERIOD_MS);

            // TODO: Do it somewhere else later
            ESP_LOGI(T_SENSOR, "Sending heartbeat");
            send_heartbeat(MQTT_CLIENT);
            ESP_LOGI(T_SENSOR, "Checking for OTA update");

            ESP_LOGI("SENOR OTA", "\n\n SKIPPING BUT REMEMBER TO ENABLE \n\n");
            handle_ota_check("SENSOR_OTA_CHECK");

            ESP_LOGI(T_SENSOR, "RESUMING SENSOR");

            // Disable and disconnect from mqtt
            //set_mqtt(false);
            //set_wifi(false);

            ESP_LOGI("SENSOR", "Resuming sensor \n");
            vTaskDelay(5000 / portTICK_PERIOD_MS);
            set_reading_state(true, base_device_type.sensorCount, taskHandles);
        } else {
            ESP_LOGI("\n < 10", "LOGGED SHOULD BE LESS THAT 10. COUNT IS: %d\n", LOGGED_COUNT);
            //set_mqtt(false);
            //set_wifi(false);
        }
        vTaskDelay(1000 / portTICK_PERIOD_MS);
    }
}
