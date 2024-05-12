#ifndef SENSOR_UTILS_H // Double header include guard
#define SENSOR_UTILS_H

void log_sensor_data(const char* sensor_path, const char* data);


void sensor_routine(void *pvParameter);

void read_and_delete_file2(const char* sensor_path);

#endif