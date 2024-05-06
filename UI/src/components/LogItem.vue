<template>
    <div class="log-container">
      <div class="log-header">
        <div class="log-left">
            <div :class="props.log.type + ' status'"></div>
            <div class="timestamp">{{ timeStampToDate(log.timestamp) }}</div>
            <div class="name">{{ getSourceName(log.source) }}</div>
        </div>
        <div class="class">{{ getClass(log.source) }}</div>
      </div>
      <div class="message">{{ log.message }}</div>
    </div>
  </template>
  
  <script setup lang="ts">
    import type { Log, LogSource } from '@/types/Log';
    import {useDataStore} from '@/stores/dataStore';

    const dataStore = useDataStore();

    interface Props {
        log: Log;
    }
    
    const props = defineProps<Props>();

    function timeStampToDate(timestamp: string): string {
        console.log(timestamp);
        return new Date(parseInt(timestamp) * 1000).toLocaleString();
    }

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
  
  .status {
    width: 10px;
    height: 10px;
    border-radius: 50%;
    background-color: var(--color-unknown);
    margin-right: 5px;
  }
  
  .status.info {
    background-color: var(--color-pending);
  }
  
  .status.warning {
    background-color: var(--color-warning);
  }
  
  .status.error {
    background-color: var(--color-disabled);
  }
  
  .status.success {
    background-color: var(--color-enabled);
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
  