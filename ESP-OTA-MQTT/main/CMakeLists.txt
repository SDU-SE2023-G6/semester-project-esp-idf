idf_component_register(SRCS "./main.c" "./sensors/DHT11_sensor.c" "./sensors/dht11Reader_reader.c" "./sensors/lightResReader_reader.c" "./sensors/light_sensor.c" "./sensors/shared_snem_library.c" "./sensors/target_device_type.c" "./src/http_routine.c" "./src/mqtt_routine.c" "./src/ntp.c" "./src/ota_routine.c" "./src/sensor_utils.c" "./src/spiffs.c" 
                    INCLUDE_DIRS "." "headers" "sensors"
                    # Embed the server root certificate into the final binary
                    EMBED_TXTFILES ${project_dir}/server_certs/ca_cert.pem
                    REQUIRES json esp_event esp_netif mqtt esp_http_client app_update esp_https_ota nvs_flash esp_wifi spiffs esp_adc
                )

set_target_properties(${COMPONENT_LIB} PROPERTIES COMPILE_FLAGS -Wno-maybe-uninitialized)

