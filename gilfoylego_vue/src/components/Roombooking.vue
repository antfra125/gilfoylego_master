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
      comfortLvl: ["All Inclusive","Helpension", "Halvpension"],
      roomtypes: ["Enkelrum", "Dubbelrum", "Familjerum"],
      show: true,
      rooms: []
    };
  },
  methods: {
    add_roombooking() {
      let formdata = this.$store.state.form;
      console.log("formdata.search = ",formdata.search)
      let current = this.$store.state.currentRoombooking;
      
      console.log("currentRoombooking från store: ", current)

      //JAG BYGGER ETT OBJEKT som ser ut som en room_booking

      //hitta det billigaste hotellet i this.rooms med rätt typ
     

      let cheapestRoom = {id:0,price:99999999}
      console.log("current selected roomtype: " +current.roomtype +  " price: "+current.price)
      for(let r of this.rooms){
        console.log("roomtype: "+r.roomtype +" price: "+r.price)
        if(r.price<cheapestRoom.price && r.roomtype == current.roomtype)
        {
          cheapestRoom.id= r.id
          cheapestRoom.price= r.price
        }
      }
      console.log("cheapest after: ",cheapestRoom.price)
      
      let roombookingObj = {
        room: cheapestRoom.id,
        hotel: "ONE HOTEL",
        roomtype: current.roomtype,
        price: cheapestRoom.price,
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


        //TODO spara bokningen till store när den är klar
        //this.$store.commit('ADD_ROOMBOOKING', currentRoombooking)

        //rensa currentRoombooking
      }
      //TODO
    },
    getRooms: async function() {
      let path = Number(this.hotelId)
      let result = await fetch("http://localhost:8090/rest/room/hotelrooms/"+path);
      this.rooms = await result.json();
      console.log("laddat in alla rum som det aktiva hotellet har",this.rooms);
      

    }
  },
  created() {

  },
  mounted() {
    this.getRooms()
  },
  
    computed: {
      form:{
        get() {
          return this.$store.state.form
        }
      },

      currentRoombooking: {
      get() {
        return this.$store.state.currentRoombooking;
      },
      set(value) {
        console.log("computed: roombooking: set(value) KOLLA!!");
        this.$store.commit("SET_ROOMBOOKING", value);
      }
    }
  },
  props: {
    hotelId: Number
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