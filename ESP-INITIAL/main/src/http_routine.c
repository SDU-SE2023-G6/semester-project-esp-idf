#include "http_routine.h"

#include <string.h>
#include <sys/param.h>
#include <stdlib.h>
#include <ctype.h>
#include "freertos/FreeRTOS.h"
#include "freertos/task.h"
#include <esp_err.h>
#include "esp_tls.h"
#include "esp_log.h"
#include "esp_system.h"

#include <esp_http_client.h>
#include "http_routine.h"
#include "cJSON.h"
#include "esp_mac.h"

#include "sdkconfig.h" // Load the config files
#include "http_routine.h"
#include "ota_routine.h"
#include "mqtt_routine.h"

#include "esp_http_client.h"

#define MAX_HTTP_RECV_BUFFER 512
#define MAX_HTTP_OUTPUT_BUFFER 2048

static const char *T_HTTP = "HTTP_ROUTING";

char* http_data;
int data_length = 0;


static void cleanup_http_data()
{
    if (http_data != NULL) {
        free(http_data);
        http_data = NULL;
        data_length = 0;
    }
}

/**
 * @brief Event handler handling the registation of the device to the server
 */
esp_err_t _http_event_handler(esp_http_client_event_t *evt)
{
    switch (evt->event_id)
    {
    case HTTP_EVENT_ERROR:
        ESP_LOGI(T_HTTP, "HTTP_EVENT_ERROR");
        cleanup_http_data();
        break;
    case HTTP_EVENT_ON_CONNECTED:
        ESP_LOGI(T_HTTP, "HTTP_EVENT_ON_CONNECTED");
        break;
    case HTTP_EVENT_HEADER_SENT:
        break;
    case HTTP_EVENT_ON_HEADER:
        ESP_LOGI(T_HTTP, "HTTP_EVENT_ON_HEADER, key=%s, value=%s", evt->header_key, evt->header_value);
        break;
    case HTTP_EVENT_ON_DATA:

        http_data = (char *)malloc(MAX_HTTP_OUTPUT_BUFFER+ 1);
        data_length = MAX_HTTP_RECV_BUFFER;
        int received_data = 0;

        if (!esp_http_client_is_chunked_response(evt->client))
        {
            ESP_LOGI("HTTP", "Non-chunked data");
            esp_http_client_read(client, http_data, MAX_HTTP_RECV_BUFFER);
            ESP_LOGI("HTTP", "Data non-chunked: %s", http_data);
        }
        else
        {
            ESP_LOGI("HTTP", "Chunked data length %d", evt->data_len);
            if (evt->data_len <= 0)
            {
                break;
            }
            if (received_data + evt->data_len > MAX_HTTP_RECV_BUFFER)
            {
                data_length += MAX_HTTP_OUTPUT_BUFFER;
                char* new_data = (char*)realloc(http_data, data_length + 1);
                if (new_data == NULL)
                {
                    ESP_LOGE("HTTP", "Failed to allocate memory for chunked data");
                    return ESP_FAIL;
                    break;
                }
                http_data = new_data;
            }
            memcpy(http_data + received_data, evt->data, evt->data_len);
            received_data += evt->data_len;
        }
        break;
    case HTTP_EVENT_ON_FINISH:
        ESP_LOGI("HTTP", "Data finished: %s", http_data);
        http_data[data_length] = '\0'; // Null terminate the string
        ESP_LOGI(T_HTTP, "HTTP_EVENT_ON_FINISH");
        break;
    case HTTP_EVENT_DISCONNECTED:
        ESP_LOGI(T_HTTP, "HTTP_EVENT_DISCONNECTED");
        int mbedtls_err = 0;
        esp_err_t err = esp_tls_get_and_clear_last_error((esp_tls_error_handle_t)evt->data, &mbedtls_err, NULL);
        if (err != 0)
        {
            ESP_LOGI(T_HTTP, "Last esp error code: 0x%x", err);
            ESP_LOGI(T_HTTP, "Last mbedtls failure: 0x%x", mbedtls_err);
        }

        break;
    case HTTP_EVENT_REDIRECT:
        ESP_LOGI(T_HTTP, "HTTP_EVENT_REDIRECT");
        esp_http_client_set_header(evt->client, "From", "user@example.com");
        esp_http_client_set_header(evt->client, "Accept", "text/html");
        esp_http_client_set_redirection(evt->client);
        break;
    }
    return ESP_OK;
}

void create_device_registration_payload(char *deviceName, char *deviceMACAddress, char *payload)
{
    cJSON *root = cJSON_CreateObject();
    cJSON_AddStringToObject(root, "deviceName", deviceName);
    cJSON_AddStringToObject(root, "deviceMACAddress", deviceMACAddress);
    strcpy(payload, cJSON_PrintUnformatted(root));
    cJSON_Delete(root);
}

esp_err_t check_for_ota_update(image_info_t* image_info)
{
    char device_mac[32] = {0};
    copy_mac_address(device_mac);

    char check_url[256];
    sprintf(check_url,
            "%s/program/binary-discovery/%s", CONFIG_SERVER_URL, device_mac);

    ESP_LOGI(T_HTTP, "Checking for updates at %s", check_url);

    esp_http_client_config_t config = {
        .url = check_url,
        .event_handler = _http_event_handler,
        .method = HTTP_METHOD_GET,
        .disable_auto_redirect = true,
    };

    esp_http_client_handle_t http_client = esp_http_client_init(&config);

    // GET
    esp_err_t err = esp_http_client_perform(http_client);
    if (err == ESP_OK)
    {
        int status_code = esp_http_client_get_status_code(http_client);
        ESP_LOGI(T_HTTP, "HTTP GET Status = %d, content_length = %d",
                 status_code,
                 data_length);
        // TODO: log update avaialable
        if (status_code != 200)
        {
            ESP_LOGE(T_HTTP, "Failed to get update with code %d", status_code);
            return ESP_FAIL;
        }

        // get response content
        cJSON *root = cJSON_Parse(http_data);

        ESP_LOGI(T_HTTP, "Response: %s", http_data);

        if (root == NULL)
        {
            ESP_LOGE(T_HTTP, "Failed to parse JSON");
            return ESP_FAIL;
        }

        cJSON *updateId = cJSON_GetObjectItem(root, "binaryId");
        cJSON *binaryHash = cJSON_GetObjectItem(root, "binaryHash");

        if (updateId == NULL || binaryHash == NULL)
        {
            ESP_LOGE(T_HTTP, "Failed to get updateId or binaryHash");
            cleanup_http_data();
            return ESP_FAIL;
        }

        ESP_LOGI(T_HTTP, "Update available: %s", updateId->valuestring);
        ESP_LOGI(T_HTTP, "Binary hash: %s", binaryHash->valuestring);

        // TODO: do check here
        image_info->binary_id = updateId->valuestring;
        image_info->binary_hash = binaryHash->valuestring;

        // CLeanup the sockets
        esp_http_client_cleanup(client);
        cleanup_http_data();
        return ESP_OK;
    }
    else
    {
        ESP_LOGE(T_HTTP, "HTTP GET request failed: %s", esp_err_to_name(err));
        // TODO: LOG ERROR
        return ESP_FAIL;
    }

    return ESP_OK;
}
