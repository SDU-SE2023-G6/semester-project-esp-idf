<script setup lang="ts">
    import { defineProps } from 'vue'
    import type { LogType } from '@/types/Log'
    import { simplifyLogType } from '@/types/Log'
    import type { SatelliteStatus } from '@/types/Satellite'
    import { ref } from 'vue'
    interface Props {
        type_log?: LogType;
        status_satellite?: SatelliteStatus;
    }

    const props = defineProps<Props>();
    let simplifiedType = ref('...');
    console.log(props)
    if(props.type_log) {
        simplifiedType.value = simplifyLogType(props.type_log).toLowerCase();
    } else if(props.status_satellite) {
        const simplifiedStatusMap = {
            "ONLINE": 'success',
            "OFFLINE": 'offline',
            "ERROR": 'error',
            "UPDATING": 'pending',
            "PENDING_METADATA": 'pending',
            "PENDING_VERSION_CHECK": 'pending',
        };

        simplifiedType.value = simplifiedStatusMap[props.status_satellite] as keyof typeof simplifiedStatusMap;
    }
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
