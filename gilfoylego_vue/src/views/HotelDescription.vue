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


  <Roombooking :hotelId="hotel.id"/>
  </section>
</template>

<script>
import Roombooking from "@/components/Roombooking.vue";
export default {
  name: "HotelDescription",
  components:{
    Roombooking
  },
    data() {
      return {
        show: true,
        hotel: []
      }
    },
    created() {
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
        let result = await fetch('http://localhost:8090/rest/hotel/'+this.$route.params.id)
        this.hotel = await result.json()
        console.log(this.hotel)
      }
    }
  };
</script>
<style scoped>
.HotelDescription{
  display:grid;
  justify-content: center;
}

img{
  position:static;
  
}
</style>