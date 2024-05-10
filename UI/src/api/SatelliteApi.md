# .SatelliteApi

All URIs are relative to *http://localhost:8080*

Method | HTTP request | Description
------------- | ------------- | -------------
[**deleteSatelliteById**](SatelliteApi.md#deleteSatelliteById) | **DELETE** /satellite/{satelliteId} | Delete satellite by ID.
[**editSatellite**](SatelliteApi.md#editSatellite) | **PUT** /satellite | Edit satellite.
[**getDataPointsBySatellite**](SatelliteApi.md#getDataPointsBySatellite) | **GET** /satellite/{satelliteId}/data-points | Get all data points for a satellite.
[**getSatelliteById**](SatelliteApi.md#getSatelliteById) | **GET** /satellite/{satelliteId} | Get satellite by ID.
[**getSatelliteDeviceType**](SatelliteApi.md#getSatelliteDeviceType) | **GET** /satellite/{satelliteId}/device-type-id | Get satellite device type id.
[**getSatellites**](SatelliteApi.md#getSatellites) | **GET** /satellites | Get satellites
[**satelliteRegister**](SatelliteApi.md#satelliteRegister) | **POST** /satellite/register | Register a ESP Satellite.


# **deleteSatelliteById**
> void deleteSatelliteById()


### Example


```typescript
import {  } from '';
import * as fs from 'fs';

const configuration = .createConfiguration();
const apiInstance = new .SatelliteApi(configuration);

let body:.SatelliteApiDeleteSatelliteByIdRequest = {
  // string
  satelliteId: "satelliteId_example",
};

apiInstance.deleteSatelliteById(body).then((data:any) => {
  console.log('API called successfully. Returned data: ' + data);
}).catch((error:any) => console.error(error));
```


### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **satelliteId** | [**string**] |  | defaults to undefined


### Return type

**void**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | OK |  -  |
**422** | Unprocessable Entity |  -  |

[[Back to top]](#) [[Back to API list]](README.md#documentation-for-api-endpoints) [[Back to Model list]](README.md#documentation-for-models) [[Back to README]](README.md)

# **editSatellite**
> void editSatellite(satelliteMetadata)


### Example


```typescript
import {  } from '';
import * as fs from 'fs';

const configuration = .createConfiguration();
const apiInstance = new .SatelliteApi(configuration);

let body:.SatelliteApiEditSatelliteRequest = {
  // SatelliteMetadata
  satelliteMetadata: {
    areaId: "areaId_example",
    deviceTypeId: "deviceTypeId_example",
    id: "id_example",
    macAddress: "macAddress_example",
    name: "name_example",
    status: "ONLINE",
  },
};

apiInstance.editSatellite(body).then((data:any) => {
  console.log('API called successfully. Returned data: ' + data);
}).catch((error:any) => console.error(error));
```


### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **satelliteMetadata** | **SatelliteMetadata**|  |


### Return type

**void**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: */*


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | OK |  -  |
**422** | Unprocessable Entity |  -  |

[[Back to top]](#) [[Back to API list]](README.md#documentation-for-api-endpoints) [[Back to Model list]](README.md#documentation-for-models) [[Back to README]](README.md)

# **getDataPointsBySatellite**
> Array<DataPointMetadata> getDataPointsBySatellite()


### Example


```typescript
import {  } from '';
import * as fs from 'fs';

const configuration = .createConfiguration();
const apiInstance = new .SatelliteApi(configuration);

let body:.SatelliteApiGetDataPointsBySatelliteRequest = {
  // string
  satelliteId: "satelliteId_example",
};

apiInstance.getDataPointsBySatellite(body).then((data:any) => {
  console.log('API called successfully. Returned data: ' + data);
}).catch((error:any) => console.error(error));
```


### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **satelliteId** | [**string**] |  | defaults to undefined


### Return type

**Array<DataPointMetadata>**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | OK |  -  |
**422** | Unprocessable Entity |  -  |

[[Back to top]](#) [[Back to API list]](README.md#documentation-for-api-endpoints) [[Back to Model list]](README.md#documentation-for-models) [[Back to README]](README.md)

# **getSatelliteById**
> SatelliteMetadata getSatelliteById()


### Example


```typescript
import {  } from '';
import * as fs from 'fs';

const configuration = .createConfiguration();
const apiInstance = new .SatelliteApi(configuration);

let body:.SatelliteApiGetSatelliteByIdRequest = {
  // string
  satelliteId: "satelliteId_example",
};

apiInstance.getSatelliteById(body).then((data:any) => {
  console.log('API called successfully. Returned data: ' + data);
}).catch((error:any) => console.error(error));
```


### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **satelliteId** | [**string**] |  | defaults to undefined


### Return type

**SatelliteMetadata**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | OK |  -  |
**422** | Unprocessable Entity |  -  |

[[Back to top]](#) [[Back to API list]](README.md#documentation-for-api-endpoints) [[Back to Model list]](README.md#documentation-for-models) [[Back to README]](README.md)

# **getSatelliteDeviceType**
> SatelliteDeviceTypeId getSatelliteDeviceType()


### Example


```typescript
import {  } from '';
import * as fs from 'fs';

const configuration = .createConfiguration();
const apiInstance = new .SatelliteApi(configuration);

let body:.SatelliteApiGetSatelliteDeviceTypeRequest = {
  // string
  satelliteId: "satelliteId_example",
};

apiInstance.getSatelliteDeviceType(body).then((data:any) => {
  console.log('API called successfully. Returned data: ' + data);
}).catch((error:any) => console.error(error));
```


### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **satelliteId** | [**string**] |  | defaults to undefined


### Return type

**SatelliteDeviceTypeId**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | OK |  -  |
**422** | Unprocessable Entity |  -  |

[[Back to top]](#) [[Back to API list]](README.md#documentation-for-api-endpoints) [[Back to Model list]](README.md#documentation-for-models) [[Back to README]](README.md)

# **getSatellites**
> Array<SatelliteMetadata> getSatellites()


### Example


```typescript
import {  } from '';
import * as fs from 'fs';

const configuration = .createConfiguration();
const apiInstance = new .SatelliteApi(configuration);

let body:any = {};

apiInstance.getSatellites(body).then((data:any) => {
  console.log('API called successfully. Returned data: ' + data);
}).catch((error:any) => console.error(error));
```


### Parameters
This endpoint does not need any parameter.


### Return type

**Array<SatelliteMetadata>**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json, */*


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | OK |  -  |
**422** | Unprocessable Entity |  -  |

[[Back to top]](#) [[Back to API list]](README.md#documentation-for-api-endpoints) [[Back to Model list]](README.md#documentation-for-models) [[Back to README]](README.md)

# **satelliteRegister**
> SatelliteRegisterResponseDTO satelliteRegister(satelliteRegisterDTO)


### Example


```typescript
import {  } from '';
import * as fs from 'fs';

const configuration = .createConfiguration();
const apiInstance = new .SatelliteApi(configuration);

let body:.SatelliteApiSatelliteRegisterRequest = {
  // SatelliteRegisterDTO
  satelliteRegisterDTO: {
    deviceMACAddress: "deviceMACAddress_example",
    deviceName: "deviceName_example",
  },
};

apiInstance.satelliteRegister(body).then((data:any) => {
  console.log('API called successfully. Returned data: ' + data);
}).catch((error:any) => console.error(error));
```


### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **satelliteRegisterDTO** | **SatelliteRegisterDTO**|  |


### Return type

**SatelliteRegisterResponseDTO**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: */*


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Device has already been registered. |  -  |
**201** | Device has been registered for the first time. |  -  |
**400** | Error creating satellite. |  -  |
**422** | Unprocessable Entity |  -  |

[[Back to top]](#) [[Back to API list]](README.md#documentation-for-api-endpoints) [[Back to Model list]](README.md#documentation-for-models) [[Back to README]](README.md)


