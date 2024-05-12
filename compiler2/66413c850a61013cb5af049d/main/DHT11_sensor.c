#include "DHT11_sensor.h"

Sensor DHT11_sensor = {
    .name = "DHT11",
    .reader = "dht11Reader",
    .readerFunction = &dht11Reader_ReaderFunction,
    .units[0] = "C",
    .units[1] = "A",
    .unitCount = 2,
    .pins[0] = "data",
    .pins[1] = "ref",
    .pinCount = 2,
    .out[0] = "temp",
    .out[1] = "humidity",
    .outCount = 2
};   	    
