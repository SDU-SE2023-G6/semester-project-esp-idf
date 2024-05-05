import type { SatelliteId } from "./Satellite";

export type LogType = 'info' | 'warning' | 'error' | 'success' | 'status';

export type Log = {
    type: LogType;
    timestamp: string;
    satellite: SatelliteId;
    message: string;
}