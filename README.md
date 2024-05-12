### ESP Device Behavior and Communication Protocol with Master Server

#### Overview
The ESP device operates as a satellite unit, frequently communicating with the master server. Its core functions include sensor data collection, log maintenance, device registration, and Over-The-Air (OTA) firmware updates.

#### MQTT Communication Topics
- **Logs** (`satellite/logs`): Messages related to device operations and status.
- **DataPoints** (`satellite/data`): Sensor data collected by the device.
- **Registration** (`satellite/register`): Initial device registration.

#### JSON Structures for MQTT Messages

##### Registration
The ESP device sends a registration request to the server with its MAC address at `satellite/logs`:

```json
{
  "satellite_mac_address": "02:1A:2B:3C:4D:5E"
}
```

The server will add the device to the database or ignore the request if the device is already registered.
This registration process is sent by the satellite when it is unable to get an binary from the server based on its MAC adress, meaning it is not registered.


##### Logging
Logs are made and stored on device under various conditions (e.g., connection status, firmware updates).
The logs stored on the device are sent to the server along the heartbeat packets, as well as during exceptional conditions (e.g., updating firmware).
Logs are sent to the server at `satellite/logs`, and the JSON structure looks like this:

```json
{
  "message": "Connected to MQTT broker",
  "type": "INFO",
  "timestamp": 1623039600,
  "satellite_mac_address": "02:1A:2B:3C:4D:5E"
}
```

The `type` field can be be of the following values:
- `INFO`: General information.
- `ERROR`: Error messages.
- `WARNING`: Warning messages.
- `DEBUG`: Debugging messages.
- `HEARTBEAT`: Heartbeat messages.
- `UPDATE_DOWNLOAD_START`: Start of firmware download.
- `UPDATE_DOWNLOAD_COMPLETE`: Completion of firmware download.
- `UPDATE_START`: Start of firmware update.
- `UPDATE_COMPLETE`: Completion of firmware update.
- `UPDATE_SUCCESS`: Successful firmware update.	
- `UPDATE_FAIL`: Failed firmware update.
- `UPDATE_ROLLBACK_START`: Start of firmware update rollback.
- `UPDATE_ROLLBACK_SUCCESS`: Successful firmware update rollback.
- `UPDATE_ROLLBACK_FAIL`: Failed firmware update rollback.

The `timestamp` field is the Unix timestamp of the log event.
The `message` field is optional and contains the log message in human-readable format.

The server will store these logs in the database for future reference linked to the device.
When a log with an empty `message` field is received, the server will generate the message based on the `type` field.

###### Heartbeat Logs

Hearbeat logs feature the `HEARTBEAT` type and include the `next_heartbeat` field, which is the Unix timestamp of the next heartbeat.

```json
{
  "type": "HEARTBEAT",
  "timestamp": 1623039600,
  "next_heartbeat": 1623039660,
  "satellite_mac_address": "02:1A:2B:3C:4D:5E"
}
```

The `next_heartbeat` field is used to calculate the time until the next heartbeat by the server.
It allows the server to monitor the device's health and connectivity status.

##### Sensor Data
The ESP device collects data from connected sensors and sends it in batches, based on the configured batch policy.

```json
{
  "value": 23,
  "unit": "°C",
  "sensor": "temperature",
  "timestamp": 1623039600,
  "satellite_mac_address": "02:1A:2B:3C:4D:5E"
}
```

The `value` field contains the sensor reading, and the `unit` field contains the unit of measurement.
The `sensor` field contains the sensor name, and the `timestamp` field is the Unix timestamp of the data point reading.

The server will store these data points in the database linked to the device.

#### Device Registration and OTA Updates

##### Registration Process
- **New Device**: Upon initial setup or reset, the ESP sends its MAC address to the server to register or re-register.
- **Check for Updates**: During each heartbeat, the device checks if there is a new firmware available.

##### OTA Update Process
- **Query for Update**: The device queries the server using its MAC address to discover if a new firmware is available.
- **Firmware Comparison**: If the server's response includes a firmware hash different from the current one, the device initiates the update process.
- **Firmware Download and Update**:
  1. The device requests the firmware binary from the server.
  2. The device start downloading the firmware binary.
  3. The device verifies the downloaded binary using the hash provided by the server.
  4. The device updates the firmware if the hash matches.
  5. The device sends a log to the server indicating the success or failure of the update.
  6. The device may rollback to the previous firmware if the update fails, and log it's success or failure.

#### Binary discovery

To check for updates, the ESP device queries the server with its MAC address at the HTTP GET `/program/binary-discovery/` endpoint.
Usage: `GET http://<BACKEND_IP>:8080/program/binary-discovery/<mac_address>`.

The server will respond with the binary hash and binary ID that the device should be using.

```json
{
  "binaryHash": "SHA256HASHOFBINARY",
  "binaryId": "245544",
}
```

If no firmware binary is found for the provided MAC address or the device is not registered, the server will respond with an error message :

```json
{
  "status": 404,
  "error": "No binary found for provided MAC address."
}
```