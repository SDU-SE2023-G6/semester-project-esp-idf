idf_component_register(SRCS "main.c" "src/http_routine.c" "src/mqtt_routine.c" "src/ota_routine.c" 
                    INCLUDE_DIRS "." "headers"
                    # Embed the server root certificate into the final binary
                    EMBED_TXTFILES ${project_dir}/server_certs/ca_cert.pem
                    REQUIRES json esp_event esp_netif mqtt esp_http_client app_update esp_https_ota nvs_flash esp_wifi spiffs esp_adc
                )

set_target_properties(${COMPONENT_LIB} PROPERTIES COMPILE_FLAGS -Wno-maybe-uninitialized)

