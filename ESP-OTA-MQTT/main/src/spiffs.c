#include "freertos/FreeRTOS.h"
#include "freertos/semphr.h"

#include "esp_err.h"
#include "esp_log.h"
#include "esp_spiffs.h"


esp_err_t init_spiffs(SemaphoreHandle_t spiffsMutex) {

    // Take the mutex to avoid conflicts with other tasks
    xSemaphoreTake(spiffsMutex, portMAX_DELAY);
     ESP_LOGI("SPIFFS", "Initializing SPIFFS");

    esp_vfs_spiffs_conf_t conf = {
        .base_path = "/spiffs",
        .partition_label = NULL,
        .max_files = 5,  
        .format_if_mount_failed = true
    };

    // Use the settings in the conf struct to register the SPIFFS file system
    esp_err_t ret = esp_vfs_spiffs_register(&conf);

    // Check if SPIFFS was mounted successfully
    if (ret != ESP_OK) {
        if (ret == ESP_FAIL) {
            ESP_LOGE("SPIFFS", "Failed to mount or format filesystem");
        } else if (ret == ESP_ERR_NOT_FOUND) {
            ESP_LOGE("SPIFFS", "Failed to find SPIFFS partition");
        } else {
            ESP_LOGE("SPIFFS", "Failed to initialize SPIFFS (%s)", esp_err_to_name(ret));
        }
        return ret;
    }

    size_t total = 0, used = 0;
    ret = esp_spiffs_info(NULL, &total, &used);
    if (ret != ESP_OK) {
        ESP_LOGE("SPIFFS", "Failed to get SPIFFS partition information (%s)", esp_err_to_name(ret));
    } else {
        ESP_LOGI("SPIFFS", "Partition size: total: %d, used: %d", total, used);
    }

    xSemaphoreGive(spiffsMutex);
    return ret;
}