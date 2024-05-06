export type SatelliteId = number | string;
export type SatelliteStatus = 'online' | 'offline' | 'error' | 'pending';
import type { AreaId } from '@/types/Area'

export type Satellite = {
    id: SatelliteId;
    name: string;
    area: AreaId;
    class: string;
    status: SatelliteStatus;
}
