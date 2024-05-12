#include "target_device_type.h"

SensorInstantiation FTL_DHT11_outside = {
    .sensor = &DHT11_sensor,
    .name = "outside",
    .pins = {1, 2},
    .pinCount = 2,
    .samplingRate = {1, SECOND}
};
SensorInstantiation FTL_light_top = {
    .sensor = &light_sensor,
    .name = "top",
    .pins = {3},
    .pinCount = 1,
    .samplingRate = {2, SECOND}
};

DeviceType base_device_type = {
    .name = "FTL",
    .sensorInstantiations = {&FTL_DHT11_outside, &FTL_light_top},
    .sensorCount = 2,
    .batchRatePolicy = {1, SECOND},
    .batchSizePolicy = 0,
    .heartBeatPolicy = {10, SECOND}
};

DeviceType* get_device_type_constrained(double* readings) {
	DeviceType* modified = duplicateDeviceType(&base_device_type);
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
		modified->sensorInstantiations[1]->samplingRate.unit = DAY;
	}
	if (((outside_temp == 90.12 && top_value > 200) || (outside_temp == 90.0 && top_value > 20))) {
		modified->sensorInstantiations[1]->samplingRate.value = 4;
		modified->sensorInstantiations[1]->samplingRate.unit = DAY;
	}
	
	
	
	return modified;
}
