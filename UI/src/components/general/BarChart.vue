<script setup lang="ts">
  import { Bar } from 'vue-chartjs'
  import { computed } from 'vue'
  import { ArcElement, Chart as ChartJS, Legend, Tooltip, LinearScale, CategoryScale, BarElement } from 'chart.js'
  import type { ChartOptions, ChartData } from 'chart.js'

  ChartJS.register(ArcElement, Tooltip, Legend, LinearScale, CategoryScale, BarElement)

  const props = defineProps<{
    labels: string[];
    data: number[];
    color: string;
  }>()

  const chartData = computed<ChartData<'bar'>>(() => {
    return {
      labels: props.labels,
      datasets: [{
        data: props.data, 
        backgroundColor: props.color,
      }],
    }
  })

  const chartOptions: ChartOptions<'bar'> = {
  plugins: {
    legend: {
      display: false,
      labels: {
        color: '#FFFFFF' // Color for the legend labels
      }
    },
  },
  scales: {
    x: {
      grid: {
        display: false,
      },
      ticks: {
        color: '#FFFFFF' // Color for the x-axis labels
      }
    },
    y: {
      grid: {
        color: '#444444' // Color for the horizontal grid lines
      },
      ticks: {
        color: '#FFFFFF' // Color for the y-axis labels
      }
    }
  },
  backgroundColor: '#222222' // Background color for the chart area
}
</script>

<template>
    <div class="wrapper">
        <Bar
            :options="chartOptions"
            :data="chartData"
        />
    </div>
</template>

<style scoped>

.wrapper {
    width: 100%;
    height: 100%;
}
</style>