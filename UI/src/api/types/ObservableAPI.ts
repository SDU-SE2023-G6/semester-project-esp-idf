import { ResponseContext, RequestContext, HttpFile, HttpInfo } from '../http/http';
import { Configuration} from '../configuration'
import { Observable, of, from } from '../rxjsStub';
import {mergeMap, map} from  '../rxjsStub';
import { AreaMetadata } from '../models/AreaMetadata';
import { DataPointMetadata } from '../models/DataPointMetadata';
import { DeviceTypeMetadata } from '../models/DeviceTypeMetadata';
import { ErrorResponse } from '../models/ErrorResponse';
import { LogMetadata } from '../models/LogMetadata';
import { LogType } from '../models/LogType';
import { SatelliteMetadata } from '../models/SatelliteMetadata';
import { SatelliteStatus } from '../models/SatelliteStatus';

import { AreaApiRequestFactory, AreaApiResponseProcessor} from "../apis/AreaApi";
export class ObservableAreaApi {
    private requestFactory: AreaApiRequestFactory;
    private responseProcessor: AreaApiResponseProcessor;
    private configuration: Configuration;

    public constructor(
        configuration: Configuration,
        requestFactory?: AreaApiRequestFactory,
        responseProcessor?: AreaApiResponseProcessor
    ) {
        this.configuration = configuration;
        this.requestFactory = requestFactory || new AreaApiRequestFactory(configuration);
        this.responseProcessor = responseProcessor || new AreaApiResponseProcessor();
    }

    /**
     * Add new area.
     * @param areaMetadata 
     */
    public addAreaWithHttpInfo(areaMetadata: AreaMetadata, _options?: Configuration): Observable<HttpInfo<AreaMetadata>> {
        const requestContextPromise = this.requestFactory.addArea(areaMetadata, _options);

        // build promise chain
        let middlewarePreObservable = from<RequestContext>(requestContextPromise);
        for (let middleware of this.configuration.middleware) {
            middlewarePreObservable = middlewarePreObservable.pipe(mergeMap((ctx: RequestContext) => middleware.pre(ctx)));
        }

        return middlewarePreObservable.pipe(mergeMap((ctx: RequestContext) => this.configuration.httpApi.send(ctx))).
            pipe(mergeMap((response: ResponseContext) => {
                let middlewarePostObservable = of(response);
                for (let middleware of this.configuration.middleware) {
                    middlewarePostObservable = middlewarePostObservable.pipe(mergeMap((rsp: ResponseContext) => middleware.post(rsp)));
                }
                return middlewarePostObservable.pipe(map((rsp: ResponseContext) => this.responseProcessor.addAreaWithHttpInfo(rsp)));
            }));
    }

    /**
     * Add new area.
     * @param areaMetadata 
     */
    public addArea(areaMetadata: AreaMetadata, _options?: Configuration): Observable<AreaMetadata> {
        return this.addAreaWithHttpInfo(areaMetadata, _options).pipe(map((apiResponse: HttpInfo<AreaMetadata>) => apiResponse.data));
    }

    /**
     * Delete area by ID.
     * @param areaId 
     */
    public deleteAreaByIdWithHttpInfo(areaId: string, _options?: Configuration): Observable<HttpInfo<void>> {
        const requestContextPromise = this.requestFactory.deleteAreaById(areaId, _options);

        // build promise chain
        let middlewarePreObservable = from<RequestContext>(requestContextPromise);
        for (let middleware of this.configuration.middleware) {
            middlewarePreObservable = middlewarePreObservable.pipe(mergeMap((ctx: RequestContext) => middleware.pre(ctx)));
        }

        return middlewarePreObservable.pipe(mergeMap((ctx: RequestContext) => this.configuration.httpApi.send(ctx))).
            pipe(mergeMap((response: ResponseContext) => {
                let middlewarePostObservable = of(response);
                for (let middleware of this.configuration.middleware) {
                    middlewarePostObservable = middlewarePostObservable.pipe(mergeMap((rsp: ResponseContext) => middleware.post(rsp)));
                }
                return middlewarePostObservable.pipe(map((rsp: ResponseContext) => this.responseProcessor.deleteAreaByIdWithHttpInfo(rsp)));
            }));
    }

    /**
     * Delete area by ID.
     * @param areaId 
     */
    public deleteAreaById(areaId: string, _options?: Configuration): Observable<void> {
        return this.deleteAreaByIdWithHttpInfo(areaId, _options).pipe(map((apiResponse: HttpInfo<void>) => apiResponse.data));
    }

    /**
     * Edit area.
     * @param areaId 
     * @param areaMetadata 
     */
    public editAreaWithHttpInfo(areaId: string, areaMetadata: AreaMetadata, _options?: Configuration): Observable<HttpInfo<void>> {
        const requestContextPromise = this.requestFactory.editArea(areaId, areaMetadata, _options);

        // build promise chain
        let middlewarePreObservable = from<RequestContext>(requestContextPromise);
        for (let middleware of this.configuration.middleware) {
            middlewarePreObservable = middlewarePreObservable.pipe(mergeMap((ctx: RequestContext) => middleware.pre(ctx)));
        }

        return middlewarePreObservable.pipe(mergeMap((ctx: RequestContext) => this.configuration.httpApi.send(ctx))).
            pipe(mergeMap((response: ResponseContext) => {
                let middlewarePostObservable = of(response);
                for (let middleware of this.configuration.middleware) {
                    middlewarePostObservable = middlewarePostObservable.pipe(mergeMap((rsp: ResponseContext) => middleware.post(rsp)));
                }
                return middlewarePostObservable.pipe(map((rsp: ResponseContext) => this.responseProcessor.editAreaWithHttpInfo(rsp)));
            }));
    }

    /**
     * Edit area.
     * @param areaId 
     * @param areaMetadata 
     */
    public editArea(areaId: string, areaMetadata: AreaMetadata, _options?: Configuration): Observable<void> {
        return this.editAreaWithHttpInfo(areaId, areaMetadata, _options).pipe(map((apiResponse: HttpInfo<void>) => apiResponse.data));
    }

    /**
     * Get area by ID.
     * @param areaId 
     */
    public getAreaByIdWithHttpInfo(areaId: string, _options?: Configuration): Observable<HttpInfo<AreaMetadata>> {
        const requestContextPromise = this.requestFactory.getAreaById(areaId, _options);

        // build promise chain
        let middlewarePreObservable = from<RequestContext>(requestContextPromise);
        for (let middleware of this.configuration.middleware) {
            middlewarePreObservable = middlewarePreObservable.pipe(mergeMap((ctx: RequestContext) => middleware.pre(ctx)));
        }

        return middlewarePreObservable.pipe(mergeMap((ctx: RequestContext) => this.configuration.httpApi.send(ctx))).
            pipe(mergeMap((response: ResponseContext) => {
                let middlewarePostObservable = of(response);
                for (let middleware of this.configuration.middleware) {
                    middlewarePostObservable = middlewarePostObservable.pipe(mergeMap((rsp: ResponseContext) => middleware.post(rsp)));
                }
                return middlewarePostObservable.pipe(map((rsp: ResponseContext) => this.responseProcessor.getAreaByIdWithHttpInfo(rsp)));
            }));
    }

    /**
     * Get area by ID.
     * @param areaId 
     */
    public getAreaById(areaId: string, _options?: Configuration): Observable<AreaMetadata> {
        return this.getAreaByIdWithHttpInfo(areaId, _options).pipe(map((apiResponse: HttpInfo<AreaMetadata>) => apiResponse.data));
    }

    /**
     * Get all areas.
     */
    public getAreasWithHttpInfo(_options?: Configuration): Observable<HttpInfo<Array<AreaMetadata>>> {
        const requestContextPromise = this.requestFactory.getAreas(_options);

        // build promise chain
        let middlewarePreObservable = from<RequestContext>(requestContextPromise);
        for (let middleware of this.configuration.middleware) {
            middlewarePreObservable = middlewarePreObservable.pipe(mergeMap((ctx: RequestContext) => middleware.pre(ctx)));
        }

        return middlewarePreObservable.pipe(mergeMap((ctx: RequestContext) => this.configuration.httpApi.send(ctx))).
            pipe(mergeMap((response: ResponseContext) => {
                let middlewarePostObservable = of(response);
                for (let middleware of this.configuration.middleware) {
                    middlewarePostObservable = middlewarePostObservable.pipe(mergeMap((rsp: ResponseContext) => middleware.post(rsp)));
                }
                return middlewarePostObservable.pipe(map((rsp: ResponseContext) => this.responseProcessor.getAreasWithHttpInfo(rsp)));
            }));
    }

    /**
     * Get all areas.
     */
    public getAreas(_options?: Configuration): Observable<Array<AreaMetadata>> {
        return this.getAreasWithHttpInfo(_options).pipe(map((apiResponse: HttpInfo<Array<AreaMetadata>>) => apiResponse.data));
    }

    /**
     * Get all satellites in an area.
     * @param areaId 
     */
    public getSatellitesInAreaWithHttpInfo(areaId: string, _options?: Configuration): Observable<HttpInfo<Array<SatelliteMetadata>>> {
        const requestContextPromise = this.requestFactory.getSatellitesInArea(areaId, _options);

        // build promise chain
        let middlewarePreObservable = from<RequestContext>(requestContextPromise);
        for (let middleware of this.configuration.middleware) {
            middlewarePreObservable = middlewarePreObservable.pipe(mergeMap((ctx: RequestContext) => middleware.pre(ctx)));
        }

        return middlewarePreObservable.pipe(mergeMap((ctx: RequestContext) => this.configuration.httpApi.send(ctx))).
            pipe(mergeMap((response: ResponseContext) => {
                let middlewarePostObservable = of(response);
                for (let middleware of this.configuration.middleware) {
                    middlewarePostObservable = middlewarePostObservable.pipe(mergeMap((rsp: ResponseContext) => middleware.post(rsp)));
                }
                return middlewarePostObservable.pipe(map((rsp: ResponseContext) => this.responseProcessor.getSatellitesInAreaWithHttpInfo(rsp)));
            }));
    }

    /**
     * Get all satellites in an area.
     * @param areaId 
     */
    public getSatellitesInArea(areaId: string, _options?: Configuration): Observable<Array<SatelliteMetadata>> {
        return this.getSatellitesInAreaWithHttpInfo(areaId, _options).pipe(map((apiResponse: HttpInfo<Array<SatelliteMetadata>>) => apiResponse.data));
    }

}

import { DataPointsApiRequestFactory, DataPointsApiResponseProcessor} from "../apis/DataPointsApi";
export class ObservableDataPointsApi {
    private requestFactory: DataPointsApiRequestFactory;
    private responseProcessor: DataPointsApiResponseProcessor;
    private configuration: Configuration;

    public constructor(
        configuration: Configuration,
        requestFactory?: DataPointsApiRequestFactory,
        responseProcessor?: DataPointsApiResponseProcessor
    ) {
        this.configuration = configuration;
        this.requestFactory = requestFactory || new DataPointsApiRequestFactory(configuration);
        this.responseProcessor = responseProcessor || new DataPointsApiResponseProcessor();
    }

    /**
     * Get all Data points.
     */
    public getDataPointsWithHttpInfo(_options?: Configuration): Observable<HttpInfo<Array<DataPointMetadata>>> {
        const requestContextPromise = this.requestFactory.getDataPoints(_options);

        // build promise chain
        let middlewarePreObservable = from<RequestContext>(requestContextPromise);
        for (let middleware of this.configuration.middleware) {
            middlewarePreObservable = middlewarePreObservable.pipe(mergeMap((ctx: RequestContext) => middleware.pre(ctx)));
        }

        return middlewarePreObservable.pipe(mergeMap((ctx: RequestContext) => this.configuration.httpApi.send(ctx))).
            pipe(mergeMap((response: ResponseContext) => {
                let middlewarePostObservable = of(response);
                for (let middleware of this.configuration.middleware) {
                    middlewarePostObservable = middlewarePostObservable.pipe(mergeMap((rsp: ResponseContext) => middleware.post(rsp)));
                }
                return middlewarePostObservable.pipe(map((rsp: ResponseContext) => this.responseProcessor.getDataPointsWithHttpInfo(rsp)));
            }));
    }

    /**
     * Get all Data points.
     */
    public getDataPoints(_options?: Configuration): Observable<Array<DataPointMetadata>> {
        return this.getDataPointsWithHttpInfo(_options).pipe(map((apiResponse: HttpInfo<Array<DataPointMetadata>>) => apiResponse.data));
    }

}

import { DeviceTypeApiRequestFactory, DeviceTypeApiResponseProcessor} from "../apis/DeviceTypeApi";
export class ObservableDeviceTypeApi {
    private requestFactory: DeviceTypeApiRequestFactory;
    private responseProcessor: DeviceTypeApiResponseProcessor;
    private configuration: Configuration;

    public constructor(
        configuration: Configuration,
        requestFactory?: DeviceTypeApiRequestFactory,
        responseProcessor?: DeviceTypeApiResponseProcessor
    ) {
        this.configuration = configuration;
        this.requestFactory = requestFactory || new DeviceTypeApiRequestFactory(configuration);
        this.responseProcessor = responseProcessor || new DeviceTypeApiResponseProcessor();
    }

    /**
     * Get device types of satellites.
     */
    public getDeviceTypesWithHttpInfo(_options?: Configuration): Observable<HttpInfo<Array<DeviceTypeMetadata>>> {
        const requestContextPromise = this.requestFactory.getDeviceTypes(_options);

        // build promise chain
        let middlewarePreObservable = from<RequestContext>(requestContextPromise);
        for (let middleware of this.configuration.middleware) {
            middlewarePreObservable = middlewarePreObservable.pipe(mergeMap((ctx: RequestContext) => middleware.pre(ctx)));
        }

        return middlewarePreObservable.pipe(mergeMap((ctx: RequestContext) => this.configuration.httpApi.send(ctx))).
            pipe(mergeMap((response: ResponseContext) => {
                let middlewarePostObservable = of(response);
                for (let middleware of this.configuration.middleware) {
                    middlewarePostObservable = middlewarePostObservable.pipe(mergeMap((rsp: ResponseContext) => middleware.post(rsp)));
                }
                return middlewarePostObservable.pipe(map((rsp: ResponseContext) => this.responseProcessor.getDeviceTypesWithHttpInfo(rsp)));
            }));
    }

    /**
     * Get device types of satellites.
     */
    public getDeviceTypes(_options?: Configuration): Observable<Array<DeviceTypeMetadata>> {
        return this.getDeviceTypesWithHttpInfo(_options).pipe(map((apiResponse: HttpInfo<Array<DeviceTypeMetadata>>) => apiResponse.data));
    }

}

import { LogsApiRequestFactory, LogsApiResponseProcessor} from "../apis/LogsApi";
export class ObservableLogsApi {
    private requestFactory: LogsApiRequestFactory;
    private responseProcessor: LogsApiResponseProcessor;
    private configuration: Configuration;

    public constructor(
        configuration: Configuration,
        requestFactory?: LogsApiRequestFactory,
        responseProcessor?: LogsApiResponseProcessor
    ) {
        this.configuration = configuration;
        this.requestFactory = requestFactory || new LogsApiRequestFactory(configuration);
        this.responseProcessor = responseProcessor || new LogsApiResponseProcessor();
    }

    /**
     * Get all Logs.
     */
    public getLogsWithHttpInfo(_options?: Configuration): Observable<HttpInfo<Array<LogMetadata>>> {
        const requestContextPromise = this.requestFactory.getLogs(_options);

        // build promise chain
        let middlewarePreObservable = from<RequestContext>(requestContextPromise);
        for (let middleware of this.configuration.middleware) {
            middlewarePreObservable = middlewarePreObservable.pipe(mergeMap((ctx: RequestContext) => middleware.pre(ctx)));
        }

        return middlewarePreObservable.pipe(mergeMap((ctx: RequestContext) => this.configuration.httpApi.send(ctx))).
            pipe(mergeMap((response: ResponseContext) => {
                let middlewarePostObservable = of(response);
                for (let middleware of this.configuration.middleware) {
                    middlewarePostObservable = middlewarePostObservable.pipe(mergeMap((rsp: ResponseContext) => middleware.post(rsp)));
                }
                return middlewarePostObservable.pipe(map((rsp: ResponseContext) => this.responseProcessor.getLogsWithHttpInfo(rsp)));
            }));
    }

    /**
     * Get all Logs.
     */
    public getLogs(_options?: Configuration): Observable<Array<LogMetadata>> {
        return this.getLogsWithHttpInfo(_options).pipe(map((apiResponse: HttpInfo<Array<LogMetadata>>) => apiResponse.data));
    }

}

import { SatelliteApiRequestFactory, SatelliteApiResponseProcessor} from "../apis/SatelliteApi";
export class ObservableSatelliteApi {
    private requestFactory: SatelliteApiRequestFactory;
    private responseProcessor: SatelliteApiResponseProcessor;
    private configuration: Configuration;

    public constructor(
        configuration: Configuration,
        requestFactory?: SatelliteApiRequestFactory,
        responseProcessor?: SatelliteApiResponseProcessor
    ) {
        this.configuration = configuration;
        this.requestFactory = requestFactory || new SatelliteApiRequestFactory(configuration);
        this.responseProcessor = responseProcessor || new SatelliteApiResponseProcessor();
    }

    /**
     * Edit satellite.
     * @param satelliteMetadata 
     */
    public editSatelliteWithHttpInfo(satelliteMetadata: SatelliteMetadata, _options?: Configuration): Observable<HttpInfo<void>> {
        const requestContextPromise = this.requestFactory.editSatellite(satelliteMetadata, _options);

        // build promise chain
        let middlewarePreObservable = from<RequestContext>(requestContextPromise);
        for (let middleware of this.configuration.middleware) {
            middlewarePreObservable = middlewarePreObservable.pipe(mergeMap((ctx: RequestContext) => middleware.pre(ctx)));
        }

        return middlewarePreObservable.pipe(mergeMap((ctx: RequestContext) => this.configuration.httpApi.send(ctx))).
            pipe(mergeMap((response: ResponseContext) => {
                let middlewarePostObservable = of(response);
                for (let middleware of this.configuration.middleware) {
                    middlewarePostObservable = middlewarePostObservable.pipe(mergeMap((rsp: ResponseContext) => middleware.post(rsp)));
                }
                return middlewarePostObservable.pipe(map((rsp: ResponseContext) => this.responseProcessor.editSatelliteWithHttpInfo(rsp)));
            }));
    }

    /**
     * Edit satellite.
     * @param satelliteMetadata 
     */
    public editSatellite(satelliteMetadata: SatelliteMetadata, _options?: Configuration): Observable<void> {
        return this.editSatelliteWithHttpInfo(satelliteMetadata, _options).pipe(map((apiResponse: HttpInfo<void>) => apiResponse.data));
    }

    /**
     * Get all data points for a satellite.
     * @param satelliteId 
     */
    public getDataPointsBySatelliteWithHttpInfo(satelliteId: string, _options?: Configuration): Observable<HttpInfo<Array<DataPointMetadata>>> {
        const requestContextPromise = this.requestFactory.getDataPointsBySatellite(satelliteId, _options);

        // build promise chain
        let middlewarePreObservable = from<RequestContext>(requestContextPromise);
        for (let middleware of this.configuration.middleware) {
            middlewarePreObservable = middlewarePreObservable.pipe(mergeMap((ctx: RequestContext) => middleware.pre(ctx)));
        }

        return middlewarePreObservable.pipe(mergeMap((ctx: RequestContext) => this.configuration.httpApi.send(ctx))).
            pipe(mergeMap((response: ResponseContext) => {
                let middlewarePostObservable = of(response);
                for (let middleware of this.configuration.middleware) {
                    middlewarePostObservable = middlewarePostObservable.pipe(mergeMap((rsp: ResponseContext) => middleware.post(rsp)));
                }
                return middlewarePostObservable.pipe(map((rsp: ResponseContext) => this.responseProcessor.getDataPointsBySatelliteWithHttpInfo(rsp)));
            }));
    }

    /**
     * Get all data points for a satellite.
     * @param satelliteId 
     */
    public getDataPointsBySatellite(satelliteId: string, _options?: Configuration): Observable<Array<DataPointMetadata>> {
        return this.getDataPointsBySatelliteWithHttpInfo(satelliteId, _options).pipe(map((apiResponse: HttpInfo<Array<DataPointMetadata>>) => apiResponse.data));
    }

    /**
     * Get all logs for a satellite.
     * @param satelliteId 
     */
    public getLogsBySatelliteWithHttpInfo(satelliteId: string, _options?: Configuration): Observable<HttpInfo<Array<LogMetadata>>> {
        const requestContextPromise = this.requestFactory.getLogsBySatellite(satelliteId, _options);

        // build promise chain
        let middlewarePreObservable = from<RequestContext>(requestContextPromise);
        for (let middleware of this.configuration.middleware) {
            middlewarePreObservable = middlewarePreObservable.pipe(mergeMap((ctx: RequestContext) => middleware.pre(ctx)));
        }

        return middlewarePreObservable.pipe(mergeMap((ctx: RequestContext) => this.configuration.httpApi.send(ctx))).
            pipe(mergeMap((response: ResponseContext) => {
                let middlewarePostObservable = of(response);
                for (let middleware of this.configuration.middleware) {
                    middlewarePostObservable = middlewarePostObservable.pipe(mergeMap((rsp: ResponseContext) => middleware.post(rsp)));
                }
                return middlewarePostObservable.pipe(map((rsp: ResponseContext) => this.responseProcessor.getLogsBySatelliteWithHttpInfo(rsp)));
            }));
    }

    /**
     * Get all logs for a satellite.
     * @param satelliteId 
     */
    public getLogsBySatellite(satelliteId: string, _options?: Configuration): Observable<Array<LogMetadata>> {
        return this.getLogsBySatelliteWithHttpInfo(satelliteId, _options).pipe(map((apiResponse: HttpInfo<Array<LogMetadata>>) => apiResponse.data));
    }

    /**
     * Get satellite by ID.
     * @param satelliteId 
     */
    public getSatelliteByIdWithHttpInfo(satelliteId: string, _options?: Configuration): Observable<HttpInfo<SatelliteMetadata>> {
        const requestContextPromise = this.requestFactory.getSatelliteById(satelliteId, _options);

        // build promise chain
        let middlewarePreObservable = from<RequestContext>(requestContextPromise);
        for (let middleware of this.configuration.middleware) {
            middlewarePreObservable = middlewarePreObservable.pipe(mergeMap((ctx: RequestContext) => middleware.pre(ctx)));
        }

        return middlewarePreObservable.pipe(mergeMap((ctx: RequestContext) => this.configuration.httpApi.send(ctx))).
            pipe(mergeMap((response: ResponseContext) => {
                let middlewarePostObservable = of(response);
                for (let middleware of this.configuration.middleware) {
                    middlewarePostObservable = middlewarePostObservable.pipe(mergeMap((rsp: ResponseContext) => middleware.post(rsp)));
                }
                return middlewarePostObservable.pipe(map((rsp: ResponseContext) => this.responseProcessor.getSatelliteByIdWithHttpInfo(rsp)));
            }));
    }

    /**
     * Get satellite by ID.
     * @param satelliteId 
     */
    public getSatelliteById(satelliteId: string, _options?: Configuration): Observable<SatelliteMetadata> {
        return this.getSatelliteByIdWithHttpInfo(satelliteId, _options).pipe(map((apiResponse: HttpInfo<SatelliteMetadata>) => apiResponse.data));
    }

    /**
     * Get satellites
     */
    public getSatellitesWithHttpInfo(_options?: Configuration): Observable<HttpInfo<Array<SatelliteMetadata>>> {
        const requestContextPromise = this.requestFactory.getSatellites(_options);

        // build promise chain
        let middlewarePreObservable = from<RequestContext>(requestContextPromise);
        for (let middleware of this.configuration.middleware) {
            middlewarePreObservable = middlewarePreObservable.pipe(mergeMap((ctx: RequestContext) => middleware.pre(ctx)));
        }

        return middlewarePreObservable.pipe(mergeMap((ctx: RequestContext) => this.configuration.httpApi.send(ctx))).
            pipe(mergeMap((response: ResponseContext) => {
                let middlewarePostObservable = of(response);
                for (let middleware of this.configuration.middleware) {
                    middlewarePostObservable = middlewarePostObservable.pipe(mergeMap((rsp: ResponseContext) => middleware.post(rsp)));
                }
                return middlewarePostObservable.pipe(map((rsp: ResponseContext) => this.responseProcessor.getSatellitesWithHttpInfo(rsp)));
            }));
    }

    /**
     * Get satellites
     */
    public getSatellites(_options?: Configuration): Observable<Array<SatelliteMetadata>> {
        return this.getSatellitesWithHttpInfo(_options).pipe(map((apiResponse: HttpInfo<Array<SatelliteMetadata>>) => apiResponse.data));
    }

}