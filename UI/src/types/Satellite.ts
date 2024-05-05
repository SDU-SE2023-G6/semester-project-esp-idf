export type SatelliteId = number | string;

import type { AreaId } from '@/types/Area'

export type Satellite = {
    id: SatelliteId;
    name: string;
    area: AreaId;
    class: string;
}
