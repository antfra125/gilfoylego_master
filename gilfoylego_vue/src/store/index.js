import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    form: {
    search: '',
    startDate: '',
    endDate: '',
    amountOfRooms: '',
    amenities: [],
    m2Center: '',
    m2Beach: ''

  }
  },
  mutations: { 
    changeForm(state, value){
    state.form = value;
  }
  },
  actions: {
  },
  modules: {
  }
})
