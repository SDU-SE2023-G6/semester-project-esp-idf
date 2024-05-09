
#include <esp_http_client.h>
#include <cJSON.h>

static const char *T_HTTP = "HTTP_ROUTING";

/**
 * @brief Event handler handling the registation of the device to the server
*/
esp_err_t _http_device_register_event_handler(esp_http_client_event_t *evt)
{
	switch(evt->event_id) {
		case HTTP_EVENT_ERROR:
			ESP_LOGD(T_HTTP, "HTTP_EVENT_ERROR");
			break;
		case HTTP_EVENT_ON_CONNECTED:
			ESP_LOGD(T_HTTP, "HTTP_EVENT_ON_CONNECTED");
			break;
		case HTTP_EVENT_HEADER_SENT:
			ESP_LOGD(T_HTTP, "HTTP_EVENT_HEADER_SENT");
			break;
		case HTTP_EVENT_ON_HEADER:
			ESP_LOGD(T_HTTP, "HTTP_EVENT_ON_HEADER, key=%s, value=%s", evt->header_key, evt->header_value);
			break;
		case HTTP_EVENT_ON_DATA:
			ESP_LOGD(T_HTTP, "HTTP_EVENT_ON_DATA, evt->data_len=%d", evt->data_len);
			if (!esp_http_client_is_chunked_response(evt->client)) {
				ESP_LOG_BUFFER_HEXDUMP(T_HTTP, evt->data, evt->data_len, ESP_LOG_DEBUG);
				//char buffer[512];
				char *buffer = malloc(evt->data_len + 1);
				//esp_http_client_read(evt->client, buffer, evt->data_len);
				memcpy(buffer, evt->data, evt->data_len);
				buffer[evt->data_len] = 0;
                ESP_LOGD(T_HTTP, "HTTP_EVENT_ON_DATA, buffer=%s", buffer);
				
				free(buffer);
			}
			break;
		case HTTP_EVENT_ON_FINISH:
			ESP_LOGD(T_HTTP, "HTTP_EVENT_ON_FINISH");
			break;
		case HTTP_EVENT_DISCONNECTED:
			ESP_LOGD(T_HTTP, "HTTP_EVENT_DISCONNECTED");
			break;
#if ESP_IDF_VERSION >= ESP_IDF_VERSION_VAL(5, 0, 0)
		case HTTP_EVENT_REDIRECT:
			ESP_LOGD(T_HTTP, "HTTP_EVENT_REDIRECT");
			break;
#endif
	}
	return ESP_OK;
}


void http_request_task(void *pvParameters)
{
    esp_http_client_config_t config = {
        .url = "http://www.google.com",
        .event_handler = _http_event_handler,
    };
    esp_http_client_handle_t client = esp_http_client_init(&config);
    esp_err_t err = esp_http_client_perform(client);
    if (err == ESP_OK) {
        ESP_LOGI(T_HTTP, "HTTP GET Status = %d, content_length = %d",
                esp_http_client_get_status_code(client),
                esp_http_client_get_content_length(client));
    } else {
        ESP_LOGE(T_HTTP, "HTTP GET request failed: %s", esp_err_to_name(err));
    }
    esp_http_client_cleanup(client);
    vTaskDelete(NULL);
}