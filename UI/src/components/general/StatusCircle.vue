<script setup lang="ts">
    import { defineProps } from 'vue'
    import type { LogType } from '@/types/Log'

    interface Props {
        type: LogType;
    }

    const props = defineProps<Props>();
    
</script>

<template>
    <div :class="props.type + ' status'"></div>
</template>

<style scoped>
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
</style>
