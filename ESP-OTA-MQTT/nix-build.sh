#!/bin/sh
folder_path="./main"

# Find all .c files in the folder recursively and extract their base names
c_files=$(find "$folder_path" -maxdepth 1 -name "*.c" -exec basename {} \; | sed 's/.*/"&"/' | tr '\n' ' ')

# Construct the sed command to replace SRCS argument
sed_command="/^idf_component_register/s/SRCS .*/SRCS $c_files/"

# Run sed to modify the file
sed -i "$sed_command" ./main/CMakeLists.txt

nix --offline --experimental-features 'nix-command flakes' develop github:mirrexagon/nixpkgs-esp-dev#esp32-idf -c cmake .
nix --offline --experimental-features 'nix-command flakes' develop github:mirrexagon/nixpkgs-esp-dev#esp32-idf -c make
