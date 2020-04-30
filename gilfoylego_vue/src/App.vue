<template>
  <div id="app">
    <div class="d-flex justify-content-between" id="nav">
      <span class="title p-2">
        <router-link to="/">
          <img src="./images/title.png" />
        </router-link>
      </span>
      <span class="user p-2">
        <b-dropdown dropleft variant="link" toggle-class="text-decoration-none" no-caret>
          <template v-slot:button-content>
            <span>
              <img src="./images/user.png" />
            </span>
          </template>
          <div v-if="!$store.state.isLoggedIn">
            <b-dropdown-item href="/login">Logga in</b-dropdown-item>
          </div>
          <div v-if="$store.state.isLoggedIn">
            <b-dropdown-item href="/profile">Beställningar</b-dropdown-item>
            <b-dropdown-item v-on:click="logOut()">Logga Ut</b-dropdown-item>
          </div>
        </b-dropdown>
      </span>
    </div>
    <main class="container">
      <router-view />
    </main>
  </div>
</template>


<style src="./style.css"></style>
<style src="./bootstrap.min.css"></style>

<script>
export default {
  data() {
    return {
      isLoggedIn: false
    };
  },
  created() {
    this.$store.dispatch("isUserLoggedIn")
    console.log("created() kördes");
    this.$store.dispatch("getFormdata");
  },
  methods: {
    logOut() {
      this.$store.dispatch("LoggingOut")
      this.$router.push('/');
    }
  }
};
</script>
<style>
app {
    overflow-y: scroll;
}
</style>