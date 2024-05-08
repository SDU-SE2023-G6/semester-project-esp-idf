#ifndef HTL_DEVICE_TYPE_H
#define HTL_DEVICE_TYPE_H
#include <stdio.h>
#include "shared_snem_library.h"
#include "DHT11_sensor.h"
#include "light_sensor.h"

DeviceType* HTL_device_applyConstraints(double* readings);

#endif /* HTL_DEVICE_TYPE_H */
