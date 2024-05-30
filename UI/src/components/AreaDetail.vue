<script setup lang="ts">
  import { ref } from 'vue';
  import DataTable from "primevue/datatable"
  import InputText from "primevue/inputtext"
  import Column from "primevue/column"
  import Dropdown from "primevue/dropdown"
  import { useDataStore } from '@/stores/dataStore';
  import { useRoute } from 'vue-router';
  import BackButton from '@/components/general/BackButton.vue';
  import { FilterMatchMode } from 'primevue/api';
  import { useInterval } from '@/composables/useInterval';

  import { FontAwesomeIcon } from '@fortawesome/vue-fontawesome'
  import { faTrashCan } from '@fortawesome/free-solid-svg-icons'
  import type { Satellite } from '@/types/Satellite';
  import StatusCircle from './general/StatusCircle.vue';
  import type { Area } from '@/types/Area';


  const dataStore = useDataStore();
  const { setSafeInterval } = useInterval();

  const route = useRoute();

  const id = route.params.id as string;
  const area: Area = ref({ name: "", id: ""});
  const areas: Area[] = ref([]);
  const satellites: Satellite[] = ref([]);
  const types = ref([]);
  
  async function fetchData() {
    area.value = await dataStore.getAreaById(id);
    areas.value = await dataStore.getAreas();
    satellites.value = await dataStore.getSatellitesByArea(id);
    types.value = await dataStore.getSatelliteTypes();
  }

  fetchData();
  setSafeInterval(() => fetchData(), 1000);


  const selectedSatellites = ref<Satellite[]>([]);
  const selectedArea = ref();

  const changeArea = async () => {
    let promises = [];

    for(let satellite of selectedSatellites.value) {
      satellite.area = selectedArea.value.id;
      promises.push(dataStore.editSatellite(satellite));
    }

    await Promise.all(promises);
    await fetchData();
  }

  const deleteSatellite = async (satellite: Satellite) => {
    if (!confirm(`Are you sure you want to delete ${satellite.name}?`)) return;
    await dataStore.deleteSatellite(satellite);
    await fetchData();
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
    if(satellite.name === "") {
      return
    }

    dataStore.editSatellite(satellite)     

    console.log(satellites)

    isDialogShown.value = false;
    helpSatellite.name = "";
  }



  const products = ref(satellites);
  const editingRows = ref([]);


const onRowEditSave = (event) => {
    let { newData, index } = event;
    products.value[index] = newData;

    dataStore.editSatellite(products.value[index]);
    fetchData();
};


const filters = ref({
    global: { value: null, matchMode: FilterMatchMode.CONTAINS },
    name: { value: null, matchMode: FilterMatchMode.STARTS_WITH },
    type: { value: null, matchMode: FilterMatchMode.STARTS_WITH },
    status: { value: null, matchMode: FilterMatchMode.EQUALS },
});




</script>

<template>

  <BackButton />

  <div v-if="area" class="body-wrapper">
    <h1>{{ area.name }}</h1> 

    <ABtn class="button">
      <a href="/new-device">
        <i class="i-bx-plus-circle"/>
      Add New Device
      </a>
    </ABtn>
  
    <div class="flex menu-wrapper">
      <div :class="{ visible: selectedSatellites.length > 0 }" class="area-menu">
          <Dropdown v-model="selectedArea" :options="areas" optionLabel="name" placeholder="Select an area" :disabled="selectedSatellites.length <= 0" />

          <ABtn class="button" @click="changeArea" :disabled="selectedSatellites.length <= 0">
            Move to  {{selectedArea?.name}}
          </ABtn>
      </div>
      <AInput
          type="text"
          placeholder="Keywords Search"
          prepend-inner-icon="i-bx-search"
          v-model="filters['global'].value"
          class="input"
        />
    </div>

    <div class="table-wrapper">
      <DataTable
        v-model:editingRows="editingRows"
        v-model:selection="selectedSatellites"
        v-model:filters="filters"
        :globalFilterFields="['name', 'type', 'status']"
        :value="satellites"
        selectionMode="multiple"
        editMode="row"
        dataKey="id"
        :rows="10"
        :paginator="true"
        :currentPageReportTemplate="'Showing {first} to {last} of {totalRecords}'"
        :rowsPerPageOptions="[5, 10, 20]"
        @row-edit-save="onRowEditSave"
      >

      <template #empty> No satellites found. </template>
      <template #loading> Loading satellites data. Please wait. </template>  

      <Column selectionMode="multiple" headerStyle="width: 3em" />

      <column field="status" header="Status" style="width: 50px;">
        <template #body="{ data }">
          <StatusCircle :status_satellite="data.status" />
        </template>
      </column>

      <Column field="name" header="Name" style="width: 30%;">
        <template #editor="{ data, field }">
          <InputText v-model="data[field]" autofocus/>
        </template>
      </Column>

      <Column field="type" header="Type" style="width: 30%;">
        <template #body="{ data }">
          {{ data.type.name }}
        </template>
        <template #editor="{ data, field }">
            <Dropdown v-model="data[field]" :options="types" optionLabel="name" placeholder="Select a type" />
        </template>
      </Column>

      <Column :rowEditor="true" style="width: 10%; min-width: 8rem" bodyStyle="text-align:center">
        <p>X</p>
      </Column>

      <Column>
        <template #body="{ data }">
            <FontAwesomeIcon :icon="faTrashCan" @click="deleteSatellite(data)" />
        </template>
      </Column>
      </DataTable>
    </div>

  </div>

  <p v-else class="">No area found</p>
</template>

<style>
  .p-datatable-tbody tr:hover td
  {
    background: var(--color-layer-hover) !important;
  }

  .p-datatable-thead th, .p-paginator {
    background: var(--color-background-mute) !important;
  }

  .p-datatable-tbody td	 {
    background: var(--color-background-soft) !important;
  }

  .button a{
    color: white;
  }

  .menu-wrapper {
    justify-content: space-between;
    margin: 1em 0;
    position: relative
  }

  .input {
    position: absolute;
    right: 0;
  }

  .table-wrapper {
    border-radius: 15px;
    overflow: hidden;
   
  }
  .menu-wrapper .input {
    width: 30%;
    max-width: 300px;
  }

  .area-menu {
    opacity: 0;
    gap: 1em;
    display: flex;
  }
  .visible {
    opacity: 1;
  }
</style>
