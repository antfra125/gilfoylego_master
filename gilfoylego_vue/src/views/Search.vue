<template>
  <div class="d-flex justify-content-center">
    <div>
      <div class="container">
        <div class="row form-group d-flex justify-content-center input-group mt-auto">
          <input type="text" class="form-control" placeholder="Hotell, stad eller land">
          <div class="input-group-append">
            <button class="form-control custom-search-button"><img class="pb-1" src="../images/search.png"></button>
          </div>
        </div>
        <div class="row form-group d-flex justify-content-between">
          <div class="col-6">
            <div class="row">
              Från
            </div>
            <div class="row">
              <input type="date" class="form-control" min="2020-07-01" max="2020-08-30">
            </div>
          </div>
          <div class="col-6">
            <div class="row d-flex justify-content-end">
              Till
            </div>
            <div class="row">
              <input type="date" class="form-control" min="2020-07-02" max="2020-08-31">
            </div>
          </div>
        </div>
        <div class="row form-group d-flex justify-content-center">
          <input type="number" class="form-control" min="1" placeholder="Antal rum">
        </div>
        <div class="row d-flex justify-content-center">
            <div class="column p-1">
            </div>
          </div>
          <div class="row form-group sort d-flex justify-content-between">
            <span class="column">Sortera efter:</span>
            <span class="column"><img src="../images/sort.png"> Pris</span>
            <span class="column"><img src="../images/sort.png"> Omdömde</span>
        </div>
        <div class="row">
            Filter:
        </div>
        <div class="row d-flex justify-content-between">
            <div class="column">
              <input type="checkbox"> Pool
            </div>
            <div class="column">
            <input type="checkbox"> Barnklubb
            </div>
        </div>
        <div class="row form-group d-flex justify-content-between">
            <div class="column">
              <input type="checkbox"> Kvällsunderhållning
            </div>
            <div class="column">
            <input type="checkbox"> Restaurang
            </div>
        </div>
        <div class="row form-group">
          <input type="number" class="form-control" min="0" placeholder="Maxavstånd till strand">
        </div>
        <div class="row">
          <input type="number" class="form-control" min="0" placeholder="Maxavstånd till centrum">
        </div>
      </div>
      <div class="container pt-5" v-for="hotel in hotels" :key="hotel.id">
      <router-link to="/hoteldescription">
        <div class="row result">
          <div class="col-4 pic-col">
            <img src="../images/ex.jpg">
          </div>
          <div class="col-8 pl-4">
            <div class="row">
              <strong>{{hotel.name}}</strong>
            </div>
            <div class="row">
              Omdöme: {{hotel.rating}}
            </div>
            <div class="row">
              <p v-if="hotel.metersToBeach < 1000">Avstånd till stranden: {{hotel.metersToBeach}} m</p>
              <p v-if="hotel.metersToBeach > 1000">Avstånd till stranden: {{hotel.metersToBeach / 1000}} km</p>
            </div>
            <div class="row">
              <p v-if="hotel.metersToCityCenter < 1000">Avstånd till stranden: {{hotel.metersToCityCenter}} m</p>
              <p v-if="hotel.metersToCityCenter > 1000">Avstånd till stranden: {{hotel.metersToCityCenter / 1000}} km</p>
            </div>
            <div class="row d-flex justify-content-end">
              Från ?kr
            </div>
          </div>
        </div>
      </router-link>
      </div>
    </div>
  </div>
  
</template>

<script>
export default {
    data() {
      return {
        show: true,
        hotels: []
      }
    },
    mounted() {
      this.getHotels();
    },
    methods: {
      getHotels: async function() {
        let result = await fetch('http://localhost:8080/rest/hotel');
        this.hotels = await result.json();
      }
    }
  }
</script>