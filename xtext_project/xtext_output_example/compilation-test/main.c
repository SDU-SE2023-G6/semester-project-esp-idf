#include <stdio.h>
#include <dlfcn.h> // Header for dynamic loading

#include "shared_snem_library.h" // Include the header file for the shared library

int main() {
    // Load the shared library
    void *lib_handle = dlopen("./libshared_snem.so", RTLD_LAZY);
    if (!lib_handle) {
        fprintf(stderr, "Error: %s\n", dlerror());
        return 1;
    }

    // Get the function pointers
    DeviceType *(*duplicateDeviceType)(const DeviceType *);
    void (*freeDeviceType)(DeviceType *);
    DeviceType *(*applyConstraints)(double *);

    duplicateDeviceType = dlsym(lib_handle, "duplicateDeviceType");
    freeDeviceType = dlsym(lib_handle, "freeDeviceType");
    applyConstraints = dlsym(lib_handle, "HTL_device_applyConstraints");

    if (!duplicateDeviceType || !freeDeviceType || !applyConstraints) {
        fprintf(stderr, "Error: %s\n", dlerror());
        dlclose(lib_handle);
        return 1;
    }

    // Test 1: Duplicate an empty device type
    printf("Test 1: Duplicate an empty device type\n");
    DeviceType original_empty_device_type = {
        .name = "EmptyDevice",
        .sensorCount = 0 // No sensors initially
    };
    DeviceType *duplicated_empty_device_type = duplicateDeviceType(&original_empty_device_type);
    if (!duplicated_empty_device_type) {
        fprintf(stderr, "Error: Failed to duplicate empty device type\n");
        dlclose(lib_handle);
        return 1;
    }
    printf("Duplicated Empty Device Type Name: %s\n", duplicated_empty_device_type->name);
    freeDeviceType(duplicated_empty_device_type);

    // Test 2: Duplicate a device type with sensors
    printf("\nTest 2: Duplicate a device type with sensors\n");
    Sensor sensor1 = {
        .name = "Sensor1",
        .unitCount = 1,
        .pinCount = 1,
        .outCount = 1
    };
    Sensor sensor2 = {
        .name = "Sensor2",
        .unitCount = 2,
        .pinCount = 2,
        .outCount = 2
    };
    DeviceType original_device_type = {
        .name = "DeviceWithSensors",
        .sensorCount = 2,
        .sensorInstantiations = {&sensor1, &sensor2}
    };
    DeviceType *duplicated_device_type = duplicateDeviceType(&original_device_type);
    if (!duplicated_device_type) {
        fprintf(stderr, "Error: Failed to duplicate device type with sensors\n");
        dlclose(lib_handle);
        return 1;
    }
    printf("Duplicated Device Type Name: %s\n", duplicated_device_type->name);
    printf("Number of Sensors in Duplicated Device Type: %d\n", duplicated_device_type->sensorCount);
    freeDeviceType(duplicated_device_type);

    // Test 3: Apply constraints to the device type
    printf("\nTest 3: Apply constraints to the device type\n");
    double readings[] = {90.12, 9999.9, 100.0}; // Sample readings
    DeviceType *constrained_device_type = applyConstraints(readings);
    if (!constrained_device_type) {
        fprintf(stderr, "Error: Failed to apply constraints\n");
        dlclose(lib_handle);
        return 1;
    }
    printf("Device Type Name after Applying Constraints: %s\n", constrained_device_type->name);
    printf("New Sampling Rate for Sensor 1: %d\n", constrained_device_type->sensorInstantiations[0]->samplingRate.value);
    printf("New Sampling Rate for Sensor 2: %d\n", constrained_device_type->sensorInstantiations[1]->samplingRate.value);
    freeDeviceType(constrained_device_type);

    // Close the shared library
    dlclose(lib_handle);

    return 0;
}
