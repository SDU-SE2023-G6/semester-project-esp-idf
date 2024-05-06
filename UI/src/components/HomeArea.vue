<template>
  <div class="area-container">
      <div class="flex area-header">
        <RouterLink :to="`/areas/${ props.area.id}`"><h2 class="area-name">{{ props.area.name }}</h2></RouterLink>
        <div v-if="props.details" class="flex area-details">
          <RouterLink :to="`/areas/${ props.area.id}`">
            <FontAwesomeIcon :icon="faEdit" />
          </RouterLink>
          <FontAwesomeIcon :icon="faPencil" @click="isDialogShown = true"/>
          <FontAwesomeIcon :icon="faTrash" @click="removeArea()"/> 
        </div>
      </div>
      <div class="area-satellites">
        <HomeSatellite v-for="satellite in satellites" :key="satellite.id" :satellite="satellite" />
      </div>
  </div>

  <ADialog
      v-model="isDialogShown"
      title="Edit Area"
    >
      <div class="a-card-body">
        <AInput
          type="text"
          label="Area name"
          placeholder="Enter area name"
          v-model="$props.area.name"
          required
        />

        <div class="buttons">
          <ABtn
            color="success"
            @click="editArea(props.area)"
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

<script setup lang="ts">
import type { Area } from '@/types/Area';
import HomeSatellite from '@/components/HomeSatellite.vue';
import {useDataStore} from '@/stores/dataStore';
import { FontAwesomeIcon } from '@fortawesome/vue-fontawesome'
import { faTrash, faPencil, faEdit } from '@fortawesome/free-solid-svg-icons'
import { defineProps, ref } from 'vue';

const dataStore = useDataStore();


interface Props {
  area: Area;
  details: Boolean;
}

const props = defineProps<Props>();

const satellites = dataStore.getSatellitesByArea(props.area.id);

const isDialogShown = ref(false)


const removeArea = () => {
  if(!confirm("are you sure you want to delete this area?")) return
  dataStore.removeArea(props.area)
}

const editArea = (area: Area) => {
  console.log("area", area)
  if(area.name === "") {
    return
  }

  dataStore.editArea(area) 
  isDialogShown.value = false;
}
</script>

<style scoped>
.area-header {
  justify-content: space-between;
  align-items: center;
}
.area-details {
  gap: 1em;
  align-items: center;
  position: relative;
  z-index: 100;
  color: var(--vt-c-blue);
}
.area-details > *:hover {
  cursor: pointer;
  color:var(--vt-c-blue-hover)
}
.area-container {
  display: flex;
  flex-direction: column;
  gap: 10px;
  padding: 10px;
  background: var(--color-layer);
  border-radius: 10px;
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

.area-satellites {
  max-height: 200px;
  overflow-y: scroll;
  padding-right: 10px;
}

::-webkit-scrollbar {
  width: 10px;
  border-radius: 10px;
}

::-webkit-scrollbar-track {
  background: var(--color-layer);
  border-radius: 10px;
}

::-webkit-scrollbar-thumb {
  background: var(--color-layer);
  border-radius: 10px;
}

::-webkit-scrollbar-thumb:hover {
  background: var(--color-layer);
}
</style>
