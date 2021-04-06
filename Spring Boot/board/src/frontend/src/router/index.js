// Front 서버가 컨트롤 하는 URL
// 포트번호의 역할 : 서비스 종류를 구별시키는 것
// 7777 : 스프링, 8080 : 뷰
// axios : Spring과 Front를 연결해줌

import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'
import About from '../views/About'

import Test from "@/views/Test";

import BoardListPage from '../views/BoardListPage'
import BoardRegisterPage from '../views/BoardRegisterPage'
import BoardModifyPage from '../views/BoardModifyPage'
import BoardReadPage from '../views/BoardReadPage'

import VuetifyBoardListPage from "@/views/vuetifyPage/VuetifyBoardListPage";
//import VuetifyBoardListPaginationPage from "@/views/vuetifyPage/VuetifyBoardListPaginationPage";

Vue.use(VueRouter)

// 특정 URL에 어떤 컴포넌트가 처리를 할지 설정
const routes = [
  {
    // 홈
    path: '/',
    name: 'Home',
    component: Home
  },
  {
    // 소개
    path: '/about',
    name: 'About',
    component: About
  },
  {
    // 테스트
    path: '/test',
    name: 'Test',
    component: Test
  },
  {
    // 게시판
    path: '/board',
    name: 'BoardListPage',
    components: {
      default: BoardListPage
    }
  },
  {
    // 게시물 작성
    path: '/board/create',
    name: 'BoardRegisterPage',
    components: {
      default: BoardRegisterPage
    }
  },
  {
    // 가변 인자를 쓸 때
    path: '/board/:boardNo',
    name: 'BoardReadPage',
    components: {
      default: BoardReadPage
    },
    // Router의 props로
    // default: true를 해놓으면
    // params로 해놓은 boardNo가
    // 자동으로 props로 세팅되어서 들어감
    props: {
      default: true
    }
  },
  {
    path: '/board/:boardNo/edit',
    name: 'BoardModifyPage',
    components: {
      default: BoardModifyPage
    },
    props: {
      default: true
    }
  },
  {
    path: '/vuetifyBoard',
    name: 'VuetifyBoardListPage',
    components: {
      default: VuetifyBoardListPage
    }
  },/*
  {
    path: '/vuetifyPagination',
    name: 'VuetifyBoardListPaginationPage',
    components: {
      default: VuetifyBoardListPaginationPage
    }
  }*/
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router

/*
BackEnd
1. Controller
2. Entity
3. Service Interface
4. Service Implements
5. Repository

FrontEnd
1. Router
2. Views
3. Components
4. Store (데이터 저장소)

모든 컴포넌트에는 data와 methods가 없이 외부만 존재하고
모든 데이터는 store에서 일괄처리 함

Store : 중앙 집중식 저장소
각 컴포넌트가 실행될 때
props(Properties: 부모 자식 간 데이터 전달)를 사용하지 않아도 되는 장점
state에 컨트롤할 데이터가 전부 들어가 있어서 편리

*/