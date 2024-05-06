<script setup lang="ts">
import { ref } from 'vue'
import { useDataStore } from '@/stores/dataStore';
import DataTable from 'primevue/datatable';
import Column from 'primevue/column';
import { RouterLink } from 'vue-router';
import { FontAwesomeIcon } from '@fortawesome/vue-fontawesome'
import { faTrash, faPencil, faEdit } from '@fortawesome/free-solid-svg-icons'
import type { Area } from '@/types/Area';

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

const removeArea = (area: Area) => {
  if(!confirm("are you sure you want to delete this area?")) return
  dataStore.removeArea(area)
}

const editArea = (area: Area) => {
  helpArea.name = area.name;
  helpArea.id = Number(area.id);
  isEditMode.value = true;
  isDialogShown.value = true;
}

</script>

<template>
  <div>
    <h1>Areas</h1>

    <ABtn class="button" @click="isDialogShown = true">
      Add Area
    </ABtn>

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

    <DataTable :value="areas">
      <Column field="name" header="Name"></Column>
      <Column header="Actions">
        <template #body="{ data }">
          <RouterLink :to="`/areas/${data.id}`">
            <FontAwesomeIcon :icon="faEdit" />
          </RouterLink>
          <FontAwesomeIcon :icon="faTrash" @click="removeArea(data)"/> 
          <FontAwesomeIcon :icon="faPencil" @click="editArea(data)"/>
        </template>
      </Column>
    </DataTable>
  </div>
</template>

<style scoped>
  .a-card-body {
    display: flex;
    flex-direction: column;
    gap: 1em;

  }
  .buttons {
    display: flex;
    gap: 0.5em;
  }
</style>
