import * as backendAPI from '@/api';

export function createAPIConfiguration() {
  const configurationParameters = {
    baseServer: backendAPI.server1
  };

  return backendAPI.createConfiguration(configurationParameters);
}

// Instantiate API clients
export const AreaApi = new backendAPI.AreaApi(createAPIConfiguration());
export const DataPointsApi = new backendAPI.DataPointsApi(createAPIConfiguration());
export const DeviceTypeApi = new backendAPI.DeviceTypeApi(createAPIConfiguration());
export const LogsApi = new backendAPI.LogsApi(createAPIConfiguration());
export const SatelliteApi = new backendAPI.SatelliteApi(createAPIConfiguration());

