#include "light_sensor.h"

Sensor light_sensor = {
    .name = "light",
    .reader = "lightResReader",
    .readerFunction = &lightResReader_ReaderFunction,
    .units[0] = "Lux",
    .unitCount = 1,
    .pins[0] = "pin",
    .pinCount = 1,
    .out[0] = "value",
    .outCount = 1
};   	    
