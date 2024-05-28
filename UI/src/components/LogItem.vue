<template>
    <div class="log-container" @click="isDialogShown = true">
      <div class="log-header">
        <div class="log-left">
            <StatusCircle :type_log="log.type" />
            <div class="timestamp">{{ timeStampToDate(log.timestamp) }}</div>
            <div class="name">{{ sourceName }}</div>
        </div>
      </div>
      <div class="message">{{ log.message }}</div>
    </div>

    <ADialog
      v-model="isDialogShown"
      :title="sourceName"
      :subtitle="timeStampToDate(log.timestamp)"
    >
    <div class="dialog-content">
      <StatusCircle :type_log="log.type" />
      <p>{{ log.message }}</p>
    </div>
   

    <FontAwesomeIcon :icon="faXmark" @click="isDialogShown = false" class="closeBtn"/>
    </ADialog>
  </template>
  
<script setup lang="ts">
    import type { Log } from '@/types/Log';
    import { ref } from 'vue';
    import { FontAwesomeIcon } from '@fortawesome/vue-fontawesome'
    import { faXmark } from '@fortawesome/free-solid-svg-icons'
    import StatusCircle from './general/StatusCircle.vue';

    interface Props {
        log: Log;
    }
    
    const props = defineProps<Props>();

    function timeStampToDate(timestamp: Date): string {
        return `${timestamp.toLocaleDateString()} ${timestamp.toLocaleTimeString()}`;
    }
    
    const isDialogShown = ref(false)

    let sourceName = ref(props.log.source);
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
  