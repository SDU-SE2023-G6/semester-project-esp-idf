<template>
    <h1>New device</h1>
    <div class="configuration-step">
      <h2>Intitial firmware flashing</h2>
      <p>To a new satellite, first connect a new ESP32 with USB to your computer, and install the intitial mesh frimware by clicking the "Initialize" button below, then select your device.</p>
      <ABtn class="button" id="initialize">Initialize</ABtn>
      <esp-web-install-button id="esp-web-install-button" 
          :manifest="`esp-web-install/manifest.json`"
          ></esp-web-install-button>
    </div>
    <br>
    <!--<div class="configuration-step">
        <h2>Configuration and connection to the network</h2>
        <p>To a new satellite, first connect a new ESP32 with USB to your computer, and install the intitial mesh frimware by clicking the "Initialize" button below, then select your device.</p>
        <ABtn class="button" id="connect" @click="handleConnectButtonClick">Configure and connect</ABtn>
    </div>-->




    <ADialog
      v-model="isDialogShown"
      title="Fill satellite metadata"
    >
      <div class="a-card-body">
        <AInput
            type="text"
            placeholder="Enter satellite name"
            required
            v-model="selectedName"
            class="input"
        />

        <Dropdown v-model="selectedClass" :options="classes"  placeholder="Select a class" />

        <Dropdown v-model="selectedArea" :options="areas" optionLabel="name" placeholder="Select an area" />
        

        <div class="buttons">
            <ABtn
                color="success"
                @click="saveMetadata()"
            >
                Confirm
            </ABtn>
            <ABtn
                variant="light"
                color="danger"
                @click="isDialogShown = false"
            >
                Cancel
            </ABtn>
        </div>
        
      </div>
    </ADialog>

</template>

<script>
    navigator.serial.addEventListener("connect", (e) => {
    // Connect to `e.target` or add it to a list of available ports.
        console.log('connected :'+e);
    });

    navigator.serial.addEventListener("disconnect", (e) => {
    // Remove `e.target` from the list of available ports.
        console.log(e);
    });

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
import Dropdown from 'primevue/dropdown';
import { useDataStore } from '@/stores/dataStore';

const dataStore = useDataStore();

const selectedClass = ref();
const selectedArea = ref();
const selectedName = ref();

const areas = dataStore.getAreas;
const classes = dataStore.getClasses;

const isDialogShown = ref(true);

const pendingDevices = dataStore.getDevidesPendingMetadata;

let connectedPort = null;

async function handleConnectButtonClick() {
    navigator.serial
        .requestPort()
        .then(async (port) => {
            // Connect to `port` or add it to the list of available ports.
            console.log("Connected to:", port);
            connectedPort = port;
            await port.open({ baudRate: 115200 });
            console.log("Port readable:", port.readable);

            // Function to decode incoming bytes into a string
            function decodeText(data) {
                const decoder = new TextDecoder('utf-8');
                return decoder.decode(data);
            }

            while (port.readable) {
                const reader = port.readable.getReader();
                try {
                    while (true) {
                        const { value, done } = await reader.read();
                        if (done) {
                            // |reader| has been canceled.
                            break;
                        }

                        if (value) {
                            // Decode and log the UART data
                            const decodedMessage = decodeText(value);
                            console.log("Decoded message:", decodedMessage);
                        }
                    }
                } catch (error) {
                    console.log("Error reading data:", error);
                } finally {
                    reader.releaseLock();
                }
            }
        })
        .catch((e) => {
            // The user didn't select a port.
            console.log(e);
        });
}

const saveMetadata = () => {
    console.log("Save metadata");
    console.log(selectedName.value, selectedClass.value, selectedArea.value);


};

</script>

<style scoped>
.a-card-body {
    display: flex;
    flex-direction: column;
    gap: 1em;
    max-width: 500px;
}
.a-card-body .input {
    background-color: #09090b;
    border-radius: 8px;
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