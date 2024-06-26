<script setup lang="ts">
import BarChart from '../components/general/BarChart.vue'
import PieChart from '@/components/general/PieChart.vue';
import { SimplifiedLogType, simplifyLogType } from '@/types/Log';
import { useDataStore } from '@/stores/dataStore';
import { ref } from 'vue';
import { useTime } from '@/composables/useTime';
import type { Log } from '@/types/Log';
import type { DataPoint } from '@/types/DataPoint';
import type {Satellite} from '@/types/Satellite';
import { useInterval } from '@/composables/useInterval';
const { setSafeInterval } = useInterval();

const { slidingWindow } = useTime() 


const logTypes: SimplifiedLogType[] = [SimplifiedLogType.Heartbeat, SimplifiedLogType.Debug, SimplifiedLogType.Info, SimplifiedLogType.Warning, SimplifiedLogType.Error, SimplifiedLogType.Success, SimplifiedLogType.Update];

const dataStore = useDataStore();
//const logs = ref(dataStore.getLogs);
 

let logs = ref<Log[]>([]);
const logData = ref();
const groupedLogs = ref();
const data = ref<{dt:DataPoint,src:Satellite}[]>([]);

const requestingLogs = ref(false);
const requestingData = ref(false);

async function fetchLogs() {
  if(requestingLogs.value) return;
  requestingLogs.value = true;
  logs.value = await dataStore.getLogs();
  logData.value = logTypes.map(type => logs.value.filter(log => simplifyLogType(log.type) === type).length);
  groupedLogs.value = slidingWindow.value.map((hour: string) => logs.value.filter((log: Log) => log.timestamp.getHours() === parseInt(hour)).length);
  requestingLogs.value = false;
}

async function fetchData() {
  if(requestingData.value) return;
  requestingData.value = true;
  let dataPoints = (await dataStore.getDataPoints()).slice(0, 20);
  let newData = [];
  for(let i = 0; i < dataPoints.length; i++){
    let satellite = await dataStore.getSatelliteById(dataPoints[i].satellite);
    newData.push({dt: dataPoints[i], src: satellite});
  }
  if(data.value.length == 0){
    data.value = newData;
  } else if(JSON.stringify(data.value) !== JSON.stringify(newData)){
    data.value = newData;
  }
  requestingData.value = false;
}


fetchLogs();
fetchData();


setSafeInterval(() => fetchLogs(), 3500);
setSafeInterval(() => fetchData(), 3500);


const cols: ATableProps['cols'] = [
  {name: 'Source', formatter: row => `${row.src.name}/${row.dt.sensor}`},
  { name: 'value', formatter: row => `${row.dt.value} ${row.dt.unit}` },
  {name: 'timestamp', formatter: row => `${row.dt.timestamp.toLocaleString()}`},
]


const logColors = ref([
  getComputedStyle(document.documentElement)
    .getPropertyValue('--color-unknown'),
  getComputedStyle(document.documentElement)
    .getPropertyValue('--color-unknown'),
  getComputedStyle(document.documentElement)
    .getPropertyValue('--color-pending'),
  getComputedStyle(document.documentElement)
    .getPropertyValue('--color-warning'),
  getComputedStyle(document.documentElement)
    .getPropertyValue('--color-disabled'),
  getComputedStyle(document.documentElement)
    .getPropertyValue('--color-enabled'),
  getComputedStyle(document.documentElement)
    .getPropertyValue('--color-updating'),
]);
</script>


<template>
  <div>
    <h1>Data Monitoring</h1>
    <div class="w-full charts-wrapper">

      <div class="flex-col">
        <div class="tile">
          <h3>Number of logs past 24h</h3>
          <BarChart :labels="slidingWindow" :data="groupedLogs" color="#fff"/>
        </div>
          <div class="tile">
            <h3>Logs past 24h</h3>
            <PieChart :labels="logTypes" :data="logData" :colors="logColors" />
          </div>
        </div>
        <div class="tile">
          <ATable
          :rows="data"
          :cols="cols"
        />
      </div>
    </div>
  </div>
</template>

<style scoped>
  .charts-wrapper {
    display: flex;
    gap: 1em;
    flex-wrap: wrap;
  }
  .tile {
    border: 1px solid #333;
    padding: 1em;
    border-radius: 10px;
    min-width: 30vw;
  }
  .flex-col {
    display: flex;
    flex-direction: column;
    gap: 1em;
  }
</style>
