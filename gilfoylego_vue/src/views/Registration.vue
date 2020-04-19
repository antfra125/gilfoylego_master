<template>
    <div class="d-flex justify-content-center pt-5">
        <form class="text-center">
            <div class="form-group">
                <router-link to="/">Tillbaka till login</router-link>
            </div>
            <div class="form-group">
                <input type="text" class="form-control" placeholder="Användarnamn">
            </div>
            <div class="form-group">
                <b-form-input
          id="input-1"
          v-model="form.email"
          type="email"
          required
          placeholder="E-mail"
        ></b-form-input>
            </div>
            <div class="form-group">
                <input type="password" class="form-control" placeholder="Lösenord">
            </div>
            <div class="form-group">
                <input type="password" class="form-control" placeholder="Upprepa lösenord">
            </div>
            <div class="form-group">
                <input type="text" class="form-control" placeholder="Förnamn">
            </div>
            <div class="form-group">
                <input type="text" class="form-control" placeholder="Efternamn">
            </div>
            <div class="form-group">
                <input type="text" placeholder="Adress">
                <input type="text" placeholder="Postadress">
                <input type="text" placeholder="Stad">
            </div>
            <div class="form-group">
                <button>Registrera</button>
            </div>
            
        </form>
    </div>
</template>

<script>
  export default {
    data() {
      return {
        form: {
          email: '',
          name: '',
          food: null,
          checked: []
        },
        foods: [{ text: 'Select One', value: null }, 'Carrots', 'Beans', 'Tomatoes', 'Corn'],
        show: true
      }
    },
    methods: {
      onSubmit(evt) {
        evt.preventDefault()
        alert(JSON.stringify(this.form))
      },
      onReset(evt) {
        evt.preventDefault()
        // Reset our form values
        this.form.email = ''
        this.form.name = ''
        this.form.food = null
        this.form.checked = []
        // Trick to reset/clear native browser form validation state
        this.show = false
        this.$nextTick(() => {
          this.show = true
        })
      }
    }
  }
</script>