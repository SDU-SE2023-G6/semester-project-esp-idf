import type { SatelliteId } from "./Satellite";

export type DataPoint = {
    value: number;
    timestamp: string;
    satellite: SatelliteId;
    sensor: string;
    unit: string;
}