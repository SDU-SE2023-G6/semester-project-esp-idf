# .DataPointsApi

All URIs are relative to *http://localhost:8080*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getDataPoints**](DataPointsApi.md#getDataPoints) | **GET** /data-points | Get all Data points.
[**getDataPointsFromSometimeAgo**](DataPointsApi.md#getDataPointsFromSometimeAgo) | **GET** /data-points/hours/{hoursAgo} | Get all Data points.


# **getDataPoints**
> Array<DataPointMetadata> getDataPoints()


### Example


```typescript
import {  } from '';
import * as fs from 'fs';

const configuration = .createConfiguration();
const apiInstance = new .DataPointsApi(configuration);

let body:any = {};

apiInstance.getDataPoints(body).then((data:any) => {
  console.log('API called successfully. Returned data: ' + data);
}).catch((error:any) => console.error(error));
```


### Parameters
This endpoint does not need any parameter.


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

# **getDataPointsFromSometimeAgo**
> Array<DataPointMetadata> getDataPointsFromSometimeAgo()


### Example


```typescript
import {  } from '';
import * as fs from 'fs';

const configuration = .createConfiguration();
const apiInstance = new .DataPointsApi(configuration);

let body:.DataPointsApiGetDataPointsFromSometimeAgoRequest = {
  // number
  hoursAgo: 1,
};

apiInstance.getDataPointsFromSometimeAgo(body).then((data:any) => {
  console.log('API called successfully. Returned data: ' + data);
}).catch((error:any) => console.error(error));
```


### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **hoursAgo** | [**number**] |  | defaults to undefined


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


