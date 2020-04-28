<template>
<div>
    <div class="container my-4 p-5 grey-border" v-for="hotel in filteredHotels" :key="hotel.id">
      
        <div class="row result">
          <div class="sm-col-12 md-col-12 lg-col-4 pic-col">
            <img :src="hotel.imgUrl">
          </div>
          <div class="sm-col-12 md-col-12 lg-col-8 pl-4">
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
            <router-link v-on:click="saveToStore()" :to="'/hoteldescription/'+hotel.id" > <button default=none class="btn-lg btn-warning" >Boka</button>
      </router-link>

            <div class="row d-flex justify-content-end pt-5">
              Från ?kr
            </div>
          </div>
        </div>
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
      // },
      //   //localStorage.setItem('formen', JSON.stringify(this.form));
      //   saveToStore(){
      //   console.log("saveToStore kördes!")
      //   this.$store.state.form = this.form ;
      //   alert("WOW! /HotelResult sparade till $store.state på ditt klick!")
      // }
    }
    },
    props: {
      form: {},
      hotelId: String,
      search: String, 
      m2Center: String
      }
    ,
  computed: {
    // form(){
    //   return this.$store.state.form
    // },

  filteredHotels (){
     
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