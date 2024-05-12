#ifndef SHARED_SNEM_LIBRARY_H
#define SHARED_SNEM_LIBRARY_H
			
#include <stdio.h>
#include <stdlib.h>
#include <string.h>



// Pre-identify types and constants
typedef struct Sensor Sensor;
typedef struct SensorInstantiation SensorInstantiation;
typedef struct DeviceType DeviceType;
typedef struct TimeDuration TimeDuration;
typedef enum TimeUnit TimeUnit;

#define MAX_CONSTRAINTS 10
#define MAX_UNITS 100
#define MAX_PINS 100
#define MAX_OUTPUTS 100
#define MAX_INSTANTIATIONS 100

enum TimeUnit {
    SECOND,
    MINUTE,
    HOUR,
    DAY
};

struct TimeDuration {
    int value;
    TimeUnit unit;
};

struct Sensor {
    char name[100];
    char units[MAX_UNITS][100];
    int unitCount;
    char reader[150];
    double* (*readerFunction)(int*, int);
    char pins[MAX_PINS][100];
    int pinCount;
    char out[MAX_OUTPUTS][100];
    int outCount;
};

struct SensorInstantiation {
    Sensor* sensor;
    char name[100];
    int pins[MAX_PINS];
    int pinCount;
    TimeDuration samplingRate;
    double* readings;
};

struct DeviceType {
    char name[100];
    SensorInstantiation* sensorInstantiations[MAX_INSTANTIATIONS];
    int sensorCount;
    TimeDuration batchRatePolicy;
    int batchSizePolicy;
    TimeDuration heartBeatPolicy;
};

DeviceType *duplicateDeviceType(const DeviceType *original);
void freeDeviceType(DeviceType *deviceType);
	
#endif // SHARED_SNEM_LIBRARY_H
