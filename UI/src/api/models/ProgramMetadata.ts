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

import { ProgramStatus } from '../models/ProgramStatus';
import { HttpFile } from '../http/http';

export class ProgramMetadata {
    'compiled'?: Date;
    'createdDate'?: Date;
    'id'?: string;
    'iteration'?: number;
    'lastModifiedDate'?: Date;
    'status'?: ProgramStatus;

    static readonly discriminator: string | undefined = undefined;

    static readonly attributeTypeMap: Array<{name: string, baseName: string, type: string, format: string}> = [
        {
            "name": "compiled",
            "baseName": "compiled",
            "type": "Date",
            "format": "date-time"
        },
        {
            "name": "createdDate",
            "baseName": "createdDate",
            "type": "Date",
            "format": "date-time"
        },
        {
            "name": "id",
            "baseName": "id",
            "type": "string",
            "format": ""
        },
        {
            "name": "iteration",
            "baseName": "iteration",
            "type": "number",
            "format": "int64"
        },
        {
            "name": "lastModifiedDate",
            "baseName": "lastModifiedDate",
            "type": "Date",
            "format": "date-time"
        },
        {
            "name": "status",
            "baseName": "status",
            "type": "ProgramStatus",
            "format": ""
        }    ];

    static getAttributeTypeMap() {
        return ProgramMetadata.attributeTypeMap;
    }

    public constructor() {
    }
}



