idf_component_register(SRCS "ota_routine.c" "main.c" "mqtt_routine.c"
                    INCLUDE_DIRS "." 
                    # Embed the server root certificate into the final binary
                    EMBED_TXTFILES ${project_dir}/server_certs/ca_cert.pem
                    REQUIRES json
                )

set_target_properties(${COMPONENT_LIB} PROPERTIES COMPILE_FLAGS -Wno-maybe-uninitialized)

