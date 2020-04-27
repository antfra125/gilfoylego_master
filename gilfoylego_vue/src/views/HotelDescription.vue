<template>
  <section class="container HotelDescription">
    <section class="row d-flex mb-1 mt-4 top-section">
      <img class="col-4 d-flex" :src="hotel.imgUrl" />
      <span class="col-6 ml-5" id="thisIsTheDescription">
        <div class="row">
          <strong>{{hotel.name}}</strong>
        </div>
        <div class="row">
          Omdöme: {{hotel.rating}}
        </div>
        <div class="row">
          {{hotel.description}}
        </div>
      </span>
    </section>
    <section class="row ml-1 mb-3">
      <span v-if="form.roomtype == 'Enkelrum'">
        <p>799kr/natt</p>
      </span>
      <span v-if="form.roomtype == 'Dubbelrum'">
        <p>1299kr/natt</p>
      </span>
      <span v-if="form.roomtype == 'Familjerum'">
        <p>1699kr/natt</p>
      </span>
    </section>

    <section class="row">
      <div class="col extra">
        <img class="pr-2" src="../images/v.png" v-if="hotel.hasPool">
        <img class="pr-2" src="../images/x.png" v-if="!hotel.hasPool">
        <label for="Pool">Pool</label>
      </div>
      <div class="col extra">
        <img class="pr-2" src="../images/v.png" v-if="hotel.hasKidsClub">
        <img class="pr-2" src="../images/x.png" v-if="!hotel.hasKidsClub">
        <label for="KidsClubs">Barnklubb</label>
      </div>
    </section>

    <section class="row mb-3">
      <div class="col extra">
        <img class="pr-2" src="../images/v.png" v-if="hotel.hasRestaurant">
        <img class="pr-2" src="../images/x.png" v-if="!hotel.hasRestaurant">
        <label for="Resturant">Resturang</label>
      </div>
      <div class="col extra">
        <img class="pr-2" src="../images/v.png" v-if="hotel.hasEveningEntertainment">
        <img class="pr-2" src="../images/x.png" v-if="!hotel.hasEveningEntertainment">
        <label for="Entertaiment">Kvällsunderhållning</label>
      </div>
    </section>

    <section class="row ml-4 mb-2">
      <div>
        <p v-if="hotel.metersToBeach < 1000">Avstånd till stranden: {{hotel.metersToBeach}} m</p>
        <p v-if="hotel.metersToBeach > 1000">Avstånd till stranden: {{hotel.metersToBeach / 1000}} km</p>
        <p v-if="hotel.metersToCityCenter < 1000">Avstånd till centrum: {{hotel.metersToCityCenter}} m</p>
        <p v-if="hotel.metersToCityCenter > 1000">Avstånd till centrum: {{hotel.metersToCityCenter / 1000}} km</p>
      </div>
    </section>

    <section class="mb-5">
      <h4 class="mb-4">Rum</h4>
      <b-form @submit="onSubmit" @reset="onReset" v-if="show">
        <div class="row ml-1">
          <h5 class="mr-3">Rumstyp</h5>
          <b-form-select id="input-3" v-model="form.roomtype" :options="roomtypes" required></b-form-select>
        </div>

        <div class="row mt-3 ml-1">
          <h5 class="mr-3">Extrasäng</h5>
          <b-form-checkbox-group v-model="form.extrabed" id="checkboxes-4">
            <b-form-checkbox value="true"></b-form-checkbox>
          </b-form-checkbox-group>
        </div>

        <div class="row mt-3 ml-1">
          <h5 class="mr-3">Antal vuxna</h5>
          <b-form-input
            type="number"
            min="1"
            v-model="form.amountOfGrownUps"
            required
            placeholder="Antal vuxna"
          ></b-form-input>
        </div>

        <div class="row mt-3 ml-1">
          <h5 class="mr-3">Antal barn</h5>
          <b-form-input
            type="number"
            min="1"
            v-model="form.amountOfKids"
            required
            placeholder="Antal barn"
          ></b-form-input>
        </div>
        <router-link to="/bookingconfirmation">
          <b-button class="mt-3">Boka</b-button>
        </router-link>
      </b-form>
    </section>
  </section>
</template>

<script>
export default {
    data() {
      return {
        form: {
          amountOfGrownUps: '',
          amountOfKids: '',
          roomtype: 'Enkelrum',
          extrabed: []
        },
        roomtypes: ['Enkelrum', 'Dubbelrum', 'Familjerum'],
        show: true,
        hotel: []
      }
    },
    mounted() {
      this.getHotel();
    },
    methods: {
      onSubmit(evt) {
        evt.preventDefault()
        alert(JSON.stringify(this.form))
      },
      onReset(evt) {
        evt.preventDefault()
        this.form.amountOfGrownUps = ''
        this.form.amountOfKids = ''
        this.form.roomtype = 'Enkelrum'
        this.form.extrabed = []
        this.show = false
        this.$nextTick(() => {
          this.show = true
        })
      },
      getHotel: async function() {
        let result = await fetch('http://localhost:8090/rest/hotel/1');
        this.hotel = await result.json();
        console.log(this.hotel)
      }
    }
  };
</script>