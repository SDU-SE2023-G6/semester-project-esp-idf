/**
 * SNEM API
 * Documentation for SNEM API.
 *
 * OpenAPI spec version: 1.0.0
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

import { HttpFile } from '../http/http';

export enum LogType {
    Error = 'ERROR',
    Info = 'INFO',
    Debug = 'DEBUG',
    Warning = 'WARNING',
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
