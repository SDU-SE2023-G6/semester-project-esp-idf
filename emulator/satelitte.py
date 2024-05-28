import paho.mqtt.client as mqtt
import json
import uuid
import time
import requests

import random

def random_mac_address():
    # Generate first byte with the local admin and unicast bits set
    first_byte = random.choice([0x02, 0x06, 0x0A, 0x0E])  # Locally administered and unicast
    mac = [first_byte] + [random.randint(0x00, 0xFF) for _ in range(5)]
    return ':'.join(f'{octet:02x}' for octet in mac)

# Check for a MAC_ADRESS file and read the MAC address from it
# If the file does not exist, generate a random MAC address and write it to the file
ESP_mac_address = None
try:
    with open("EMU_MAC_ADDRESS", "r") as f:
        ESP_mac_address = f.read()
        print("ESP MAC address: ", ESP_mac_address)
except FileNotFoundError:
    with open("EMU_MAC_ADDRESS", "w") as f:
        ESP_mac_address = random_mac_address()
        f.write(ESP_mac_address)
        print("ESP MAC address: ", ESP_mac_address)


ESP_firmware_hash = None

## Check if backend is running in a container or locally
# If running in a container, use the container name "backend" as the backend URL
# If running locally, use localhost as the backend URL

BACKEND_URL = None
MQTT_BROKER = None

while BACKEND_URL == None or MQTT_BROKER == None:
    try:
        response = requests.get("http://backend:8080")
        BACKEND_URL = "http://backend:8080"
        MQTT_BROKER = "mqtt_broker"
        print("Backend URL: ", BACKEND_URL)
        print("MQTT Broker: ", MQTT_BROKER)
    except requests.exceptions.ConnectionError:
        print("Unable to connect to backend as expected with container syntax.")
    try:
        response = requests.get("http://localhost:8080")
        BACKEND_URL = "http://localhost:8080"
        MQTT_BROKER = "localhost"
        print("Backend URL: ", BACKEND_URL)
        print("MQTT Broker: ", MQTT_BROKER)
    except requests.exceptions.ConnectionError:
        print("Unable to connect to backend as expected with localhost syntax.")
    
    time.sleep(1)

# The callback for when the client receives a CONNACK response from the server.
def on_connect(client, userdata, flags, reason_code, properties):
    print(f"Connected with result code {reason_code}")
    publish_log(client, time.time(), "Connected to MQTT broker", "INFO")

# Function to publish log messages to the "satellite/logs" topic
def publish_log(client, timestamp, message, msg_type):
    log_entry = {
        "message": message,
        "type": msg_type,
        "timestamp": timestamp,
        "satellite_mac_address": ESP_mac_address
    }
    client.publish("satellite/logs", json.dumps(log_entry))

def publish_log_heartbeat(client, next_heartbeat):
    log_entry = {
        "type": "HEARTBEAT",
        "timestamp": int(time.time()),
        "next_heartbeat": int(next_heartbeat),
        "satellite_mac_address": ESP_mac_address
    }
    client.publish("satellite/logs", json.dumps(log_entry))

def publish_data(client, timestamp, sensor, unit, data):
    data_entry = {
        "value": data,
        "unit": unit,
        "sensor": sensor,
        "timestamp": timestamp,
        "satellite_mac_address": ESP_mac_address
    }
    client.publish("satellite/data", json.dumps(data_entry))

def publish_register(client):
    register = {
        "satellite_mac_address": ESP_mac_address,
    }
    client.publish("satellite/register", json.dumps(register))



def query_binary_discovery(mac_address):
    # Construct the URL with the given MAC address
    base_url = f"{BACKEND_URL}/program/binary-discovery/"
    full_url = f"{base_url}{mac_address}"

    try:
        # Send an HTTP GET request
        response = requests.get(full_url)

        # Raise an exception if the request was not successful
        response.raise_for_status()

        response = response.json()

        response["status"] = 200

        # Return the JSON response content
        return response

    except requests.exceptions.HTTPError as http_err:
        return {
            "status": 404,
            "error": f"HTTP error occurred: {http_err}"
        }
    except Exception as err:
        print(f"An error occurred: {err}")

    return None

# MQTT Client setup
mqttc = mqtt.Client(mqtt.CallbackAPIVersion.VERSION2)
mqttc.on_connect = on_connect

# Connect to the MQTT broker
mqttc.connect(MQTT_BROKER, 1883, 60)

# Register the satellite
publish_register(mqttc)

ESP_logs_storage = []
ESP_data_storage = []

ESP_sensors = [
    {
        "name": "temperature",
        "unit": "°C",
        "min_value": -20,
        "max_value": 50,
        "sample_rate": 5,
        "last_sample": 0
    },
    {
        "name": "humidity",
        "unit": "%",
        "min_value": 0,
        "max_value": 100,
        "sample_rate": 20,
        "last_sample": 0
    },
    {
        "name": "pressure",
        "unit": "hPa",
        "min_value": 800,
        "max_value": 1200,
        "sample_rate": 10,
        "last_sample": 0
    }
]

ESP_config = {
    "batch_size": 10,
    "batch_timeout": 30,
    "last_batch_sent": 0,
    "heartbeat_interval": 10,
    "last_heartbeat_sent": 0
}

while True:
    if(ESP_firmware_hash != None):
        print("Sampling sensors")
        for sensor in ESP_sensors:
            if(time.time() - sensor["last_sample"] > sensor["sample_rate"]):
                sensor["last_sample"] = time.time()
                data = random.randint(sensor["min_value"], sensor["max_value"])
                ESP_data_storage.append({
                    "value": data,
                    "unit": sensor["unit"],
                    "sensor": sensor["name"],
                    "timestamp": int(time.time())
                })
        if len(ESP_data_storage) >= ESP_config["batch_size"] or time.time() - ESP_config["last_batch_sent"] > ESP_config["batch_timeout"]:
            print("Sending batch")
            for data in ESP_data_storage:
                publish_data(mqttc, data["timestamp"], data["sensor"], data["unit"], data["value"])
            ESP_data_storage = []
            ESP_config["last_batch_sent"] = time.time()
    if time.time() - ESP_config["last_heartbeat_sent"] > ESP_config["heartbeat_interval"]:
        binary_discovery = query_binary_discovery(ESP_mac_address)
        if binary_discovery == None or binary_discovery["status"] == 404:
            print("No binary found, registering")
            publish_register(mqttc)
        else:
            print("Sending heartbeat")
            publish_log_heartbeat(mqttc, time.time() + ESP_config["heartbeat_interval"])
            if binary_discovery["binaryHash"] != ESP_firmware_hash:
                print("New firmware hash detected: ", ESP_firmware_hash)
                publish_log(mqttc, time.time(), "Downloading new firmware", "UPDATE_DOWNLOAD_START")
                time.sleep(2)
                publish_log(mqttc, time.time(), "Download complete, starting update", "UPDATE_DOWNLOAD_COMPLETE")
                time.sleep(2)
                publish_log(mqttc, time.time(), "Firmware update in progress", "UPDATE_START")
                time.sleep(5)
                ESP_firmware_hash = binary_discovery["binaryHash"]
                publish_log(mqttc, time.time(), "Firmware update complete", "UPDATE_SUCCESS")
        ESP_config["last_heartbeat_sent"] = time.time()
    time.sleep(1)
    