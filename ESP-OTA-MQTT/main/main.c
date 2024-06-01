/* Advanced HTTPS OTA example

   This example code is in the Public Domain (or CC0 licensed, at your option.)

   Unless required by applicable law or agreed to in writing, this
   software is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR
   CONDITIONS OF ANY KIND, either express or implied.
*/
#include <string.h>
#include "freertos/FreeRTOS.h"
#include "freertos/task.h"
#include "freertos/event_groups.h"
#include "esp_system.h"
#include "esp_event.h"
#include "esp_log.h"
#include "esp_ota_ops.h"
#include "esp_http_client.h"
#include "esp_https_ota.h"
#include "nvs.h"
#include "nvs_flash.h"
#include "protocol_examples_common.h"
#include "esp_wifi_types.h"
#include "http_routine.h"

#include "freertos/semphr.h"

// Project imports
#include "sensor_utils.h"
#include "spiffs.h"
#include "mqtt_routine.h"
#include "ota_routine.h"
#include "ntp.h"

#if CONFIG_BOOTLOADER_APP_ANTI_ROLLBACK
#include "esp_efuse.h"
#endif

#if CONFIG_EXAMPLE_CONNECT_WIFI
#include "esp_wifi.h"
#endif

SemaphoreHandle_t init_lock;

TaskHandle_t gatherData = NULL;
// TaskHandle_t send_data = NULL;


static const char *TAG = "MAIN_ROUTINE";

// ESP_ERROR_CHECK(esp_event_handler_register(WIFI_EVENT, WIFI_EVENT_STA_DISCONNECTED, &disconnect_handler, &server));

void app_main(void)
{

    // Create a initial lock for better control of the initialization
    init_lock = xSemaphoreCreateMutex();

    ESP_LOGI(TAG, "OTA example app_main start");
    // Initialize NVS.
    esp_err_t err = nvs_flash_init();
    if (err == ESP_ERR_NVS_NO_FREE_PAGES || err == ESP_ERR_NVS_NEW_VERSION_FOUND) {
        // 1.OTA app partition table has a smaller NVS partition size than the non-OTA
        // partition table. This size mismatch may cause NVS initialization to fail.
        // 2.NVS partition contains data in new format and cannot be recognized by this version of code.
        // If this happens, we erase NVS partition and initialize NVS again.
        ESP_ERROR_CHECK(nvs_flash_erase());
        err = nvs_flash_init();
    }
    ESP_ERROR_CHECK( err );

    ESP_ERROR_CHECK(esp_netif_init());
    ESP_ERROR_CHECK(esp_event_loop_create_default());

    ESP_ERROR_CHECK(esp_event_handler_register(ESP_HTTPS_OTA_EVENT, ESP_EVENT_ANY_ID, &ota_event_handler, NULL));

    const esp_partition_t *running_partition = esp_ota_get_running_partition();

    if (running_partition != NULL) {
        printf("Currently running partition: \n");
        printf("Type: %d\n", running_partition->type);
        printf("Subtype: %d\n", running_partition->subtype);
        printf("Address: 0x%" PRIu32 "\n", running_partition->address);
        printf("Size: 0x%" PRIu32 "\n", running_partition->size);
        printf("Label: %s\n", running_partition->label);
    } else {
        printf("Failed to find running partition\n");
    }

    // TODO: replace with custom wifi init
    ESP_ERROR_CHECK(example_connect());

    esp_wifi_set_ps(WIFI_PS_NONE);

    esp_wifi_set_ps(WIFI_PS_MIN_MODEM);

    xSemaphoreTake(init_lock, portMAX_DELAY);
    ESP_LOGI(TAG, "Starting MQTT");
    mqtt_app_start();
    ESP_LOGI(TAG, "RELASING LOCK");
    xSemaphoreGive(init_lock);

    #if true

        image_info_t *image_info = malloc(sizeof(image_info_t));
        if (image_info == NULL) {
            ESP_LOGI("OTA_IMAGE", "Failed to allocated image info");
            ESP_ERROR_CHECK(ESP_FAIL);
        } 


        char app_sha[65];
        copy_app_description(app_sha);
        ESP_LOGI("SHA_CHECK", "Current APP SHA %s", app_sha);


        while (1)
        {   
            register_device(MQTT_CLIENT);
            esp_err_t ota_res = check_for_ota_update(image_info);
            if (ota_res == ESP_OK)
            {
                ESP_LOGI(TAG, "OTA update available");
                if (image_info != NULL)
                {   
                    ESP_LOGI("IMAGE_INFO", "OTA Image hash: %s", image_info->binary_hash);
                    ESP_LOGI("IMAGE_INFO", "App hash: %s", app_sha);

                    bool same_hash = is_same_firmware_hash(image_info->binary_hash);
                    if (!same_hash) {
                        ESP_LOGI(TAG, "Performing OTA");
                        perform_ota(image_info->binary_id);
                    } else {
                        ESP_LOGE(TAG, "Binary up to date.");
                    }
                } else {
                    ESP_LOGE(TAG, "Image info is NULL");
                }
            }
            sleep(5);
        }

        return;

    #else

    // Init file system
    init_spiffs(init_lock);


    // Use semaphore to control the initialization
    xSemaphoreTake(init_lock, portMAX_DELAY);
    // check for OTA update
    //ESP_LOGI("OTA", "\n\n SKIPPING BUT REMEMBER TO ENABLE \n\n");
    handle_ota_check("MAIN_OTA_CHECK"); 
    
    xSemaphoreGive(init_lock);

    // xTaskCreate(&satellite_register_device, "register_device", 8192, NULL, 5, NULL);


    /* CODE FOR MAIN LOOP */
    // Initialize SNTP and go to the sensor routine
    ESP_LOGI(TAG, "Starting main loop");
    if (initialize_sntp(6, 10000) == ESP_OK) {
        ESP_LOGI(TAG, "SNTP initialized");
        xTaskCreate(&sensor_routine, "sensor_task", 8192, NULL, 5, gatherData);
    } else {
        ESP_LOGE(TAG, "SNTP initialization failed");
        // TODO: Log error and reboot
    }
    return;

    #endif
}