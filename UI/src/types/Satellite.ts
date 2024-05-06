export type SatelliteId = number;

import type { AreaId } from '@/types/Area'

export type Satellite = {
    id: SatelliteId;
    name: string;
    area: AreaId;
    class: string;
}
