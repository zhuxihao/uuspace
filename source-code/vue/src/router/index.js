import Vue from 'vue'
import VueRouter from 'vue-router'
import Login from '../views/login.vue'
import Home from '../views/home.vue'
import Main from '../views/main.vue'
import Rizhi from '../views/rizhi.vue'
import Xiangce from '../views/xiangce.vue'
import Liuyan from '../views/liuyan.vue'
import Shuoshuo from '../views/shuoshuo'
import Dangan from '../views/dangan'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'Login',
    component: Login
  },
  {
    path: '/Home',
    component: Home,
    children: [
      {
        path: '/',
        component: Main
      },
      {
        path: '/Main',
        component: Main
      },
      {
        path: '/Rizhi',
        component: Rizhi
      },
      {
        path: '/Xiangce',
        component: Xiangce
      },
      {
        path: '/Liuyan',
        component: Liuyan
      },
      {
        path: '/Shuoshuo',
        component: Shuoshuo
      },
      {
        path: '/Dangan',
        component: Dangan
      },
    ]
  }
]

const router = new VueRouter({
  routes
})

export default router
