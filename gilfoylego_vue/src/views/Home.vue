
<template>
  <div class="home text-center">
    <div class="banner p-5">
      <img src="../images/hawaii.jpg">
    </div>
    <div class="d-flex justify-content-center">
        <form>
          <div class="row d-flex justify-content-center form-group">
              <input type="text" class="form-control" placeholder="Hotell, stad eller land"> 
          </div>
          <div class="row form-group d-flex justify-content-between">
          <div class="col-6">
            <div class="row">
              Från
            </div>
            <div class="row">
              <input type="date" class="form-control" min="2020-07-01" max="2020-08-30">
            </div>
          </div>
          <div class="col-6">
            <div class="row d-flex justify-content-end">
              Till
            </div>
            <div class="row">
              <input type="date" class="form-control" min="2020-07-02" max="2020-08-31">
            </div>
          </div>
        </div>
          <div class="row form-group d-flex justify-content-center">
              <input type="number" class="form-control" min="1" placeholder="Antal rum">
          </div>
          <div class="row form-group d-flex justify-content-center">
              <button>Sök</button>
          </div>
        </form>
    </div>
  </div>
</template>
<script>

</script>
