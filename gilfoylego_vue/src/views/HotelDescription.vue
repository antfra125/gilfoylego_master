<template>
  <section class="container HotelDescription">
    <section class="row d-flexmb-1 mt-4">
      <img class="col-4 d-flex" src="../img/hotel1.jpg" />
      <p class="col-6 d-flex ml-5" id="thisIsTheDescription">
        Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin pretium hendrerit est,
        ac dignissim turpis. Vivamus non scelerisque metus. Aliquam erat volutpat. Aenean
        malesuada ex magna, sit amet porta nisl efficitur nec. In neque ligula, pulvinar a
        ante ac, viverra aliquet ligula. Praesent ac eros et mauris malesuada interdum.
        Praesent in nisl mauris. Phasellus malesuada ac dui in maximus.
      </p>
    </section>
    <section class="row ml-1 mb-3">
      <p>2199/night</p>
    </section>

    <section class="row">
      <div class="col">
        <input type="checkbox" id="addOn" name="Pool" value="Pool" />
        <label for="Pool">Pool</label>
      </div>
      <div class="col">
        <input type="checkbox" id="addOn" name="KidsClub" value="KidsClub" />
        <label for="KidsClubs">KidsClubs</label>
      </div>
    </section>

    <section class="row mb-3">
      <div class="col">
        <input type="checkbox" id="addOn" name="Resturant" value="Resturant" />
        <label for="Resturant">Resturant</label>
      </div>
      <div class="col">
        <input type="checkbox" id="addOn" name="Entertaiment" value="Entertaiment" />
        <label for="Entertaiment">Entertaiment</label>
      </div>
    </section>

    <section class="row">
      <div>
        <p>Distance to the beach: {distanceBeach}</p>
        <p>Distance to centrum: {distanceCentrum}</p>
      </div>
    </section>
  </section>
</template>