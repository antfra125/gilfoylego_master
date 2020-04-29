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