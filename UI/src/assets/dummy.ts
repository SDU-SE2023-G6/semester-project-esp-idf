import type { Area } from "@/types/Area";
import type { DataPoint } from "@/types/DataPoint";
import type { Log } from "@/types/Log";
import type { Satellite, SatelliteStatus } from "@/types/Satellite";

const areas : Area[] = [
    {
        id: 1,
        name: 'Forest'
    },
    {
        id: 2,
        name: 'Pond'
    },
    {
        id: 3,
        name: 'Cave'
    }
];

const statuses: SatelliteStatus[] = ['online', 'offline', 'error', 'pending'];

const currentTimestamp = Math.floor(Date.now() / 1000);

const randomTimestampWithinLast24Hours = () => {
    return (currentTimestamp - 86400) + Math.floor(Math.random() * 86400);
}

const satellites: Satellite[] = [
    {
        id: 1,
        name: 'F-HT-00-00',
        area: 1,
        class: 'HT',
        status: statuses[Math.floor(Math.random() * statuses.length)]
    },
    {
        id: 2,
        name: 'F-HT-00-01',
        area: 1,
        class: 'HT',
        status: statuses[Math.floor(Math.random() * statuses.length)]
    },
    {
        id: 3,
        name: 'F-CO2-00-01',
        area: 1,
        class: 'CO2',
        status: statuses[Math.floor(Math.random() * statuses.length)]
    },
    {
        id: 4,
        name: 'F-HT-00-02',
        area: 1,
        class: 'HT',
        status: statuses[Math.floor(Math.random() * statuses.length)]
    },
    {
        id: 5,
        name: 'F-HT-00-03',
        area: 1,
        class: 'HT',
        status: statuses[Math.floor(Math.random() * statuses.length)]
    },
    {
        id: 6,
        name: 'F-HT-01-00',
        area: 1,
        class: 'HT',
        status: statuses[Math.floor(Math.random() * statuses.length)]
    },
    {
        id: 7,
        name: 'F-HT-01-01',
        area: 1,
        class: 'HT',
        status: statuses[Math.floor(Math.random() * statuses.length)]
    },
    {
        id: 8,
        name: 'F-HT-01-02',
        area: 1,
        class: 'HT',
        status: statuses[Math.floor(Math.random() * statuses.length)]
    },
    {
        id: 9,
        name: 'F-HT-01-03',
        area: 1,
        class: 'HT',
        status: statuses[Math.floor(Math.random() * statuses.length)]
    },
    {
        id: 10,
        name: 'F-CO2-01-03',
        area: 1,
        class: 'CO2',
        status: statuses[Math.floor(Math.random() * statuses.length)]
    },
    {
        id: 11,
        name: 'F-HT-02-00',
        area: 1,
        class: 'HT',
        status: statuses[Math.floor(Math.random() * statuses.length)]
    },
    {
        id: 12,
        name: 'F-HT-02-01',
        area: 1,
        class: 'HT',
        status: statuses[Math.floor(Math.random() * statuses.length)]
    },
    {
        id: 13,
        name: 'F-HT-02-02',
        area: 1,
        class: 'HT',
        status: statuses[Math.floor(Math.random() * statuses.length)]
    },
    {
        id: 14,
        name: 'F-HT-02-03',
        area: 1,
        class: 'HT',
        status: statuses[Math.floor(Math.random() * statuses.length)]
    },
    {
        id: 16,
        name: 'F-HT-03-00',
        area: 1,
        class: 'HT',
        status: statuses[Math.floor(Math.random() * statuses.length)]
    },
    {
        id: 17,
        name: 'F-HT-03-01',
        area: 1,
        class: 'HT',
        status: statuses[Math.floor(Math.random() * statuses.length)]
    },
    {
        id: 18,
        name: 'F-HT-03-02',
        area: 1,
        class: 'HT',
        status: statuses[Math.floor(Math.random() * statuses.length)]
    },
    {
        id: 19,
        name: 'F-HT-03-03',
        area: 1,
        class: 'HT',
        status: statuses[Math.floor(Math.random() * statuses.length)]
    },
    {
        id: 20,
        name: 'P-Temp',
        area: 2,
        class: 'T',
        status: statuses[Math.floor(Math.random() * statuses.length)]
    },
    {
        id: 21,
        name: 'P-CO2',
        area: 2,
        class: 'CO2',
        status: statuses[Math.floor(Math.random() * statuses.length)]
    },
    {
        id: 22,
        name: 'P-Rad',
        area: 2,
        class: 'Rad',
        status: statuses[Math.floor(Math.random() * statuses.length)]
    },
    {
        id: 23,
        name: 'C-Temp-00',
        area: 3,
        class: 'T',
        status: statuses[Math.floor(Math.random() * statuses.length)]
    },
    {
        id: 24,
        name: 'C-Temp-01',
        area: 3,
        class: 'T',
        status: statuses[Math.floor(Math.random() * statuses.length)]
    },
    {
        id: 25,
        name: 'C-Temp-02',
        area: 3,
        class: 'T',
        status: statuses[Math.floor(Math.random() * statuses.length)]
    },
    {
        id: 26,
        name: 'C-Temp-03',
        area: 3,
        class: 'T',
        status: statuses[Math.floor(Math.random() * statuses.length)]
    },
    {
        id: 27,
        name: 'C-Temp-04',
        area: 3,
        class: 'T',
        status: statuses[Math.floor(Math.random() * statuses.length)]
    },
    {
        id: 28,
        name: 'C-Temp-05',
        area: 3,
        class: 'T',
        status: statuses[Math.floor(Math.random() * statuses.length)]
    },
    {
        id: 29,
        name: 'C-Temp-06',
        area: 3,
        class: 'T',
        status: statuses[Math.floor(Math.random() * statuses.length)]
    },
    {
        id: 30,
        name: 'C-Temp-07',
        area: 3,
        class: 'T',
        status: statuses[Math.floor(Math.random() * statuses.length)]
    },
    {
        id: 31,
        name: 'C-CO2-00',
        area: 3,
        class: 'CO2',
        status: statuses[Math.floor(Math.random() * statuses.length)]
    },
    {
        id: 32,
        name: 'C-CO2-01',
        area: 3,
        class: 'CO2',
        status: statuses[Math.floor(Math.random() * statuses.length)]
    },
    {
        id: 33,
        name: 'C-CO2-02',
        area: 3,
        class: 'CO2',
        status: statuses[Math.floor(Math.random() * statuses.length)]
    },
    {
        id: 34,
        name: 'C-CO2-03',
        area: 3,
        class: 'CO2',
        status: statuses[Math.floor(Math.random() * statuses.length)]
    },
    {
        id: 35,
        name: 'C-CO2-04',
        area: 3,
        class: 'CO2',
        status: statuses[Math.floor(Math.random() * statuses.length)]
    },
    {
        id: 39,
        name: 'C-Rad-00',
        area: 3,
        class: 'Rad',
        status: statuses[Math.floor(Math.random() * statuses.length)]
    },
    {
        id: 40,
        name: 'C-Rad-01',
        area: 3,
        class: 'Rad',
        status: statuses[Math.floor(Math.random() * statuses.length)]
    },
    {
        id: 41,
        name: 'C-Rad-02',
        area: 3,
        class: 'Rad',
        status: statuses[Math.floor(Math.random() * statuses.length)]
    }
];


const dataPoints : DataPoint[] = [
    {
        value: 35.2,
        timestamp: randomTimestampWithinLast24Hours(),
        satellite: 1,
        sensor: "Temperature",
        unit: "°C"
    },
    {
        value: 36.1,
        timestamp: randomTimestampWithinLast24Hours(),
        satellite: 1,
        sensor: "Temperature",
        unit: "°C"
    },
    {
        value: 19.4,
        timestamp: randomTimestampWithinLast24Hours(),
        satellite: 2,
        sensor: "Temperature",
        unit: "°C"
    },
    {
        value: 18.9,
        timestamp: randomTimestampWithinLast24Hours(),
        satellite: 2,
        sensor: "Temperature",
        unit: "°C"
    },
    {
        value: 408.5,
        timestamp: randomTimestampWithinLast24Hours(),
        satellite: 3,
        sensor: "CO2",
        unit: "ppm"
    },
    {
        value: 410.0,
        timestamp: randomTimestampWithinLast24Hours(),
        satellite: 3,
        sensor: "CO2",
        unit: "ppm"
    },
    {
        value: 22.8,
        timestamp: randomTimestampWithinLast24Hours(),
        satellite: 23,
        sensor: "Temperature",
        unit: "°C"
    },
    {
        value: 23.2,
        timestamp: randomTimestampWithinLast24Hours(),
        satellite: 23,
        sensor: "Temperature",
        unit: "°C"
    },
    {
        value: 21.1,
        timestamp: randomTimestampWithinLast24Hours(),
        satellite: 24,
        sensor: "Temperature",
        unit: "°C"
    },
    {
        value: 21.3,
        timestamp: randomTimestampWithinLast24Hours(),
        satellite: 24,
        sensor: "Temperature",
        unit: "°C"
    },
    {
        value: 405.0,
        timestamp: randomTimestampWithinLast24Hours(),
        satellite: 31,
        sensor: "CO2",
        unit: "ppm"
    },
    {
        value: 406.5,
        timestamp: randomTimestampWithinLast24Hours(),
        satellite: 31,
        sensor: "CO2",
        unit: "ppm"
    },
    {
        value: 405.7,
        timestamp: randomTimestampWithinLast24Hours(),
        satellite: 32,
        sensor: "CO2",
        unit: "ppm"
    },
    {
        value: 407.1,
        timestamp: randomTimestampWithinLast24Hours(),
        satellite: 32,
        sensor: "CO2",
        unit: "ppm"
    },
    {
        value: 7.8,
        timestamp: randomTimestampWithinLast24Hours(),
        satellite: 39,
        sensor: "Radiation",
        unit: "Gy"
    },
    {
        value: 7.9,
        timestamp: randomTimestampWithinLast24Hours(),
        satellite: 39,
        sensor: "Radiation",
        unit: "Gy"
    },
    {
        value: 36.7,
        timestamp: randomTimestampWithinLast24Hours(),
        satellite: 1,
        sensor: "Temperature",
        unit: "°C"
    },
    {
        value: 19.1,
        timestamp: randomTimestampWithinLast24Hours(),
        satellite: 2,
        sensor: "Temperature",
        unit: "°C"
    },
    {
        value: 411.8,
        timestamp: randomTimestampWithinLast24Hours(),
        satellite: 3,
        sensor: "CO2",
        unit: "ppm"
    },
    {
        value: 20.9,
        timestamp: randomTimestampWithinLast24Hours(),
        satellite: 23,
        sensor: "Temperature",
        unit: "°C"
    },
    {
        value: 22.7,
        timestamp: randomTimestampWithinLast24Hours(),
        satellite: 24,
        sensor: "Temperature",
        unit: "°C"
    },
    {
        value: 408.4,
        timestamp: randomTimestampWithinLast24Hours(),
        satellite: 31,
        sensor: "CO2",
        unit: "ppm"
    },
    {
        value: 408.0,
        timestamp: randomTimestampWithinLast24Hours(),
        satellite: 32,
        sensor: "CO2",
        unit: "ppm"
    },
    {
        value: 7.6,
        timestamp: randomTimestampWithinLast24Hours(),
        satellite: 39,
        sensor: "Radiation",
        unit: "Gy"
    },
    {
        value: 38.2,
        timestamp: randomTimestampWithinLast24Hours(),
        satellite: 1,
        sensor: "Temperature",
        unit: "°C"
    },
    {
        value: 19.6,
        timestamp: randomTimestampWithinLast24Hours(),
        satellite: 2,
        sensor: "Temperature",
        unit: "°C"
    },
    {
        value: 412.4,
        timestamp: randomTimestampWithinLast24Hours(),
        satellite: 3,
        sensor: "CO2",
        unit: "ppm"
    },
    {
        value: 21.2,
        timestamp: randomTimestampWithinLast24Hours(),
        satellite: 23,
        sensor: "Temperature",
        unit: "°C"
    },
    {
        value: 22.0,
        timestamp: randomTimestampWithinLast24Hours(),
        satellite: 24,
        sensor: "Temperature",
        unit: "°C"
    },
    {
        value: 407.5,
        timestamp: randomTimestampWithinLast24Hours(),
        satellite: 31,
        sensor: "CO2",
        unit: "ppm"
    },
    {
        value: 407.2,
        timestamp: randomTimestampWithinLast24Hours(),
        satellite: 32,
        sensor: "CO2",
        unit: "ppm"
    },
    {
        value: 7.4,
        timestamp: randomTimestampWithinLast24Hours(),
        satellite: 39,
        sensor: "Radiation",
        unit: "Gy"
    }
];


const logs: Log[] = [
    {
        type: "info",
        timestamp: randomTimestampWithinLast24Hours(),
        source: 1,
        message: "Update completed"
    },
    {
        type: "warning",
        timestamp: randomTimestampWithinLast24Hours(),
        source: 2,
        message: "Did not report for 4 hours"
    },
    {
        type: "error",
        timestamp: randomTimestampWithinLast24Hours(),
        source: 3,
        message: "An error occurred at 12:00"
    },
    {
        type: "success",
        timestamp: randomTimestampWithinLast24Hours(),
        source: 1,
        message: "Connection restored successfully"
    },
    {
        type: "status",
        timestamp: randomTimestampWithinLast24Hours(),
        source: 23,
        message: "System operating normally"
    },
    {
        type: "info",
        timestamp: randomTimestampWithinLast24Hours(),
        source: 24,
        message: "Update completed"
    },
    {
        type: "error",
        timestamp: randomTimestampWithinLast24Hours(),
        source: 31,
        message: "Update failed"
    },
    {
        type: "warning",
        timestamp: randomTimestampWithinLast24Hours(),
        source: 32,
        message: "Connection stopped abruptly"
    },
    {
        type: "info",
        timestamp: randomTimestampWithinLast24Hours(),
        source: 39,
        message: "Update completed"
    },
    {
        type: "error",
        timestamp: randomTimestampWithinLast24Hours(),
        source: 3,
        message: "Did not report for 6 hours"
    },
    {
        type: "status",
        timestamp: randomTimestampWithinLast24Hours(),
        source: 1,
        message: "System operating normally"
    },
    {
        type: "info",
        timestamp: randomTimestampWithinLast24Hours(),
        source: 23,
        message: "Connection restored successfully"
    },
    {
        type: "success",
        timestamp: randomTimestampWithinLast24Hours(),
        source: 2,
        message: "Update completed"
    },
    {
        type: "warning",
        timestamp: randomTimestampWithinLast24Hours(),
        source: 3,
        message: "Connection stopped abruptly"
    }
]


const Data = {
    areas,
    satellites,
    dataPoints,
    logs
}


export default Data