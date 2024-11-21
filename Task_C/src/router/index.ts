import { createRouter, createWebHistory, RouteRecordRaw } from 'vue-router';
import StudentTable from '../views/StudentTable.vue';

const routes: Array<RouteRecordRaw> = [
  {
    path: '/',
    name: 'HomePage',
    component: () => import('../views/HomePage.vue'), // Updated name
  },
  {
    path: '/students',
    name: 'Students',
    component: StudentTable,
  },
  {
    path: '/settings',
    name: 'SettingsPage',
    component: () => import('../views/SettingsPage.vue'), // Updated name
  },
];

const router = createRouter({
  history: createWebHistory(),
  routes,
});

export default router;
