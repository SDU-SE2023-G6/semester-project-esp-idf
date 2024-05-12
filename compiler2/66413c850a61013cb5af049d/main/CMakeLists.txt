idf_component_register(SRCS "dht11Reader_reader.c" "light_sensor.c" "ota_routine.c" "ntp.c" "main.c" "lightResReader_reader.c" "target_device_type.c" "http_routine.c" "mqtt_routine.c" "DHT11_sensor.c" "shared_snem_library.c" 
                    INCLUDE_DIRS "." "files" "sensors"
                    # Embed the server root certificate into the final binary
                    EMBED_TXTFILES ${project_dir}/server_certs/ca_cert.pem
                    REQUIRES json esp_event esp_netif mqtt esp_http_client app_update esp_https_ota nvs_flash esp_wifi spiffs
                )

set_target_properties(${COMPONENT_LIB} PROPERTIES COMPILE_FLAGS -Wno-maybe-uninitialized)

