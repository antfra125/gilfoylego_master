<template>
<div>
    <div class="container my-4 p-5 grey-border" v-for="hotel in filteredHotels" :key="hotel.id">
      <router-link to="/hoteldescription">
        <div class="row result">
          <div class="col-4 pic-col">
            <img :src="hotel.imgUrl">
          </div>
          <div class="col-8 pl-4">
            <div class="row smallhotelframe">
              <span><strong>{{hotel.name}}</strong></span>
            </div>
            <div class="row">
              <span><em>{{hotel.city}}, {{hotel.country}}</em></span>
            </div>
            <div class="row">
              <span>Omdöme: {{hotel.rating}}</span>
            </div>
            <div class="row">
              <span v-if="hotel.mToBeach < 1000">Avstånd till stranden: {{hotel.mToBeach}} m</span>
              <span v-if="hotel.mToBeach >= 1000">Avstånd till stranden: {{hotel.mToBeach / 1000}} km</span>
            </div>
            <div class="row">
              <span v-if="hotel.mToCity < 1000">Avstånd till centrum: {{hotel.mToCity}} m</span>
              <span v-if="hotel.mToCity >= 1000">Avstånd till centrum: {{hotel.mToCity / 1000}} km</span>
            </div>
            <div class="row d-flex justify-content-end pt-5">
              Från ?kr
            </div>
          </div>
        </div>
      </router-link>
      </div>
    </div>
</template>

<script>

export default {
    data() {
      return {
        hotels: []
      }
    },
    mounted() {
      this.getHotels();
    },
    methods: {
      getHotels: async function() {
        let result = await fetch('http://localhost:8090/rest/hotelview');
        this.hotels = await result.json();
      }
    },
    props: ['search', 'm2Center'],
  computed: {
  filteredHotels (){
      console.log(this.m2Center)
        if(this.m2Center != '') {
            return this.hotels.filter(hotel => {
            return hotel.name.toLowerCase().includes(this.search.toLowerCase()) && hotel.metersToCityCenter < this.m2Center  
        })
      }
      else {
        return this.hotels.filter(hotel => {
        return hotel.name.toLowerCase().includes(this.search.toLowerCase()) 
          || hotel.city.toLowerCase().includes(this.search.toLowerCase()) 
          || hotel.country.toLowerCase().includes(this.search.toLowerCase())
        })
      }
      }
    }
  }
</script>