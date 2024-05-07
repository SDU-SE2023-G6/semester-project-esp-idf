// src/router/index.ts
import { createRouter, createWebHistory } from 'vue-router';
import HomeView from '../views/HomeView.vue';

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'home',
      component: HomeView
    },
    {
      path: '/logs',
      name: 'logs',
      component: () => import('../views/LogsView.vue')
    },
    {
      path: '/areas',
      name: 'areas',
      component: () => import('../views/AreasView.vue'),
      children: [
        {
          path: '',
          name: 'areaList',
          component: () => import('../components/AreaList.vue')
        },
        {
          path: ':id',
          name: 'areaDetail',
          component: () => import('../components/AreaDetail.vue')
        }
      ]
    },
    {
      path: '/editor',
      name: 'XtextEditor',
      component: () => import('../views/DslView.vue')
    },
    {
      path: '/data-monitoring',
      name: 'dataMonitoring',
      component: () => import('../views/DataMonitoringView.vue')
    }
  ]
});

export default router;
