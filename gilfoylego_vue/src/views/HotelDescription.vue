<template>
  <section class="container HotelDescription">
    <section class="row d-flexmb-1 mt-4">
      <img class="col-4 d-flex" src="../images/hotel1.jpg" />
      <span class="col-6 ml-5" id="thisIsTheDescription">
        <div class="row">
          <strong>Hotellets namn</strong>
        </div>
        <div class="row">
          Omdöme: ?
        </div>
        <div class="row">
          Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin pretium hendrerit est,
        ac dignissim turpis. Vivamus non scelerisque metus. Aliquam erat volutpat. Aenean
        malesuada ex magna, sit amet porta nisl efficitur nec. In neque ligula, pulvinar a
        ante ac, viverra aliquet ligula. Praesent ac eros et mauris malesuada interdum.
        Praesent in nisl mauris. Phasellus malesuada ac dui in maximus.
        </div>
      </span>
    </section>
    <section class="row ml-1 mb-3">
    <span v-if="form.roomtype == 'Enkelrum'"><p>799kr/natt</p></span>
    <span v-if="form.roomtype == 'Dubbelrum'"><p>1299kr/natt</p></span>
    <span v-if="form.roomtype == 'Familjerum'"><p>1699kr/natt</p></span>
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
        <b-form @submit="onSubmit" @reset="onReset" v-if="show">
      <div class="row ml-1">
        <h5 class="mr-3">Rumstyp</h5>
        <b-form-select
          id="input-3"
          v-model="form.roomtype"
          :options="roomtypes"
          required
        ></b-form-select>
      </div>

      <div class="row mt-3 ml-1">
        <h5 class="mr-3">Extrasäng</h5>
              <b-form-checkbox-group v-model="form.extrabed" id="checkboxes-4">
          <b-form-checkbox value="true"></b-form-checkbox>
        </b-form-checkbox-group>
      </div>

      <div class="row mt-3 ml-1">
        <h5 class="mr-3">Antal vuxna</h5>
        <b-form-input
              type="number"
              min="1"
              v-model="form.amountOfGrownUps"
              required
              placeholder="Antal vuxna"
            ></b-form-input>
      </div>

      <div class="row mt-3 ml-1">
        <h5 class="mr-3">Antal barn</h5>
        <b-form-input
              type="number"
              min="1"
              v-model="form.amountOfKids"
              required
              placeholder="Antal barn"
            ></b-form-input>
      </div>
      <b-button class="mt-3">Boka</b-button>
      </b-form>
    </section>
    
  </section>
</template>

<script>
export default {
    data() {
      return {
        form: {
          amountOfGrownUps: '',
          amountOfKids: '',
          roomtype: 'Enkelrum',
          extrabed: []
        },
        roomtypes: ['Enkelrum', 'Dubbelrum', 'Familjerum'],
        show: true
      }
    }
    }
</script>