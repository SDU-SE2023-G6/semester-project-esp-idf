<script setup lang="ts">
  import { Pie } from 'vue-chartjs'
  import { computed } from 'vue'
  import { ArcElement, Chart as ChartJS, Legend, Tooltip, LinearScale, CategoryScale, BarElement } from 'chart.js'
  import type { ChartOptions, ChartData } from 'chart.js'

  const props = defineProps<{
    labels: string[];
    data: number[];
    colors: string[];
  }>()

  ChartJS.register(ArcElement, Tooltip, Legend, LinearScale, CategoryScale, BarElement)

  const chartData = computed<ChartData<'pie'>>(() => {
    return {
      labels: props.labels,
      datasets: [{
        data: props.data, 
        backgroundColor: props.colors,
        borderColor: 'transparent', 
      }],
    }
  })

  const chartOptions: ChartOptions<'pie'> = {
    plugins: {
      legend: {
        display: true,
        labels: {
          color: '#FFFFFF' 
        }
      },
    },
  }

</script>

<template>
    <div>
        <Pie
            :options="chartOptions"
            :data="chartData"
        />
    </div>
</template>

<style scoped>
 
</style>