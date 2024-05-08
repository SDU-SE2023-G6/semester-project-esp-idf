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
import { ObservableAreaApi } from './ObservableAPI';

import { AreaApiRequestFactory, AreaApiResponseProcessor} from "../apis/AreaApi";
export class PromiseAreaApi {
    private api: ObservableAreaApi

    public constructor(
        configuration: Configuration,
        requestFactory?: AreaApiRequestFactory,
        responseProcessor?: AreaApiResponseProcessor
    ) {
        this.api = new ObservableAreaApi(configuration, requestFactory, responseProcessor);
    }

    /**
     * Add new area.
     * @param areaMetadata 
     */
    public addAreaWithHttpInfo(areaMetadata: AreaMetadata, _options?: Configuration): Promise<HttpInfo<AreaMetadata>> {
        const result = this.api.addAreaWithHttpInfo(areaMetadata, _options);
        return result.toPromise();
    }

    /**
     * Add new area.
     * @param areaMetadata 
     */
    public addArea(areaMetadata: AreaMetadata, _options?: Configuration): Promise<AreaMetadata> {
        const result = this.api.addArea(areaMetadata, _options);
        return result.toPromise();
    }

    /**
     * Delete area by ID.
     * @param areaId 
     */
    public deleteAreaByIdWithHttpInfo(areaId: string, _options?: Configuration): Promise<HttpInfo<void>> {
        const result = this.api.deleteAreaByIdWithHttpInfo(areaId, _options);
        return result.toPromise();
    }

    /**
     * Delete area by ID.
     * @param areaId 
     */
    public deleteAreaById(areaId: string, _options?: Configuration): Promise<void> {
        const result = this.api.deleteAreaById(areaId, _options);
        return result.toPromise();
    }

    /**
     * Edit area.
     * @param areaId 
     * @param areaMetadata 
     */
    public editAreaWithHttpInfo(areaId: string, areaMetadata: AreaMetadata, _options?: Configuration): Promise<HttpInfo<void>> {
        const result = this.api.editAreaWithHttpInfo(areaId, areaMetadata, _options);
        return result.toPromise();
    }

    /**
     * Edit area.
     * @param areaId 
     * @param areaMetadata 
     */
    public editArea(areaId: string, areaMetadata: AreaMetadata, _options?: Configuration): Promise<void> {
        const result = this.api.editArea(areaId, areaMetadata, _options);
        return result.toPromise();
    }

    /**
     * Get area by ID.
     * @param areaId 
     */
    public getAreaByIdWithHttpInfo(areaId: string, _options?: Configuration): Promise<HttpInfo<AreaMetadata>> {
        const result = this.api.getAreaByIdWithHttpInfo(areaId, _options);
        return result.toPromise();
    }

    /**
     * Get area by ID.
     * @param areaId 
     */
    public getAreaById(areaId: string, _options?: Configuration): Promise<AreaMetadata> {
        const result = this.api.getAreaById(areaId, _options);
        return result.toPromise();
    }

    /**
     * Get all areas.
     */
    public getAreasWithHttpInfo(_options?: Configuration): Promise<HttpInfo<Array<AreaMetadata>>> {
        const result = this.api.getAreasWithHttpInfo(_options);
        return result.toPromise();
    }

    /**
     * Get all areas.
     */
    public getAreas(_options?: Configuration): Promise<Array<AreaMetadata>> {
        const result = this.api.getAreas(_options);
        return result.toPromise();
    }

    /**
     * Get all satellites in an area.
     * @param areaId 
     */
    public getSatellitesInAreaWithHttpInfo(areaId: string, _options?: Configuration): Promise<HttpInfo<Array<SatelliteMetadata>>> {
        const result = this.api.getSatellitesInAreaWithHttpInfo(areaId, _options);
        return result.toPromise();
    }

    /**
     * Get all satellites in an area.
     * @param areaId 
     */
    public getSatellitesInArea(areaId: string, _options?: Configuration): Promise<Array<SatelliteMetadata>> {
        const result = this.api.getSatellitesInArea(areaId, _options);
        return result.toPromise();
    }


}



import { ObservableDataPointsApi } from './ObservableAPI';

import { DataPointsApiRequestFactory, DataPointsApiResponseProcessor} from "../apis/DataPointsApi";
export class PromiseDataPointsApi {
    private api: ObservableDataPointsApi

    public constructor(
        configuration: Configuration,
        requestFactory?: DataPointsApiRequestFactory,
        responseProcessor?: DataPointsApiResponseProcessor
    ) {
        this.api = new ObservableDataPointsApi(configuration, requestFactory, responseProcessor);
    }

    /**
     * Get all Data points.
     */
    public getDataPointsWithHttpInfo(_options?: Configuration): Promise<HttpInfo<Array<DataPointMetadata>>> {
        const result = this.api.getDataPointsWithHttpInfo(_options);
        return result.toPromise();
    }

    /**
     * Get all Data points.
     */
    public getDataPoints(_options?: Configuration): Promise<Array<DataPointMetadata>> {
        const result = this.api.getDataPoints(_options);
        return result.toPromise();
    }


}



import { ObservableDeviceTypeApi } from './ObservableAPI';

import { DeviceTypeApiRequestFactory, DeviceTypeApiResponseProcessor} from "../apis/DeviceTypeApi";
export class PromiseDeviceTypeApi {
    private api: ObservableDeviceTypeApi

    public constructor(
        configuration: Configuration,
        requestFactory?: DeviceTypeApiRequestFactory,
        responseProcessor?: DeviceTypeApiResponseProcessor
    ) {
        this.api = new ObservableDeviceTypeApi(configuration, requestFactory, responseProcessor);
    }

    /**
     * Get device types of satellites.
     */
    public getDeviceTypesWithHttpInfo(_options?: Configuration): Promise<HttpInfo<Array<DeviceTypeMetadata>>> {
        const result = this.api.getDeviceTypesWithHttpInfo(_options);
        return result.toPromise();
    }

    /**
     * Get device types of satellites.
     */
    public getDeviceTypes(_options?: Configuration): Promise<Array<DeviceTypeMetadata>> {
        const result = this.api.getDeviceTypes(_options);
        return result.toPromise();
    }


}



import { ObservableLogsApi } from './ObservableAPI';

import { LogsApiRequestFactory, LogsApiResponseProcessor} from "../apis/LogsApi";
export class PromiseLogsApi {
    private api: ObservableLogsApi

    public constructor(
        configuration: Configuration,
        requestFactory?: LogsApiRequestFactory,
        responseProcessor?: LogsApiResponseProcessor
    ) {
        this.api = new ObservableLogsApi(configuration, requestFactory, responseProcessor);
    }

    /**
     * Get all Logs.
     */
    public getLogsWithHttpInfo(_options?: Configuration): Promise<HttpInfo<Array<LogMetadata>>> {
        const result = this.api.getLogsWithHttpInfo(_options);
        return result.toPromise();
    }

    /**
     * Get all Logs.
     */
    public getLogs(_options?: Configuration): Promise<Array<LogMetadata>> {
        const result = this.api.getLogs(_options);
        return result.toPromise();
    }


}



import { ObservableSatelliteApi } from './ObservableAPI';

import { SatelliteApiRequestFactory, SatelliteApiResponseProcessor} from "../apis/SatelliteApi";
export class PromiseSatelliteApi {
    private api: ObservableSatelliteApi

    public constructor(
        configuration: Configuration,
        requestFactory?: SatelliteApiRequestFactory,
        responseProcessor?: SatelliteApiResponseProcessor
    ) {
        this.api = new ObservableSatelliteApi(configuration, requestFactory, responseProcessor);
    }

    /**
     * Edit satellite.
     * @param satelliteMetadata 
     */
    public editSatelliteWithHttpInfo(satelliteMetadata: SatelliteMetadata, _options?: Configuration): Promise<HttpInfo<void>> {
        const result = this.api.editSatelliteWithHttpInfo(satelliteMetadata, _options);
        return result.toPromise();
    }

    /**
     * Edit satellite.
     * @param satelliteMetadata 
     */
    public editSatellite(satelliteMetadata: SatelliteMetadata, _options?: Configuration): Promise<void> {
        const result = this.api.editSatellite(satelliteMetadata, _options);
        return result.toPromise();
    }

    /**
     * Get all data points for a satellite.
     * @param satelliteId 
     */
    public getDataPointsBySatelliteWithHttpInfo(satelliteId: string, _options?: Configuration): Promise<HttpInfo<Array<DataPointMetadata>>> {
        const result = this.api.getDataPointsBySatelliteWithHttpInfo(satelliteId, _options);
        return result.toPromise();
    }

    /**
     * Get all data points for a satellite.
     * @param satelliteId 
     */
    public getDataPointsBySatellite(satelliteId: string, _options?: Configuration): Promise<Array<DataPointMetadata>> {
        const result = this.api.getDataPointsBySatellite(satelliteId, _options);
        return result.toPromise();
    }

    /**
     * Get all logs for a satellite.
     * @param satelliteId 
     */
    public getLogsBySatelliteWithHttpInfo(satelliteId: string, _options?: Configuration): Promise<HttpInfo<Array<LogMetadata>>> {
        const result = this.api.getLogsBySatelliteWithHttpInfo(satelliteId, _options);
        return result.toPromise();
    }

    /**
     * Get all logs for a satellite.
     * @param satelliteId 
     */
    public getLogsBySatellite(satelliteId: string, _options?: Configuration): Promise<Array<LogMetadata>> {
        const result = this.api.getLogsBySatellite(satelliteId, _options);
        return result.toPromise();
    }

    /**
     * Get satellite by ID.
     * @param satelliteId 
     */
    public getSatelliteByIdWithHttpInfo(satelliteId: string, _options?: Configuration): Promise<HttpInfo<SatelliteMetadata>> {
        const result = this.api.getSatelliteByIdWithHttpInfo(satelliteId, _options);
        return result.toPromise();
    }

    /**
     * Get satellite by ID.
     * @param satelliteId 
     */
    public getSatelliteById(satelliteId: string, _options?: Configuration): Promise<SatelliteMetadata> {
        const result = this.api.getSatelliteById(satelliteId, _options);
        return result.toPromise();
    }

    /**
     * Get satellites
     */
    public getSatellitesWithHttpInfo(_options?: Configuration): Promise<HttpInfo<Array<SatelliteMetadata>>> {
        const result = this.api.getSatellitesWithHttpInfo(_options);
        return result.toPromise();
    }

    /**
     * Get satellites
     */
    public getSatellites(_options?: Configuration): Promise<Array<SatelliteMetadata>> {
        const result = this.api.getSatellites(_options);
        return result.toPromise();
    }


}



