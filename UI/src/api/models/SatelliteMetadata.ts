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

import { SatelliteStatus } from '../models/SatelliteStatus';
import { HttpFile } from '../http/http';

export class SatelliteMetadata {
    'areaId'?: string;
    'deviceTypeId'?: string;
    'id'?: string;
    'macAddress'?: string;
    'name'?: string;
    'status'?: SatelliteStatus;

    static readonly discriminator: string | undefined = undefined;

    static readonly attributeTypeMap: Array<{name: string, baseName: string, type: string, format: string}> = [
        {
            "name": "areaId",
            "baseName": "areaId",
            "type": "string",
            "format": ""
        },
        {
            "name": "deviceTypeId",
            "baseName": "deviceTypeId",
            "type": "string",
            "format": ""
        },
        {
            "name": "id",
            "baseName": "id",
            "type": "string",
            "format": ""
        },
        {
            "name": "macAddress",
            "baseName": "macAddress",
            "type": "string",
            "format": ""
        },
        {
            "name": "name",
            "baseName": "name",
            "type": "string",
            "format": ""
        },
        {
            "name": "status",
            "baseName": "status",
            "type": "SatelliteStatus",
            "format": ""
        }    ];

    static getAttributeTypeMap() {
        return SatelliteMetadata.attributeTypeMap;
    }

    public constructor() {
    }
}



