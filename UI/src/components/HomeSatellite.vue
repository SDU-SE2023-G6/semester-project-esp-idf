<template>
  <div class="satellite-container" v-if="isSatelliteInitialized"> 
    <div class="stat-name">
      <div :class="status + ' status'"><ATooltip :text="statusText" /></div>
      <div class="name">{{ props.satellite.name }}</div>
    </div>
    <div class="class">{{ props.satellite.type?.name }}</div>
  </div>
</template>

<script setup lang="ts">
import type { Satellite } from '@/types/Satellite';
import { computed, ref } from 'vue';
import { useInterval } from '@/composables/useInterval';
const { setSafeInterval } = useInterval();


interface Props {
  satellite: Satellite;
}


const props = defineProps<Props>();
const isSatelliteInitialized = computed(() => props.satellite.status !== 'PENDING_METADATA');

const simplifiedStatusMap = {
  "ONLINE": 'online',
  "OFFLINE": 'offline',
  "ERROR": 'error',
  "UPDATING": 'updating',
  "PENDING_METADATA": 'pending',
  "PENDING_VERSION_CHECK": 'pending',
};

const humanReadableStatusMap = {
  "ONLINE": 'Online',
  "OFFLINE": 'Offline',
  "ERROR": 'Error',
  "UPDATING": 'Updating',
  "PENDING_METADATA": 'Pending Metadata',
  "PENDING_VERSION_CHECK": 'Pending Version Check',
};

const statusText = ref(humanReadableStatusMap[props.satellite.status] as keyof typeof humanReadableStatusMap);
const status = ref(simplifiedStatusMap[props.satellite.status] as keyof typeof simplifiedStatusMap);

async function fetchSatelliteStatus() {
  const s  = props.satellite.status;
  status.value = simplifiedStatusMap[s] as keyof typeof simplifiedStatusMap;
  statusText.value = humanReadableStatusMap[s] as keyof typeof humanReadableStatusMap;
}

fetchSatelliteStatus();
setSafeInterval(() => fetchSatelliteStatus(), 1000);
</script>

<style scoped>
.satellite-container {
  display: flex;
  flex-direction: row;
  justify-content: space-between;
  align-items: center;
  padding: 2px 6px;
  gap: 67px;
  width: 100%;
  height: 18px;
  background: var(--color-layer);
  border-radius: 10px;
  margin: 5px 0;
}

.stat-name {
  display: flex;
  flex-direction: row;
  align-items: center;
  gap: 10px;
}

.status {
  width: 10px;
  height: 10px;
  border-radius: 50%;
}

.status.online {
  background-color: var(--color-enabled);
}

.status.offline {
  background-color: var(--color-unknown);
}

.status.error {
  background-color: var(--color-disabled);
}

.status.pending {
  background-color: var(--color-pending);
}

.status.updating {
  background-color: var(--color-updating);
}

.name {
  font-family: 'Hack Nerd Font Mono', monospace;
  font-size: 12px;
  color: var(--color-text);
}

.class {
  font-family: 'Inter', sans-serif;
  font-style: italic;
  font-size: 9px;
  color: var(--color-text);
}
</style>
