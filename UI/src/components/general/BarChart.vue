<script setup lang="ts">
  import { Bar } from 'vue-chartjs'
  import { computed } from 'vue'
  import { ArcElement, Chart as ChartJS, Legend, Tooltip, LinearScale, CategoryScale, BarElement } from 'chart.js'
  import type { ChartOptions, ChartData } from 'chart.js'

  ChartJS.register(ArcElement, Tooltip, Legend, LinearScale, CategoryScale, BarElement)

  const chartData = computed<ChartData<'bar'>>(() => {
    return {
      labels: slidingWindow.value,
      datasets: [{
        data: [40, 20, 12, 40, 20, 12, 40, 20, 12, 40, 20, 12, 40, 20, 12, 40, 20, 12, 40, 20, 12, 40, 20, 12], 
        backgroundColor: "#007AFF",
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


const currentHour = new Date().getHours();

const slidingWindow = computed(() => {
    const items = Array.from({ length: 24 }, (_, index) => (index + currentHour) % 24 + ":00");
    return items;
});
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
    border: 1px solid #333;
    padding: 1em;
    border-radius: 10px;
  }
</style>