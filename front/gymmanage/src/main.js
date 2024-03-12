import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'

// 重置css样式
import 'normalize.css'
import ElementPlus from 'element-plus'
import 'element-plus/dist/index.css'
// import * as Icons from '@element-plus/icons'
import axios from 'axios'
import VueAxios from 'vue-axios'
// 引入中文包
import zhCn from 'element-plus/dist/locale/zh-cn.mjs'

createApp(App)
  .use(VueAxios,axios)
  .use(store)
  .use(ElementPlus, {
    locale: zhCn
  })
  .use(router)
  .mount('#app')

// Object.keys(Icons).forEach(key => {
//     App.component(key, Icons[key])
// })



