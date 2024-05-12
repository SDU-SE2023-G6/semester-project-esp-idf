#ifndef TARGET_DEVICE_TYPE_H
#define TARGET_DEVICE_TYPE_H
#include <stdio.h>
#include "shared_snem_library.h"

DeviceType* getDeviceTypeConstrained(double* readings);


extern DeviceType dummy_device_type;

#endif /* TARGET_DEVICE_TYPE_H */
