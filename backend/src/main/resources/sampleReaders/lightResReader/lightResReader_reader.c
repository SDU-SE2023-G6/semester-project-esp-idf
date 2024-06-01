#include "lightResReader_reader.h"
#include <stdio.h>

const int LIGHTRESREADER_READER_INPUT_SIZE = 1;
const int LIGHTRESREADER_READER_OUTPUT_SIZE = 1;

double* lightResReader_ReaderFunction(int *pin, int count) {
    if (count != 1) {
        printf("Error: Expected 1 inputs, received %d\n", count);
        return NULL;
    }


    static double result[1];

    result[0] = 25.5;

    return result;
}
