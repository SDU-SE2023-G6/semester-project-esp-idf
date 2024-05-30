import type { SatelliteId } from "./Satellite";

export type LogSource = SatelliteId | 'system';
export enum LogType {
    Info = 'INFO',
    Error = 'ERROR',
    Warning = 'WARNING',
    Debug = 'DEBUG',
    Heartbeat = 'HEARTBEAT',
    UpdateDownloadStart = 'UPDATE_DOWNLOAD_START',
    UpdateDownloadComplete = 'UPDATE_DOWNLOAD_COMPLETE',
    UpdateStart = 'UPDATE_START',
    UpdateComplete = 'UPDATE_COMPLETE',
    UpdateSuccess = 'UPDATE_SUCCESS',
    UpdateFail = 'UPDATE_FAIL',
    UpdateRollbackStart = 'UPDATE_ROLLBACK_START',
    UpdateRollbackSuccess = 'UPDATE_ROLLBACK_SUCCESS',
    UpdateRollbackFail = 'UPDATE_ROLLBACK_FAIL'
}

const logHumanReadable = {
    [LogType.Info]: 'Info',
    [LogType.Error]: 'An error occurred on the satellite.',
    [LogType.Warning]: 'Warning',
    [LogType.Debug]: 'Debug',
    [LogType.Heartbeat]: 'The satellite is alive and well.',
    [LogType.UpdateDownloadStart]: 'The satellite is downloading an update.',
    [LogType.UpdateDownloadComplete]: 'The satellite has finished downloading an update.',
    [LogType.UpdateStart]: 'The satellite is updating.',
    [LogType.UpdateComplete]: 'The satellite has finished updating.',
    [LogType.UpdateSuccess]: 'The satellite has successfully updated.',
    [LogType.UpdateFail]: 'The satellite failed to update.',
    [LogType.UpdateRollbackStart]: 'The satellite is rolling back to a previous version after a failed update.',
    [LogType.UpdateRollbackSuccess]: 'The satellite has successfully rolled back to a previous version.',
    [LogType.UpdateRollbackFail]: 'The satellite failed to roll back to a previous version.'
}

export function getLogMessage(logType:LogType):string {
    return logHumanReadable[logType];
}

export enum SimplifiedLogType {
    Info = 'Info',
    Error = 'Error',
    Warning = 'Warning',
    Debug = 'Debug',
    Success = 'Success',
    Update = 'Update',
    Heartbeat = 'Heartbeat'
}

const logSimplification = {
    [LogType.Info]: SimplifiedLogType.Info,
    [LogType.Error]: SimplifiedLogType.Error,
    [LogType.Warning]: SimplifiedLogType.Warning,
    [LogType.Debug]: SimplifiedLogType.Debug,
    [LogType.Heartbeat]: SimplifiedLogType.Heartbeat,
    [LogType.UpdateDownloadStart]: SimplifiedLogType.Update,
    [LogType.UpdateDownloadComplete]: SimplifiedLogType.Update,
    [LogType.UpdateStart]: SimplifiedLogType.Update,
    [LogType.UpdateComplete]: SimplifiedLogType.Update,
    [LogType.UpdateSuccess]: SimplifiedLogType.Success,
    [LogType.UpdateFail]: SimplifiedLogType.Error,
    [LogType.UpdateRollbackStart]: SimplifiedLogType.Update,
    [LogType.UpdateRollbackSuccess]: SimplifiedLogType.Success,
    [LogType.UpdateRollbackFail]: SimplifiedLogType.Error,
    [SimplifiedLogType.Info]: SimplifiedLogType.Info,
    [SimplifiedLogType.Error]: SimplifiedLogType.Error,
    [SimplifiedLogType.Warning]: SimplifiedLogType.Warning,
    [SimplifiedLogType.Debug]: SimplifiedLogType.Debug,
    [SimplifiedLogType.Success]: SimplifiedLogType.Success,
    [SimplifiedLogType.Update]: SimplifiedLogType.Update,
    [SimplifiedLogType.Heartbeat]: SimplifiedLogType.Heartbeat
}

export function simplifyLogType(logType:LogType|SimplifiedLogType):SimplifiedLogType {
    return logSimplification[logType];
}


export type Log = {
    id?: string;
    type: LogType;
    timestamp: Date;
    source: LogSource;
    message?: string;
}