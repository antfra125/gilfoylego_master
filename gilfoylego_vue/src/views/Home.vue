
<template>
  <div class="home text-center pb-5">
    <div class="banner pb-5 pt-2">
      <img src="../images/hawaii.jpg" />
    </div>
    <div class="d-flex justify-content-center">
      <b-form @submit="onSubmit" @reset="onReset">
        <div class="row d-flex justify-content-center form-group">
          <b-form-input
            type="text"
            v-model="form.search"
            placeholder="Hotell, stad eller land"
          ></b-form-input>
        </div>
        <div class="row form-group d-flex justify-content-between">
          <div class="col-md-5 col-sm-12">
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
          <div class="col-md-5 col-sm-12">
            <div class="row d-flex">Till</div>
            <div class="row">
              <b-form-datepicker v-model="form.endDate" :min="eMin" :max="eMax" placeholder="Till"></b-form-datepicker>
            </div>
          </div>
        </div>
          <div class="row">Filter:</div>
          <b-form-checkbox-group v-model="form.amenities">
            <div class="row d-flex justify-content-between">
              <div class="column">
                <b-form-checkbox value="pool">Pool</b-form-checkbox>
              </div>
              <div class="column">
                <b-form-checkbox class="mr-0" value="eveningentertainment">Kvällsunderhållning</b-form-checkbox>
              </div>
            </div>
            <div class="row form-group d-flex justify-content-between">
              <div class="column">
                <b-form-checkbox value="kidsclub">Barnklubb</b-form-checkbox>
              </div>
              <div class="column">
                <b-form-checkbox class="mr-0" value="restaurant">Restaurang</b-form-checkbox>
              </div>
            </div>
          </b-form-checkbox-group>
          <div class="row form-group">
            <b-form-input
              type="number"
              min="0"
              v-model="form.m2Beach"
              placeholder="Maxavstånd till strand i meter"
            ></b-form-input>
          </div>
          <div class="row">
            <b-form-input
              type="number"
              min="0"
              v-model="form.m2Center"
              placeholder="Maxavstånd till centrum i meter"
            ></b-form-input>
          </div>
        <div class="row form-group d-flex justify-content-center pt-3">
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
  name: "Search",
  components: {
  },
  data() {
    return {
      sMin: "2020-07-01",
      sMax: "2020-08-30",
      eMin: "2020-07-02",
      eMax: "2020-08-31"
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
      this.form.amenities = [];
      this.form.m2Beach = "";
      this.form.m2Center = "";
    }
  },
  computed: {
    form: {
      get() {
        console.log("computed: forms: get() WOW!");
        return this.$store.state.form;
      },
      set(value) {
        console.log("computed: forms: set(value) KOLLA!!");
        this.$store.commit("SET_FORM", value);
      }
    }
  }
};
</script>
