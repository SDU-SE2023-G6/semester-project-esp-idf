<script setup lang="ts">
  import BarChart from '@/components/general/BarChart.vue'
  import HomeArea from '@/components/HomeArea.vue';
  import { useDataStore } from '@/stores/dataStore';
  import type { Area } from '@/types/Area';
  import type { Log } from '@/types/Log';
  import LogItem from '@/components/LogItem.vue';
  import { useTime } from '@/composables/useTime';
  import {ref} from 'vue';
  const { slidingWindow } = useTime()


  const dataStore = useDataStore();

  const areas = ref<Area[]>([]);
  const logs = ref<Log[]>([]);
  const someLogs = ref<Log[]>([]);

  async function fetchAreasAndLogs() {
    areas.value = await dataStore.getAreas();
    const logsOldValue = logs.value;
    const logsNewValue = (await dataStore.getLogs())
      .sort((a, b) => Number(b.timestamp) - Number(a.timestamp))
      .slice(0, 10);
    // Check if the logs have changed
    
    if(!logsOldValue){
      logs.value = logsNewValue;
      return;
    }
    if (JSON.stringify(logsOldValue) !== JSON.stringify(logsNewValue)) {
      logs.value = logsNewValue;
    }

  }

  fetchAreasAndLogs();
  setInterval(() => fetchAreasAndLogs(), 1000);

  const groupedLogs = ref();
  async function fetchLogs() {
    someLogs.value = await dataStore.getLogs();
    groupedLogs.value = slidingWindow.value.map((hour: string) => someLogs.value.filter((log: Log) => log.timestamp.getHours() === parseInt(hour)).length);
  }

  fetchLogs();
  setInterval(() => fetchLogs(), 5000);


</script>

<template>
  <div class="w-full">
    <h1>Dashboard</h1>
    <div class="flex main-wrapper">
      <div class="w-full area-wrapper">
        <HomeArea v-for="area in areas" :key="area.id" :area="area" :details="false" class="area-container"/>
      </div> 
      <div class="flex column-wrapper w-full">
        <div class="general-wrapper">
          <h2>Incoming data</h2>
          <BarChart :labels="slidingWindow" :data="groupedLogs" color="#fff" class="chart"/>
        </div>
       <div class="general-wrapper">
          <h2>Logs</h2>
          <LogItem v-for="log in logs" :log="log" :key="log.id" />
        </div>
      </div>
    </div>
  </div>

</template>

<style scoped>
  .chart {
    width: 100% !important;
    height: 100%  !important;
  }
  .column-wrapper {
    display: flex;
    flex-direction: column;
    gap: 1em;
    max-width: 500px;
  }
  .general-wrapper {
    background: var(--color-layer);
    padding: 1em;
    border-radius: 10px;
  }
  .general-wrapper h2 {
    margin-bottom: 0.5em;
  }

  .main-wrapper {
    width: 100%;
    gap: 2em;
    display: flex;
    justify-content: left;
    flex-wrap: wrap;
  }
  
  .area-wrapper {
    gap: 1em;
    display: flex;
    flex-wrap: wrap;
    min-width: min-content;
    max-width: max-content;
    width: 45vw;
  }

</style>
