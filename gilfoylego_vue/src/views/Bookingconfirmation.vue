<style scoped>
.roomloop{
  display:table;
  align-content: center;
  align-items:center;
}
</style>

<template>
  <section class="container">
    <section v-show="!showConfirmation">
      <h3 class="row ml-1 mb-4">Bekräfta bokning</h3>
      
      <div v-if="roombookings.length>0">
        <section class="row">
          <ul class="roomloop" v-for="room in roombookings" :key="room.id">
            <li>
              <div>Rumsnummer: {{room.room.id}} </div>
              <div>Pris/natt: {{room.room.price}} kr</div>
            </li>
          </ul>
        </section>
        <section><h3>Totalsumma: {{this.sum}}</h3></section>
    

        <section class="row mt-5 mb-5">
          <div class="col-6">
            <router-link to="/">
              <button type="button" class="btn btn-secondary">Avbryt bokning</button>
            </router-link>
          </div>
          <div class="col-6">
            <button
              v-on:click="purchaseConfirmed()"
              id="confirmed"
              type="button"
              class="btn btn-success">
              Bekräfta bokning
            </button>
          </div>
        </section>
      </div>
      <div v-else>Du har inga rum bokade (⊙_⊙)？ Hur kom du hit??
        <div>
          <router-link to ="/">
            <b-button default="none" class="btn">Till Startsidan</b-button>
          </router-link>
        </div>
      </div>
      </section>
      <section class="mt-5" v-if="showConfirmation">
        <div class="row">
          <h3>Tack för din bokning hos oss, vi hoppas på att du har en trevlig resa!</h3>
        </div>
        <div class="row mt-3">
          <router-link to="/"><button class="btn btn-success">Startsida</button></router-link>
        </div>
      </section>
    
  </section>
</template>


<script>
export default {
  data() {
    return {
      sum: 0,
      roombookings: [],
      showConfirmation: false
    };
  },
  methods: {
    purchaseConfirmed(){
      

        this.postBookingAndRoombookings();
        this.$store.dispatch('clearRoombookings')
        this.$store.dispatch('clearCurrentRoombooking')
        this.$store.dispatch('getFormdata')
        this.showConfirmation = true;
    },
    async postBookingAndRoombookings(){
      //hämta active user
      let booking = {
        user: this.$store.state.user
      }
      await fetch('rest/booking',{
        method: "POST",
        headers: { 'Content-Type': 'application/json' },
        // TODO var hittar jag aktiv user - id
        body: JSON.stringify(booking)
      })
      //autogenereras
      let response = await fetch('rest/booking/last')
     
      let bookingobject = await response.json()
       console.log("bookingobject: ",bookingobject)//hämta bookingobject
      //let bookingobject = response

      this.$store.state.roombookings.forEach(rb => {
        rb.booking = bookingobject
        console.log("HAR DEN ETT bookingobject?: ",rb)
         this.postRoombooking(rb)
      });

    },
    
    async postRoombooking(roombooking){
      await fetch('rest/roombooking',{
        method: "POST",
        headers: {'Content-Type': 'application/json'},
      body: JSON.stringify(roombooking)}
      )
      console.log("POSTAT I ROOMBOOKING!??")
    },
    changeToConfirmation() {
      this.showconfirmation = true;
     },
      getRoombookings: function(){
        this.roombookings = this.$store.state.roombookings
      },
      calculateSum: function(){
        
        for(let r of this.roombookings){
          this.sum+=r.room.price
        }
      }

  },
  mounted() {
    this.getRoombookings()
    this.calculateSum()
      }
    
  
}


/*$(document).ready(function() {
        $('#confirmed').on('click', function() {
            $('#thankYouConfirmation').show();
            $('#confirmMe').hide();
        });
    });*/
</script>