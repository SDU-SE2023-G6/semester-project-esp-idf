#include "lightResReader_reader.h"
#include <stdio.h>

const int LIGHTRESREADER_READER_INPUT_SIZE = 1;
const int LIGHTRESREADER_READER_OUTPUT_SIZE = 1;

void lightResReader_ReaderFunction(SensorInstantiation *instantiation) {
    if (instantiation->pinCount != 1) {
        printf("Error: Expected 1 inputs, received %d\n", instantiation->pinCount);
        return;
    }

    if (!instantiation->configured) {
        instantiation->configured = 1;
    }

    instantiation->readings[0] = 13.3;
}
