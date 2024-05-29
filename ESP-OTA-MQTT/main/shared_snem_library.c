#include "shared_snem_library.h"

DeviceType* duplicateDeviceType(const DeviceType* original) {
    DeviceType* duplicated = (DeviceType*)malloc(sizeof(DeviceType));
    if (duplicated == NULL) {
        fprintf(stderr, "Memory allocation failed\n");
        exit(EXIT_FAILURE);
    }

    memcpy(duplicated, original, sizeof(DeviceType));

    duplicated->sensorCount = original->sensorCount;
    for (int i = 0; i < original->sensorCount; i++) {
        SensorInstantiation* duplicatedInstantiation = (SensorInstantiation*)malloc(sizeof(SensorInstantiation));
        if (duplicatedInstantiation == NULL) {
            fprintf(stderr, "Memory allocation failed\n");
            exit(EXIT_FAILURE);
        }
        memcpy(duplicatedInstantiation, original->sensorInstantiations[i], sizeof(SensorInstantiation));
        duplicated->sensorInstantiations[i] = duplicatedInstantiation;
    }

    return duplicated;
}


void freeDeviceType(DeviceType* deviceType) {
    if (deviceType == NULL) {
        return;
    }
    for (int i = 0; i < deviceType->sensorCount; i++) {
        free(deviceType->sensorInstantiations[i]);
    }
    free(deviceType);
}
