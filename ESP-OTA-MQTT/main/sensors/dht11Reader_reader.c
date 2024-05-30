#include "dht11Reader_reader.h"
#include <stdio.h>

const int DHT11READER_READER_INPUT_SIZE = 2;
const int DHT11READER_READER_OUTPUT_SIZE = 2;



void dht11Reader_ReaderFunction(SensorInstantiation *instantiation) {
    if (instantiation->pinCount != 2) {
        printf("Error: Expected 2 inputs, received %d\n", instantiation->pinCount);
        return;
    }
    
    if (!instantiation->configured) {
        instantiation->configured = 1;
    }

    instantiation->readings[0] = 25.5;
    instantiation->readings[1] = 50.0;
}
