<template>
  <main>
    <section class="mb-5">
      

      <!-- TODO HÄR VILL JAG ATT DET SKA SKRIVAS UT DATUMstart OCH DATUMend SOM FINNS SPARAT I STORE.STATE.FORM-->
    </section>
    <section class="mb-5">
      <p>Bokning mellan <strong>{{form.startDate}}</strong> och <strong>{{form.endDate}}</strong></p>
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
      <b-form>
        <div class="row ml-1">
          <h5 class="mr-3">Rumstyp</h5>
          <b-form-select id="input-3" v-model="currentRoombooking.roomtype" :options="roomtypes" required></b-form-select>
        </div>
          <div class="row ml-1">
          <h5 class="mr-3">Bekvämlighetsnivå</h5>
          <b-form-select id="input-3" v-model="currentRoombooking.comfortLvl" :options="comfortLvl" required></b-form-select>
        </div>

        <div class="row mt-3 ml-1">
          <h5 class="mr-3">Extrasäng</h5>
            <b-form-checkbox v-model="currentRoombooking.extrabed" id="checkboxes-4"></b-form-checkbox>
        </div>

        <div class="row mt-3 ml-1">
          <h5 class="mr-3">Antal vuxna</h5>
          <b-form-input
            type="number"
            min="1"
            max="4"
            v-model="currentRoombooking.adults"
            required
            placeholder="Antal vuxna"
          ></b-form-input>
        </div>

        <div class="row mt-3 ml-1">
          <h5 class="mr-3">Antal barn</h5>
          <b-form-input
            type="number"
            min="0"
            max="4"
            v-model="currentRoombooking.kids"
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
  data() {
    return {
      //formu: {},
      blabla: {
        amountOfGrownUps: "",
        amountOfKids: "",
        roomtype: "Enkelrum",
        extrabed: []
      },
      comfortLvl: ["All Inclusive","Helpension", "Halvpension"],
      roomtypes: ["Enkelrum", "Dubbelrum", "Familjerum"],

      show: true
    };
  },
  methods: {
    add_roombooking() {
      let formdata = this.$store.state.form;
      console.log("formdata.search = ",formdata.search)
      let current = this.$store.state.currentRoombooking;
      console.log("currentRoombooking från store: ", current)

      //JAG BYGGER ETT OBJEKT som ser ut som en room_booking

      
      let roombookingObj = {
        room: 200,
        hotel: "ETT HOTELNAMN",
        roomtype: "EN RUMSTYP",
        price: 10000,
        dateCheckin: formdata.startDate,
        dateCheckout: formdata.endDate,
        extrabed: current.extrabed ? true : false,
        allInclusive: current.comfortLvl == "All Inclusive" ? true : false,
        fullPension: current.comfortLvl == "Helpension" ? true : false,
        halfPension: current.comfortLvl == "Halvpension" ? true : false,
        adults: current.adults,
        children: current.kids
      }
      console.log("RBOOOO", roombookingObj)


      console.log("ok");
      if (formdata.startDate == "" || formdata.endDate == "") {
        console.log("neeee, error!! du måste välja datum ju");
      } else {
        // ta startdatum och slutdatum från store.state.form och släng ihop dom med currentRoombooking
        //


        //TODO spara bokningen till store när den är klar
        //this.$store.commit('ADD_ROOMBOOKING', currentRoombooking)

        //rensa currentRoombooking
      }
      //TODO
    }
  },
  created() {

  },
  mounted() {
    console.log(
      "laddar in från this.$store.state.form: ",
      this.$store.state.form
    );
  },
    computed: {
      form:{
        get() {
          return this.$store.state.form
        }
      },

      currentRoombooking: {
      get() {
        console.log("computed: roombooking: get() WOW!");
        return this.$store.state.currentRoombooking;
      },
      set(value) {
        console.log("computed: roombooking: set(value) KOLLA!!");
        this.$store.commit("SET_ROOMBOOKING", value);
      }
    }
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
};
</script>