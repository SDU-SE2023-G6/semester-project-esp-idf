<template>
    <div class="log-container" @click="isDialogShown = true">
      <div class="log-header">
        <div class="log-left">
            <StatusCircle :type="log.type" />
            <div class="timestamp">{{ timeStampToDate(log.timestamp) }}</div>
            <div class="name">{{ getSourceName(log.source) }}</div>
        </div>
        <div class="class">{{ getClass(log.source) }}</div>
      </div>
      <div class="message">{{ log.message }}</div>
    </div>

    <ADialog
      v-model="isDialogShown"
      :title="getSourceName(log.source)"
      :subtitle="timeStampToDate(log.timestamp)"
    >
    <div class="dialog-content">
      <StatusCircle :type="log.type" />
      <p>{{ log.message }}</p>
    </div>
   

    <FontAwesomeIcon :icon="faXmark" @click="isDialogShown = false" class="closeBtn"/>
    </ADialog>
  </template>
  
  <script setup lang="ts">
    import type { Log, LogSource } from '@/types/Log';
    import {useDataStore} from '@/stores/dataStore';
    import { useTime } from '@/composables/useTime';
    import { ref } from 'vue';
    import { FontAwesomeIcon } from '@fortawesome/vue-fontawesome'
    import { faXmark } from '@fortawesome/free-solid-svg-icons'
    import StatusCircle from './general/StatusCircle.vue';

    const dataStore = useDataStore();

    interface Props {
        log: Log;
    }
    
    const props = defineProps<Props>();

    const { timeStampToDate } = useTime()
    
    const isDialogShown = ref(false)



    function getSourceName(source: LogSource): string {
        if(source === 'system') return 'System';
        return dataStore.getSatellite(source)?.name || 'Unknown';
    }

    function getClass(source: LogSource): string {
        if(source === 'system') return 'System';
        return dataStore.getSatellite(source)?.class || 'Unknown';
    }
  </script>
  
  <style scoped>
  .dialog-content {
    align-items: center;
    padding: 0 1em 1em 1em;
    gap: 0.25em;
    display: grid;
    grid-template-columns: 15px 1fr;
  }
  .closeBtn {
    position: absolute;
    top: 1em;
    right: 1em;
    cursor: pointer;
  }
  .log-container {
    display: flex;
    flex-direction: column;
    align-items: flex-start;
    padding: 2px 6px;
    gap: 10px;
    width: 100%;
    background: var(--color-layer);
    border-radius: 10px;
    margin-bottom: 10px;
    cursor: pointer;
  }
  .log-container:hover {
    background: var(--color-layer-hover);
  }
  
  .log-header {
    display: flex;
    flex-direction: row;
    justify-content: space-between;
    align-items: center;
    width: 100%;
  }

  .log-left {
    display: flex;
    flex-direction: row;
    justify-content: flex-start;
    align-items: center;
    width: 100%;
  }
  
  .timestamp {
    font-family: 'Hack Nerd Font Mono', monospace;
    font-size: 10px;
    color: var(--color-text);
    margin-right: 10px;
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
  
  .message {
    font-family: 'JetBrains Mono', monospace;
    font-size: 10px;
    color: var(--color-text);
    opacity: 0.5;
  }
  </style>
  