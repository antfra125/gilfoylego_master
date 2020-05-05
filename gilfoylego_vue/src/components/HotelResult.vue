<template>
  <div>
    <div class="container my-4 p-5 grey-border custom-link" v-for="hotel in filteredHotels" :key="hotel.id" v-on:click="resultLink(hotel)">
      <div class="row result w-100">
        <div class="col-sm-12 col-md-12 col-lg-4 pic-col">
          <img :src="hotel.imgUrl">
        </div>
        <div class="col-sm-12 col-md-12 col-lg-8 px-4">
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
              Från {{hotel.rooms[0].price}} kr
            </div>
        </div>
      </div>
    </div>
    <div class="container my-4 p-5 grey-border" v-show="filteredHotels.length == 0">
      <div class="row result w-100 d-flex justify-content-center">
        <h3>Inget hotell passade tyvärr dina krav!</h3>
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
    resultLink(hotel) {
      this.$router.push('hoteldescription/' + hotel.id);
    },
    getHotelAmenities (hotel) {
      return [hotel.eveningEntertainment, hotel.pool, hotel.kidsclub, hotel.restaurant]
    },
    getHotels: async function() {
      let result = await fetch('http://localhost:8090/rest/hotelview');
      this.$store.state.hotels = await result.json();
    }
  },
  props: {
    form: {},
    hotelId: String,
    search: String, 
    m2Center: String,
    dateStart: String,
    dateEnd: String
  },
  computed: {
    formAmenities () {
      return [this.$store.state.form.amenities.includes("eveningentertainment"), 
        this.$store.state.form.amenities.includes("pool"), 
        this.$store.state.form.amenities.includes("kidsclub"), 
        this.$store.state.form.amenities.includes("restaurant")]
    },
    filteredHotels: function() {
      let searchResult;

      searchResult = this.$store.state.hotels.filter(hotel => {
        return hotel.name.toLowerCase().includes(this.search.toLowerCase()) 
        || hotel.city.toLowerCase().includes(this.search.toLowerCase()) 
        || hotel.country.toLowerCase().includes(this.search.toLowerCase())
      })

      let fa = this.formAmenities
      searchResult = searchResult.filter(hotel => {
        let includeInResult = true
        for(let i=0;i < fa.length;i++){
          if(fa[i] && includeInResult){
            includeInResult = this.getHotelAmenities(hotel)[i]
          }
        }
        return includeInResult
      })

      if(this.$store.state.form.m2Beach > 0) {
          searchResult = searchResult.filter(hotel => hotel.mToBeach <= this.$store.state.form.m2Beach)
      }

      if(this.$store.state.form.m2Center > 0) {
        searchResult = searchResult.filter(hotel => hotel.mToCity <= this.$store.state.form.m2Center)
      }

      searchResult.forEach(hotel => {
        hotel.rooms.sort((a, b) => (a.price - b.price))
      });
        
      if (this.$store.state.sortByRatings) {
        let ascDesc = this.$store.state.sortASC ? 1 : -1;
        return searchResult.sort((a, b) => ascDesc * a.rating.toString().localeCompare(b.rating));
      }

      if (this.$store.state.sortByPrice) {
        let ascDesc = this.$store.state.sortASC ? 1 : -1;
        searchResult.sort((a, b) => {
          //let indexA = this.$store.state.sortASC ? 0 : a.rooms.length - 1
          //let indexB = this.$store.state.sortASC ? 0 : b.rooms.length - 1
          return ascDesc * (a.rooms[0].price - b.rooms[0].price)
        });
      }
        
      return searchResult
      }
    }
  }
</script>