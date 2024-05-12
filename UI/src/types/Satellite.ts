export type SatelliteId = string;

export enum SatelliteStatus {
    Online = 'ONLINE',
    Offline = 'OFFLINE',
    Error = 'ERROR',
    Updating = 'UPDATING',
    PendingMetadata = 'PENDING_METADATA',
    PendingVersionCheck = 'PENDING_VERSION_CHECK'
}

import type { AreaId } from '@/types/Area'
import type { SatelliteType } from './SatelliteType';

export type Satellite = {
    id: SatelliteId;
    type?: SatelliteType;
    name?: string;
    area?: AreaId;
    status: SatelliteStatus;
    macAddress?: string;
}
