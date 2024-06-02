#ifndef NTP_H
#define NTP_H

#include "esp_err.h"

esp_err_t initialize_sntp(int max_retries, int delay_ms);

#endif /* NTP_H */