// UnoCSS import
import 'uno.css'
// anu styles
import 'anu-vue/dist/style.css'
// default theme styles
import '@anu-vue/preset-theme-default/dist/style.css'

import 'primevue/resources/themes/aura-dark-noir/theme.css'

import "https://unpkg.com/esp-web-tools@10/dist/web/install-button.js";

import './assets/main.css'

import { createApp } from 'vue'
import { createPinia } from 'pinia'
import { anu } from 'anu-vue'
import PrimeVue from 'primevue/config';


import App from './App.vue'
import router from './router'

const app = createApp(App)

app.use(createPinia())
app.use(router)
app.use(anu, {
    initialTheme: 'dark'
})
app.use(PrimeVue);

app.mount('#app')


