idf_component_register(SRCS "main.c" "ota_routine.c" "ntp.c" "mqtt_routine.c" "http_routine.c" "dht11Reader_reader.c" "DHT11_sensor.c" "lightResReader_reader.c" "light_sensor.c" "shared_snem_library.c" "target_device_type.c" 
                    INCLUDE_DIRS "." "files" "sensors"
                    # Embed the server root certificate into the final binary
                    EMBED_TXTFILES ${project_dir}/server_certs/ca_cert.pem
                    REQUIRES json esp_event esp_netif mqtt esp_http_client app_update esp_https_ota nvs_flash esp_wifi spiffs
                )

set_target_properties(${COMPONENT_LIB} PROPERTIES COMPILE_FLAGS -Wno-maybe-uninitialized)

