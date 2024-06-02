#ifndef LIGHTRESREADER_READER_H
#define LIGHTRESREADER_READER_H
#include <stdint.h>

extern const int LIGHTRESREADER_READER_INPUT_SIZE;
extern const int LIGHTRESREADER_READER_OUTPUT_SIZE;
double* lightResReader_ReaderFunction(int *pin, int count);

#endif /* LIGHTRESREADER_READER_H */
