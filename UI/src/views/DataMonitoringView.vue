<script setup lang="ts">
import LineChart from '@/components/general/LineChart.vue';
import BarChart from '../components/general/BarChart.vue'
import PieChart from '@/components/general/PieChart.vue';
import type { LogType } from '@/types/Log';
import { useDataStore } from '@/stores/dataStore';
import { ref, computed } from 'vue';
import { useTime } from '@/composables/useTime';

const { slidingWindow } = useTime() 


const logTypes: LogType[] = ['info', 'warning', 'error', 'success', 'status'];

const dataStore = useDataStore();
const logs = ref(dataStore.getLogs); 
const logData = ref(logTypes.map(type => logs.value.filter(log => log.type === type).length));


const logColors = ref([
  getComputedStyle(document.documentElement)
    .getPropertyValue('--color-pending'),
  getComputedStyle(document.documentElement)
    .getPropertyValue('--color-warning'),
  getComputedStyle(document.documentElement)
    .getPropertyValue('--color-disabled'),
  getComputedStyle(document.documentElement)
    .getPropertyValue('--color-enabled'),
    getComputedStyle(document.documentElement)
    .getPropertyValue('--color-unknown'),
 
  
]);


const dummyLineData = [20, 30, 40, 50, 60, 70, 80, 90, 100, 90, 80, 70, 60, 50, 40, 30, 20, 10, 20, 30, 40, 50, 60, 70];



</script>


<template>
  <div>
    <h1>Data Monitoring</h1>
    <div class="w-full charts-wrapper">
      <div class="tile">
        <h3>Number of logs past 24h</h3>
        <BarChart :labels="slidingWindow" :data="dummyLineData" color="#fff"/>
      </div>
     
      <div class="tile">
        <h3>Temperature in Forest past 24h</h3>
        <LineChart :labels="slidingWindow" :data="dummyLineData" color="#fff"/>
      </div>

     
      <div class="tile">
        <h3>Logs past 24h</h3>
        <PieChart :labels="logTypes" :data="logData" :colors="logColors" />
      </div>
      
    </div> 

   
  </div>
</template>

<style scoped>
  .charts-wrapper {
    display: grid;
    grid-template-columns: 1fr 1fr;
    gap: 1em;
  }
  .tile {
    border: 1px solid #333;
    padding: 1em;
    border-radius: 10px;
  }
</style>
