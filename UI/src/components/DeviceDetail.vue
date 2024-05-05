<script setup lang="ts">
  import { ref } from 'vue';
  import { useRoute } from 'vue-router';
  import { FontAwesomeIcon } from '@fortawesome/vue-fontawesome'
  import { faChevronLeft  } from '@fortawesome/free-solid-svg-icons'
  import type { Device } from '@/types/Device'
  import LoadingSpinner from '@/components/LoadingSpinner.vue';
  //import { InstallButton } from "esp-web-tools";



  const loadDevice = async () => {
    //todo: delte once API is ready
    try {
      const foundDevice = devices.value.find(device => device.id == id);
      if(foundDevice) device = foundDevice;    
    } catch (error) {
      console.error(error);
    }
    
    //todo: ready for api call
    /*try {
      const response = await fetch(`https://localhost/api/devices/${id}`);
      device = await response.json();
    } catch (error) {
      console.error(error);
    }*/
  }

  const handleForm = async () => {
    const goal = id === 'new' ? 'create' : 'update';

    try {
      const requestOptions = {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(device)
      };
      const response = await fetch(`https://localhost/api/devices/${goal}`, requestOptions);
      console.log(await response.json());
    } catch (error) {
      console.error(error);
    }
  }



  //todo: delete once API is ready
  const devices = ref<Device[]>([
    { id: 1, name: 'Device 1', description: 'This is device 1' },
    { id: 2, name: 'Device 2', description: 'This is device 2' },
  ]);

  const route = useRoute();
  const id = route.params.id;

  let device: Device = {
    id: '',
    name: '',
    description: ''
  };
  

  loadDevice();
</script>

<template>
  <div>

    <RouterLink to="/devices"> <FontAwesomeIcon :icon="faChevronLeft" /> <span>Back</span></RouterLink>

    <h1>Device Detail</h1>
    <div v-if="id=='new' || device.id != ''">
      <form>
        <label for="name">Name:</label>
        <input type="text" id="name" v-model="device.name" />

        <label for="description">Description:</label>
        <input type="text" id="description" v-model="device.description" />
      </form>

      <button @click="handleForm">{{ id == 'new' ? 'create' : 'update' }}</button>
    </div>

    <!--
    <InstallButton
      manifest="https://firmware.esphome.io/esp-web-tools/manifest.json"
    >
      <button slot="activate">Custom install button</button>
      <span slot="unsupported">Ah snap, your browser doesn't work!</span>
      <span slot="not-allowed">Ah snap, you are not allowed to use this on HTTP!</span>
  </InstallButton>-->
    
    <LoadingSpinner v-if="id != 'new' && device.id == ''"/>

  </div>
</template>

<style scoped>
 
</style>
