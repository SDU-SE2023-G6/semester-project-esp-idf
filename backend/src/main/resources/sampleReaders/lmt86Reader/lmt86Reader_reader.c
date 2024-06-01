#include "lmt86Reader_reader.h"
#include <stdio.h>
#include <math.h>
#include "esp_system.h"
#include "nvs_flash.h"
#include "esp_event.h"
#include "esp_netif.h"
#include "protocol_examples_common.h"
#include "esp_log.h"
#include "freertos/FreeRTOS.h"
#include "freertos/task.h"
#include "esp_adc/adc_oneshot.h"
#include "esp_adc/adc_cali.h"
#include "soc/adc_channel.h"

const int LMT86READER_READER_INPUT_SIZE = 1;
const int LMT86READER_READER_OUTPUT_SIZE = 1;

// =======================================
// ADC configuration
const static char *TAG_ADC = "ADC_LMT86";

#define ADC_ATTEN ADC_ATTEN_DB_11
#define ADC_BITWIDTH ADC_BITWIDTH_DEFAULT


static bool initialize_adc_calibration(adc_unit_t unit, adc_channel_t channel, adc_atten_t atten, adc_cali_handle_t *out_handle);

static bool initialize_adc_calibration(adc_unit_t unit, adc_channel_t channel, adc_atten_t atten, adc_cali_handle_t *out_handle) {
    esp_err_t ret = ESP_FAIL;
    bool calibrated = false;

    adc_cali_line_fitting_config_t cali_config = {
        .unit_id = unit,
        .atten = atten,
        .bitwidth = ADC_BITWIDTH,
    };
    ret = adc_cali_create_scheme_line_fitting(&cali_config, out_handle);
    if (ret == ESP_OK) {
        calibrated = true;
        ESP_LOGI(TAG_ADC, "Calibration Success");
    } else {
        ESP_LOGE(TAG_ADC, "Calibration Failed, error: %d", ret);
    }

    return calibrated;
}

adc_channel_t map_gpio_to_adc_channel(int gpio_num) {
    adc_channel_t adc_channel;
    switch (gpio_num) {
        case ADC1_CHANNEL_0_GPIO_NUM:
            adc_channel = ADC1_GPIO36_CHANNEL;
            break;
        case ADC1_CHANNEL_1_GPIO_NUM:
            adc_channel = ADC1_GPIO37_CHANNEL;
            break;
        case ADC1_CHANNEL_2_GPIO_NUM:
            adc_channel = ADC1_GPIO38_CHANNEL;
            break;
        case ADC1_CHANNEL_3_GPIO_NUM:
            adc_channel = ADC1_GPIO39_CHANNEL;
            break;
        case ADC1_CHANNEL_4_GPIO_NUM:
            adc_channel = ADC1_GPIO32_CHANNEL;
            break;
        case ADC1_CHANNEL_5_GPIO_NUM:
            adc_channel = ADC1_GPIO33_CHANNEL;
            break;
        case ADC1_CHANNEL_6_GPIO_NUM:
            adc_channel = ADC1_GPIO34_CHANNEL;
            break;
        case ADC1_CHANNEL_7_GPIO_NUM:
            adc_channel = ADC1_GPIO35_CHANNEL;
            break;
        case ADC2_CHANNEL_0_GPIO_NUM:
            adc_channel = ADC2_GPIO4_CHANNEL;
            break;
        case ADC2_CHANNEL_1_GPIO_NUM:
            adc_channel = ADC2_GPIO0_CHANNEL;
            break;
        case ADC2_CHANNEL_2_GPIO_NUM:
            adc_channel = ADC2_GPIO2_CHANNEL;
            break;
        case ADC2_CHANNEL_3_GPIO_NUM:
            adc_channel = ADC2_GPIO15_CHANNEL;
            break;
        case ADC2_CHANNEL_4_GPIO_NUM:
            adc_channel = ADC2_GPIO13_CHANNEL;
            break;
        case ADC2_CHANNEL_5_GPIO_NUM:
            adc_channel = ADC2_GPIO12_CHANNEL;
            break;
        case ADC2_CHANNEL_6_GPIO_NUM:
            adc_channel = ADC2_GPIO14_CHANNEL;
            break;
        case ADC2_CHANNEL_7_GPIO_NUM:
            adc_channel = ADC2_GPIO27_CHANNEL;
            break;
        case ADC2_CHANNEL_8_GPIO_NUM:
            adc_channel = ADC2_GPIO25_CHANNEL;
            break;
        case ADC2_CHANNEL_9_GPIO_NUM:
            adc_channel = ADC2_GPIO26_CHANNEL;
            break;
        default:
            // Handle invalid GPIO numbers
            adc_channel = ADC1_GPIO36_CHANNEL; // Assign a default ADC channel
            ESP_LOGE(TAG_ADC, "Invalid GPIO number, using default ADC channel");
            break;
    }
    return adc_channel;
}

struct adc_sensor_calibration {
    adc_unit_t unit;
    adc_channel_t channel;
    adc_atten_t atten;
    adc_cali_handle_t *handle;
    adc_oneshot_unit_handle_t unit_handle;
};

struct adc_sensor_calibration calibrate_adc_sensor(int gpio_num) {

    adc_oneshot_unit_handle_t adc_unit_handle;
    adc_oneshot_unit_init_cfg_t init_config = {
        .unit_id = ADC_UNIT_1,
    };
    adc_oneshot_chan_cfg_t channel_config = {
        .bitwidth = ADC_BITWIDTH,
        .atten = ADC_ATTEN,
    };
    adc_cali_handle_t adc_cali_handle = NULL;
    adc_channel_t ADC_CHANNEL = map_gpio_to_adc_channel(gpio_num);


    ESP_ERROR_CHECK(adc_oneshot_new_unit(&init_config, &adc_unit_handle));
    ESP_ERROR_CHECK(adc_oneshot_config_channel(adc_unit_handle, ADC_CHANNEL, &channel_config));
    bool calibration_success = initialize_adc_calibration(ADC_UNIT_1, ADC_CHANNEL, ADC_ATTEN, &adc_cali_handle);
    if (!calibration_success) {
        ESP_LOGE(TAG_ADC, "ADC calibration failed");
    }

    struct adc_sensor_calibration calibration;

    calibration.unit = ADC_UNIT_1;
    calibration.channel = ADC_CHANNEL;
    calibration.atten = ADC_ATTEN;
    calibration.handle = &adc_cali_handle;
    calibration.unit_handle = adc_unit_handle;


    return calibration;
}

// End of ADC configuration
// =======================================


double calculateTemperature(double vTemp);

double calculateTemperature(double vTemp) {
    double a = 10.888;
    double b = (1777.3 - vTemp);
    double c = 0.00347;
    double temperatureC = (a - sqrt(a * a + 4 * c * b)) / (2 * -c) + 30;
    return temperatureC;
}

void lmt86Reader_ReaderFunction(SensorInstantiation *instantiation) {
    if (instantiation->pinCount != 1) {
        printf("Error: Expected 1 inputs, received %d\n", instantiation->pinCount);
        return;
    }

    if (!instantiation->configured) {
        struct adc_sensor_calibration calibration = calibrate_adc_sensor(instantiation->pins[0]);
        instantiation->sensorConfig = (void *) &calibration;
        instantiation->configured = 1;
    }
    struct adc_sensor_calibration* calibration = (struct adc_sensor_calibration*) instantiation->sensorConfig;
    
    int raw_adc_value = 0;
    int voltage = 0;
    ESP_ERROR_CHECK(adc_oneshot_read(calibration->unit_handle, calibration->channel, &raw_adc_value));
    ESP_ERROR_CHECK(adc_cali_raw_to_voltage(calibration->handle, raw_adc_value, &voltage));
    double temperature = calculateTemperature((double)voltage);

    instantiation->readings[0] = temperature;
}
