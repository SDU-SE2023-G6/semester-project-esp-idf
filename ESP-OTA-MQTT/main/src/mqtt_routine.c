#include "mqtt_routine.h"

#include "sensor_utils.h"
#include "ota_routine.h"

#include <stdio.h>
#include <stddef.h>
#include <string.h>
#include "esp_system.h"
#include "esp_event.h"
#include "esp_netif.h"
#include "protocol_examples_common.h"
#include "esp_log.h"
#include "mqtt_client.h"
#include "esp_log.h"
#include "mqtt_client.h"
#include "esp_mac.h"
#include "cJSON.h"
#include <stdio.h>
#include <stdlib.h>
#include <inttypes.h>
#include <stdint.h>
#include "esp_system.h"

#include "sdkconfig.h" // Load the config files

static const char *T_MQTT = "MQTT";

esp_mqtt_client_handle_t client = NULL;

void copy_mac_address(char *dest)
{
    uint8_t base_mac_addr[6] = {0}; // MAC address of the ESP32
    esp_read_mac(base_mac_addr, ESP_MAC_WIFI_STA);
    sprintf(dest, "%02x%02x%02x%02x%02x%02x", 
        base_mac_addr[0], base_mac_addr[1], base_mac_addr[2], 
        base_mac_addr[3], base_mac_addr[4], base_mac_addr[5]);
}

static void copy_update_topic(char* dest) {
    char device_id[18] = {0};
    copy_mac_address(device_id);
    // Set the device update and heartbeat topics
    sprintf(dest, "%s/update", device_id);
}

static void copy_heartbeat_topic(char* dest) {
    char device_id[18] = {0};
    copy_mac_address(device_id);
    // Set the device update and heartbeat topics
    sprintf(dest,"%s/satellite/logs", device_id);
}

void send_heartbeat(esp_mqtt_client_handle_t client) {
    cJSON *root = cJSON_CreateObject();

    char device_id[18] = {0};
    copy_mac_address(device_id);

    char timestamp_next[20];
    // TODO: Fix this to be a proper timestamp
    sprintf(timestamp_next, "%" PRId64, xx_time_get_time());

    char timestamp[20];
    sprintf(timestamp, "%" PRId64, xx_time_get_time());
    
    cJSON_AddStringToObject(root,"message", "Heartbeat");
    cJSON_AddStringToObject(root,"type", "HEARTBEAT");
    cJSON_AddStringToObject(root,"timestamp", timestamp);
    cJSON_AddStringToObject(root,"next_heartbeat", timestamp_next);
    cJSON_AddStringToObject(root,"satellite_mac_address", device_id);

    char data[512] = {0};
    sprintf(data, "%s", cJSON_PrintUnformatted(root));

    char device_heartbeat_topic[50] = {0}; // Topic for receiving OTA updates
    copy_heartbeat_topic(device_heartbeat_topic);

     // create a topic string for the device
    esp_mqtt_client_publish(client, device_heartbeat_topic, data, 0, 0, 0);
    cJSON_Delete(root);
}

static void mqtt_event_handler(void *handler_args, esp_event_base_t base, int32_t event_id, void *event_data)
        // subscribe to the device update topic
        msg_id = esp_mqtt_client_subscribe(client, device_update_topic, 0);

        send_heartbeat(client);

        print_user_property(event->property->user_property);
        esp_mqtt5_client_set_user_property(&publish_property.user_property, user_property_arr, USE_PROPERTY_ARR_SIZE);
        esp_mqtt5_client_set_publish_property(client, &publish_property);

        // subscribe to the device update topic
        msg_id = esp_mqtt_client_subscribe(client, device_update_topic, 0);
        send_heartbeat(client);

        // TODO: Consider using a enum here.
        // Publish a i am alive message

        esp_mqtt5_client_delete_user_property(publish_property.user_property);
        publish_property.user_property = NULL;
        break;
    case MQTT_EVENT_SUBSCRIBED:
        ESP_LOGI(T_MQTT, "MQTT_EVENT_SUBSCRIBED, msg_id=%d", event->msg_id);
        print_user_property(event->property->user_property);
        break;
    case MQTT_EVENT_SUBSCRIBED:
        ESP_LOGI(T_MQTT, "MQTT_EVENT_SUBSCRIBED, msg_id=%d", event->msg_id);
        print_user_property(event->property->user_property);
        esp_mqtt5_client_set_publish_property(client, &publish_property);
        ESP_LOGI(T_MQTT, "sent publish successful, msg_id=%d", msg_id);
        break;
    case MQTT_EVENT_UNSUBSCRIBED:
        ESP_LOGI(T_MQTT, "MQTT_EVENT_UNSUBSCRIBED, msg_id=%d", event->msg_id);
        esp_mqtt_client_disconnect(client);
        break;
    case MQTT_EVENT_PUBLISHED:
        ESP_LOGI(T_MQTT, "MQTT_EVENT_PUBLISHED, msg_id=%d", event->msg_id);
        break;
    case MQTT_EVENT_DATA:

        char *topic = malloc(event->topic_len + 1);
        memcpy(topic, event->topic, event->topic_len);
        topic[event->topic_len] = '\0';

        // Check which topic the message was received on
        if (strcmp(topic, device_update_topic) == 0) {
            ESP_LOGI(T_MQTT, "OTA update received");
            ESP_LOGI(T_MQTT, "Handle OTA data: %.*s", event->data_len, event->data);
            cJSON *root = cJSON_Parse(event->data);
            cJSON *url = cJSON_GetObjectItem(root, "url");
            if (url) {
                ESP_LOGI(T_MQTT, "OTA URL: %s", url->valuestring);
                // Start the OTA update
                esp_err_t OTA_RESULT = perform_ota(url->valuestring);
                if (OTA_RESULT == ESP_OK) {
                    ESP_LOGI(T_MQTT, "OTA update successful");
                } else {
                    ESP_LOGI(T_MQTT, "OTA update failed");
                }
            } else {
                ESP_LOGI(T_MQTT, "OTA URL not found");
            }
            cJSON_Delete(root);

        } else if (strcmp(topic, device_heartbeat_topic) == 0) {
            ESP_LOGI(T_MQTT, "Other topic received %s", topic);
        }

        free(topic);
        break;
    case MQTT_EVENT_ERROR:
        ESP_LOGI(T_MQTT, "MQTT_EVENT_ERROR");
        break;
    default:
        ESP_LOGI(T_MQTT, "Other event id:%d", event->event_id);
        break;
    }
}

void mqtt_app_start(void)
{
    /*** SETUP THE MAC ADDRESS STUFF ***/
    // Get and set the mac address of the device

     // create a topic string for the device
    char device_topic[32] = {0};
    copy_mac_address(device_topic);

    // print the base topic the device is using
    ESP_LOGI(T_MQTT, "Connect on %s", device_topic);

    esp_mqtt_client_config_t mqtt_cfg = {
        .broker.address.uri = CONFIG_BROKER_URL,
    };

    esp_mqtt_client_handle_t client = esp_mqtt_client_init(&mqtt_cfg);

    /* The last argument may be used to pass data to the event handler, in this example mqtt_event_handler */
    esp_mqtt_client_register_event(client, ESP_EVENT_ANY_ID, mqtt_event_handler, NULL);
    esp_mqtt_client_start(client);

    // Register the device
    register_device(client);
}



esp_err_t register_device(esp_mqtt_client_handle_t client)
{
    cJSON *root = cJSON_CreateObject();

     // create a topic string for the device
    char device_id[32] = {0};
    copy_mac_address(device_id);

    cJSON_AddStringToObject(root, "satellite_mac_address", device_id);

    char device_data[50] = {0};
    sprintf(device_data, "%s", cJSON_PrintUnformatted(root));

    cJSON_AddStringToObject(root, "satellite_mac_address", device_id);
    esp_mqtt_client_publish(client, "satellite/register", device_data, 0, 0, 0);

    cJSON_Delete(root);
    // Start the MQTT client
    return ESP_OK;
}
