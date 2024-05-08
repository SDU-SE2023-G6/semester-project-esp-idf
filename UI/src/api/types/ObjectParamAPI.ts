import { ResponseContext, RequestContext, HttpFile, HttpInfo } from '../http/http';
import { Configuration} from '../configuration'

import { AreaMetadata } from '../models/AreaMetadata';
import { DataPointMetadata } from '../models/DataPointMetadata';
import { DeviceTypeMetadata } from '../models/DeviceTypeMetadata';
import { ErrorResponse } from '../models/ErrorResponse';
import { LogMetadata } from '../models/LogMetadata';
import { LogType } from '../models/LogType';
import { SatelliteMetadata } from '../models/SatelliteMetadata';
import { SatelliteStatus } from '../models/SatelliteStatus';

import { ObservableAreaApi } from "./ObservableAPI";
import { AreaApiRequestFactory, AreaApiResponseProcessor} from "../apis/AreaApi";

export interface AreaApiAddAreaRequest {
    /**
     * 
     * @type AreaMetadata
     * @memberof AreaApiaddArea
     */
    areaMetadata: AreaMetadata
}

export interface AreaApiDeleteAreaByIdRequest {
    /**
     * 
     * @type string
     * @memberof AreaApideleteAreaById
     */
    areaId: string
}

export interface AreaApiEditAreaRequest {
    /**
     * 
     * @type string
     * @memberof AreaApieditArea
     */
    areaId: string
    /**
     * 
     * @type AreaMetadata
     * @memberof AreaApieditArea
     */
    areaMetadata: AreaMetadata
}

export interface AreaApiGetAreaByIdRequest {
    /**
     * 
     * @type string
     * @memberof AreaApigetAreaById
     */
    areaId: string
}

export interface AreaApiGetAreasRequest {
}

export interface AreaApiGetSatellitesInAreaRequest {
    /**
     * 
     * @type string
     * @memberof AreaApigetSatellitesInArea
     */
    areaId: string
}

export class ObjectAreaApi {
    private api: ObservableAreaApi

    public constructor(configuration: Configuration, requestFactory?: AreaApiRequestFactory, responseProcessor?: AreaApiResponseProcessor) {
        this.api = new ObservableAreaApi(configuration, requestFactory, responseProcessor);
    }

    /**
     * Add new area.
     * @param param the request object
     */
    public addAreaWithHttpInfo(param: AreaApiAddAreaRequest, options?: Configuration): Promise<HttpInfo<AreaMetadata>> {
        return this.api.addAreaWithHttpInfo(param.areaMetadata,  options).toPromise();
    }

    /**
     * Add new area.
     * @param param the request object
     */
    public addArea(param: AreaApiAddAreaRequest, options?: Configuration): Promise<AreaMetadata> {
        return this.api.addArea(param.areaMetadata,  options).toPromise();
    }

    /**
     * Delete area by ID.
     * @param param the request object
     */
    public deleteAreaByIdWithHttpInfo(param: AreaApiDeleteAreaByIdRequest, options?: Configuration): Promise<HttpInfo<void>> {
        return this.api.deleteAreaByIdWithHttpInfo(param.areaId,  options).toPromise();
    }

    /**
     * Delete area by ID.
     * @param param the request object
     */
    public deleteAreaById(param: AreaApiDeleteAreaByIdRequest, options?: Configuration): Promise<void> {
        return this.api.deleteAreaById(param.areaId,  options).toPromise();
    }

    /**
     * Edit area.
     * @param param the request object
     */
    public editAreaWithHttpInfo(param: AreaApiEditAreaRequest, options?: Configuration): Promise<HttpInfo<void>> {
        return this.api.editAreaWithHttpInfo(param.areaId, param.areaMetadata,  options).toPromise();
    }

    /**
     * Edit area.
     * @param param the request object
     */
    public editArea(param: AreaApiEditAreaRequest, options?: Configuration): Promise<void> {
        return this.api.editArea(param.areaId, param.areaMetadata,  options).toPromise();
    }

    /**
     * Get area by ID.
     * @param param the request object
     */
    public getAreaByIdWithHttpInfo(param: AreaApiGetAreaByIdRequest, options?: Configuration): Promise<HttpInfo<AreaMetadata>> {
        return this.api.getAreaByIdWithHttpInfo(param.areaId,  options).toPromise();
    }

    /**
     * Get area by ID.
     * @param param the request object
     */
    public getAreaById(param: AreaApiGetAreaByIdRequest, options?: Configuration): Promise<AreaMetadata> {
        return this.api.getAreaById(param.areaId,  options).toPromise();
    }

    /**
     * Get all areas.
     * @param param the request object
     */
    public getAreasWithHttpInfo(param: AreaApiGetAreasRequest = {}, options?: Configuration): Promise<HttpInfo<Array<AreaMetadata>>> {
        return this.api.getAreasWithHttpInfo( options).toPromise();
    }

    /**
     * Get all areas.
     * @param param the request object
     */
    public getAreas(param: AreaApiGetAreasRequest = {}, options?: Configuration): Promise<Array<AreaMetadata>> {
        return this.api.getAreas( options).toPromise();
    }

    /**
     * Get all satellites in an area.
     * @param param the request object
     */
    public getSatellitesInAreaWithHttpInfo(param: AreaApiGetSatellitesInAreaRequest, options?: Configuration): Promise<HttpInfo<Array<SatelliteMetadata>>> {
        return this.api.getSatellitesInAreaWithHttpInfo(param.areaId,  options).toPromise();
    }

    /**
     * Get all satellites in an area.
     * @param param the request object
     */
    public getSatellitesInArea(param: AreaApiGetSatellitesInAreaRequest, options?: Configuration): Promise<Array<SatelliteMetadata>> {
        return this.api.getSatellitesInArea(param.areaId,  options).toPromise();
    }

}

import { ObservableDataPointsApi } from "./ObservableAPI";
import { DataPointsApiRequestFactory, DataPointsApiResponseProcessor} from "../apis/DataPointsApi";

export interface DataPointsApiGetDataPointsRequest {
}

export class ObjectDataPointsApi {
    private api: ObservableDataPointsApi

    public constructor(configuration: Configuration, requestFactory?: DataPointsApiRequestFactory, responseProcessor?: DataPointsApiResponseProcessor) {
        this.api = new ObservableDataPointsApi(configuration, requestFactory, responseProcessor);
    }

    /**
     * Get all Data points.
     * @param param the request object
     */
    public getDataPointsWithHttpInfo(param: DataPointsApiGetDataPointsRequest = {}, options?: Configuration): Promise<HttpInfo<Array<DataPointMetadata>>> {
        return this.api.getDataPointsWithHttpInfo( options).toPromise();
    }

    /**
     * Get all Data points.
     * @param param the request object
     */
    public getDataPoints(param: DataPointsApiGetDataPointsRequest = {}, options?: Configuration): Promise<Array<DataPointMetadata>> {
        return this.api.getDataPoints( options).toPromise();
    }

}

import { ObservableDeviceTypeApi } from "./ObservableAPI";
import { DeviceTypeApiRequestFactory, DeviceTypeApiResponseProcessor} from "../apis/DeviceTypeApi";

export interface DeviceTypeApiGetDeviceTypesRequest {
}

export class ObjectDeviceTypeApi {
    private api: ObservableDeviceTypeApi

    public constructor(configuration: Configuration, requestFactory?: DeviceTypeApiRequestFactory, responseProcessor?: DeviceTypeApiResponseProcessor) {
        this.api = new ObservableDeviceTypeApi(configuration, requestFactory, responseProcessor);
    }

    /**
     * Get device types of satellites.
     * @param param the request object
     */
    public getDeviceTypesWithHttpInfo(param: DeviceTypeApiGetDeviceTypesRequest = {}, options?: Configuration): Promise<HttpInfo<Array<DeviceTypeMetadata>>> {
        return this.api.getDeviceTypesWithHttpInfo( options).toPromise();
    }

    /**
     * Get device types of satellites.
     * @param param the request object
     */
    public getDeviceTypes(param: DeviceTypeApiGetDeviceTypesRequest = {}, options?: Configuration): Promise<Array<DeviceTypeMetadata>> {
        return this.api.getDeviceTypes( options).toPromise();
    }

}

import { ObservableLogsApi } from "./ObservableAPI";
import { LogsApiRequestFactory, LogsApiResponseProcessor} from "../apis/LogsApi";

export interface LogsApiGetLogsRequest {
}

export class ObjectLogsApi {
    private api: ObservableLogsApi

    public constructor(configuration: Configuration, requestFactory?: LogsApiRequestFactory, responseProcessor?: LogsApiResponseProcessor) {
        this.api = new ObservableLogsApi(configuration, requestFactory, responseProcessor);
    }

    /**
     * Get all Logs.
     * @param param the request object
     */
    public getLogsWithHttpInfo(param: LogsApiGetLogsRequest = {}, options?: Configuration): Promise<HttpInfo<Array<LogMetadata>>> {
        return this.api.getLogsWithHttpInfo( options).toPromise();
    }

    /**
     * Get all Logs.
     * @param param the request object
     */
    public getLogs(param: LogsApiGetLogsRequest = {}, options?: Configuration): Promise<Array<LogMetadata>> {
        return this.api.getLogs( options).toPromise();
    }

}

import { ObservableSatelliteApi } from "./ObservableAPI";
import { SatelliteApiRequestFactory, SatelliteApiResponseProcessor} from "../apis/SatelliteApi";

export interface SatelliteApiEditSatelliteRequest {
    /**
     * 
     * @type SatelliteMetadata
     * @memberof SatelliteApieditSatellite
     */
    satelliteMetadata: SatelliteMetadata
}

export interface SatelliteApiGetDataPointsBySatelliteRequest {
    /**
     * 
     * @type string
     * @memberof SatelliteApigetDataPointsBySatellite
     */
    satelliteId: string
}

export interface SatelliteApiGetLogsBySatelliteRequest {
    /**
     * 
     * @type string
     * @memberof SatelliteApigetLogsBySatellite
     */
    satelliteId: string
}

export interface SatelliteApiGetSatelliteByIdRequest {
    /**
     * 
     * @type string
     * @memberof SatelliteApigetSatelliteById
     */
    satelliteId: string
}

export interface SatelliteApiGetSatellitesRequest {
}

export class ObjectSatelliteApi {
    private api: ObservableSatelliteApi

    public constructor(configuration: Configuration, requestFactory?: SatelliteApiRequestFactory, responseProcessor?: SatelliteApiResponseProcessor) {
        this.api = new ObservableSatelliteApi(configuration, requestFactory, responseProcessor);
    }

    /**
     * Edit satellite.
     * @param param the request object
     */
    public editSatelliteWithHttpInfo(param: SatelliteApiEditSatelliteRequest, options?: Configuration): Promise<HttpInfo<void>> {
        return this.api.editSatelliteWithHttpInfo(param.satelliteMetadata,  options).toPromise();
    }

    /**
     * Edit satellite.
     * @param param the request object
     */
    public editSatellite(param: SatelliteApiEditSatelliteRequest, options?: Configuration): Promise<void> {
        return this.api.editSatellite(param.satelliteMetadata,  options).toPromise();
    }

    /**
     * Get all data points for a satellite.
     * @param param the request object
     */
    public getDataPointsBySatelliteWithHttpInfo(param: SatelliteApiGetDataPointsBySatelliteRequest, options?: Configuration): Promise<HttpInfo<Array<DataPointMetadata>>> {
        return this.api.getDataPointsBySatelliteWithHttpInfo(param.satelliteId,  options).toPromise();
    }

    /**
     * Get all data points for a satellite.
     * @param param the request object
     */
    public getDataPointsBySatellite(param: SatelliteApiGetDataPointsBySatelliteRequest, options?: Configuration): Promise<Array<DataPointMetadata>> {
        return this.api.getDataPointsBySatellite(param.satelliteId,  options).toPromise();
    }

    /**
     * Get all logs for a satellite.
     * @param param the request object
     */
    public getLogsBySatelliteWithHttpInfo(param: SatelliteApiGetLogsBySatelliteRequest, options?: Configuration): Promise<HttpInfo<Array<LogMetadata>>> {
        return this.api.getLogsBySatelliteWithHttpInfo(param.satelliteId,  options).toPromise();
    }

    /**
     * Get all logs for a satellite.
     * @param param the request object
     */
    public getLogsBySatellite(param: SatelliteApiGetLogsBySatelliteRequest, options?: Configuration): Promise<Array<LogMetadata>> {
        return this.api.getLogsBySatellite(param.satelliteId,  options).toPromise();
    }

    /**
     * Get satellite by ID.
     * @param param the request object
     */
    public getSatelliteByIdWithHttpInfo(param: SatelliteApiGetSatelliteByIdRequest, options?: Configuration): Promise<HttpInfo<SatelliteMetadata>> {
        return this.api.getSatelliteByIdWithHttpInfo(param.satelliteId,  options).toPromise();
    }

    /**
     * Get satellite by ID.
     * @param param the request object
     */
    public getSatelliteById(param: SatelliteApiGetSatelliteByIdRequest, options?: Configuration): Promise<SatelliteMetadata> {
        return this.api.getSatelliteById(param.satelliteId,  options).toPromise();
    }

    /**
     * Get satellites
     * @param param the request object
     */
    public getSatellitesWithHttpInfo(param: SatelliteApiGetSatellitesRequest = {}, options?: Configuration): Promise<HttpInfo<Array<SatelliteMetadata>>> {
        return this.api.getSatellitesWithHttpInfo( options).toPromise();
    }

    /**
     * Get satellites
     * @param param the request object
     */
    public getSatellites(param: SatelliteApiGetSatellitesRequest = {}, options?: Configuration): Promise<Array<SatelliteMetadata>> {
        return this.api.getSatellites( options).toPromise();
    }

}
