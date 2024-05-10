<script setup lang="ts">
import { ProgramStatus } from '@/api';
import { ProgramApi } from '@/stores/api';
import { computed, ref } from 'vue';


//import XtextEditor from '@/components/XtextEditor.vue'
const programStatus = ref<ProgramStatus>(ProgramStatus.Unchanged);
const pollProgramStatus = async () => {
    const status = await ProgramApi.getProgramStatus();
    programStatus.value = status.status ?? ProgramStatus.ErrorUnexpected;
};

setInterval(pollProgramStatus, 1000);
pollProgramStatus();

const actionInProgress = ref(false);

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
            <ABtn class="button" @click="compile" :disabled="actionInProgress">
                <i class="i-bx-code-block" />
                Compile
            </ABtn>
            <ABtn v-if="programStatus === ProgramStatus.CodeGeneratedRequiresOverride" class="override-button" @click="overrideCompile" :disabled="actionInProgress">
                Continue compile
            </ABtn>
            <div class="status">
                <p class="status-text">Current Status:</p>
                <p :class="statusClass">{{ programStatus.replace(/_/g, ' ') }}</p>
            </div>
        </div>
        <iframe src="http://localhost:8081"></iframe>
    </div>
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
iframe {
    border: 0px none;
    width: 100%;
    margin-top: 1em;
    height: 100%;
}
.unchanged { color: white; }
.changed { color: orange; }
.generating-code { color: orange; }
.code-generated-override-required { color: yellow; }
.error-generating-code { color: red; }
.code-generated { color: green; }
.compiling-binaries { color: orange; }
.error-compiling-binaries { color: red; }
.compiled-completely { color: green; }
.error-unexpected { color: red; }
</style>
