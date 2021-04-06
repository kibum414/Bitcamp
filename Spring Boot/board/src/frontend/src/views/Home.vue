<template>
  <div class="home">
    <!-- <img alt="Vue logo" src="../assets/logo.png"> -->
    <div id="header">
      <!-- router-link가 동작을 하려면
           router > index.js 에 각각의 URL이 매핑되어 있어야 함
           router > index.js 에 path 걸어놓은 것과 매핑 -->
      <router-link :to="{ name: 'Home' }"
                   class="nav-link"
                   active-class="active">
        홈
      </router-link>
      <router-link :to="{ name: 'About' }"
                   class="nav-link"
                   active-class="active">
        소개
      </router-link>
      <router-link :to="{ name: 'Test' }"
                   class="nav-link"
                   active-class="active">
        테스트
      </router-link>
      <router-link :to="{ name: 'BoardListPage' }"
                   class="nav-link"
                   active-class="active">
        게시판
      </router-link>
      <router-link :to="{ name: 'VuetifyBoardListPage' }"
                   class="nav-link"
                   active-class="active">
        뷰티파이
      </router-link>
      <router-link :to="{ name: 'CrawlCategoryPage' }"
                   class="nav-link"
                   active-class="active">
        크롤링
      </router-link>
      <h2>This is an Home Page</h2>
    </div>
  </div>
</template>

<script>
// @ is an alias to /src
// import HelloWorld from '@/components/HelloWorld.vue'

// js 파일에서 변수 선언 후 사용하지 않을 경우
// jsx로 처리되는 변수들은 shadowing 돼서 eslint가 찾아내지 못할 경우
// serve 할 때 뜨는
// error '변수' is defined but never used no-unused-vars
// 위와 같은 에러가 발생하지 않게 해주는 주석
/* eslint-disable no-unused-vars */
import store from '../store'
import Vue from 'vue'
// import cookies from 'vue-cookies'

import { mapState, mapGetters, mapActions } from 'vuex'

// Vue.use(cookies)

export default {
  name: 'Home',
  data: function () {
    return {
      message: 'Vue Test Message'
    }
  },
  components: {
  }
}
</script>

<style scoped>
div {
  border: 1px solid #ccc;
}

#header {
  padding: 15px;
  margin-bottom: 15px;
  margin: 5px 5px;
}
</style>