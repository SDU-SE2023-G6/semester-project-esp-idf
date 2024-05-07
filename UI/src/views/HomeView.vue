<script setup lang="ts">
  import BarChart from '@/components/general/BarChart.vue'
  import HomeArea from '@/components/HomeArea.vue';
  import type { Satellite } from '@/types/Satellite';
  import { useDataStore } from '@/stores/dataStore';
  import type { Area } from '@/types/Area';
  import LogItem from '@/components/LogItem.vue';
  import { useTime } from '@/composables/useTime';
  

  const dataStore = useDataStore();

  const areas: Area[] = dataStore.getAreas;
  const logs = dataStore.getLogs;

  // Sort logs by timestamp and only show the last 5
  const sortedLogs = [...logs].sort((a, b) => Number(b.timestamp) - Number(a.timestamp));
  const selectedLogs = sortedLogs.slice(0, 5);

</script>

<template>
  <div class="w-full">
    <h1>Dashboard</h1>
    <div class="flex main-wrapper">
      <div class="w-full area-wrapper">
        <HomeArea v-for="area in areas" :key="area.id" :area="area" :details="false"/>
      </div> 
      <div class="flex column-wrapper w-full">
        <BarChart class="chart"/>
       <div>
        <LogItem v-for="log in selectedLogs" :log="log" :key="log.timestamp" />
      </div>
      </div>
    </div>
  </div>

</template>

<style scoped>
  .chart {
    width: 100% !important;
    height: auto  !important;
  }
  .column-wrapper {
    display: flex;
    flex-direction: column;
    gap: 1em;
  }
  .main-wrapper {
    width: 100%;
    gap: 2em;
  }
  .w-full {
    width: 100%;
  }
  .area-wrapper {
    gap: 1em;
    display: grid;
    grid-template-columns: 1fr 1fr;
  }

</style>
