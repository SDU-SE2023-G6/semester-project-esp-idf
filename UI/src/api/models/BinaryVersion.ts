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

export class BinaryVersion {
    'binaryHash'?: string;
    'binaryId'?: string;

    static readonly discriminator: string | undefined = undefined;

    static readonly attributeTypeMap: Array<{name: string, baseName: string, type: string, format: string}> = [
        {
            "name": "binaryHash",
            "baseName": "binaryHash",
            "type": "string",
            "format": ""
        },
        {
            "name": "binaryId",
            "baseName": "binaryId",
            "type": "string",
            "format": ""
        }    ];

    static getAttributeTypeMap() {
        return BinaryVersion.attributeTypeMap;
    }

    public constructor() {
    }
}
