<script setup lang="ts">
    //import XtextEditor from '@/components/XtextEditor.vue'
</script>

<template>
    <div class="wrapper">
        <h1>DSL Editor</h1>
        <iframe src="http://localhost:8080"></iframe>
        <!--<XtextEditor />-->
    </div>
</template>

<style scoped>
    .wrapper {
        height: calc(100% - 5em);
    }
    iframe {
        border: 0px none;
        width: 100%;
        height: 100%;
    }
</style>