
<template>
  <div class="home text-center pb-5">
    <div class="banner pb-5 pt-2">
      <img src="../images/hawaii.jpg" />
    </div>
    <div class="d-flex justify-content-center">
      <SearchForm />
    </div>
  </div>
</template>

<script>
import SearchForm from "@/components/SearchForm.vue";

export default {
  name: "Search",
  components: {
      SearchForm
  },
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
        amountOfRooms: "",
        amenities: [],
        m2Center: "",
        m2Beach: ""
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
