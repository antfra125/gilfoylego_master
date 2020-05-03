<template>
  <main>
    <div v-if="this.$store.state.isLoggedIn">
      <section class="mb-5"></section>
      <section class="mb-5">
        <p>
          Bokning mellan
          <strong>{{form.startDate}}</strong> och
          <strong>{{form.endDate}}</strong>
        </p>
        <h4 class="mb-4">Rum</h4>
        <section class="row ml-1 mb-3"></section>
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
          <b-button id="saveRoom" class="btn mt-5" v-on:click="add_roombooking">Lägg till rum</b-button>
          <router-link v-on:click="add_roombooking" to="/bookingconfirmation">
            <span v-if="bookedRooms>0">
              <b-button class="mt-5 ml-5 btn-success">
                Boka di
                <span v-if="bookedRooms===1">tt</span>
                <span v-else>na {{this.bookedRooms}}</span> rum
              </b-button>
            </span>
          </router-link>
          <router-link to="/search">
            <b-button class="btn ml-5 mt-5">Gå tillbaka</b-button>
          </router-link>
        </b-form>
      </section>
    </div>
    <div v-else>
      <p>
        <router-link to="/login">Logga in</router-link>för att boka
      </p>
    </div>
  </main>
</template>

<script>
//let currentRoombooking = {}

export default {
  data() {
    return {
      bookedRooms: 0,
      index: 0,
      comfortLvl: ["All Inclusive", "Helpension", "Halvpension"],
      roomtypes: ["Enkelrum", "Dubbelrum", "Familjerum"],
      show: true,
      rooms: []
    };
  },
  methods: {
    find_cheapest_room() {},
    calculate_days_staying(dIn, dOut) {
      let datein = new Date(dIn);
      let dateout = new Date(dOut);
      return Math.floor(
        (Date.UTC(
          dateout.getFullYear(),
          dateout.getMonth(),
          dateout.getDate()
        ) -
          Date.UTC(datein.getFullYear(), datein.getMonth(), datein.getDate())) /
          (1000 * 60 * 60 * 24)
      );
    },
    add_roombooking() {
      let formdata = this.$store.state.form;
      if (formdata === null) {
        //formdata.startDate == "" || formdata.endDate == "") {
        console.log("neeee, error!! du måste välja datum ju");
      } else {
        let current = this.$store.state.currentRoombooking;

        let cheapestRoom = { id: 0 };
        if (current.roomtype === undefined) {
          current.roomtype = "Enkelrum";
        }
        //for(let i = 0, i< this.rooms.length())

        let x = 999999;
        for (let r of this.rooms) {
          console.log("Inne i loopen");
          console.log("r ser ut såhär: ", r);
          //r har inte rumstyp i sig. detta är problematiskt

          if (r.price < x /*&& r.roomtype == current.roomtype*/) {
            console.log("inne i rumstypscheckern");
            x = r.price;
            cheapestRoom.id = r.id;
          }
        }

        let datediff = this.calculate_days_staying(
          formdata.startDate,
          formdata.endDate
        );

        console.log("datediff: ", datediff);

        /*borttagna element som kan vara bra att ha till v-for loopen sen
          index: this.index,
          hotel: "ONE HOTEL",
          roomtype: current.roomtype,
         * cheapestRoom.price * datediff
         * 
         */
        if (current.comfortLvl == undefined) {
          current.comfortLvl = "All Inclusive";
        }
        console.log("priset innan(per natt): ", x);
        let price =
          x === 999999
            ? 666
            : (x +
                ((current.extrabed ? 200 : 0) +
                  (current.comfortLvl == "All Inclusive" ? 500 : 0) +
                  (current.comfortLvl == "Helpension" ? 300 : 0) +
                  (current.comfortLvl == "Halvpension" ? 150 : 0))) *
              datediff;

        console.log("priset att spara(totalen med tilllägg): ", price);
        let roombookingObj = {
          // TODO kanske att en kan välja rum
          room: this.rooms[0],
          price: price,
          dateCheckin: formdata.startDate,
          dateCheckout: formdata.endDate,
          extrabed: current.extrabed ? true : false,
          allInclusive: current.comfortLvl == "All Inclusive" ? true : false,
          fullPension: current.comfortLvl == "Helpension" ? true : false,
          halfPension: current.comfortLvl == "Halvpension" ? true : false,
          adults: current.adults == null ? 1 : Number(current.adults),
          children: current.kids == null ? 0 : Number(current.kids)
        };

        this.index++;
        this.bookedRooms++;
        console.log(
          "färdigt rumsbokningsobjekt, redo att sparas: ",
          roombookingObj
        );
        this.$store.commit("ADD_ROOMBOOKING", roombookingObj);
        //  this.$store.dispatch("addRoombooking", roombookingObj);
        //TODO spara bokningen till store när den är klar
        //this.$store.commit('ADD_ROOMBOOKING', currentRoombooking)

        //rensa currentRoombooking
      }
    },
    postBooking: async function() {},
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
      get() {
        return this.$store.state.roombookings;
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