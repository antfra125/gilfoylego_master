<template>
  <div class="home text-center">
    <div>
      <p>Sök på din drömdestination:</p>
    </div>
    <div class="container">
        <form>
          <div class="row justify-content-center">
            <div class="column">
              Hotell, stad eller land:
            </div>
          </div>
          <div class="row justify-content-center">
            <div class="column">
              <input type="text">
            </div>
          </div>
          <div class="row d-flex justify-content-center">
            <div class="column text-left">
              Från
            </div>
            <div class="column">
              Till
            </div>
          </div>
          <div class="row d-flex justify-content-center">
            <div class="column">
              <input type="date" min="2020-07-01" max="2020-08-24">
            </div>
            <div class="column">
              <input type="date" min="2020-07-02" max="2020-08-31">
            </div>
          </div>
          <div class="row d-flex justify-content-center">
            <div class="column">
              Antal vuxna:
            </div>
          </div>
          <div class="row d-flex justify-content-center">
            <div class="column">
              <input type="number">
            </div>
          </div>
          <div class="row d-flex justify-content-center">
            <div class="column">
              Antal barn:
            </div>
          </div>
          <div class="row d-flex justify-content-center">
            <div class="column">
              <input type="number">
            </div>
          </div>
          <div class="row justify-content-center">
            <div class="column">
              Rumstyp:
            </div>
          </div>
          <div class="row d-flex justify-content-center">
            <div class="column pt-1">
              <select id="roomtype" name="roomtype">
                <option value="Enkelrum">Enkelrum</option>
                <option value="Dubbelrum">Dubbelrum</option>
                <option value="Familjerum">Familjerum</option>
              </select>
            </div>
          </div>
          <div class="row d-flex justify-content-center">
            <div class="column p-2">
              <button>Sök</button>
            </div>
          </div>
        </form>
    </div>
  </div>
</template>
<script>

</script>
