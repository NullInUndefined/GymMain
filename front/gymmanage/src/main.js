import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'

import ElementPlus from 'element-plus'
import 'element-plus/dist/index.css'
// import * as Icons from '@element-plus/icons'
import axios from 'axios'
import VueAxios from 'vue-axios'

createApp(App).use(VueAxios,axios).use(store).use(ElementPlus).use(router).mount('#app')

// Object.keys(Icons).forEach(key => {
//     App.component(key, Icons[key])
// })



