import type { Area } from "@/types/Area";
import type { DataPoint } from "@/types/DataPoint";
import type { Log } from "@/types/Log";
import type { Satellite } from "@/types/Satellite";

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

const satellites : Satellite[] = [
    {
        id: 1,
        name: 'F-HT-00-00',
        area: 1,
        class: 'HT'
    },
    {
        id: 2,
        name: 'F-HT-00-01',
        area: 1,
        class: 'HT'
    },
    {
        id: 3,
        name: 'F-CO2-00-01',
        area: 1,
        class: 'CO2'
    },
    {
        id: 4,
        name: 'F-HT-00-02',
        area: 1,
        class: 'HT'
    },
    {
        id: 5,
        name: 'F-HT-00-03',
        area: 1,
        class: 'HT'
    },
    {
        id: 6,
        name: 'F-HT-01-00',
        area: 1,
        class: 'HT'
    },
    {
        id: 7,
        name: 'F-HT-01-01',
        area: 1,
        class: 'HT'
    },
    {
        id: 8,
        name: 'F-HT-01-02',
        area: 1,
        class: 'HT'
    },
    {
        id: 9,
        name: 'F-HT-01-03',
        area: 1,
        class: 'HT'
    },
    {
        id: 10,
        name: 'F-CO2-01-03',
        area: 1,
        class: 'CO2'
    },
    {
        id: 11,
        name: 'F-HT-02-00',
        area: 1,
        class: 'HT'
    },
    {
        id: 12,
        name: 'F-HT-02-01',
        area: 1,
        class: 'HT'
    },
    {
        id: 13,
        name: 'F-HT-02-02',
        area: 1,
        class: 'HT'
    },
    {
        id: 14,
        name: 'F-HT-02-03',
        area: 1,
        class: 'HT'
    },
    {
        id: 16,
        name: 'F-HT-03-00',
        area: 1,
        class: 'HT'
    },
    {
        id: 17,
        name: 'F-HT-03-01',
        area: 1,
        class: 'HT'
    },
    {
        id: 18,
        name: 'F-HT-03-02',
        area: 1,
        class: 'HT'
    },
    {
        id: 19,
        name: 'F-HT-03-03',
        area: 1,
        class: 'HT'
    },
    {
        id: 20,
        name: 'P-Temp',
        area: 2,
        class: 'T'
    },
    {
        id: 21,
        name: 'P-CO2',
        area: 2,
        class: 'CO2'
    },
    {
        id: 22,
        name: 'P-Rad',
        area: 2,
        class: 'Rad'
    },
    {
        id: 23,
        name: 'C-Temp-00',
        area: 3,
        class: 'T'
    },
    {
        id: 24,
        name: 'C-Temp-01',
        area: 3,
        class: 'T'
    },
    {
        id: 25,
        name: 'C-Temp-02',
        area: 3,
        class: 'T'
    },
    {
        id: 26,
        name: 'C-Temp-03',
        area: 3,
        class: 'T'
    },
    {
        id: 27,
        name: 'C-Temp-04',
        area: 3,
        class: 'T'
    },
    {
        id: 28,
        name: 'C-Temp-05',
        area: 3,
        class: 'T'
    },
    {
        id: 29,
        name: 'C-Temp-06',
        area: 3,
        class: 'T'
    },
    {
        id: 30,
        name: 'C-Temp-07',
        area: 3,
        class: 'T'
    },
    {
        id: 31,
        name: 'C-CO2-00',
        area: 3,
        class: 'CO2'
    },
    {
        id: 32,
        name: 'C-CO2-01',
        area: 3,
        class: 'CO2'
    },
    {
        id: 33,
        name: 'C-CO2-02',
        area: 3,
        class: 'CO2'
    },
    {
        id: 34,
        name: 'C-CO2-03',
        area: 3,
        class: 'CO2'
    },
    {
        id: 35,
        name: 'C-CO2-04',
        area: 3,
        class: 'CO2'
    },
    {
        id: 39,
        name: 'C-Rad-00',
        area: 3,
        class: 'Rad'
    },
    {
        id: 40,
        name: 'C-Rad-01',
        area: 3,
        class: 'Rad'
    },
    {
        id: 41,
        name: 'C-Rad-02',
        area: 3,
        class: 'Rad'
    }
];

const dataPoints : DataPoint[] = [
    {
        value: 35.2,
        timestamp: "1683091200",
        satellite: 1
    },
    {
        value: 36.1,
        timestamp: "1683094800",
        satellite: 1
    },
    {
        value: 19.4,
        timestamp: "1683091200",
        satellite: 2
    },
    {
        value: 18.9,
        timestamp: "1683094800",
        satellite: 2
    },
    {
        value: 408.5,
        timestamp: "1683091200",
        satellite: 3
    },
    {
        value: 410.0,
        timestamp: "1683094800",
        satellite: 3
    },
    {
        value: 22.8,
        timestamp: "1683091200",
        satellite: 23
    },
    {
        value: 23.2,
        timestamp: "1683094800",
        satellite: 23
    },
    {
        value: 21.1,
        timestamp: "1683091200",
        satellite: 24
    },
    {
        value: 21.3,
        timestamp: "1683094800",
        satellite: 24
    },
    {
        value: 405.0,
        timestamp: "1683091200",
        satellite: 31
    },
    {
        value: 406.5,
        timestamp: "1683094800",
        satellite: 31
    },
    {
        value: 405.7,
        timestamp: "1683091200",
        satellite: 32
    },
    {
        value: 407.1,
        timestamp: "1683094800",
        satellite: 32
    },
    {
        value: 7.8,
        timestamp: "1683091200",
        satellite: 39
    },
    {
        value: 7.9,
        timestamp: "1683094800",
        satellite: 39
    },
    {
        value: 36.7,
        timestamp: "1683098400",
        satellite: 1
    },
    {
        value: 19.1,
        timestamp: "1683098400",
        satellite: 2
    },
    {
        value: 411.8,
        timestamp: "1683098400",
        satellite: 3
    },
    {
        value: 20.9,
        timestamp: "1683098400",
        satellite: 23
    },
    {
        value: 22.7,
        timestamp: "1683098400",
        satellite: 24
    },
    {
        value: 408.4,
        timestamp: "1683098400",
        satellite: 31
    },
    {
        value: 408.0,
        timestamp: "1683098400",
        satellite: 32
    },
    {
        value: 7.6,
        timestamp: "1683098400",
        satellite: 39
    },
    {
        value: 38.2,
        timestamp: "1683102000",
        satellite: 1
    },
    {
        value: 19.6,
        timestamp: "1683102000",
        satellite: 2
    },
    {
        value: 412.4,
        timestamp: "1683102000",
        satellite: 3
    },
    {
        value: 21.2,
        timestamp: "1683102000",
        satellite: 23
    },
    {
        value: 22.0,
        timestamp: "1683102000",
        satellite: 24
    },
    {
        value: 407.5,
        timestamp: "1683102000",
        satellite: 31
    },
    {
        value: 407.2,
        timestamp: "1683102000",
        satellite: 32
    },
    {
        value: 7.4,
        timestamp: "1683102000",
        satellite: 39
    }
]

const logs: Log[] = [
    {
        type: "info",
        timestamp: "1683091200",
        satellite: 1,
        message: "Update completed"
    },
    {
        type: "warning",
        timestamp: "1683094800",
        satellite: 2,
        message: "Did not report for 4 hours"
    },
    {
        type: "error",
        timestamp: "1683098400",
        satellite: 3,
        message: "An error occurred at 12:00"
    },
    {
        type: "success",
        timestamp: "1683102000",
        satellite: 1,
        message: "Connection restored successfully"
    },
    {
        type: "status",
        timestamp: "1683105600",
        satellite: 23,
        message: "System operating normally"
    },
    {
        type: "info",
        timestamp: "1683109200",
        satellite: 24,
        message: "Update completed"
    },
    {
        type: "error",
        timestamp: "1683112800",
        satellite: 31,
        message: "Update failed"
    },
    {
        type: "warning",
        timestamp: "1683116400",
        satellite: 32,
        message: "Connection stopped abruptly"
    },
    {
        type: "info",
        timestamp: "1683120000",
        satellite: 39,
        message: "Update completed"
    },
    {
        type: "error",
        timestamp: "1683123600",
        satellite: 3,
        message: "Did not report for 6 hours"
    },
    {
        type: "status",
        timestamp: "1683127200",
        satellite: 1,
        message: "System operating normally"
    },
    {
        type: "info",
        timestamp: "1683130800",
        satellite: 23,
        message: "Connection restored successfully"
    },
    {
        type: "success",
        timestamp: "1683134400",
        satellite: 2,
        message: "Update completed"
    },
    {
        type: "warning",
        timestamp: "1683138000",
        satellite: 3,
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