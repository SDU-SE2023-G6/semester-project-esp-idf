<template>
  <div class="area-container">
    <h2 class="area-name">{{ props.area.name }}</h2>
    <div class="area-satellites">
      <HomeSatellite v-for="satellite in satellites" :key="satellite.id" :satellite="satellite" />
    </div>
  </div>
</template>

<script setup lang="ts">
import type { Area } from '@/types/Area';
import HomeSatellite from '@/components/HomeSatellite.vue';
import {useDataStore} from '@/stores/dataStore';

const dataStore = useDataStore();


interface Props {
  area: Area;
}

const props = defineProps<Props>();

const satellites = dataStore.getSatellitesByArea(props.area.id);
</script>

<style scoped>
.area-container {
  display: flex;
  flex-direction: column;
  gap: 10px;
  padding: 10px;
  background: var(--color-layer);
  border-radius: 10px;
  margin: 10px 0;
}

.area-satellites {
  max-height: 200px;
  overflow-y: scroll;
  padding-right: 10px;
}

::-webkit-scrollbar {
  width: 10px;
  border-radius: 10px;
}

::-webkit-scrollbar-track {
  background: var(--color-layer);
  border-radius: 10px;
}

::-webkit-scrollbar-thumb {
  background: var(--color-layer);
  border-radius: 10px;
}

::-webkit-scrollbar-thumb:hover {
  background: var(--color-layer);
}
</style>
