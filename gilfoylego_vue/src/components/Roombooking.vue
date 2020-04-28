<template>
  <main>
    <section class="mb-5">
      <!-- TODO HÄR VILL JAG ATT DET SKA SKRIVAS UT DATUMstart OCH DATUMend SOM FINNS SPARAT I STORE.STATE.FORM-->
    </section>
    <section class="mb-5">
      <h4 class="mb-4">Rum</h4>
       <section class="row ml-1 mb-3">
     <!--  TODO 

        <span v-if="form.roomtype == 'Enkelrum'">
        <p>799kr/natt</p>
      </span>
      <span v-if="form.roomtype == 'Dubbelrum'">
        <p>1299kr/natt</p>
      </span>
      <span v-if="form.roomtype == 'Familjerum'">
        <p>1699kr/natt</p>
      </span>
      -->
    </section>
      <b-form >
        <div class="row ml-1">
          <h5 class="mr-3">Rumstyp</h5>
          <b-form-select id="input-3" v-model="roomspecs.roomtype" :options="roomtypes" required></b-form-select>
        </div>

        <div class="row mt-3 ml-1">
          <h5 class="mr-3">Extrasäng</h5>
          <b-form-checkbox-group v-model="roomspecs.extrabed" id="checkboxes-4">
            <b-form-checkbox value="true"></b-form-checkbox>
          </b-form-checkbox-group>
        </div>

        <div class="row mt-3 ml-1">
          <h5 class="mr-3">Antal vuxna</h5>
          <b-form-input
            type="number"
            min="1"
            v-model="roomspecs.amountOfGrownUps"
            required
            placeholder="Antal vuxna"
          ></b-form-input>
        </div>

        <div class="row mt-3 ml-1">
          <h5 class="mr-3">Antal barn</h5>
          <b-form-input
            type="number"
            min="1"
            v-model="roomspecs.amountOfKids"
            required
            placeholder="Antal barn"
          ></b-form-input>
        </div>
        <b-button id="saveRoom" class="btn-lg btn-warning" v-on:click="add_roombooking">SPARA RUMMET</b-button>
        <router-link to="/bookingconfirmation">
          <b-button class="mt-3">Boka</b-button>
        </router-link>
      </b-form>
    </section>
    </main>
</template>

<script>
//let currentRoombooking = {}


export default {

  data(){
    return {
      formu: {},
      roomspecs: {
          amountOfGrownUps: '',
          amountOfKids: '',
          roomtype: 'Enkelrum',
          extrabed: []
        },
        roomtypes: ['Enkelrum', 'Dubbelrum', 'Familjerum'],
        formdata: this.$store.state.form,
      show: true
    }
    
  
  },
  methods:{
    add_roombooking(){

      //TODO
      let formdata = this.$store.state.form
      console.log("taget från state.form: ",formdata)
      let roombookingObj = formdata.startDate + formdata.endDate + formdata.amountOfRooms;
        
        console.log(roombookingObj)
      console.log("ok")
      if(formdata.startDate == "" || formdata.endDate == ""){
        console.log("neeee, error!! du måste välja datum ju")
       
      }
      else{
        // ta startdatum och slutdatum från store.state.form och släng ihop dom med roomspecs
        // 
        
        let roombookingObj = formdata.startDate + formdata.endDate;
        
        console.log(roombookingObj)

        //TODO spara bokningen till store när den är klar
      //this.$store.commit('ADD_ROOMBOOKING', currentRoombooking)
      }
      //TODO
    }
  },
  created(){
    let fulhemtadForm = "HOHOHO LOL"
    console.log(fulhemtadForm)
  },
  mounted(){
        
        console.log("laddar in från this.$store.state.form: ", this.$store.state.form)
        console.log("sparar till form")
  }

//   data() {
//         roombooking: {
//           adults = '',
//           amountOfKids: '',
//           roomtype: 'Enkelrum',
//           extrabed: []
//         },
//         roomtypes: ['Enkelrum', 'Dubbelrum', 'Familjerum'],
//         show: true,
// },
// props:
//
}
</script>