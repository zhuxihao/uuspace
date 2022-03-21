import Vue from 'vue'
import App from './App.vue'
import router from './router'
import Element from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
import './assets/CSS/global.css'
import axios from 'axios'

axios.defaults.headers.post['Content-Type'] = 'text/plain'
// axios.defaults.baseURL = 'http://localhost:8080/uukj_war/'
Vue.prototype.$axios = axios
Vue.use(Element)

Vue.config.productionTip = false

new Vue({
  router,
  render: h => h(App)
}).$mount('#app')
