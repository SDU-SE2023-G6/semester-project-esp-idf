<script setup lang="ts">
import { computed, ref } from 'vue';
import LogItem from '@/components/LogItem.vue';
import StatusCircle from '@/components/general/StatusCircle.vue';
import { useDataStore } from '@/stores/dataStore';
import type { LogType } from '@/types/Log';

const dataStore = useDataStore();
const logs = ref([]); // Use ref for reactivity

const logTypes: LogType[] = ['info', 'warning', 'error', 'success', 'status'];

const selectedLogTypes = ref([...logTypes]); // Maintain the types you want to display

const filteredLogs = computed(() => 
  logs.value
    .filter(log => selectedLogTypes.value.includes(log.type))
    .sort((a, b) => Number(b.timestamp) - Number(a.timestamp))
);

const fetchLogs = async () => logs.value = await dataStore.getLogs();
fetchLogs();
setInterval(() => fetchLogs(), 1000);

const toggleType = (type: LogType) => {
  if (selectedLogTypes.value.includes(type)) {
    selectedLogTypes.value = selectedLogTypes.value.filter(logType => logType !== type);
  } else {
    selectedLogTypes.value.push(type);
  }
};

</script>

<template>
  <div>
    <h1>Logs</h1>
    <div class="flex logs-menu-wrapper">
      <h3>Filter: </h3>
      <div class="flex menu" 
           v-for="logType in logTypes" 
           :key="logType" 
           @click="toggleType(logType)"
           :class="{ selected: !selectedLogTypes.includes(logType) }">
        <StatusCircle :type="logType" /> 
        <span>{{ logType }}</span>
      </div>
    </div>
    <LogItem v-for="log in filteredLogs" :log="log" :key="log.timestamp" />
  </div>
</template>

<style scoped>
.menu {
  align-items: center;
  gap: 0em;
  cursor: pointer;
}
.menu:hover {
  filter: brightness(150%);
}
.logs-menu-wrapper {
  margin-bottom: 1em;
}
.menu.selected {
  text-decoration: line-through;
  color: #999;
}
</style>