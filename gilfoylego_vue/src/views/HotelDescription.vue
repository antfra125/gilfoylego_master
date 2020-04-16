<template>
  <section class="container HotelDescription">
    <section class="row d-flexmb-1 mt-4">
      <img class="col-4 d-flex" src="../images/hotel1.jpg" />
      <p class="col-6 d-flex ml-5" id="thisIsTheDescription">
        Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin pretium hendrerit est,
        ac dignissim turpis. Vivamus non scelerisque metus. Aliquam erat volutpat. Aenean
        malesuada ex magna, sit amet porta nisl efficitur nec. In neque ligula, pulvinar a
        ante ac, viverra aliquet ligula. Praesent ac eros et mauris malesuada interdum.
        Praesent in nisl mauris. Phasellus malesuada ac dui in maximus.
      </p>
    </section>
    <section class="row ml-1 mb-3">
      <p>2199kr/natt</p>
    </section>

    <section class="row">
      <div class="col extra">
        <img class="pr-2" src="../images/v.png">
        <label for="Pool">Pool</label>
      </div>
      <div class="col extra">
        <img class="pr-2" src="../images/x.png">
        <label for="KidsClubs">Barnklubb</label>
      </div>
    </section>

    <section class="row mb-3">
      <div class="col extra">
        <img class="pr-2" src="../images/v.png">
        <label for="Resturant">Resturang</label>
      </div>
      <div class="col extra">
        <img class="pr-2" src="../images/v.png">
        <label for="Entertaiment">Underhållning</label>
      </div>
    </section>

    <section class="row ml-4 mb-2">
      <div>
        <p>Avstånd till stranden: {distanceBeach}</p>
        <p>Avstånd till centrum: {distanceCentrum}</p>
      </div>
    </section>

    <section class="mb-5">
      <h4 class="mb-4">Rum</h4>

      <div class="row ml-1">
        <h5 class="mr-3">Rumstyp</h5>
        <b-dropdown id="dropdown-1" text="Enkel rum" class>
          <b-dropdown-item>Dubbel rum</b-dropdown-item>
          <b-dropdown-item>Flera rum</b-dropdown-item>
        </b-dropdown>
      </div>

      <div class="row mt-3 ml-1">
        <h5 class="mr-3">Antal personer</h5>
        <b-dropdown id="dropdown-1" text="1" class>
          <b-dropdown-item>2</b-dropdown-item>
        </b-dropdown>
      </div>
      
    </section>
  </section>
</template>