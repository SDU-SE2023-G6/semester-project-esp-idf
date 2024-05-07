<template>
    <h1>New device</h1>
    <div class="configuration-step">
      <h2>Intitial firmware flashing</h2>
      <p>To a new satellite, first connect a new ESP32 with USB to your computer, and install the intitial mesh frimware by clicking the "Initialize" button below, then select your device.</p>
      <ABtn id="initialize">Initialize</ABtn>
      <esp-web-install-button id="esp-web-install-button" 
          :manifest="`esp-web-install/manifest.json`"
          ></esp-web-install-button>
    </div>
    <br>
    <div class="configuration-step">
        <h2>Configuration and connection to the network</h2>
        <p>To a new satellite, first connect a new ESP32 with USB to your computer, and install the intitial mesh frimware by clicking the "Initialize" button below, then select your device.</p>
        <ABtn id="connect" @click="handleConnectButtonClick">Configure and connect</ABtn>
    </div>

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

</script>

<style scoped>
.configuration-step{
    width: 500px;
}

.configuration-step p{
    margin: 10px 0;
}
</style>