import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import vuetify from './plugins/vuetify';

Vue.config.productionTip = false

new Vue({
  router,
  store,
  vuetify,
  render: h => h(App)
}).$mount('#app')

/*
store = vuex
Vue에서 state 관리를 하기 위해 도입한 전역 객체
자바스크립트는 멀티 스레드, 이것도 멀티 스레드
멀티 스레드인 상태에서 전역으로 존재하는 객체 => critical section
전역적인 것을 관리하기 위해서 critical section을 컨트롤할 무언가가 필요
state : critical section이 되는 변수들이 배치된 영역
action : 비동기 처리하는 영역(이게 돌다 저게 돌 수 있고 저게 돌다 그게 돌 수 있는)

데이터 처리 자체만큼은, critical section에 접근하는 녀석 자체는
반드시 안정적인 처리를 보장해야 함
mutation : 데이터를 처리하는 부분. critical section에 접근하는 녀석
mutation에 데이터를 넣는 것은 방해받지 않음
=> 번거롭더라도 action에서 commit을 해서 mutation으로 넘기는 이유임
왜냐하면 데이터가 공유되어서 방해를 받아버리면 DB 오염 => 대형 사고
*/