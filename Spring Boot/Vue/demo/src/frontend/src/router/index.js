import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'
import About from '../views/About'

import Test from "@/views/Test";

import BoardListPage from '../views/BoardListPage.vue'
import BoardRegisterPage from '../views/BoardRegisterPage.vue'
import BoardModifyPage from '../views/BoardModifyPage.vue'
import BoardReadPage from '../views/BoardReadPage.vue'

import VuetifyBoardListPage from "@/views/vuetifyPage/VuetifyBoardListPage";
//import VuetifyBoardListPaginationPage from "@/views/vuetifyPage/VuetifyBoardListPaginationPage";

import CrawlCategoryPage from "@/views/crawl/CrawlCategoryPage";
// 포트번호: 7777 스프링, 8080 뷰
// 서비스 종료를 구별시키기 위함
Vue.use(VueRouter)

// 특정 url에 어떤 컴포넌트가 처리를 할지 설정
const routes = [
  {
    // Home
    path: '/',
    name: 'Home',
    component: Home
  },
  {
    // About
    path: '/about',
    name: 'About',
    component: About
  },
  {
    path: '/test',
    name: 'Test',
    component: Test
  },
  {
    // 게시판 페이지
    path: '/board',
    name: 'BoardListPage',
    components: {
      default: BoardListPage
    }
  },
  {
    // 게시물 작성 페이지
    path: '/board/create',
    name: 'BoardRegisterPage',
    components: {
      default: BoardRegisterPage
    }
  },
  {
    // 가변 인자로 쓸 때
    path: '/board/:boardNo',
    name: 'BoardReadPage',
    components: {
      default: BoardReadPage
    },
    props: {
      // 자동으로 props로 세팅돼서 들어감
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
  },
  {
    path: '/crawlCategory',
    name: 'CrawlCategoryPage',
    components: {
      default: CrawlCategoryPage
    }
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
