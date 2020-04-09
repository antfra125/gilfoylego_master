<template>
  <div id="app">
    <div class="d-flex justify-content-between" id="nav">
      <span class="title p-2"><router-link to="/">Gilfoyle Go</router-link></span>
      <span class="user p-2"><router-link to="/about"><img src="./images/user.png"></router-link></span>
    </div>
    <main class="container">
    <router-view/>
    </main>
  </div>
</template>

<style src="./style.css"></style>
<style src="./bootstrap.min.css"></style>

