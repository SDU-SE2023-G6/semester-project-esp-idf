#!/bin/bash
base_src_path="./main"
folder_path="$base_src_path/sensors"

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
c_files=$(find "$base_src_path" -maxdepth 2 -name "*.c" | sed 's/\.\/main\///' | sed 's/.*/"&"/' | tr '\n' ' ')
c_files_escaped=$(echo "$c_files" | sed 's/"/\\"/g')
sed_command="/^idf_component_register/s|SRCS .*|SRCS $c_files_escaped|"
echo "Executing sed command: sed -i '$sed_command' \"$base_src_path/CMakeLists.txt\""
eval "sed -i '$sed_command' \"$base_src_path/CMakeLists.txt\""

# Build the project
#export CCACHE_DIR=/compiler/ccache
#idf.py --ccache build
idf.py build