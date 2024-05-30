<template>
    <h1>New device</h1>
    <div class="configuration-step">
      <h2>Intitial firmware flashing</h2>
      <p>To a new satellite, first connect a new ESP32 with USB to your computer, and install the intitial mesh frimware by clicking the "Initialize" button below, then select your device.</p>
      <ABtn id="initialize" icon="i-bx-transfer-alt">Select device to initialize</ABtn>
      <esp-web-install-button id="esp-web-install-button"
            compilation:src="`esp-web-install/esp-web-install-button.js`"
            compilation:manifest="`esp-web-install/manifest.json`"
          :manifest="`esp-web-install/manifest.json`"
          ></esp-web-install-button>
    </div>
    <br>

    <div class="configuration-step">
        <h2>Unregistered satellites</h2>
        <p> Satellites that have been flashed with the initial firmware but have not been registered yet will appear here. </p>
    </div>    
    <div class="unregistered-wrapper">
        <ACard v-for="device in pendingDevices" :key="pendingDevices.indexOf(device)" 
            :title="device.macAddress"
            variant="outline"
            color="primary"
            class="shadow-none unregister-card"
        >
            <ABtn @click="selectDevice(device)" variant="outline">Fill metadata</ABtn>
        </ACard>
    </div>

    <ADialog
      v-model="isDeviceSelected"
      title="Satellite registration"
    >
      <div class="a-card-body">
          
          <AInput
          type="text"
          required
          v-model="selectedName"
          class="input"
          placeholder="Enter a name"
          prepend-inner-icon="i-bx-code"
          />
          
          <ASelect v-model="selectedType" :options="types" placeholder="Select a type" prepend-inner-icon="i-bx-chip"/>
          <ASelect v-model="selectedArea" :options="areas" placeholder="Select an area" prepend-inner-icon="i-bx-map-pin"/>

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
                @click="saveMetadata()"
            >
                Confirm
            </ABtn>
            <ABtn
                color="danger"
                variant="outline"
                @click="resetForm()"
            >
                Cancel
            </ABtn>
        </div>
        
      </div>
    </ADialog>

</template>

<script>

    navigator.serial.getPorts().then((ports) => {
        console.log(ports);

        const ESPWebInstallButton = document.querySelector("esp-web-install-button").shadowRoot.querySelector("button");
        console.log(ESPWebInstallButton);
        ESPWebInstallButton.style.display = "none";
        
        const InitializeButton = document.querySelector("#initialize");
        InitializeButton.addEventListener("click", () => {
            ESPWebInstallButton.click();
        });
    });


</script>

<script setup>
import { ref } from 'vue';
import { useDataStore } from '@/stores/dataStore';
import { useInterval } from '@/composables/useInterval';
const { setSafeInterval } = useInterval();
const dataStore = useDataStore();

const isDeviceSelected = ref(false);
const selectedDevice = ref(null);
const selectedType = ref();
const selectedArea = ref();
const selectedName = ref();

let areas = ref([]);
let types = ref([]);

async function fetchAreasAndTypes() {
    const areasList = await dataStore.getAreas();
    areas.value = [];
    areasList.forEach(area => {
        areas.value.push({text: area.name, value: area.name, id: area.id});
    });
    console.log(areas.value);

    const typesList = await dataStore.getSatelliteTypes();
    types.value = [];
    typesList.forEach(type => {
        types.value.push({text: type.name, value: type.name, id: type.id});
    });
    console.log(types.value);
}

fetchAreasAndTypes();

const pendingDevices = ref([]);

const fetchPendingDevices = async () => pendingDevices.value = await dataStore.getDevicesPendingMetadata();
fetchPendingDevices();
setSafeInterval(() => fetchPendingDevices(), 1000);

let modalError = ref("");
let modalErrorDisplayed = ref(false);

const selectDevice = (device) => {
    resetForm();
    selectedDevice.value = device;
    isDeviceSelected.value = true;
};

const saveMetadata = async () => {
    
    console.log(selectedName.value, selectedType.value, selectedArea.value);
    if(!selectedName.value || !selectedType.value || !selectedArea.value){
        modalError.value = "Please fill all fields.";
        modalErrorDisplayed.value = true;
        return;
    }

    const selectedTypeIndex = types.value.findIndex(type => type.value === selectedType.value);
    if(selectedTypeIndex === -1){
        modalError.value = "Invalid type.";
        modalErrorDisplayed.value = true;
        return;
    }
    const selectedTypeId = types.value[selectedTypeIndex].id;

    const selectedAreaIndex = areas.value.findIndex(area => area.value === selectedArea.value);
    if(selectedAreaIndex === -1){
        modalError.value = "Invalid area.";
        modalErrorDisplayed.value = true;
        return;
    }

    const selectedAreaId = areas.value[selectedAreaIndex].id;

    await dataStore.editSatellite({
        id: selectedDevice.value.id,
        macAddress: selectedDevice.value.macAddress,
        status: "UPDATING",
        name: selectedName.value,
        type: {id: selectedTypeId},
        area: selectedAreaId
    });

    resetForm();
    fetchPendingDevices();
};

const resetForm = () => {
    selectedName.value = "";
    selectedType.value = "";
    selectedArea.value = "";
    isDeviceSelected.value = false;
    modalError.value = "";
};

</script>

<style scoped>
.unregistered-wrapper {
    display: flex;
    flex-direction: row;
    flex-wrap: wrap;
    gap: 1em;
}
.unregistered-wrapper > * {
    text-align: center;
    border: 1px solid var(--color-border);
    border-radius: 10px;
    padding: 1em;
    margin: 1em 0px;
    width: 200px;
    min-height: 200px;
    display: flex;
    flex-direction: column;
    justify-content: space-around;
}


@keyframes blink {
  0% { opacity: 1; }
  25%, 75% { opacity: 0.4; }
  50%, 100% { opacity: 1; }
}

.unregister-card {
  animation: blink 1s ease-out;
}

.a-card-body {
    display: flex;
    flex-direction: column;
    gap: 1em;
    max-width: 500px;
}

.buttons {
    display: flex;
    gap: 0.5em;
}

.configuration-step{
    width: 500px;
}

.configuration-step p{
    margin: 10px 0;
}
</style>