<template>
  <div id="app">
    <div class="d-flex justify-content-between" id="nav">
      <span class="title p-2"><router-link to="/"><img src="./images/title.png"></router-link></span>
        <span class="user p-2">
          <b-dropdown dropleft variant="link" toggle-class="text-decoration-none" no-caret>
            <template v-slot:button-content>
              <span><img src="./images/user.png"></span>
            </template>
              <div v-if="!this.$store.state.isLoggedIn">
                <b-dropdown-item href="/login">Logga in</b-dropdown-item>
              </div>
              <div v-if="this.$store.state.isLoggedIn">
                <b-dropdown-item href="#">Beställningar</b-dropdown-item>
                <b-dropdown-item v-on:click="this.$store.state.isLoggedIn=false">Logga Ut</b-dropdown-item>
              </div>
          </b-dropdown>
        </span>
    </div>
    <main class="container">
    <router-view/>
    </main>
  </div>
</template>


<style src="./style.css"></style>
<style src="./bootstrap.min.css"></style>

<script>/*
export default{
data(){
  return{
    isLoggedIn: this.$store.state.isLoggedIn
}
}
}*/
</script>