<script setup lang="ts">
import { useRoute } from 'vue-router';
import { FontAwesomeIcon } from '@fortawesome/vue-fontawesome'
import { faHouse, faCode, faFile, faMountainCity, faChartLine,faMicrochip } from '@fortawesome/free-solid-svg-icons'


const route = useRoute();
const isActive = (path: string) => {
    return route.path === path || route.path.startsWith(`${path}/`);
}

</script>
<template>
    <div class="wrapper">
        <img alt="Vue logo" src="../assets/logo.svg" />
        <nav>
            <router-link to="/">  
                <FontAwesomeIcon :icon="faHouse" />
                <span>Home</span>
            </router-link>
            <router-link to="/logs">
                <FontAwesomeIcon :icon="faFile" /> 
                <span>Logs</span>
            </router-link>
            <router-link to="/areas" :class="{ 'active': (isActive('/areas') || isActive('/satellites')) }">
                <FontAwesomeIcon :icon="faMountainCity" /> 
                <span>Areas</span>
            </router-link>
            <router-link to="/editor">
                <FontAwesomeIcon :icon="faCode" /> 
                <span>DSL Editor</span>
            </router-link>
            <router-link to="/data-monitoring">
                <FontAwesomeIcon :icon="faChartLine" />
                <span>Data Monitoring</span>
            </router-link>
        </nav>
    </div>
</template>

<style scoped>
    .wrapper {
        display: flex;
        flex-direction: column;
        justify-content: space-between;
        align-items: center;
        padding: 2em 0;
        gap:2em;
    }
    img {
        padding:1em;
    }
    nav {
        display: flex;
        flex-direction: column;
    }
    nav > a {
        display: flex;
        gap: 1em;
        padding: 0.75em 1em;
        width: 100%;
        align-items: center;
    }

    nav a {
        text-decoration: none;
        color: var(--color-text);
    }

    nav a.router-link-exact-active, nav a.active {
        color: var(--vt-c-blue)
    }
    nav a svg {
        width: 1.25em;
    }
</style>