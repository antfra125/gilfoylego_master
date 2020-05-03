<template>
    <div class="d-flex justify-content-center pt-5">
        <b-form class="text-center" @submit="onSubmit" @reset="onReset">
            <div class="form-group">
                <router-link to="/login">Tillbaka till login</router-link>
            </div>
            <div class="form-group">
                <b-form-input
                    type="text"
                    v-model="form.username"
                    required
                    placeholder="Användarnamn"
                ></b-form-input>
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
                <b-form-input
                    type="password"
                    v-model="form.password"
                    required
                    placeholder="Lösenord"
                ></b-form-input>
            </div>
            <div class="form-group">
                <b-form-input
                    type="password"
                    v-model="form.passwordCheck"
                    required
                    placeholder="Upprepa lösenord"
                ></b-form-input>
            </div>
            <div class="form-group">
                <b-form-input
                    type="text"
                    v-model="form.firstName"
                    required
                    placeholder="Tilltalsnamn"
                ></b-form-input>
            </div>
            <div class="form-group">
                <b-form-input
                    type="text"
                    v-model="form.lastName"
                    required
                    placeholder="Efternamn"
                ></b-form-input>
            </div>
            <div class="form-group">
                <b-form-input
                    type="text"
                    v-model="form.phone"
                    required
                    placeholder="Telefonnummer"
                ></b-form-input>
            </div>
            <div class="form-group d-flex">
                <b-form-input
                    type="text"
                    v-model="form.street"
                    required
                    placeholder="Gata"
                ></b-form-input>
                <b-form-input
                    type="text"
                    v-model="form.zipCode"
                    required
                    placeholder="Postadress"
                ></b-form-input>
                <b-form-input
                    type="text"
                    v-model="form.city"
                    required
                    placeholder="Stad"
                ></b-form-input>
            </div>
            <div class="form-group">
                <span><b-button type="submit">Registrera</b-button></span>
                <span class="pl-2"><b-button type="reset">Töm</b-button></span>
            </div>
        </b-form>
    </div>
    
</template>

<script>
  export default {
    data() {
      return {
        form: {
            username: '',
            email: '',
            password: '',
            passwordCheck: '',
            firstName: '',
            lastName:'',
            phone:'',
            street: '',
            zipCode: '',
            city: '',
        },
        
      }
    },
    methods: {
      onSubmit(evt) {
        evt.preventDefault()
        this.addUser()
      },
      onReset(evt) {
        evt.preventDefault()
        // Reset our form values
        this.form.username = ''
        this.form.email = ''
        this.form.password = ''
        this.form.passwordCheck = ''
        this.form.firstName = ''
        this.form.lastName = ''
        this.form.phone = ''
        this.form.street = ''
        this.form.zipCode = ''
        this.form.city = ''
      },
      async addUser(){
            let newUser = {
                username: this.form.username,
                email: this.form.email,
                password: this.form.password,
                firstName: this.form.firstName,
                lastName: this.form.lastName,
                phone: this.form.phone,
                address: this.form.street + ' ' + this.form.zipCode + ' ' + this.form.city
            }
                let response = await fetch('/rest/user',{
                method: 'POST',
                headers: { 'Content-Type': 'application/json' },
                body: JSON.stringify(newUser)
                
            });
            
            if(response.url.includes('error')){
                console.log('Fel!')
                this.form.username = ''
                this.form.email = ''
                this.form.password = ''
                this.form.passwordCheck = ''
                this.form.firstName = ''
                this.form.lastName = ''
                this.form.phone = ''
                this.form.street = ''
                this.form.zipCode = ''
                this.form.city = ''
            } else {
                console.log("Success")
                console.log(response);
                this.$router.push('/login');
            }
            let response2 = await response.json();
            console.log(response2)
        }
    }
  }
</script>