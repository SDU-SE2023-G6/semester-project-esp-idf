#include "shared_snem_library.h"

DeviceType* duplicateDeviceType(const DeviceType* original) {
    // Allocate memory for the new DeviceType
    DeviceType* duplicated = (DeviceType*)malloc(sizeof(DeviceType));
    if (duplicated == NULL) {
        fprintf(stderr, "Memory allocation failed\n");
        exit(EXIT_FAILURE);
    }

    // Copy the original DeviceType into the newly allocated memory
    memcpy(duplicated, original, sizeof(DeviceType));

    // Duplicate sensor instantiations
    duplicated->sensorCount = original->sensorCount;
    for (int i = 0; i < original->sensorCount; i++) {
        // Allocate memory for each SensorInstantiation
        SensorInstantiation* duplicatedInstantiation = (SensorInstantiation*)malloc(sizeof(SensorInstantiation));
        if (duplicatedInstantiation == NULL) {
            fprintf(stderr, "Memory allocation failed\n");
            exit(EXIT_FAILURE);
        }
        // Copy the original SensorInstantiation into the duplicated one
        memcpy(duplicatedInstantiation, original->sensorInstantiations[i], sizeof(SensorInstantiation));
        // Update the pointer in the duplicated DeviceType
        duplicated->sensorInstantiations[i] = duplicatedInstantiation;
    }

    return duplicated;
}


void freeDeviceType(DeviceType* deviceType) {
    if (deviceType == NULL) {
        return;
    }
    // Free each SensorInstantiation
    for (int i = 0; i < deviceType->sensorCount; i++) {
        free(deviceType->sensorInstantiations[i]);
    }
    // Free the DeviceType itself
    free(deviceType);
}
