import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import vuetify from './plugins/vuetify';

Vue.config.productionTip = false

new Vue({
  // 뷰 객체가 담고 있음
  router,
  // store가 vuex
  // vue에서 state 관리를 하기 위해 도입한 전역 객체
  // 자바스크립트는 멀티 스레드.
  // 이것도 멀티 스레드
  // 멀티 스레드인 상태에서 전역으로 존재하는 객체
  // critical section
  // 이것을 관리하기 위한 것
  // actions 비동기처리하는 것
  // 데이터 처리 만큼은(critical section에 접근하는 것 만큼은)
  store,
  vuetify,
  render: h => h(App)
}).$mount('#app')
