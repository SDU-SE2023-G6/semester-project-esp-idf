#include <string.h>
#include "freertos/FreeRTOS.h"
#include "freertos/task.h"
#include "freertos/event_groups.h"
#include "esp_system.h"
#include "esp_log.h"
#include "esp_ota_ops.h"
#include "esp_http_client.h"
#include "esp_https_ota.h"
#include "cJSON.h"

#include "ota_routine.h"
#include "http_routine.h"
#include "mqtt_routine.h"

static const char *T_OTA = "OTA_ROUTINE";

/**
 * Copy the sha of the app into provided buffer. Needs a char buffer of size 65.
*/
esp_err_t copy_app_description(char* buffer) {
    const esp_app_desc_t *app_desc = esp_app_get_description(); 
    // Print the SHA-256 hash
    for (int i = 0; i < 32; ++i) {
        sprintf(&buffer[i * 2], "%02x", app_desc->app_elf_sha256[i]);
    }
    buffer[64] = '\0'; // Null-terminate the string

    return ESP_OK;
}

/*
 * @brief Function to check if the hash of the binary is the same as the one in the app description
*/
bool is_same_firmware_hash(char *binary_hash)
{
    char app_sha256[65];
    copy_app_description(app_sha256);


    ESP_LOGI(T_OTA, "\n");
    ESP_LOGI(T_OTA, "App SHA256: %s", app_sha256);
    ESP_LOGI(T_OTA, "Binary SHA256: %s", binary_hash);
    ESP_LOGI(T_OTA, "\n");
    return strcmp(app_sha256, binary_hash) == 0;
}


/* Event handler for catching system events */
void ota_event_handler(void* arg, esp_event_base_t event_base,
                          int32_t event_id, void* event_data)
{
    if (event_base == ESP_HTTPS_OTA_EVENT) {
        switch (event_id) {
            case ESP_HTTPS_OTA_START:
                ESP_LOGI(T_OTA, "OTA started");
                break;
            case ESP_HTTPS_OTA_CONNECTED:
                ESP_LOGI(T_OTA, "Connected to server");
                break;
            case ESP_HTTPS_OTA_GET_IMG_DESC:
                ESP_LOGI(T_OTA, "Reading Image Description");
                break;
            case ESP_HTTPS_OTA_VERIFY_CHIP_ID:
                ESP_LOGI(T_OTA, "Verifying chip id of new image: %d", *(esp_chip_id_t *)event_data);
                break;
            case ESP_HTTPS_OTA_DECRYPT_CB:
                ESP_LOGI(T_OTA, "Callback to decrypt function");
                break;
            case ESP_HTTPS_OTA_WRITE_FLASH:
                ESP_LOGD(T_OTA, "Writing to flash: %d written", *(int *)event_data);
                break;
            case ESP_HTTPS_OTA_UPDATE_BOOT_PARTITION:
                ESP_LOGI(T_OTA, "Boot partition updated. Next Partition: %d", *(esp_partition_subtype_t *)event_data);
                break;
            case ESP_HTTPS_OTA_FINISH:
                ESP_LOGI(T_OTA, "OTA finish");
                break;
            case ESP_HTTPS_OTA_ABORT:
                ESP_LOGI(T_OTA, "OTA abort");
                break;
        }
    }
}

static esp_err_t validate_image_header(esp_app_desc_t *new_app_info)
{
    if (new_app_info == NULL) {
        return ESP_ERR_INVALID_ARG;
    }

    const esp_partition_t *running = esp_ota_get_running_partition();
    esp_app_desc_t running_app_info;
    if (esp_ota_get_partition_description(running, &running_app_info) == ESP_OK) {
        ESP_LOGI(T_OTA, "Running firmware version: %s", running_app_info.version);
    }

#ifndef CONFIG_EXAMPLE_SKIP_VERSION_CHECK
    if (memcmp(new_app_info->version, running_app_info.version, sizeof(new_app_info->version)) == 0) {
        ESP_LOGW(T_OTA, "Current running version is the same as a new. We will not continue the update.");
        return ESP_FAIL;
    }
#endif

#ifdef CONFIG_BOOTLOADER_APP_ANTI_ROLLBACK
    /**
     * Secure version check from firmware image header prevents subsequent download and flash write of
     * entire firmware image. However this is optional because it is also taken care in API
     * esp_https_ota_finish at the end of OTA update procedure.
     */
    const uint32_t hw_sec_version = esp_efuse_read_secure_version();
    if (new_app_info->secure_version < hw_sec_version) {
        ESP_LOGW(T_OTA, "New firmware security version is less than eFuse programmed, %"PRIu32" < %"PRIu32, new_app_info->secure_version, hw_sec_version);
        return ESP_FAIL;
    }
#endif

    return ESP_OK;
}

/**
 * @brief Function to perform OTA using HTTP
*/
int perform_ota(char *binary_id)
{

    log_error("UPDATE_START", "OTA update started.");
    char update_url[256];
    sprintf(update_url,
        "%s/program/binary/%s", CONFIG_SERVER_URL, binary_id);

    ESP_LOGI(T_OTA, "Starting Advanced OTA example");
    ESP_LOGI(T_OTA, "Using url: %s", update_url);

    esp_err_t ota_finish_err = ESP_OK;
    esp_http_client_config_t config = {
        .url = update_url,
        .timeout_ms = CONFIG_EXAMPLE_OTA_RECV_TIMEOUT,
        .keep_alive_enable = true,
    };

#ifdef CONFIG_EXAMPLE_SKIP_COMMON_NAME_CHECK
    config.skip_cert_common_name_check = true;
#endif

    esp_https_ota_config_t ota_config = {
        .http_config = &config,
    };

    esp_https_ota_handle_t https_ota_handle = NULL;
    esp_err_t err = esp_https_ota_begin(&ota_config, &https_ota_handle);
    if (err != ESP_OK) {
        ESP_LOGE(T_OTA, "ESP HTTPS OTA Begin failed");
        return ESP_FAIL;
    }

    esp_app_desc_t app_desc;
    err = esp_https_ota_get_img_desc(https_ota_handle, &app_desc);
    if (err != ESP_OK) {
        ESP_LOGE(T_OTA, "esp_https_ota_read_img_desc failed");
        goto ota_end;
    }
    err = validate_image_header(&app_desc);
    if (err != ESP_OK) {
        ESP_LOGE(T_OTA, "image header verification failed");
        goto ota_end;
    }


    log_error("UPDATE_DOWNLOAD_START", "Downloading OTA update.");
    while (1) {
        err = esp_https_ota_perform(https_ota_handle);
        if (err != ESP_ERR_HTTPS_OTA_IN_PROGRESS) {
            break;
        }
        ESP_LOGD(T_OTA, "Image bytes read: %d", esp_https_ota_get_image_len_read(https_ota_handle));
    }


    if (esp_https_ota_is_complete_data_received(https_ota_handle) != true) {
        // the OTA image was not completely received and user can customise the response to this situation.
        log_error("UPDATE_FAIL", "Complete data was not received.");
        ESP_LOGE(T_OTA, "Complete data was not received.");
    } else {
        ota_finish_err = esp_https_ota_finish(https_ota_handle);
        if ((err == ESP_OK) && (ota_finish_err == ESP_OK)) {
            log_error("UPDATE_COMPLETE", "Complete.");
            ESP_LOGI(T_OTA, "ESP_HTTPS_OTA upgrade successful. Rebooting ...");
            vTaskDelay(1000 / portTICK_PERIOD_MS);
            esp_restart();
        } else {
            log_error("UPDATE_FAIL", "Complete data was not received.");
            if (ota_finish_err == ESP_ERR_OTA_VALIDATE_FAILED) {
                ESP_LOGE(T_OTA, "Image validation failed, image is corrupted");
            }
            ESP_LOGE(T_OTA, "ESP_HTTPS_OTA upgrade failed 0x%x", ota_finish_err);
            return ESP_FAIL;
        }
    }


ota_end:
    esp_https_ota_abort(https_ota_handle);
    ESP_LOGE(T_OTA, "ESP_HTTPS_OTA upgrade failed");
    log_error("UPDATE_FAIL", "OTA upgrade failed.");
    return ESP_FAIL;
}


/*
*   @brief Function to check for OTA updates and perform OTA if available
*/
void handle_ota_check(char *tag) {

    image_info_t *image_info = malloc(sizeof(image_info_t));
    esp_err_t ota_res = check_for_ota_update(image_info);
    if(ota_res == ESP_OK) {

        if (image_info == NULL) {
            ESP_LOGE(tag, "Image info is NULL");
            return;
        }

        if (is_same_firmware_hash(image_info->binary_hash)) {
            ESP_LOGI("\n HANDLE_OTA_CHECK", "Binary up to date \n\n");
            return;
        }

        perform_ota(image_info->binary_id);
        ESP_LOGI(tag, "OTA update found. Rebooting...");
    }

    free(image_info);
}