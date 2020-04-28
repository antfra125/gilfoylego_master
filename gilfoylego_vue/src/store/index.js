import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)
/** När du vill ha din kod i komponenten
    
    Så gör du du en commit (med data) till en mutation som sätter state.

    Du läser sedan tillbaks ifrån store via computed (getter)
 */
export default new Vuex.Store({
  state: {  
    user: {},
    isLoggedIn: false,    
    form: {}
  },
  mutations: {
    SET_FORM(state, payload) {
      
      console.log("state.form innan:",state.form)
      console.log("payload: ",payload)
      state.form = payload;
      console.log("state.form efter:",state.form)

      console.log("You set state.form to the value of the payload!")
    },
    setUser(state, value){
      state.user = value;
      console.log('Inloggad: ' + this.state.user)
    }
  },
  actions: {
    async getFormdata({ commit } ) {
      console.log("You made a dispatch through getFormdata!")
      let form =  {
        search: "",
        startDate: "",
        endDate: "",
        amountOfRooms: "",
        amenities: [],
        m2Center: "",
        m2Beach: ""
      }
      commit('SET_FORM', form)
    },
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
