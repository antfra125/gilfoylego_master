<template>
  <div>
    <b-form @submit="onSubmit" v-if="show">
      <div class="row d-flex justify-content-center form-group">
        <div class="col p-0">
          <b-form-input
            type="text"
            v-model="form.search"
            required
            placeholder="Hotell, stad eller land"
          ></b-form-input>
        </div>
        <div class="col-auto p-0">
          <button class="form-control custom-search-button">
            <img class="pb-1" src="../images/search.png" />
          </button>
        </div>
      </div>
      <div class="row form-group d-flex justify-content-between">
        <div class="col-6">
          <div class="row">Från</div>
          <div class="row">
            <b-form-datepicker
              v-model="form.startDate"
              :default="sMin"
              :min="sMin"
              :max="sMax"
              placeholder="Från"
            ></b-form-datepicker>
          </div>
        </div>
        <div class="col-6">
          <div class="row d-flex justify-content-end">Till</div>
          <div class="row">
            <b-form-datepicker v-model="form.endDate" :min="eMin" :max="eMax" placeholder="Till"></b-form-datepicker>
          </div>
        </div>
      </div>
      <div class="row form-group d-flex justify-content-center">
        <b-form-input
          type="number"
          min="1"
          v-model="form.amountOfRooms"
          required
          placeholder="Antal rum"
        ></b-form-input>
      </div>
      <div class="row form-group sort d-flex justify-content-between">
        <span class="column">Sortera efter:</span>
        <span class="column">
          <img src="../images/sort.png" /> Pris
        </span>
        <span class="column">
          <img src="../images/sort.png" /> Omdömde
        </span>
      </div>
      <div class="row">Filter:</div>
      <b-form-checkbox-group v-model="form.amenities">
        <div class="row d-flex justify-content-between">
          <div class="column">
            <b-form-checkbox value="pool">Pool</b-form-checkbox>
          </div>
          <div class="column">
            <b-form-checkbox value="eveningentertainment">Kvällsunderhållning</b-form-checkbox>
          </div>
        </div>
        <div class="row form-group d-flex justify-content-between">
          <div class="column">
            <b-form-checkbox value="kidsclub">Barnklubb</b-form-checkbox>
          </div>
          <div class="column">
            <b-form-checkbox value="restaurant">Restaurang</b-form-checkbox>
          </div>
        </div>
      </b-form-checkbox-group>
      <div class="row form-group">
        <b-form-input
          type="number"
          min="0"
          v-model="form.m2Beach"
          placeholder="Maxavstånd till strand i meter"
        ></b-form-input>
      </div>
      <div class="row">
        <b-form-input
          type="number"
          min="0"
          v-model="form.m2Center"
          placeholder="Maxavstånd till centrum i meter"
        ></b-form-input>
        <div class="mt-3">
          <span>
            <router-link to="/search">
              <b-button>Sök</b-button>
            </router-link>
          </span>
          <span class="pl-2">
            <b-button type="reset">Töm</b-button>
          </span>
        </div>
      </div>
    </b-form>
  </div>
</template>


<script>

export default {
  name: "Search",
  components: {
  },
  data() {
    return {
      sMin: "2020-07-01",
      sMax: "2020-08-30",
      eMin: "2020-07-02",
      eMax: "2020-08-31",
      show: true,
      hotels: []
    };
  },
  mounted() {
    this.getHotels();
  },

  methods: {
    onSubmit(evt) {
      evt.preventDefault();
      alert(JSON.stringify(this.form));
    },
    getHotels: async function() {
      let result = await fetch("http://localhost:8090/rest/hotelview");
      this.hotels = await result.json();
      console.log(this.hotels);
    }
  },
  computed: {
    form: {
      get() {
        console.log("computed: forms: get() WOW!");
        return this.$store.state.form;
      },
      set(value) {
        console.log("computed: forms: set(value) KOLLA!!");
        this.$store.commit("SET_FORM", value);
      }
    }
  }
};
</script>