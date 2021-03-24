import Vue from 'vue'
import Vuex from 'vuex'

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
Vuex : Actions - Mutations - States
Vue Components
       |
       | Dispatch
       V
    Actions --- Backend API
       |
       | Commit
       V
   Mutations --- Devtools
       |
       | Mutate
       V
     States
       |
       | Render
       V
Vue Components
*/