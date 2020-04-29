<template>
  <div class="d-flex justify-content-center">
    <div class="container">
      <div class="row form-group d-flex justify-content-center mt-auto">
        <SearchForm/>

        <div>
          <HotelResult :search="form.search" :m2Center="form.m2Center" />
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import HotelResult from "@/components/HotelResult.vue";
import SearchForm from "@/components/SearchForm.vue";

export default {
  name: "Search",
  components: {
    HotelResult, SearchForm
  },
  data() {
    return {
      sMin: "2020-07-01",
      sMax: "2020-08-30",
      eMin: "2020-07-02",
      eMax: "2020-08-31",
      show: true,
      hotels: []
    };
  },
  mounted() {
    this.getHotels();
  },

  methods: {
    onSubmit(evt) {
      evt.preventDefault();
      alert(JSON.stringify(this.form));
    },
    getHotels: async function() {
      let result = await fetch("http://localhost:8090/rest/hotelview");
      this.hotels = await result.json();
      console.log(this.hotels);
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