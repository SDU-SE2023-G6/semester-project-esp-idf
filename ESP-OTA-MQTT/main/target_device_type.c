#include "target_device_type.h"

SensorInstantiation HTL_DHT11_outside = {
    .sensor = &DHT11_sensor,
    .name = "outside",
    .pins = {1, 2},
    .pinCount = 2,
    .samplingRate = {1, SECOND},
	.readings = (double[]) {0.0, 0.0}
};
SensorInstantiation HTL_light_top = {
    .sensor = &light_sensor,
    .name = "top",
    .pins = {3},
    .pinCount = 1,
    .samplingRate = {2, SECOND},
	.readings = (double[]) {0.0}
};

DeviceType base_device_type = {
    .name = "HTL",
    .sensorInstantiations = {&HTL_DHT11_outside, &HTL_light_top},
    .sensorCount = 2,
    .batchRatePolicy = {1, SECOND},
    .batchSizePolicy = 0,
    .heartBeatPolicy = {10, SECOND}
};

void constrain_device_type(DeviceType* device_type) {
	double outside_temp = device_type->sensorInstantiations[0]->readings[0];
	double outside_humidity = device_type->sensorInstantiations[0]->readings[1];
	double top_value = device_type->sensorInstantiations[0]->readings[0];
	if (outside_temp > 20) {
		device_type->sensorInstantiations[0]->samplingRate.value = 2;
		device_type->sensorInstantiations[0]->samplingRate.unit = SECOND;
	}
	if (top_value > 20) {
		device_type->sensorInstantiations[1]->samplingRate.value = 2;
		device_type->sensorInstantiations[1]->samplingRate.unit = SECOND;
	}
	if (outside_temp == 90.0) {
		device_type->sensorInstantiations[1]->samplingRate.value = 4;
		device_type->sensorInstantiations[1]->samplingRate.unit = DAY;
	}
	if (((outside_temp == 90.12 && top_value > 200) || (outside_temp == 90.0 && top_value > 20))) {
		device_type->sensorInstantiations[1]->samplingRate.value = 4;
		device_type->sensorInstantiations[1]->samplingRate.unit = DAY;
	}
}
