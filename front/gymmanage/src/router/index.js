import { createRouter, createWebHashHistory } from 'vue-router'
import testPage from "@/views/testPage";
import AdminCenter from "@/views/AdminCenter";
import AdminMem from "@/views/AdminMem";
import AdminCoach from "@/views/AdminCoach";
import AdminCurse from "@/views/AdminCurse";
import mainPage from "@/views/mainPage";
import MemCenter from "@/views/MemCenter";
import MemCurse from "@/views/MemCurse";
import MemCoach from "@/views/MemCoach";
import TestLogin from "@/views/TestLogin";
import registerView from "@/views/registerView";
import LoginView from "@/views/LoginView";
import AdminOrder from "@/views/AdminOrder";


const routes = [
  {
    path: '/getAll',
    name:'test',
    component: testPage
  },

  {
    path: '/',
    name:'mainPage',
    component: mainPage
  },

  {
    path: '/TestLogin',
    component: TestLogin
  },

//这里是登陆及注册的视图
  {
    path: '/registerView',
    name:'registerView',
    component: registerView
  },

  {
    path: '/LoginView',
    name:'LoginView',
    component: LoginView
  },


    //此处为用户的两个界面路由
  {
    path: '/MemCenter',
    component: MemCenter,
    redirect: '/MemCurse',
    children: [
      {
        path: '/MemCurse',
        component: MemCurse
      },
      {
        //这里一定要记得打引号嗷不然tmd子路由跳转不过去
        path:'/MemCoach',
        component: MemCoach
      }
    ]
  },

  //此处为管理员界面的三个功能路由
  {
    path:'/AdminCenter',
    component: AdminCenter,
    redirect:'/AdminMem',
    children:[
      {
        path:'/AdminMem',
        component:AdminMem
      },
      {
        path:'/AdminCoach',
        component:AdminCoach
      },
      {
        path:'/AdminCurse',
        component:AdminCurse
      },
      {
        path:'/AdminOrder',
        component: AdminOrder
      }
    ]
  },
]

const router = createRouter({
  history: createWebHashHistory(),
  routes
})

export default router


