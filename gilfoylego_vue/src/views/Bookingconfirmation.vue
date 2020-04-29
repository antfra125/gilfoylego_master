<template>
  <section class="container">
    <section v-show="!showConfirmation">
      <h3 class="row ml-1 mb-4">Bekräfta bokning</h3>
      <div v-if="roombookings.length>0">
        <section class="row">
          <div v-for="room in roombookings" :key="room.id">
            <div>Rumsnummer: {{room.room}}</div>
     
     
            <h4>Grande Hotel</h4>
            <ul>
              <li class="mb-3">Avstånd till stranden:</li>
              <li class="mb-4">Avstånd till centrum:</li>
            </ul>
            <!-- Iterera över alla checkade boxar för hotelet(pool, underhållning osv) -->
            <div class="col extra ml-3 mb-2">
              <img class="pr-2" src="../images/v.png" />
              <label for="Pool">Pool (Insert/fetch data depending on hotel choice)</label>
            </div>  
          
            <section class="row mt-4">
              <!--Insert/fetch right choosen bedtype-->
              <label class="col-4 choice-bedtype">Rumstyp:</label>
              <!--Insert/fetch right amount of money for the choosen hotel, room, do the math (person + kids + roomtype) -->
              <label class="col-8 choice-bedtype">
              <!--Fetch and insert the -->
              kr för hela sällskapet under
              <!--{fetch and insert choosen nights here}-->
              </label>
            </section>



            <section class="row mt-3">
              <!--Insert/fetch right amount of individual('s)-->
              <label class="col-4 choice-amount-persons">Antal personer:</label>
              <!--Insert/fetch right amount of kids, if it's choosen to start with-->
              <label class="col-4 choice-amount-kids">Antal barn:</label>
            </section>



          </div>
      
        </section>

    

        <section class="row mt-5 mb-5">
          <div class="col-6">
            <router-link to="/hoteldescription">
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

      <section class="mt-5" v-if="showConfirmation">
        <div class="row">
          <h3>Tack för din bokning hos oss, vi hoppas på att du har en trevlig resa!</h3>
        </div>
        <div class="row mt-3">
          <router-link to="/"><button class="btn btn-success">Startsida</button></router-link>
        </div>
      </section>
    </section>
  </section>
</template>


<script>
export default {
  data() {
    return {
      roombookings: [],
      showConfirmation: false
    };
  },
  methods: {
    purchaseConfirmed(){
      

        this.postBookingAndRoombookings();
        // this.$store.dispatch('clearRoombookings')
        // this.$store.dispatch('clearCurrentRoombooking')
        // this.$store.dispatch('clearForm')
        // this.changeToConfirmation()
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
      }

  },
  mounted() {
    this.getRoombookings()
      }
    
  
}


/*$(document).ready(function() {
        $('#confirmed').on('click', function() {
            $('#thankYouConfirmation').show();
            $('#confirmMe').hide();
        });
    });*/
</script>