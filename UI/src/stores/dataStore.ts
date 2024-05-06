// stores/dataStore.js
import { defineStore } from 'pinia';
import Data from '@/assets/dummy';
import type { DataPoint } from '@/types/DataPoint';
import type { Log } from '@/types/Log';
import type { Area, AreaId } from '@/types/Area';
import type { Satellite, SatelliteId } from '@/types/Satellite';

export const useDataStore = defineStore('data', {
  state: () => ({
    areas: Data.areas,
    satellites: Data.satellites,
    dataPoints: Data.dataPoints.sort((a: DataPoint, b: DataPoint) => parseInt(a.timestamp) - parseInt(b.timestamp)),
    logs: Data.logs.sort((a: Log, b: Log) => parseInt(a.timestamp) - parseInt(b.timestamp))
  }),
  getters: {
    getAreas: state => state.areas,
    getArea: state => (areaId: AreaId) => state.areas.find(area => area.id === areaId),
    getSatellites: state => state.satellites,
    getSatellite: state => (satelliteId: SatelliteId) => state.satellites.find(satellite => satellite.id === satelliteId),
    getDataPoints: state => state.dataPoints,
    getLogs: state => state.logs,
    getSatellitesByArea: state => (areaId: AreaId) => state.satellites.filter((satellite: Satellite) => satellite.area === areaId),
    getDataPointsBySatellite: state => (satelliteId: SatelliteId) => state.dataPoints.filter(dataPoint => dataPoint.satellite === satelliteId),
    getLogsBySatellite: state => (satelliteId: SatelliteId) => state.logs.filter(log => log.satellite === satelliteId)
  },
  actions: {
    editSatellite(satellite: Satellite) {
      const index = this.satellites.findIndex(sat => sat.id === satellite.id);
      this.satellites[index] = satellite;
    },
    addArea(area: Area) {
      this.areas.push(area);
    },
    editArea(area: Area) {
      const index = this.areas.findIndex(a => a.id === area.id);
      this.areas[index] = area;
    },
    removeArea(area: Area) {
      const index = this.areas.findIndex(a => a.id === area.id);
      this.areas.splice(index, 1);
    }
  }
});
