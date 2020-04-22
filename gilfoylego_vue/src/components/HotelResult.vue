<template>
<div>
    <div class="container my-4 p-5 grey-border" v-for="hotel in filteredHotels" :key="hotel.id">
      <router-link to="/hoteldescription">
        <div class="row result">
          <div class="col-4 pic-col">
            <img :src="hotel.imgUrl">
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
              <p v-if="hotel.metersToCityCenter < 1000">Avstånd till centrum: {{hotel.metersToCityCenter}} m</p>
              <p v-if="hotel.metersToCityCenter > 1000">Avstånd till centrum: {{hotel.metersToCityCenter / 1000}} km</p>
            </div>
            <div class="row d-flex justify-content-end">
              Från ?kr
            </div>
          </div>
        </div>
      </router-link>
      </div>
    </div>
</template>