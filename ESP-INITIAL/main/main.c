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
#include "mqtt_routine.h"
#include "ota_routine.h"

#if CONFIG_BOOTLOADER_APP_ANTI_ROLLBACK
#include "esp_efuse.h"
#endif

#if CONFIG_EXAMPLE_CONNECT_WIFI
#include "esp_wifi.h"
#endif

static const char *TAG = "MAIN_ROUTINE";

// ESP_ERROR_CHECK(esp_event_handler_register(WIFI_EVENT, WIFI_EVENT_STA_DISCONNECTED, &disconnect_handler, &server));

void app_main(void)
{

    ESP_LOGI(TAG, "Initial ESP flash start");
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

    ESP_ERROR_CHECK(example_connect());
    esp_wifi_set_ps(WIFI_PS_NONE);

    esp_wifi_set_ps(WIFI_PS_MIN_MODEM);

    ESP_LOGI(TAG, "Starting MQTT WAITING FOR UPDATE");
    mqtt_app_start();

    while (1)
    {
        check_for_ota_update();
        sleep(5);
    }
    return;
}