<script setup lang="ts">
import { ref } from 'vue'
import { useDataStore } from '@/stores/dataStore';
import HomeArea from './HomeArea.vue';

const dataStore = useDataStore();
const areas = dataStore.areas;

const isDialogShown = ref(false)

let helpArea = {
  name: "",
  id: 0
}

const isEditMode = ref(false)

const handleModal = (area = JSON.parse(JSON.stringify(helpArea))) => {

  console.log("area", area)
  if(area.name === "") {
    return
  }

  if(!isEditMode.value) {
    dataStore.addArea({
      name: area.name,
      id: 69
    })
  } else {
    dataStore.editArea(area) 
  }

  isDialogShown.value = false;
  helpArea.name = "";
  isEditMode.value = false;

}

</script>

<template>
  <div>
    <h1>Areas</h1>

    <ABtn class="button" @click="isDialogShown = true">
      Add Area
    </ABtn>

    <div class="flex area-wrapper">
      <HomeArea v-for="area in areas" :key="area.id" :area="area" :details="true"/>
    </div>


    <ADialog
      v-model="isDialogShown"
      :title="isEditMode ? 'Edit Area' : 'Add New Area'"
    >
      <div class="a-card-body">
        <AInput
          type="text"
          label="Area name"
          placeholder="Enter area name"
          v-model="helpArea.name"
          required
        />

        <div class="buttons">
          <ABtn
            color="success"
            @click="handleModal()"
          >
            Confirm
          </ABtn>
          <ABtn
            variant="light"
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
  .area-wrapper {
    gap: 1em;
    flex-direction: column;
  }
</style>
