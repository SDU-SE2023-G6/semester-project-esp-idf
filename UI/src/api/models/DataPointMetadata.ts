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

export class DataPointMetadata {
    'id'?: string;
    'measurement'?: number;
    'satelliteId'?: string;
    'sensor'?: string;
    'timestamp'?: Date;
    'unit'?: string;

    static readonly discriminator: string | undefined = undefined;

    static readonly attributeTypeMap: Array<{name: string, baseName: string, type: string, format: string}> = [
        {
            "name": "id",
            "baseName": "id",
            "type": "string",
            "format": ""
        },
        {
            "name": "measurement",
            "baseName": "measurement",
            "type": "number",
            "format": "double"
        },
        {
            "name": "satelliteId",
            "baseName": "satelliteId",
            "type": "string",
            "format": ""
        },
        {
            "name": "sensor",
            "baseName": "sensor",
            "type": "string",
            "format": ""
        },
        {
            "name": "timestamp",
            "baseName": "timestamp",
            "type": "Date",
            "format": "date-time"
        },
        {
            "name": "unit",
            "baseName": "unit",
            "type": "string",
            "format": ""
        }    ];

    static getAttributeTypeMap() {
        return DataPointMetadata.attributeTypeMap;
    }

    public constructor() {
    }
}
