const char *REGISTER_ENDPOINT = "/satellite/register";

typedef struct device_registration
{
    char* deviceName;
    uint8_t* deviceMACAddress;
} device_registration_t;

typedef struct satellite_success_response 
{   
    bool success;
} satellite_success_response_t;

void satellite_register_device(void *pvParameters);


void init_http_client(esp_http_client_config_t* config);