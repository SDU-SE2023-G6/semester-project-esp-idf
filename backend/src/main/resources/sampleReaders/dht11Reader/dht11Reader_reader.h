#ifndef DHT11READER_READER_H
#define DHT11READER_READER_H
#include <stdint.h>
#include "shared_snem_library.h"

extern const int DHT11READER_READER_INPUT_SIZE;
extern const int DHT11READER_READER_OUTPUT_SIZE;
void dht11Reader_ReaderFunction(SensorInstantiation *instantiation);

#endif /* DHT11READER_READER_H */
