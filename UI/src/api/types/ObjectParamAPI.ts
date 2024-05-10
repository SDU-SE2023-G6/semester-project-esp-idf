import { ResponseContext, RequestContext, HttpFile, HttpInfo } from '../http/http';
import { Configuration} from '../configuration'

import { AreaMetadata } from '../models/AreaMetadata';
import { DataPointMetadata } from '../models/DataPointMetadata';
import { DeviceTypeMetadata } from '../models/DeviceTypeMetadata';
import { ErrorResponse } from '../models/ErrorResponse';
import { LogMetadata } from '../models/LogMetadata';
import { LogType } from '../models/LogType';
import { ProgramDslContent } from '../models/ProgramDslContent';
import { ProgramMetadata } from '../models/ProgramMetadata';
import { ProgramStatus } from '../models/ProgramStatus';
import { ProgramStatusProjection } from '../models/ProgramStatusProjection';
import { SatelliteDeviceTypeId } from '../models/SatelliteDeviceTypeId';
import { SatelliteMetadata } from '../models/SatelliteMetadata';
import { SatelliteRegisterDTO } from '../models/SatelliteRegisterDTO';
import { SatelliteRegisterResponseDTO } from '../models/SatelliteRegisterResponseDTO';
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
    areaId?: string
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
    public getSatellitesInAreaWithHttpInfo(param: AreaApiGetSatellitesInAreaRequest = {}, options?: Configuration): Promise<HttpInfo<Array<SatelliteMetadata>>> {
        return this.api.getSatellitesInAreaWithHttpInfo(param.areaId,  options).toPromise();
    }

    /**
     * Get all satellites in an area.
     * @param param the request object
     */
    public getSatellitesInArea(param: AreaApiGetSatellitesInAreaRequest = {}, options?: Configuration): Promise<Array<SatelliteMetadata>> {
        return this.api.getSatellitesInArea(param.areaId,  options).toPromise();
    }

}

import { ObservableDataPointsApi } from "./ObservableAPI";
import { DataPointsApiRequestFactory, DataPointsApiResponseProcessor} from "../apis/DataPointsApi";

export interface DataPointsApiGetDataPointsRequest {
}

export interface DataPointsApiGetDataPointsFromSometimeAgoRequest {
    /**
     * 
     * @type number
     * @memberof DataPointsApigetDataPointsFromSometimeAgo
     */
    hoursAgo: number
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

    /**
     * Get all Data points.
     * @param param the request object
     */
    public getDataPointsFromSometimeAgoWithHttpInfo(param: DataPointsApiGetDataPointsFromSometimeAgoRequest, options?: Configuration): Promise<HttpInfo<Array<DataPointMetadata>>> {
        return this.api.getDataPointsFromSometimeAgoWithHttpInfo(param.hoursAgo,  options).toPromise();
    }

    /**
     * Get all Data points.
     * @param param the request object
     */
    public getDataPointsFromSometimeAgo(param: DataPointsApiGetDataPointsFromSometimeAgoRequest, options?: Configuration): Promise<Array<DataPointMetadata>> {
        return this.api.getDataPointsFromSometimeAgo(param.hoursAgo,  options).toPromise();
    }

}

import { ObservableDeviceTypeApi } from "./ObservableAPI";
import { DeviceTypeApiRequestFactory, DeviceTypeApiResponseProcessor} from "../apis/DeviceTypeApi";

export interface DeviceTypeApiGetDeviceTypeByIdRequest {
    /**
     * 
     * @type string
     * @memberof DeviceTypeApigetDeviceTypeById
     */
    deviceTypeId: string
}

export interface DeviceTypeApiGetDeviceTypesRequest {
}

export class ObjectDeviceTypeApi {
    private api: ObservableDeviceTypeApi

    public constructor(configuration: Configuration, requestFactory?: DeviceTypeApiRequestFactory, responseProcessor?: DeviceTypeApiResponseProcessor) {
        this.api = new ObservableDeviceTypeApi(configuration, requestFactory, responseProcessor);
    }

    /**
     * Get device types of satellites by ID.
     * @param param the request object
     */
    public getDeviceTypeByIdWithHttpInfo(param: DeviceTypeApiGetDeviceTypeByIdRequest, options?: Configuration): Promise<HttpInfo<DeviceTypeMetadata>> {
        return this.api.getDeviceTypeByIdWithHttpInfo(param.deviceTypeId,  options).toPromise();
    }

    /**
     * Get device types of satellites by ID.
     * @param param the request object
     */
    public getDeviceTypeById(param: DeviceTypeApiGetDeviceTypeByIdRequest, options?: Configuration): Promise<DeviceTypeMetadata> {
        return this.api.getDeviceTypeById(param.deviceTypeId,  options).toPromise();
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

export interface LogsApiGetLogsBySatelliteRequest {
    /**
     * 
     * @type string
     * @memberof LogsApigetLogsBySatellite
     */
    source?: string
}

export interface LogsApiGetLogsFromSometimeAgoRequest {
    /**
     * 
     * @type number
     * @memberof LogsApigetLogsFromSometimeAgo
     */
    hoursAgo: number
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

    /**
     * Get all logs for a given source. Expects null or no input to get system logs.
     * @param param the request object
     */
    public getLogsBySatelliteWithHttpInfo(param: LogsApiGetLogsBySatelliteRequest = {}, options?: Configuration): Promise<HttpInfo<Array<LogMetadata>>> {
        return this.api.getLogsBySatelliteWithHttpInfo(param.source,  options).toPromise();
    }

    /**
     * Get all logs for a given source. Expects null or no input to get system logs.
     * @param param the request object
     */
    public getLogsBySatellite(param: LogsApiGetLogsBySatelliteRequest = {}, options?: Configuration): Promise<Array<LogMetadata>> {
        return this.api.getLogsBySatellite(param.source,  options).toPromise();
    }

    /**
     * Get logs since some amount of hours ago.
     * @param param the request object
     */
    public getLogsFromSometimeAgoWithHttpInfo(param: LogsApiGetLogsFromSometimeAgoRequest, options?: Configuration): Promise<HttpInfo<Array<LogMetadata>>> {
        return this.api.getLogsFromSometimeAgoWithHttpInfo(param.hoursAgo,  options).toPromise();
    }

    /**
     * Get logs since some amount of hours ago.
     * @param param the request object
     */
    public getLogsFromSometimeAgo(param: LogsApiGetLogsFromSometimeAgoRequest, options?: Configuration): Promise<Array<LogMetadata>> {
        return this.api.getLogsFromSometimeAgo(param.hoursAgo,  options).toPromise();
    }

}

import { ObservableProgramApi } from "./ObservableAPI";
import { ProgramApiRequestFactory, ProgramApiResponseProcessor} from "../apis/ProgramApi";

export interface ProgramApiCompileProgramRequest {
}

export interface ProgramApiCompileProgramContinueDestructivelyRequest {
}

export interface ProgramApiDownloadBinaryRequest {
    /**
     * 
     * @type string
     * @memberof ProgramApidownloadBinary
     */
    binaryId: string
}

export interface ProgramApiGetProgramDslContentRequest {
}

export interface ProgramApiGetProgramMetadataRequest {
}

export interface ProgramApiGetProgramStatusRequest {
}

export interface ProgramApiSaveProgramDslContentRequest {
    /**
     * 
     * @type ProgramDslContent
     * @memberof ProgramApisaveProgramDslContent
     */
    programDslContent: ProgramDslContent
}

export class ObjectProgramApi {
    private api: ObservableProgramApi

    public constructor(configuration: Configuration, requestFactory?: ProgramApiRequestFactory, responseProcessor?: ProgramApiResponseProcessor) {
        this.api = new ObservableProgramApi(configuration, requestFactory, responseProcessor);
    }

    /**
     * Get program DSL definition
     * @param param the request object
     */
    public compileProgramWithHttpInfo(param: ProgramApiCompileProgramRequest = {}, options?: Configuration): Promise<HttpInfo<ProgramStatusProjection>> {
        return this.api.compileProgramWithHttpInfo( options).toPromise();
    }

    /**
     * Get program DSL definition
     * @param param the request object
     */
    public compileProgram(param: ProgramApiCompileProgramRequest = {}, options?: Configuration): Promise<ProgramStatusProjection> {
        return this.api.compileProgram( options).toPromise();
    }

    /**
     * Continue compilation despite warnings
     * @param param the request object
     */
    public compileProgramContinueDestructivelyWithHttpInfo(param: ProgramApiCompileProgramContinueDestructivelyRequest = {}, options?: Configuration): Promise<HttpInfo<ProgramStatusProjection>> {
        return this.api.compileProgramContinueDestructivelyWithHttpInfo( options).toPromise();
    }

    /**
     * Continue compilation despite warnings
     * @param param the request object
     */
    public compileProgramContinueDestructively(param: ProgramApiCompileProgramContinueDestructivelyRequest = {}, options?: Configuration): Promise<ProgramStatusProjection> {
        return this.api.compileProgramContinueDestructively( options).toPromise();
    }

    /**
     * @param param the request object
     */
    public downloadBinaryWithHttpInfo(param: ProgramApiDownloadBinaryRequest, options?: Configuration): Promise<HttpInfo<Array<string>>> {
        return this.api.downloadBinaryWithHttpInfo(param.binaryId,  options).toPromise();
    }

    /**
     * @param param the request object
     */
    public downloadBinary(param: ProgramApiDownloadBinaryRequest, options?: Configuration): Promise<Array<string>> {
        return this.api.downloadBinary(param.binaryId,  options).toPromise();
    }

    /**
     * Get program DSL definition
     * @param param the request object
     */
    public getProgramDslContentWithHttpInfo(param: ProgramApiGetProgramDslContentRequest = {}, options?: Configuration): Promise<HttpInfo<ProgramDslContent>> {
        return this.api.getProgramDslContentWithHttpInfo( options).toPromise();
    }

    /**
     * Get program DSL definition
     * @param param the request object
     */
    public getProgramDslContent(param: ProgramApiGetProgramDslContentRequest = {}, options?: Configuration): Promise<ProgramDslContent> {
        return this.api.getProgramDslContent( options).toPromise();
    }

    /**
     * Get program metadata
     * @param param the request object
     */
    public getProgramMetadataWithHttpInfo(param: ProgramApiGetProgramMetadataRequest = {}, options?: Configuration): Promise<HttpInfo<ProgramMetadata>> {
        return this.api.getProgramMetadataWithHttpInfo( options).toPromise();
    }

    /**
     * Get program metadata
     * @param param the request object
     */
    public getProgramMetadata(param: ProgramApiGetProgramMetadataRequest = {}, options?: Configuration): Promise<ProgramMetadata> {
        return this.api.getProgramMetadata( options).toPromise();
    }

    /**
     * Get program status
     * @param param the request object
     */
    public getProgramStatusWithHttpInfo(param: ProgramApiGetProgramStatusRequest = {}, options?: Configuration): Promise<HttpInfo<ProgramStatusProjection>> {
        return this.api.getProgramStatusWithHttpInfo( options).toPromise();
    }

    /**
     * Get program status
     * @param param the request object
     */
    public getProgramStatus(param: ProgramApiGetProgramStatusRequest = {}, options?: Configuration): Promise<ProgramStatusProjection> {
        return this.api.getProgramStatus( options).toPromise();
    }

    /**
     * Update program DSL definition
     * @param param the request object
     */
    public saveProgramDslContentWithHttpInfo(param: ProgramApiSaveProgramDslContentRequest, options?: Configuration): Promise<HttpInfo<void>> {
        return this.api.saveProgramDslContentWithHttpInfo(param.programDslContent,  options).toPromise();
    }

    /**
     * Update program DSL definition
     * @param param the request object
     */
    public saveProgramDslContent(param: ProgramApiSaveProgramDslContentRequest, options?: Configuration): Promise<void> {
        return this.api.saveProgramDslContent(param.programDslContent,  options).toPromise();
    }

}

import { ObservableSatelliteApi } from "./ObservableAPI";
import { SatelliteApiRequestFactory, SatelliteApiResponseProcessor} from "../apis/SatelliteApi";

export interface SatelliteApiDeleteSatelliteByIdRequest {
    /**
     * 
     * @type string
     * @memberof SatelliteApideleteSatelliteById
     */
    satelliteId: string
}

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

export interface SatelliteApiGetSatelliteByIdRequest {
    /**
     * 
     * @type string
     * @memberof SatelliteApigetSatelliteById
     */
    satelliteId: string
}

export interface SatelliteApiGetSatelliteDeviceTypeRequest {
    /**
     * 
     * @type string
     * @memberof SatelliteApigetSatelliteDeviceType
     */
    satelliteId: string
}

export interface SatelliteApiGetSatellitesRequest {
}

export interface SatelliteApiSatelliteRegisterRequest {
    /**
     * 
     * @type SatelliteRegisterDTO
     * @memberof SatelliteApisatelliteRegister
     */
    satelliteRegisterDTO: SatelliteRegisterDTO
}

export class ObjectSatelliteApi {
    private api: ObservableSatelliteApi

    public constructor(configuration: Configuration, requestFactory?: SatelliteApiRequestFactory, responseProcessor?: SatelliteApiResponseProcessor) {
        this.api = new ObservableSatelliteApi(configuration, requestFactory, responseProcessor);
    }

    /**
     * Delete satellite by ID.
     * @param param the request object
     */
    public deleteSatelliteByIdWithHttpInfo(param: SatelliteApiDeleteSatelliteByIdRequest, options?: Configuration): Promise<HttpInfo<void>> {
        return this.api.deleteSatelliteByIdWithHttpInfo(param.satelliteId,  options).toPromise();
    }

    /**
     * Delete satellite by ID.
     * @param param the request object
     */
    public deleteSatelliteById(param: SatelliteApiDeleteSatelliteByIdRequest, options?: Configuration): Promise<void> {
        return this.api.deleteSatelliteById(param.satelliteId,  options).toPromise();
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
     * Get satellite device type id.
     * @param param the request object
     */
    public getSatelliteDeviceTypeWithHttpInfo(param: SatelliteApiGetSatelliteDeviceTypeRequest, options?: Configuration): Promise<HttpInfo<SatelliteDeviceTypeId>> {
        return this.api.getSatelliteDeviceTypeWithHttpInfo(param.satelliteId,  options).toPromise();
    }

    /**
     * Get satellite device type id.
     * @param param the request object
     */
    public getSatelliteDeviceType(param: SatelliteApiGetSatelliteDeviceTypeRequest, options?: Configuration): Promise<SatelliteDeviceTypeId> {
        return this.api.getSatelliteDeviceType(param.satelliteId,  options).toPromise();
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

    /**
     * Register a ESP Satellite.
     * @param param the request object
     */
    public satelliteRegisterWithHttpInfo(param: SatelliteApiSatelliteRegisterRequest, options?: Configuration): Promise<HttpInfo<SatelliteRegisterResponseDTO>> {
        return this.api.satelliteRegisterWithHttpInfo(param.satelliteRegisterDTO,  options).toPromise();
    }

    /**
     * Register a ESP Satellite.
     * @param param the request object
     */
    public satelliteRegister(param: SatelliteApiSatelliteRegisterRequest, options?: Configuration): Promise<SatelliteRegisterResponseDTO> {
        return this.api.satelliteRegister(param.satelliteRegisterDTO,  options).toPromise();
    }

}
