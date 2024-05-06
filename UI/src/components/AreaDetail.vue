<script setup lang="ts">
  import { ref } from 'vue';
  import Button from "primevue/button"
  import DataTable from "primevue/datatable"
  import Column from "primevue/column"
  import Dropdown from "primevue/dropdown"
  import { useDataStore } from '@/stores/dataStore';
  import { useRoute } from 'vue-router';
  import BackButton from '@/components/general/BackButton.vue';

  import { FontAwesomeIcon } from '@fortawesome/vue-fontawesome'
  import { faPencil, faTrashCan } from '@fortawesome/free-solid-svg-icons'
  import type { Satellite } from '@/types/Satellite';


  const dataStore = useDataStore();
  const route = useRoute();

  const id = route.params.id;
  const area = dataStore.getAreaById(Number(id));
  console.log(area);

  const satellites = dataStore.getSatellitesByArea(Number(id));
  console.log(satellites);

  const columns = ["name", "class"];
  const selectedSatellites = ref([]);
  const selectedClass = ref();
  const classes = ref(dataStore.getClasses);


  const changeClass = () => {
    for(let satellite of selectedSatellites.value) {
      satellite.class = selectedClass.value;
      dataStore.editSatellite(satellite);
    }
  }

  const deleteSatellite = () => {
    console.log("delete satellite")
    satellite.area = undefined;
    dataStore.editSatellite(satellite);
  }

  const isDialogShown = ref(false);

  let helpSatellite = {
    name: "",
    id: 0
  }


  const editSatellite = (satellite: Satellite) => {

    console.log("editsatellite", satellite)

    helpSatellite.name = satellite.name;
    helpSatellite.id = Number(satellite.id);
    isDialogShown.value = true;
  }

  const handleModal = (satellite = JSON.parse(JSON.stringify(helpSatellite))) => {
    console.log("satellite", satellite)
    if(satellite.name === "") {
      return
    }

    dataStore.editSatellite(satellite)     

    console.log(satellites)

    isDialogShown.value = false;
    helpSatellite.name = "";
  }

</script>

<template>

  <BackButton />

  <div v-if="area">
    <h1>{{ area.name }}</h1> 
  
    <div :class="{ visible: selectedSatellites.length > 0 }" class="menu">
      <Dropdown v-model="selectedClass" :options="classes"  placeholder="Select a class" />
      <Button :label="`Move to class ${selectedClass}`" @click="changeClass" style="border: 2px solid black" />
    </div>

    <DataTable
      v-model:selection="selectedSatellites"
      :value="satellites"
      selectionMode="multiple"
      dataKey="id"
      :rows="5"
      :paginator="true"
      :currentPageReportTemplate="'Showing {first} to {last} of {totalRecords}'"
      :rowsPerPageOptions="[5, 10, 20]"
    >

    <template #empty> No customers found. </template>
    <template #loading> Loading customers data. Please wait. </template>


    <Column selectionMode="multiple" headerStyle="width: 3em"></Column>
    <Column v-for="col of columns" :key="col" :field="col" :header="col"></Column>


    <column field="actions" header="Actions">
      <template #body="{ data }">
        <FontAwesomeIcon :icon="faPencil" @click="editSatellite(data)"/>
        <ADialog
          v-model="isDialogShown"
          title="Edit Satellite"
        >
          <div class="a-card-body">
            <AInput
              type="text"
              label="Satellite name"
              placeholder="Enter satellite name"
              v-model="helpSatellite.name"
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
      </template>
    </column>

      
    </DataTable>


  </div>

  <p v-else class="">No area found</p>
</template>

<style scoped>
  .menu {
    opacity: 0;
  }
  .visible {
    opacity: 1;
  }
  input {
    border: 1px solid black;
  }
</style>
