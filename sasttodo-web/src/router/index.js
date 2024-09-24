import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'

const routes = [
  {
    path: '/',
    name: 'home',
    component: HomeView,
    redirect:'/user',
    children:[
      {path: '/user', component: () => import('../views/user/UserView.vue')},
      {path: '/task', component: () => import('../views/task/TaskView.vue')}
    ]
  },
  {path: '/login', component: () => import('../views/LoginView')}
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
