#ifndef HTTP_ROUTINE_H
#define HTTP_ROUTINE_H

#include "esp_http_client.h"
#include "esp_err.h"

struct image_info
{
    char* binary_id;
    char* binary_hash;
} typedef image_info_t;

void satellite_register_device(void *pvParameters);

void init_http_client(esp_http_client_config_t* config);

esp_err_t check_for_ota_update(image_info_t* image_info);

#endif