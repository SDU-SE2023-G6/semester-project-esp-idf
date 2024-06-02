#include "ntp.h"

#include <stdio.h>
#include <time.h>
#include <sys/time.h>
#include "esp_log.h"
#include "esp_sntp.h"

esp_err_t initialize_sntp(int max_retries, int delay_ms) {
    int retry = 0;
    time_t now = 0;
    struct tm timeinfo = {0};

    sntp_setoperatingmode(SNTP_OPMODE_POLL);
    sntp_setservername(0, "pool.ntp.org");  // Use the NTP pool server
    sntp_init();

    while (sntp_get_sync_status() == SNTP_SYNC_STATUS_RESET && ++retry < max_retries) {
        ESP_LOGI("SNTP", "Waiting for system time to be set... (%d/%d)", retry, max_retries);
        vTaskDelay(delay_ms / portTICK_PERIOD_MS);
    }

    if (retry == max_retries) {
        ESP_LOGE("SNTP", "Failed to synchronize time within the given retries");
        // Handle error (e.g., use a default time, retry later, notify user)
        return ESP_FAIL;
    }

    time(&now);
    localtime_r(&now, &timeinfo);

    ESP_LOGI("SNTP", "\n Current time: %s \n", asctime(&timeinfo));

    return ESP_OK;
}
