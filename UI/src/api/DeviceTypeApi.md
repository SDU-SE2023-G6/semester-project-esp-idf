# .DeviceTypeApi

All URIs are relative to *http://localhost:8080*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getDeviceTypeById**](DeviceTypeApi.md#getDeviceTypeById) | **GET** /device-type/{deviceTypeId} | Get device types of satellites by ID.
[**getDeviceTypes**](DeviceTypeApi.md#getDeviceTypes) | **GET** /device-types | Get device types of satellites.


# **getDeviceTypeById**
> DeviceTypeMetadata getDeviceTypeById()


### Example


```typescript
import {  } from '';
import * as fs from 'fs';

const configuration = .createConfiguration();
const apiInstance = new .DeviceTypeApi(configuration);

let body:.DeviceTypeApiGetDeviceTypeByIdRequest = {
  // string
  deviceTypeId: "deviceTypeId_example",
};

apiInstance.getDeviceTypeById(body).then((data:any) => {
  console.log('API called successfully. Returned data: ' + data);
}).catch((error:any) => console.error(error));
```


### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **deviceTypeId** | [**string**] |  | defaults to undefined


### Return type

**DeviceTypeMetadata**

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

# **getDeviceTypes**
> Array<DeviceTypeMetadata> getDeviceTypes()


### Example


```typescript
import {  } from '';
import * as fs from 'fs';

const configuration = .createConfiguration();
const apiInstance = new .DeviceTypeApi(configuration);

let body:any = {};

apiInstance.getDeviceTypes(body).then((data:any) => {
  console.log('API called successfully. Returned data: ' + data);
}).catch((error:any) => console.error(error));
```


### Parameters
This endpoint does not need any parameter.


### Return type

**Array<DeviceTypeMetadata>**

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


