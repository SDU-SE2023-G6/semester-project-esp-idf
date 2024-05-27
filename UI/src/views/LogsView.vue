<script setup lang="ts">
import { ref } from 'vue';
import LogItem from '@/components/LogItem.vue';
import StatusCircle from '@/components/general/StatusCircle.vue';
import { useDataStore } from '@/stores/dataStore';
import type { Log, SimplifiedLogType } from '@/types/Log';
import { simplifyLogType } from '@/types/Log';

const dataStore = useDataStore();
const logs = ref<Log[]>([]);

const logTypes: SimplifiedLogType[] = ["Heartbeat", "Debug", "Info", "Warning", "Error", "Success", "Update"]

const selectedLogTypes = ref([...logTypes]);

async function fetchLogs() {
  const newLogsValueRaw = await dataStore.getLogs();
  let newLogsValue = newLogsValueRaw
    .filter(log => selectedLogTypes.value.includes(simplifyLogType(log.type)))
    .sort((a, b) => Number(b.timestamp) - Number(a.timestamp))
    .slice(0, 50);
  if(logs.value) {
    if (JSON.stringify(logs.value) !== JSON.stringify(newLogsValue)) {
      logs.value = newLogsValue;
    }
  } else {
    logs.value = newLogsValue;
  }
}
fetchLogs();
setInterval(() => fetchLogs(), 1000);

const toggleType = (type: SimplifiedLogType) => {
  if (selectedLogTypes.value.includes(type)) {
    selectedLogTypes.value = selectedLogTypes.value.filter(logType => logType !== type);
  } else {
    selectedLogTypes.value.push(type);
  }
  fetchLogs();
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
        <StatusCircle :type_log="logType" /> 
        <span>{{ logType }}</span>
      </div>
    </div>
    <LogItem v-for="log in logs" :log="log" :key="log.id" />
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