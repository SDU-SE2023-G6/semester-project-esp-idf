#include "target_device_type.h"

SensorInstantiation dummy_a = {
    .sensor = NULL,
    .name = "outside",
    .pins = {1, 2},
    .pinCount = 2,
    .samplingRate = {1, SECOND}
};
SensorInstantiation dummy_b = {
    .sensor = NULL,
    .name = "top",
    .pins = {3},
    .pinCount = 1,
    .samplingRate = {2, SECOND}
};

DeviceType dummy_device_type = {
    .name = "HTL",
    .sensorInstantiations = {&dummy_a, &dummy_b},
    .sensorCount = 2,
    .batchRatePolicy = {1, SECOND},
    .batchSizePolicy = 0,
    .heartBeatPolicy = {10, SECOND}
};

DeviceType* getDeviceTypeConstrained(double* readings) {
	DeviceType* modified = duplicateDeviceType(&dummy_device_type);
	double outside_temp = readings[0];
	double outside_humidity = readings[1];
	double top_value = readings[2];
	if (outside_temp > 20) {
		modified->sensorInstantiations[0]->samplingRate.value = 2;
		modified->sensorInstantiations[0]->samplingRate.unit = SECOND;
	}
	if (top_value > 20) {
		modified->sensorInstantiations[1]->samplingRate.value = 2;
		modified->sensorInstantiations[1]->samplingRate.unit = SECOND;
	}
	if (outside_temp == 90.0) {
		modified->sensorInstantiations[1]->samplingRate.value = 4;
		modified->sensorInstantiations[1]->samplingRate.unit = SECOND;
	}
	if (((outside_temp == 90.12 && top_value > 200) || (outside_temp == 90.0 && top_value > 20))) {
		modified->sensorInstantiations[1]->samplingRate.value = 4;
		modified->sensorInstantiations[1]->samplingRate.unit = SECOND;
	}
	
	
	return modified;
}
