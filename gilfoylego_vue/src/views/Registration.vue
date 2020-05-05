<template>
    <div class="d-flex justify-content-center pt-5">
        <b-form class="text-center" @submit.stop.prevent="onSubmit" @reset="onReset">
            <div class="form-group">
                <router-link to="/login">Tillbaka till login</router-link>
            </div>
            <div class="form-group">
                <b-form-input
                    type="text"
                    v-model="form.username"
                    required
                    state="usernameValidation"
                    placeholder="Användarnamn"
                ></b-form-input>
                <b-form-invalid-feedback class="text-left" :state="usernameValidation">
                    Användarnamnet måste vara minst 5 tecken långt.
                </b-form-invalid-feedback>
            </div>
            <div class="form-group">
                <b-form-input
                    id="input-1"
                    v-model="form.email"
                    type="email"
                    required
                    state="mailValidation"
                    placeholder="E-mail"
                ></b-form-input>
                <b-form-invalid-feedback class="text-left" :state="mailValidation">
                    Måste vara en e-mail.
                </b-form-invalid-feedback>
            </div>
            <div class="form-group">
                <b-form-input
                    type="password"
                    v-model="form.password"
                    required
                    state="pwValidation"
                    placeholder="Lösenord"
                ></b-form-input>
                <b-form-invalid-feedback class="text-left" :state="pwValidation">
                    Lösenordet måste vara minst 8 tecken. Minst 1 bokstav och minst 1 siffra.
                </b-form-invalid-feedback>
            </div>
            <div class="form-group">
                <b-form-input
                    type="password"
                    v-model="form.passwordCheck"
                    required
                    state="repeatPwValidation"
                    placeholder="Upprepa lösenord"
                ></b-form-input>
                <b-form-invalid-feedback class="text-left" :state="repeatPwValidation">
                    Lösenorden måste matcha.
                </b-form-invalid-feedback>
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
                    state="phoneValidation"
                    placeholder="Telefonnummer"
                ></b-form-input>
                <b-form-invalid-feedback class="text-left" :state="phoneValidation">
                    Måste vara ett telefonnummer.
                </b-form-invalid-feedback>
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
    computed: {
        usernameValidation() {
            return this.form.username.length > 5
        },
        mailValidation() {
            let regex = /^(([^<>()[\]\\.,;:\s@"]+(\.[^<>()[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/
            return regex.test(this.form.email)
        },
        pwValidation() {
            let regex = /^(?=.*[A-Za-z])(?=.*\d)[A-Za-z\d]{8,}$/
            return regex.test(this.form.password)
        },
        repeatPwValidation() {
            return this.form.passwordCheck == this.form.password
        },
        phoneValidation() {
            let regex = /^[+]*[(]{0,1}[0-9]{1,4}[)]{0,1}[-\s/0-9]*$/
            return regex.test(this.form.phone)
        }
    },
    methods: {
      onSubmit(evt) {
        evt.preventDefault()
        this.addUser()
      },
      onReset(evt) {
        evt.preventDefault()
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