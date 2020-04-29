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
    form: {},
    roombookings: [],
    currentRoombooking: {}
  },
  mutations: {
    SET_ROOMBOOKINGS(state, payload){
      state.roombookings = payload
    },
    ADD_ROOMBOOKING(state, payload){
      state.roombookings.push(payload)
      console.log("rumsbokningarna i store: ",state.roombookings)


    },
    SET_CURRENTROOMBOOKNG(state, payload){
      state.currentRoombooking = payload
    },
    
    REMOVE_ONE_ROOMBOOKING(state, payload){
      // TODO    är detta verkligen rimligt?
      try{
        state.roombookings = state.roombookings.splice(state.roombookings.indexOf(payload))     
      }catch (e){ console.log("ERROR, did not find the searched element in the array.")
    }
  },
    CLEAR_ROOMBOOKINGS(state){
      state.roombookings = []
      console.log("deleted all active roombookings. i hope you intended to do this.")

    }
    ,
    SET_FORM(state, payload) {
      
      console.log("state.form innan:",state.form)
      console.log("payload: ",payload)
      state.form = payload;
      console.log("state.form efter:",state.form)

      console.log("You set state.form to the value of the payload!")
    },

    SET_USER(state, value){
      state.user = value;
      console.log('Inloggad: ' + this.state.user)
    }
  },
  actions: {
    async addRoombooking({commit}, payload){
    console.log("adding a roombooking")

      commit('ADD_ROOMBOOKING',payload)
  },

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

      if(response == null){
        this.state.isLoggedIn = false;
      }
      else{
        this.state.isLoggedIn = true;
      }
     commit('SET_USER', response2)
    }
  },
  modules: {
  }
})
