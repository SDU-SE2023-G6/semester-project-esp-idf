import type { SatelliteId } from "./Satellite";

export type DataPoint = {
    value: number;
    timestamp: Date;
    satellite: SatelliteId;
    sensor: string;
    unit: string;
}