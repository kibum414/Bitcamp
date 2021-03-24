import Vue from 'vue'
import Vuex from 'vuex'
// import axios from 'axios'

// mapState boards가 이것과 import
// action으로 가져오는 것
import state from './states'
import actions from './actions'
import mutations from './mutations'
import getters from './getters'

Vue.use(Vuex)

export default new Vuex.Store({
  state,
  actions,
  mutations,
  getters
})

/*
mutations : 스레드로 동작 -> 동기 보장
actions: 비동기 처리 -> commit 동기 처리
*/