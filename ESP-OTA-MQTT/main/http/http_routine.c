
#include <string.h>
#include <sys/param.h>
#include <stdlib.h>
#include <ctype.h>
#include "freertos/FreeRTOS.h"
#include "freertos/task.h"
#include "esp_system.h"
#include <esp_err.h>
#include "esp_tls.h"
#include "esp_log.h"
#include "esp_system.h"

#include <esp_http_client.h>
#include "http_routine.h"
#include "cJSON.h"
#include "esp_mac.h"

#include "sdkconfig.h" // Load the config files



#include "esp_http_client.h"


#define MAX_HTTP_RECV_BUFFER 512
#define MAX_HTTP_OUTPUT_BUFFER 2048

static const char *T_HTTP = "HTTP_ROUTING";


/**
 * @brief Event handler handling the registation of the device to the server
*/
esp_err_t _http_event_handler(esp_http_client_event_t *evt)
{
    static char *output_buffer;  // Buffer to store response of http request from event handler
    static int output_len;       // Stores number of bytes read
    switch(evt->event_id) {
        case HTTP_EVENT_ERROR:
            ESP_LOGI(T_HTTP, "HTTP_EVENT_ERROR");
            break;
        case HTTP_EVENT_ON_CONNECTED:
            ESP_LOGI(T_HTTP, "HTTP_EVENT_ON_CONNECTED");
            break;
        case HTTP_EVENT_HEADER_SENT:
            ESP_LOGI(T_HTTP, "HTTP_EVENT_HEADER_SENT");
            break;
        case HTTP_EVENT_ON_HEADER:
            ESP_LOGI(T_HTTP, "HTTP_EVENT_ON_HEADER, key=%s, value=%s", evt->header_key, evt->header_value);
            break;
        case HTTP_EVENT_ON_DATA:
            /*** Standard code from the ESP IDF example ***/
            // Clean the buffer in case of a new request
            if (output_len == 0 && evt->user_data) {
                // we are just starting to copy the output data into the use
                memset(evt->user_data, 0, MAX_HTTP_OUTPUT_BUFFER);
            }
            if (!esp_http_client_is_chunked_response(evt->client)) {
                // If user_data buffer is configured, copy the response into the buffer
                int copy_len = 0;
                if (evt->user_data) {
                    // The last byte in evt->user_data is kept for the NULL character in case of out-of-bound access.
                    copy_len = MIN(evt->data_len, (MAX_HTTP_OUTPUT_BUFFER - output_len));
                    if (copy_len) {
                        memcpy(evt->user_data + output_len, evt->data, copy_len);
                    }
                } else {
                    int content_len = esp_http_client_get_content_length(evt->client);
                    if (output_buffer == NULL) {
                        // We initialize output_buffer with 0 because it is used by strlen() and similar functions therefore should be null terminated.
                        output_buffer = (char *) calloc(content_len + 1, sizeof(char));
                        output_len = 0;
                        if (output_buffer == NULL) {
                            ESP_LOGE(T_HTTP, "Failed to allocate memory for output buffer");
                            return ESP_FAIL;
                        }
                    }
                    copy_len = MIN(evt->data_len, (content_len - output_len));
                    if (copy_len) {
                        memcpy(output_buffer + output_len, evt->data, copy_len);
                    }
                }
                output_len += copy_len;
            }

            break;
        case HTTP_EVENT_ON_FINISH:
            ESP_LOGI(T_HTTP, "HTTP_EVENT_ON_FINISH");
            if (output_buffer != NULL) {
                // Response is accumulated in output_buffer. Uncomment the below line to print the accumulated response
                // ESP_LOG_BUFFER_HEX(T_HTTP, output_buffer, output_len);
                free(output_buffer);
                output_buffer = NULL;
            }
            output_len = 0;
            break;
        case HTTP_EVENT_DISCONNECTED:
            ESP_LOGI(T_HTTP, "HTTP_EVENT_DISCONNECTED");
            int mbedtls_err = 0;
            esp_err_t err = esp_tls_get_and_clear_last_error((esp_tls_error_handle_t)evt->data, &mbedtls_err, NULL);
            if (err != 0) {
                ESP_LOGI(T_HTTP, "Last esp error code: 0x%x", err);
                ESP_LOGI(T_HTTP, "Last mbedtls failure: 0x%x", mbedtls_err);
            }
            if (output_buffer != NULL) {
                free(output_buffer);
                output_buffer = NULL;
            }
            output_len = 0;
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

void create_device_registration_payload(char *deviceName, char *deviceMACAddress, char *payload) {
    cJSON *root = cJSON_CreateObject();
    cJSON_AddStringToObject(root, "deviceName", deviceName);
    cJSON_AddStringToObject(root, "deviceMACAddress", deviceMACAddress);
    strcpy(payload, cJSON_PrintUnformatted(root));
    cJSON_Delete(root);
}

void http_register_deivce(void)
{
	 // Declare local_response_buffer with size (MAX_HTTP_OUTPUT_BUFFER + 1) to prevent out of bound access when
    // it is used by functions like strlen(). The buffer should only be used upto size MAX_HTTP_OUTPUT_BUFFER
    char local_response_buffer[MAX_HTTP_OUTPUT_BUFFER + 1] = {0};
    /**
     * NOTE: All the configuration parameters for http_client must be spefied either in URL or as host and path parameters.
     * If host and path parameters are not set, query parameter will be ignored. In such cases,
     * query parameter should be specified in URL.
     *
     * If URL as well as host and path parameters are specified, values of host and path will be considered.
     */
	bool success = false;

    char *payload = (char *)malloc(MAX_HTTP_OUTPUT_BUFFER);

    uint8_t esp_mac_address[6] = {0};
    esp_read_mac(esp_mac_address, ESP_MAC_WIFI_STA);

    ESP_LOGI(T_HTTP, "MAC Address: %02x:%02x:%02x:%02x:%02x:%02x", 
            esp_mac_address[0], esp_mac_address[1], esp_mac_address[2], 
            esp_mac_address[3], esp_mac_address[4], esp_mac_address[5]);

    char* deviceMACAddress = (char *)malloc(18);
    sprintf(deviceMACAddress, "%02x:%02x:%02x:%02x:%02x:%02x", 
            esp_mac_address[0], esp_mac_address[1], esp_mac_address[2], 
            esp_mac_address[3], esp_mac_address[4], esp_mac_address[5]);

    create_device_registration_payload("New ESP", deviceMACAddress, payload);
    esp_http_client_config_t config = {
        .url = CONFIG_SERVER_URL"/satellite/register",
        .event_handler = _http_event_handler,
        .method = HTTP_METHOD_POST,
        .disable_auto_redirect = true,
    };

    esp_http_client_handle_t client = esp_http_client_init(&config);
    esp_http_client_set_post_field(client, payload, strlen(payload));
    esp_http_client_set_header(client, "Content-Type", "application/json");

    // GET
    esp_err_t err = esp_http_client_perform(client);
    if (err == ESP_OK) {
        ESP_LOGI(T_HTTP, "HTTP GET Status = %d, content_length = %"PRId64,
                esp_http_client_get_status_code(client),
                esp_http_client_get_content_length(client));

		success = true;
    } else {
        ESP_LOGE(T_HTTP, "HTTP GET request failed: %s", esp_err_to_name(err));
    }
    ESP_LOG_BUFFER_HEX(T_HTTP, local_response_buffer, strlen(local_response_buffer));

    free(payload);
    free(deviceMACAddress);
    esp_http_client_cleanup(client);
}

void satellite_register_device(void *pvParameters) {
	http_register_deivce();

    vTaskDelete(NULL);
}



