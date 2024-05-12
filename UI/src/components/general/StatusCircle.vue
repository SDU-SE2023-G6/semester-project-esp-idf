<script setup lang="ts">
    import { defineProps } from 'vue'
    import type { LogType } from '@/types/Log'
    import { simplifyLogType } from '@/types/Log'

    interface Props {
        type: LogType;
    }

    const props = defineProps<Props>();
    const simplifiedType = simplifyLogType(props.type).toLowerCase();
</script>

<template>
    <div :class="simplifiedType + ' status'"></div>
</template>

<style scoped>
   .status {
    width: 10px;
    height: 10px;
    border-radius: 50%;
    background-color: var(--color-unknown);
    margin-right: 5px;
  }
  
  .status.info, .status.pending {
    background-color: var(--color-pending);
  }
  
  .status.warning {
    background-color: var(--color-warning);
  }
  
  .status.error {
    background-color: var(--color-disabled);
  }
  
  .status.success, .status.online {
    background-color: var(--color-enabled);
  }

  .status.offline {
    background-color: var(--color-unknown);
  }

  .wrapper {
    width: 100%;
    height: 100%;
}
</style>
