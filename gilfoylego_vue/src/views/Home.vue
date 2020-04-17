
<template>
  <div class="home text-center">
    <div class="banner p-5">
      <img src="../images/hawaii.jpg" />
    </div>
    <div class="d-flex justify-content-center">
      <b-form class="container b-form" @submit="onSubmit" @reset="onReset" v-if="show">
        <div class="row d-flex justify-content-center form-group">
          <b-form-input
            type="text"
            v-model="form.search"
            required
            placeholder="Hotell, stad eller land"
          ></b-form-input>
        </div>
        <div class="row form-group d-flex justify-content-between">
          <div class="col-6">
            <div class="row">Från</div>
            <div class="row">
              <b-form-datepicker v-model="startDate" :min="sMin" :max="sMax" placeholder="Från"></b-form-datepicker>
            </div>
          </div>
          <div class="col-6">
            <div class="row d-flex">Till</div>
            <div class="row">
              <b-form-datepicker v-model="endDate" :min="eMin" :max="eMax" placeholder="Till"></b-form-datepicker>
            </div>
          </div>
        </div>
        <div class="row form-group d-flex justify-content-center">
          <b-form-input
            type="number"
            min="1"
            v-model="form.amountOfRooms"
            required
            placeholder="Antal rum"
          ></b-form-input>
        </div>
        <div class="row form-group d-flex justify-content-center">
          <button type="button" class="btn btn-info"><router-link to="/search">Sök</router-link></button>
        </div>
      </b-form>
    </div>
  </div>
</template>
<script>
export default {
  data() {
    return {
      sMin: "2020-07-01",
      sMax: "2020-08-30",
      eMin: "2020-07-02",
      eMax: "2020-08-31",
      form: {
        search: "",
        startDate: "",
        endDate: "",
        amountOfRooms: ""
      },
      foods: [
        { text: "Select One", value: null },
        "Carrots",
        "Beans",
        "Tomatoes",
        "Corn"
      ],
      show: true
    };
  }
};
</script>
