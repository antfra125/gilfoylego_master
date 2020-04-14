<template>
  <div class="home text-center">
    <div class="banner p-5">
      <img src="../images/hawaii.jpg">
    </div>
    <div class="d-flex justify-content-center">
        <form>
          <div class="row d-flex justify-content-center">
            <div class="column">
              <input type="text" size="39" placeholder="Hotell, stad eller land"> 
            </div>
          </div>
          <div class="row d-flex justify-content-between">
            <div class="column text-left">
              Från
            </div>
            <div class="column">
              Till
            </div>
          </div>
          <div class="row d-flex justify-content-center">
            <div class="column">
              <input type="date" min="2020-07-01" max="2020-08-30">
            </div>
            <div class="column">
              <input type="date" min="2020-07-02" max="2020-08-31">
            </div>
          </div>
          <div class="row d-flex justify-content-center">
            <div class="column pt-1">
              <input type="number" size="39" min="1" placeholder="Antal rum">
            </div>
          </div>
          <div class="row d-flex justify-content-center">
            <div class="column p-1">
              <button>Sök</button>
            </div>
          </div>
        </form>
    </div>
  </div>
</template>
<script>

</script>
