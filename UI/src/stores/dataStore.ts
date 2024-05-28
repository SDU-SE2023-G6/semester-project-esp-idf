import { defineStore } from 'pinia';
import type { DataPoint } from '@/types/DataPoint';
import { getLogMessage, type Log, type LogSource } from '@/types/Log';
import type { Area, AreaId } from '@/types/Area';
import type { Satellite, SatelliteId } from '@/types/Satellite';
import { AreaApi, DataPointsApi, DeviceTypeApi, LogsApi, SatelliteApi } from './api';
import type { AreaMetadata, DataPointMetadata, DeviceTypeMetadata, LogMetadata, SatelliteMetadata } from '@/api';
import type { SatelliteType } from '@/types/SatelliteType';

function AreaMetadatasToAreas(areaMetadatas: AreaMetadata[]): Area[] {
  return areaMetadatas.map(AreaMetadataToArea);
}

function AreaMetadataToArea(areaMetadata: AreaMetadata): Area {
  if(!areaMetadata.name) {
    throw new Error(`Area name is required, got ${areaMetadata.name} (${areaMetadata})`);
  }
  if(!areaMetadata.id) {
    throw new Error(`Area id is required, got ${areaMetadata.id} (${areaMetadata})`);
  }
  return {
    id: areaMetadata.id,
    name: areaMetadata.name
  };
}

async function SatelliteMetadatasToSatellites(satelliteMetadatas: SatelliteMetadata[]): Promise<Satellite[]> {
  return Promise.all(satelliteMetadatas.map(SatelliteMetadataToSatellite));
}

async function SatelliteMetadataToSatellite(satelliteMetadata: SatelliteMetadata): Promise<Satellite> {
  if(!satelliteMetadata.id) {
    throw new Error(`Satellite id is required, got ${satelliteMetadata.id} (${satelliteMetadata})`);
  }

  if(!satelliteMetadata.status) {
    throw new Error(`Satellite status is required, got ${satelliteMetadata.status} (${satelliteMetadata})`);
  }

  return {
    id: satelliteMetadata.id,
    name: satelliteMetadata.name,
    area: satelliteMetadata.areaId,
    type: satelliteMetadata.deviceTypeId ? await DeviceTypeMetadataToSatelliteType(await DeviceTypeApi.getDeviceTypeById(satelliteMetadata.deviceTypeId)) : undefined,
    status: satelliteMetadata.status,
    macAddress: satelliteMetadata.macAddress
  };
}

async function DeviceTypeMetadatasToSatelliteTypes(deviceTypes: DeviceTypeMetadata[]): Promise<SatelliteType[]> {
  return Promise.all(deviceTypes.map(DeviceTypeMetadataToSatelliteType));
}

async function DeviceTypeMetadataToSatelliteType(deviceType: DeviceTypeMetadata): Promise<SatelliteType> {
  if(!deviceType.id) {
    throw new Error(`DeviceType id is required, got ${deviceType.id} (${deviceType})`);
  }
  if(!deviceType.name) {
    throw new Error(`DeviceType name is required, got ${deviceType.name} (${deviceType})`);
  }

  return {
    id: deviceType.id,
    name: deviceType.name,
    deprecated: deviceType?.deprecated
  };
}

async function DataPointMetadatasToDataPoints(dataPointMetadatas: DataPointMetadata[]): Promise<DataPoint[]> {
  return Promise.all(dataPointMetadatas.map(DataPointMetadataToDataPoint));
}

async function DataPointMetadataToDataPoint(dataPointMetadata: DataPointMetadata): Promise<DataPoint> {
  if(!dataPointMetadata.satelliteId) {
    throw new Error(`DataPoint satellite is required, got ${dataPointMetadata.satelliteId} (${dataPointMetadata})`);
  }
  if(!dataPointMetadata.timestamp) {
    throw new Error(`DataPoint timestamp is required, got ${dataPointMetadata.timestamp} (${dataPointMetadata})`);
  }
  if(dataPointMetadata.measurement === undefined) {
    throw new Error(`DataPoint value is required, got ${dataPointMetadata.measurement} (${dataPointMetadata})`);
  }
  if(!dataPointMetadata.sensor) {
    throw new Error(`DataPoint sensor is required, got ${dataPointMetadata.sensor} (${dataPointMetadata})`);
  }
  if(!dataPointMetadata.unit) {
    throw new Error(`DataPoint unit is required, got ${dataPointMetadata.unit} (${dataPointMetadata})`);
  }

  return {
    satellite: dataPointMetadata.satelliteId,
    timestamp: dataPointMetadata.timestamp,
    value: dataPointMetadata.measurement,
    sensor: dataPointMetadata.sensor,
    unit: dataPointMetadata.unit
  };
}

function LogsMetadatasToLogs(logMetadatas: LogMetadata[]): Log[] {
  return logMetadatas.map(LogMetadataToLog);
}

function LogMetadataToLog(logMetadata: LogMetadata): Log {
  if(!logMetadata.timestamp) {
    throw new Error(`Log timestamp is required, got ${logMetadata.timestamp} (${logMetadata})`);
  }
  if(!logMetadata.type) {
    throw new Error(`Log type is required, got ${logMetadata.type} (${logMetadata})`);
  }


  return {
    id: logMetadata.id,
    source: logMetadata.source ? logMetadata.source : 'system',
    timestamp: logMetadata.timestamp,
    type: logMetadata.type,
    message: logMetadata.message ? logMetadata.message : getLogMessage(logMetadata.type)
  }
}

async function fetchDevicesPendingMetadata() {
  const satellites = await SatelliteMetadatasToSatellites(await SatelliteApi.getSatellites());
  const satellitesPendingMetadata = satellites.filter(satellite => satellite.status === 'PENDING_METADATA');
  return satellitesPendingMetadata;
}

function satelliteToSatelliteMetadata(satellite: Satellite): SatelliteMetadata {
  return {
    id: satellite.id,
    name: satellite.name,
    areaId: satellite.area,
    deviceTypeId: satellite.type?.id,
    macAddress: satellite.macAddress,
    status: satellite.status
  };
}

function sortLogsByTimestamp(logs: Log[]): Log[] {
  return logs.sort((a, b) => a.timestamp.getTime() - b.timestamp.getTime());
}

export const useDataStore = defineStore('data', {
  actions: {
    getAreas: async () => AreaMetadatasToAreas(await AreaApi.getAreas()),
    getAreaById: async (id: AreaId) => AreaMetadataToArea(await AreaApi.getAreaById(id)),
    addArea: async (area: Area) => AreaApi.addArea(area),
    editArea: async (area: Area) => AreaApi.editArea(area.id, area),
    deleteArea: async (area: Area) => AreaApi.deleteAreaById(area.id),

    getSatellites: async () => SatelliteMetadatasToSatellites(await SatelliteApi.getSatellites()),
    getDevicesPendingMetadata: async () => await fetchDevicesPendingMetadata(),
    getSatelliteById: async (id: SatelliteId) => SatelliteMetadataToSatellite(await SatelliteApi.getSatelliteById(id)),
    getSatellitesByArea: async (areaId: AreaId) => SatelliteMetadatasToSatellites(await AreaApi.getSatellitesInArea(areaId)),
    getSatellitesWithoutArea: async () => SatelliteMetadatasToSatellites(await AreaApi.getSatellitesInArea()),
    editSatellite: async (satellite: Satellite) => await SatelliteApi.editSatellite(satelliteToSatelliteMetadata(satellite)),
    deleteSatellite: async (satellite: Satellite) => await SatelliteApi.deleteSatelliteById(satellite.id),
    
    getSatelliteTypes: async () => (await DeviceTypeMetadatasToSatelliteTypes(await DeviceTypeApi.getDeviceTypes())).filter(deviceType => !deviceType.deprecated),
    getSatelliteTypeById: async (id: string) => DeviceTypeMetadataToSatelliteType(await DeviceTypeApi.getDeviceTypeById(id)),

    getDataPoints: async () => DataPointMetadatasToDataPoints(await DataPointsApi.getDataPoints()),
    getDataPointsBySatellite: async (satellite: Satellite) => DataPointMetadatasToDataPoints(await SatelliteApi.getDataPointsBySatellite(satellite.id)),
    getDataPointsFromSometimeAgo: async (hours:number) => DataPointMetadatasToDataPoints(await DataPointsApi.getDataPointsFromSometimeAgo(hours)),

    getLogs: async () => sortLogsByTimestamp(LogsMetadatasToLogs(await LogsApi.getLogs())),
    getLogsBySource: async (source: LogSource) => sortLogsByTimestamp(LogsMetadatasToLogs(source === 'system' ? await LogsApi.getLogsBySatellite() : await LogsApi.getLogsBySatellite(source))),
    getLogsFromSometimeAgo: async (hours:number) => sortLogsByTimestamp(LogsMetadatasToLogs(await LogsApi.getLogsFromSometimeAgo(hours)))
  }
});
