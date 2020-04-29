<template>
  <section class="container">
    <section v-show="isConfirmationHidden">
      <h3 class="row ml-1 mb-4">Bekräfta bokning</h3>
      <section class="row">
        <img class="col-5" src="../images/hotel1.jpg" />
        <div class="col-7">
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
        </div>
      </section>

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
      <section class="row mt-5 mb-5">
        <div class="col-6">
          <router-link to="/search">
            <button type="button" class="btn btn-secondary">Avbryt bokning</button>
          </router-link>
        </div>
        <div class="col-6">
          <button
            v-on:click="showConfirmation()"
            id="confirmed"
            type="button"
            class="btn btn-success"
          >Bekräfta bokning</button>
        </div>
      </section>
    </section>

    <section class="mt-5" v-if="!isConfirmationHidden">
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
      isConfirmationHidden: true
    };
  },
  methods: {
    showConfirmation() {
      this.isConfirmationHidden = false;
    }
  }
};

/*$(document).ready(function() {
        $('#confirmed').on('click', function() {
            $('#thankYouConfirmation').show();
            $('#confirmMe').hide();
        });
    });*/
</script>