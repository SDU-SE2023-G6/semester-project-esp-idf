#ifndef OTA_ROUTINE_H
#define OTA_ROUTINE_H

#include "esp_http_client.h"
#include "esp_err.h"
#include "esp_ota_ops.h"
#include "esp_https_ota.h"

extern const uint8_t server_cert_pem_start[] asm("_binary_ca_cert_pem_start");
extern const uint8_t server_cert_pem_end[] asm("_binary_ca_cert_pem_end");

#define OTA_URL_SIZE 256

// static esp_err_t validate_image_header(esp_app_desc_t *new_app_info);

// static esp_err_t _http_client_init_cb(esp_http_client_handle_t http_client);

void ota_event_handler(void* arg, esp_event_base_t event_base, int32_t event_id, void* event_data);


int perform_ota(char *update_url);

#endif