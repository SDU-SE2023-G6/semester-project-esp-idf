<script setup lang="ts">
  import { ref } from 'vue';

  const items = ref([
    { id: 1, name: 'Item 1', description: 'This is item 1' },
    { id: 2, name: 'Item 2', description: 'This is item 2' },
    // Add more items as needed
  ]);

</script>

<template>
  <div>
    <h1>Devices</h1>
    <router-link :to="`/devices/new`">New Device</router-link>
    <ul>
      <li v-for="item in items" :key="item.id">
        <router-link :to="`/devices/${item.id}`">{{ item.name }}</router-link>
      </li>
    </ul>
  </div>
</template>

<style scoped>

</style>
