<script setup lang="ts">
  import BarChart from '@/components/general/BarChart.vue'
import HomeArea from '@/components/HomeArea.vue';
import type { Satellite } from '@/types/Satellite';
import { useDataStore } from '@/stores/dataStore';
import type { Area } from '@/types/Area';

const dataStore = useDataStore();

const areas: Area[] = dataStore.getAreas;

</script>

<template>
  <div>
    <h1>Dashboard</h1>
    <div>
      <HomeArea v-for="area in areas" :key="area.id" :area="area" />
    </div>
  </div>
    <BarChart class="chart"/>
</div>
</template>

<style scoped>
  .chart {
    width: 50% !important;
    height: auto  !important;
  }
</style>
