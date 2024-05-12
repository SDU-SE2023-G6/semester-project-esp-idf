<script setup lang="ts">
import { ref } from 'vue'
import { useDataStore } from '@/stores/dataStore';
import HomeArea from './HomeArea.vue';
import type {Area} from '@/types/Area';

const dataStore = useDataStore();

let areas: Area[] = ref([]);

async function fetchAreas() {
  areas.value = await dataStore.getAreas();
}

setInterval(() => fetchAreas(), 1000);
fetchAreas();

const isDialogShown = ref(false)

let helpArea = {
  name: "",
  id: 0
}

const isEditMode = ref(false)

const modalError = ref("");
const modalErrorDisplayed = ref(false);

const handleModal = async (area = JSON.parse(JSON.stringify(helpArea))) => {

  if(area.name === "") {
    modalError.value = "Area name cannot be empty"
    modalErrorDisplayed.value = true;
    return
  }

  await dataStore.addArea({
      name: area.name,
      id: ''
  })

  resetModal();
  fetchAreas();
}

const resetModal = () => {
  helpArea.name = "";
  modalError.value = "";
  modalErrorDisplayed.value = false;
  isDialogShown.value = false;
}

</script>

<template>
  <div>
    <h1>Areas</h1>

    <ABtn class="button" @click="isDialogShown = true">
      <i class="i-bx-location-plus" />
      Add Area
    </ABtn>

    <div class="flex area-wrapper">
      <HomeArea v-for="area in areas" :key="area.id" :area="area" :details="true"/>
    </div>


    <ADialog
      v-model="isDialogShown"
      title="Add New Area"
    >
      <div class="a-card-body">
        <AInput
          type="text"
          label="Area name"
          placeholder="Enter an area name"
          v-model="helpArea.name"
          required
        />

        <AAlert
          color="danger"
          variant="light"
          v-model="modalErrorDisplayed"
        >
          {{ modalError }}
        </AAlert>

        <div class="buttons">
          <ABtn
            color="success"
            variant="outline"
            @click="handleModal()"
          >
            Confirm
          </ABtn>
          <ABtn
            variant="outline"
            color="danger"
            @click="isDialogShown = false"
          >
            Close
          </ABtn>
        </div>
        
      </div>
    </ADialog>

  </div>
</template>

<style scoped>
  .button {
   margin-bottom: 1em;

  }
  .buttons {
    display: flex;
    gap: 0.5em;
  }
  .a-card-body {
    display: flex;
    flex-direction: column;
    gap: 1em;
  }
  .area-wrapper {
    gap: 1em;
    display: flex;
    flex-wrap: wrap;
  }
  .area-wrapper > * {
   max-height: 300px;
  }
</style>
