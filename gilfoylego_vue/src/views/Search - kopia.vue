<template>
  <div class="d-flex justify-content-center">
    <div>
        <form>
          <div class="row d-flex justify-content-center">
            <div class="column">
              <input type="text" size="35" placeholder="Hotell, stad eller land"> 
              <button class="custom-search-button"><img class="pb-1" src="../images/search.png"></button>
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
            </div>
          </div>
          <div class="row sort d-flex justify-content-between">
            <span class="column">Sortera efter:</span>
            <span class="column"><img src="../images/sort.png"> Pris</span>
            <span class="column"><img src="../images/sort.png"> Omdömde</span>
        </div>
        <div class="row">
            Filter:
        </div>
        <div class="row d-flex justify-content-between">
            <div class="column">
              <input type="checkbox"> Pool
            </div>
            <div class="column">
            <input type="checkbox"> Barnklubb
            </div>
        </div>
        <div class="row d-flex justify-content-between">
            <div class="column">
              <input type="checkbox"> Kvällsunderhållning
            </div>
            <div class="column">
            <input type="checkbox"> Restaurang
            </div>
        </div>
        <div class="row">
            <div class="column pt-1">
              <input type="number" size="39" placeholder="Maxavstånd till strand">
            </div>
          </div>
          <div class="row">
            <div class="column pt-1">
              <input type="number" size="39" placeholder="Maxavstånd till centrum">
            </div>
          </div>
        </form>
  </div>
  <div>
    <div class="result border-check row pt-5 d-flex justify-content-between">
      <div class="column border-check">
        <img src="../images/ex.jpg">
      </div>
      <div class="column border-check">
        <div class="row border-check">
          Hotellets Namn
        </div>
        <div class="row border-check">
          Omdöme
        </div>
        <div class="row border-check">
          Avstånd till stand
        </div>
        <div class="row border-check">
          Avstånd till centrum
        </div>
        <div class="row text-right border-check">
          Från ?kr
        </div>
      </div>
    </div>
  </div>
  </div>
  
</template>
