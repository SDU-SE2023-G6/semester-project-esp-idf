<script setup lang="ts">
import { RouterView } from 'vue-router'
import GlobalNavigation from './components/GlobalNavigation.vue'
</script>

<template>
  <header>
    <GlobalNavigation />
  </header>
  <main>
    <RouterView />
  </main>

 
</template>

<style scoped>
</style>
