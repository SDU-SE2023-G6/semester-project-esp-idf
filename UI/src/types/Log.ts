import type { SatelliteId } from "./Satellite";

export type LogSource = SatelliteId | 'system';
export type LogType = 'info' | 'warning' | 'error' | 'success' | 'status';

export type Log = {
    type: LogType;
    timestamp: string;
    source: LogSource;
    message: string;
}