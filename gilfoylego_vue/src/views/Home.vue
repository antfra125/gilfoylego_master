
<template>
  <div class="home text-center">
    <div class="banner p-5">
      <img src="../images/hawaii.jpg" />
    </div>
    <div class="d-flex justify-content-center">
      <b-form @submit="onSubmit" @reset="onReset" v-if="show">
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
              <b-form-datepicker
                v-model="form.startDate"
                :min="sMin"
                :max="sMax"
                placeholder="Från"
              ></b-form-datepicker>
            </div>
          </div>
          <div class="col-6">
            <div class="row d-flex justify-content-end">Till</div>
            <div class="row">
              <b-form-datepicker v-model="form.endDate" :min="eMin" :max="eMax" placeholder="Till"></b-form-datepicker>
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
          <span>
            <router-link to="/search">
              <b-button>Sök</b-button>
            </router-link>
          </span>
          <span class="pl-2">
            <b-button type="reset">Töm</b-button>
          </span>
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
      show: true
    };
  },
  methods: {
    onSubmit(evt) {
      evt.preventDefault();
      alert(JSON.stringify(this.form));
    },
    onReset(evt) {
      evt.preventDefault();
      this.form.search = "";
      this.form.startDate = "";
      this.form.endDate = "";
      this.form.amountOfRooms = "";
      this.show = false;
      this.$nextTick(() => {
        this.show = true;
      });
    }
  }
};
</script>
