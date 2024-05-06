<script setup lang="ts">
  import BarChart from '@/components/general/BarChart.vue'
</script>

<template>
  <div>
    <h1>Dashboard</h1>
    <BarChart class="chart"/>
</div>
</template>

<style scoped>
  .chart {
    width: 50% !important;
    height: auto  !important;
  }
</style>
