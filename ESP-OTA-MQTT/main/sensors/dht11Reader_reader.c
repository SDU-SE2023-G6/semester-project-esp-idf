#include "dht11Reader_reader.h"
#include <stdio.h>

const int DHT11READER_READER_INPUT_SIZE = 2;
const int DHT11READER_READER_OUTPUT_SIZE = 2;

double* dht11Reader_ReaderFunction(int *pin, int count) {
    if (count != 2) {
        printf("Error: Expected 2 inputs, received %d\n", count);
        return NULL;
    }

    static double result[2];

    result[0] = 25.5;
    result[1] = 50.0;

    return result;
}
