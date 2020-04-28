<template>
  <div class="d-flex justify-content-center">
    <div class="container">
      <div class="row form-group d-flex justify-content-center mt-auto">
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
              <button class="form-control custom-search-button"><img class="pb-1" src="../images/search.png"></button>
            </div>
          </div>
          <div class="row form-group d-flex justify-content-between">
            <div class="col-6">
              <div class="row">
                Från
              </div>
              <div class="row">
                <b-form-datepicker v-model="form.startDate" :min="sMin" :max="sMax" placeholder="Från"></b-form-datepicker>
              </div>
            </div>
            <div class="col-6">
              <div class="row d-flex justify-content-end">
                Till
              </div>
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
            <span class="column"><img src="../images/sort.png"> Pris</span>
            <span class="column"><img src="../images/sort.png"> Omdömde</span>
          </div>
          <div class="row">
            Filter:
          </div>
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
          </div>
          <div>
            <HotelResult :search="form.search" :m2Center="form.m2Center"/>
          </div>
        </b-form>
      </div>
    </div>
  </div>
</template>

<script>
import HotelResult from '@/components/HotelResult.vue'

export default {
  name: 'Search',
  components: {
    HotelResult
  },
  data() {
    return {
      sMin: '2020-07-01',
      sMax: '2020-08-30',
      eMin: '2020-07-02',
      eMax: '2020-08-31',
      form: {
        search: '',
        startDate: '',
        endDate: '',
        amountOfRooms: '',
        amenities: [],
        m2Center: ''
      },
      show: true,
      hotels: []
    }
  },
    mounted() {
      this.getHotels();
    },
    methods: {
      onSubmit(evt) {
        evt.preventDefault()
        alert(JSON.stringify(this.form))
      },
      getHotels: async function() {
        let result = await fetch('http://localhost:8090/rest/hotelview');
        this.hotels = await result.json();
        console.log(this.hotels)
      }
    },
  computed: {
    filteredHotels (){
      return this.hotels.filter(hotel => {
        return hotel.name.toLowerCase().includes(this.search.toLowerCase())
      })
    }
  }
}
</script>