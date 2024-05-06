<script setup lang="ts">
  import { FontAwesomeIcon } from '@fortawesome/vue-fontawesome'
  import { faChevronLeft  } from '@fortawesome/free-solid-svg-icons'
  import { useRouter } from 'vue-router';

  const router = useRouter();

  const goBack = () => {
    router.back();
  }

</script>

<template>
    <div class="backButton" @click="goBack"> <FontAwesomeIcon :icon="faChevronLeft" /> <span>Back</span></div>
</template>

<style scoped>
    .backButton {
        color: var(--vt-c-blue);
        cursor: pointer;
    }
    .backButton:hover {
        color: var(--vt-c-blue-hover);
    }
</style>