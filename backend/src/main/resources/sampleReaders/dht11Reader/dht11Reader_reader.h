#ifndef DHT11READER_READER_H
#define DHT11READER_READER_H
#include <stdint.h>

extern const int DHT11READER_READER_INPUT_SIZE;
extern const int DHT11READER_READER_OUTPUT_SIZE;
double* dht11Reader_ReaderFunction(int *pin, int count);

#endif /* DHT11READER_READER_H */
