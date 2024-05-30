#ifndef TARGET_DEVICE_TYPE_H
#define TARGET_DEVICE_TYPE_H
#include <stdio.h>
#include "shared_snem_library.h"
#include "DHT11_sensor.h"
#include "light_sensor.h"
extern DeviceType base_device_type;
DeviceType* get_device_type_constrained(double* readings);

#endif /* TARGET_DEVICE_TYPE_H */
