import type { SatelliteId } from "./Satellite";

export type LogSource = SatelliteId | 'system';
export enum LogType {
    Unspecified = 'UNSPECIFIED',
    Info = 'INFO',
    Warning = 'WARNING',
    Error = 'ERROR',
    Heartbeat = 'HEARTBEAT'
}

export type Log = {
    type: LogType;
    timestamp: Date;
    source: LogSource;
    message: string;
}