<template>
  <main>
    <section class="mb-5">
      <!-- TODO HÄR VILL JAG ATT DET SKA SKRIVAS UT DATUMstart OCH DATUMend SOM FINNS SPARAT I STORE.STATE.FORM-->
    </section>
    <section class="mb-5">
      <p>
        Bokning mellan
        <strong>{{form.startDate}}</strong> och
        <strong>{{form.endDate}}</strong>
      </p>
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
          <b-form-select
            id="input-3"
            v-model="currentRoombooking.roomtype"
            :options="roomtypes"
            required
          ></b-form-select>
        </div>
        <div class="row ml-1">
          <h5 class="mr-3">Bekvämlighetsnivå</h5>
          <b-form-select
            id="input-4"
            v-model="currentRoombooking.comfortLvl"
            :options="comfortLvl"
            value="All Inclusive"
            required
          ></b-form-select>
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
        <b-button id="saveRoom" class="btn-lg btn-success" v-on:click="add_roombooking">SPARA RUMMET</b-button>
        <router-link v-on:click="add_roombooking" to="/bookingconfirmation">
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
      index: 0,
      comfortLvl: ["All Inclusive", "Helpension", "Halvpension"],
      roomtypes: ["Enkelrum", "Dubbelrum", "Familjerum"],
      show: true,
      rooms: []
    };
  },
  methods: {
    find_cheapest_room(){
        
    },
    calculate_days_staying(dIn, dOut){
      let datein = new Date(dIn);
      let dateout = new Date(dOut);
      return Math.floor(
          (Date.UTC(dateout.getFullYear(), dateout.getMonth(), dateout.getDate()) -
            Date.UTC(datein.getFullYear(), datein.getMonth(), datein.getDate())) /
            (1000 * 60 * 60 * 24)
        );
    },
    add_roombooking() {
      let formdata = this.$store.state.form;
      if (formdata.startDate == "" || formdata.endDate == "") {
        console.log("neeee, error!! du måste välja datum ju");
      } else {
        let current = this.$store.state.currentRoombooking;

        //JAG BYGGER ETT OBJEKT som ser ut som en room_booking

        let cheapestRoom = {id: 0}
        console.log(
          "current selected roomtype: " +
            current.roomtype +
            " price: " +
            current.price
        );
        console.log(this.rooms.length);
        //for(let i = 0, i< this.rooms.length())

        let x = 999999;
        for (let r of this.rooms) {
          //console.log("roomtype: " + r.roomtype.name + " price: " + r.price);

          if (r.price < x /*&& r.roomtype.name == current.roomtype*/) {
             console.log("PRINTAR r FRÅN LOOPEN: ",r)
             x = r.price
             cheapestRoom.id = r.id;
           
          }
        }
        //let i = cheapestRoom.id;
        // console.log("141. this.rooms[0]: ",this.rooms[0])
        // console.log("142. this.rooms[cheapestRoom.id]: ", this.rooms[cheapestRoom.id])
        // console.log("142. this.rooms[i]: ")
        // let a = this.rooms[cheapestRoom.id];
        // console.log("A BORDE VARA ETT RUM, ÄR DET DET? :",a)
        
        //console.log("cheapest after: ", cheapestRoom.price);
        //console.log("ÄR DETTA ETT RUMSOBJEKT MED ID? ",cheapestRoom)


      let datediff = this.calculate_days_staying(formdata.startDate, formdata.endDate)
        
        

        console.log("datediff: ", datediff);

        /**borttagna element som kan vara bra att ha till v-for loopen sen
          index: this.index,
          hotel: "ONE HOTEL",
          roomtype: current.roomtype,
         * cheapestRoom.price * datediff
         * 
         */
          // TODO kanske att en kan välja rum 
        let roombookingObj = {
          room: this.rooms[0],
          price: 666,
          dateCheckin: formdata.startDate,
          dateCheckout: formdata.endDate,
          extrabed: current.extrabed ? true : false,
          allInclusive: current.comfortLvl == "All Inclusive" ? true : false,
          fullPension: current.comfortLvl == "Helpension" ? true : false,
          halfPension: current.comfortLvl == "Halvpension" ? true : false,
          adults: current.adults == null ? 1 : Number(current.adults),
          children: current.kids == null ? 0 : Number(current.kids)
        };
        this.index++
        console.log(
          "färdigt rumsbokningsobjekt, redo att sparas.");
        this.$store.dispatch('addRoombooking',roombookingObj)
        //TODO spara bokningen till store när den är klar
        //this.$store.commit('ADD_ROOMBOOKING', currentRoombooking)

        //rensa currentRoombooking
      }
    
    },
    postBooking: async function() {

    },
    getRooms: async function() {
      //försökt skicka in hotelId så jävla länge nu. fuckit. det här funkar.
      let pathUrl = "";
      pathUrl = window.location.href.toString();
      console.log(pathUrl);
      let path = pathUrl.charAt(pathUrl.length - 1);
      console.log("pathen, borde vara en siffra: ", path);

      //let path = await Number(this.hotelId)
      let result = await fetch(
        "http://localhost:8090/rest/room/hotelrooms/" + Number(path)
      );
      this.rooms = await result.json();
      console.log("laddat in alla rum som det aktiva hotellet har", this.rooms);
    }
  },
  created() {},
  mounted() {
    this.getRooms();
  },

  computed: {
    form: {
      get() {
        return this.$store.state.form;
      }
    },
    roombookings: {
      get () {
        return this.$store.state.roombookings
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