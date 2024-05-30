<script setup lang="ts">
import { ProgramStatus } from '@/api';
import { ProgramApi } from '@/stores/api';
import { computed, ref } from 'vue';
import { useInterval } from '@/composables/useInterval';
import type { Satellite } from '@/types/Satellite';
import { useDataStore } from '@/stores/dataStore';
import HomeSatellite from '@/components/HomeSatellite.vue';
import { FontAwesomeIcon } from '@fortawesome/vue-fontawesome'
import { faExclamationTriangle, faXmark } from '@fortawesome/free-solid-svg-icons';


const { setSafeInterval } = useInterval();


//import XtextEditor from '@/components/XtextEditor.vue'
const programStatus = ref<ProgramStatus>(ProgramStatus.Unchanged);
const fullStatus = ref<any>({});
const showStackTrace = ref(false);

const pollProgramStatus = async () => {
    const oldStatus = programStatus.value;
    fullStatus.value = await ProgramApi.getProgramStatus();
    programStatus.value = fullStatus.value.status ?? ProgramStatus.ErrorUnexpected;
    if(oldStatus !== programStatus.value) {
        updateBasedOnStatus();
        if(!hasStateBeenInitialized.value) {
            hasStateBeenInitialized.value = true;
        } else {
            isInitialState.value = false;
        }
    }
    console.log("Program status: ", fullStatus.value);
};

setSafeInterval(pollProgramStatus, 1000);
pollProgramStatus();

const compileResults = computed(() => {
    return fullStatus.value.binaryCompileResults.filter((result: any) => result.compileFailed);
});

const selectedError = ref<any>({});

const actionInProgress = ref(false);
const isDialogShown = ref(false);
const isDialogCloseButtonShown = ref(false);
const isDialogOverrideButtonShown = ref(false);
const isCompiling = ref(false);
const isSuccessfullyCompiled = ref(false);
const hasStateBeenInitialized = ref(false);
const isInitialState = ref(true);
const showIframe = ref(false);

setSafeInterval(() => {
    showIframe.value = true
}, 200);

const dataStore = useDataStore();

let satellites = ref<Satellite[]>([]);

async function fetchSatellites() {
    if(isSuccessfullyCompiled.value) {
        satellites.value = await dataStore.getSatellites();
    }
}

setSafeInterval(() => {
  fetchSatellites();
}, 1000);

fetchSatellites();

//First character uppercase, replace underscores with spaces and lowercase
const statusText = computed(() => programStatus.value.replace(/_/g, ' ').toLowerCase().replace(/(?:^|\s)\S/g, (a) => a.toUpperCase()));

function updateBasedOnStatus() {
    switch (programStatus.value) {
        case ProgramStatus.CodeGeneratedRequiresOverride:
            isDialogCloseButtonShown.value = true;
            isDialogShown.value = true;
            isDialogOverrideButtonShown.value = true;
            isCompiling.value = false;
            isSuccessfullyCompiled.value = false;
            break;
        case ProgramStatus.CompilingBinaries:
            isDialogCloseButtonShown.value = false;
            isDialogShown.value = true;
            isDialogOverrideButtonShown.value = false;
            isCompiling.value = true;
            isSuccessfullyCompiled.value = false;
            break;
        case ProgramStatus.CompiledCompletely:
            isSuccessfullyCompiled.value = true;
            if(isInitialState.value) {
                isDialogCloseButtonShown.value = false;
                isDialogShown.value = false;
                isDialogOverrideButtonShown.value = false;
                isCompiling.value = false;
            } else {
                isDialogCloseButtonShown.value = true;
                isDialogShown.value = true;
                isDialogOverrideButtonShown.value = false;
                isCompiling.value = false;
            }
            break;
        case ProgramStatus.ErrorCompilingBinaries:
            isDialogCloseButtonShown.value = true;
            isDialogShown.value = true;
            isDialogOverrideButtonShown.value = false;
            isCompiling.value = false;
            isSuccessfullyCompiled.value = false;
            break;
        case ProgramStatus.ErrorGeneratingCode:
            isDialogCloseButtonShown.value = true;
            isDialogShown.value = true;
            isDialogOverrideButtonShown.value = false;
            isCompiling.value = false;
            isSuccessfullyCompiled.value = false;
            break;
        case ProgramStatus.ErrorUnexpected:
            isDialogCloseButtonShown.value = true;
            isDialogShown.value = true;
            isDialogOverrideButtonShown.value = false;
            isCompiling.value = false;
            isSuccessfullyCompiled.value = false;
            break;
        default:
            isDialogCloseButtonShown.value = true;
            isDialogShown.value = false;
            isDialogOverrideButtonShown.value = false;
            isCompiling.value = false;
            isSuccessfullyCompiled.value = false;
            break;
    }
}

const statusClass = computed(() => {
    switch (programStatus.value) {
        case ProgramStatus.Unchanged:
            return 'unchanged';
        case ProgramStatus.Changed:
            return 'changed';
        case ProgramStatus.GeneratingCode:
            return 'generating-code';
        case ProgramStatus.CodeGeneratedRequiresOverride:
            return 'code-generated-override-required';
        case ProgramStatus.ErrorGeneratingCode:
            return 'error-generating-code';
        case ProgramStatus.CodeGenerated:
            return 'code-generated';
        case ProgramStatus.CompilingBinaries:
            return 'compiling-binaries';
        case ProgramStatus.ErrorCompilingBinaries:
            return 'error-compiling-binaries';
        case ProgramStatus.CompiledCompletely:
            return 'compiled-completely';
        case ProgramStatus.ErrorUnexpected:
            return 'error-unexpected';
        default:
            return '';
    }
});
const compilationDisabled = computed(() => {
    const inProgress = actionInProgress.value;
    const status = programStatus.value;

    return inProgress ||
        status === ProgramStatus.Unchanged ||
        status === ProgramStatus.GeneratingCode ||
        status === ProgramStatus.CodeGenerated ||
        status === ProgramStatus.CompilingBinaries ||
        status === ProgramStatus.CompiledCompletely;
});

const compile = async () => {
    actionInProgress.value = true;
    try {
        const status = await ProgramApi.compileProgram();
        programStatus.value = status.status ?? programStatus.value;
    } finally {
        actionInProgress.value = false;
    }
};

const overrideCompile = async () => {
    actionInProgress.value = true; // Set loading state to true before making the API call
    try {
        const status = await ProgramApi.compileProgramContinueDestructively();
        programStatus.value = status.status ?? programStatus.value;
    } finally {
        actionInProgress.value = false; // Reset loading state after API call completes (success or failure)
    }
};

</script>

<template>
    <div class="wrapper">
        <h1>DSL Editor</h1>
        <div class="top-bar">
            <ABtn class="button" @click="compile" :disabled="compilationDisabled">
                <i class="i-bx-code-block" />
                Compile
            </ABtn>
            <ABtn v-if="programStatus === ProgramStatus.CodeGeneratedRequiresOverride" class="override-button"
                @click="overrideCompile" :disabled="actionInProgress">
                Continue compile
            </ABtn>
            <div class="status">
                <p class="status-text">Current Status:</p>
                <p :class="statusClass">{{ statusText }}</p>
            </div>
        </div>
        <div class="compilation-errors">
            <p v-for="(result, index) in compileResults" :key="index" @click="selectedError = result; showStackTrace = true"> <FontAwesomeIcon  :icon="faExclamationTriangle" />{{ result.compileErrors  }} </p>
            <ADialog v-model="showStackTrace" title="Error stack trace" class="w-[80vw]">
                <div class="a-card-body">
                    <span class="closeBtn" @click="showStackTrace = false">        
                        <FontAwesomeIcon :icon="faXmark" />
                    </span>
                    {{ selectedError.compileOutput }}    
                </div>
            </ADialog>
        </div>
        <iframe :class="[showIframe ? 'show-iframe' : 'hide-iframe']" src="http://localhost:8081"></iframe>
    </div>

    <ADialog v-model="isDialogShown" 
        :title="!isSuccessfullyCompiled ? 'Compiling' : 'Compilation successful'"
        :subtitle="!isSuccessfullyCompiled ? 'Follow your compilation request status here.'  : 'Monitoring satellite OTA updates.'"
    persistent class="popup">
    <span class="closeBtn" @click="isDialogShown = false">        
          <FontAwesomeIcon :icon="faXmark" @click="isDialogShown = true"/>
    </span>
    <div class="a-card-body min-w-70 min-h-50 flex flex-col justify-center items-center">
        <ACard class="min-h=50 min-w=50"
            style="--a-loader-overlay-bg-opacity: 1; height: 100px; width: 200px;" v-if="!isSuccessfullyCompiled">
            <ALoader :title=statusText
                class="[--a-loader-overlay-bg-c:var(--a-surface-c)] min-h=20 ">
                <ASpinner class="big-loader" :style="isCompiling ? 'display: block' : 'display: none'" />
            </ALoader>
        </ACard>
        <div v-if="isSuccessfullyCompiled" class="a-card-body min-w-70 min-h-50 flex flex-col justify-center items-center">
            <div class="area-satellites">
                <HomeSatellite v-for="satellite in satellites" :key="satellite.id" :satellite="satellite" />
            </div>
        </div>
    </div>
    <div class="a-card-footer flex justify-center items-center m-5">
        <ABtn variant="light" class="text-sm" @click="isDialogShown = false" v-if="isDialogCloseButtonShown">
            Close
        </ABtn>
        <ABtn variant="light" class="text-sm" @click="overrideCompile" v-if="isDialogOverrideButtonShown">
            Override
        </ABtn>
    </div>
</ADialog>

</template>

<style scoped>
.wrapper {
    height: calc(100vh - 4em);
    display: flex;
    flex-direction: column;
}

.top-bar {
    display: flex;
    align-items: center;
    margin-bottom: 1em;
    gap: 1em;
}

.button {
    display: flex;
    align-items: center;
    background-color: #333;
    color: white;
    padding: 0.5em 1em;
    border-radius: 4px;
}

.button:disabled {
    cursor: not-allowed;
    pointer-events: all;
    /* This line is optional depending on your needs */
}

.status {
    display: flex;
    align-items: center;
}

.status-text {
    font-size: 1.2em;
    font-weight: bold;
    color: #777575;
    margin-right: 0.5em;
}

.status p {
    font-size: 1.2em;
    font-weight: bold;
    text-transform: lowercase;
}

.status p::first-letter {
    text-transform: uppercase;
}

.big-loader {
    width: 3em !important;
    height: 3em !important;
}

iframe {
    border: 0px none;
    width: 100%;
    margin-top: 1em;
    height: 100%;
}

.unchanged {
    color: white;
}

.changed {
    color: orange;
}

.generating-code {
    color: orange;
}

.code-generated-override-required {
    color: yellow;
}

.error-generating-code {
    color: red;
}

.code-generated {
    color: green;
}

.compiling-binaries {
    color: orange;
}

.error-compiling-binaries {
    color: red;
}

.compiled-completely {
    color: green;
}

.popup {
    position:relative;
}

.compilation-errors {
    display: flex;
    flex-direction: column;
    gap: 0.5em;
    color: red;
}

.compilation-errors svg {
    margin-right: 0.5em;
}

.a-card-body {
    width: 100%;
    font-size: 0.8em;
    max-height: 60vh;
    overflow: auto;
}

.closeBtn {
    position: absolute;
    top: 0;
    right: 0;
    padding: 0.75em;
    cursor: pointer;
}

.error-unexpected {
    color: red;
}
.show-iframe {
    opacity: 1;
}
.hide-iframe {
    opacity: 0;
}
</style>
