# .SatelliteApi

All URIs are relative to *http://localhost:8080*

Method | HTTP request | Description
------------- | ------------- | -------------
[**editSatellite**](SatelliteApi.md#editSatellite) | **PUT** /satellite | Edit satellite.
[**getDataPointsBySatellite**](SatelliteApi.md#getDataPointsBySatellite) | **GET** /satellite/{satelliteId}/data-points | Get all data points for a satellite.
[**getLogsBySatellite**](SatelliteApi.md#getLogsBySatellite) | **GET** /satellite/{satelliteId}/logs | Get all logs for a satellite.
[**getSatelliteById**](SatelliteApi.md#getSatelliteById) | **GET** /satellite/{satelliteId} | Get satellite by ID.
[**getSatellites**](SatelliteApi.md#getSatellites) | **GET** /satellites | Get satellites


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
    area: {
      id: "id_example",
      name: "name_example",
    },
    deviceTypeMetadata: {
      id: "id_example",
      name: "name_example",
    },
    id: "id_example",
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

# **getLogsBySatellite**
> Array<LogMetadata> getLogsBySatellite()


### Example


```typescript
import {  } from '';
import * as fs from 'fs';

const configuration = .createConfiguration();
const apiInstance = new .SatelliteApi(configuration);

let body:.SatelliteApiGetLogsBySatelliteRequest = {
  // string
  satelliteId: "satelliteId_example",
};

apiInstance.getLogsBySatellite(body).then((data:any) => {
  console.log('API called successfully. Returned data: ' + data);
}).catch((error:any) => console.error(error));
```


### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **satelliteId** | [**string**] |  | defaults to undefined


### Return type

**Array<LogMetadata>**

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


