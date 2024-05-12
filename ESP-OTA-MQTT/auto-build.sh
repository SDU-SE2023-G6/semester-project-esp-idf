#!/bin/sh
folder_path="./main"

# Rename device type files
rename_file() {
    for file in "$folder_path"/*_device_type.$1; do
        if [ "$file" != "$folder_path/target_device_type.$1" ]; then
            mv "$file" "$folder_path/target_device_type.$1"
        fi
    done
}
rename_file "c"
rename_file "h"


# Modify CMakeLists.txt source files
c_files=$(find "$folder_path" -maxdepth 1 -name "*.c" -exec basename {} \; | sed 's/.*/"&"/' | tr '\n' ' ')
sed_command="/^idf_component_register/s/SRCS .*/SRCS $c_files/"
sed -i "$sed_command" "$folder_path/CMakeLists.txt"

# Build the project
#source /opt/esp/entrypoint.sh 
idf.py fullclean
idf.py build