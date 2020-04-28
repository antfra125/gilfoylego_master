import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    user: {},
    isLoggedIn: false,
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
    },
    setUser(state, value){
      state.user = value;
      console.log('Inloggad: ' + this.state.user)
    }
  },
  actions: {
    async isUserLoggedIn({ commit }){
      let response = await fetch('rest/activeuser')
      let response2 = await response.json()

      if(response2 == null){
        this.state.isLoggedIn = false;
      }
      else{
        this.state.isLoggedIn = true;
      }
     commit('setUser', response2)
    }
  },
  modules: {
  }
})
