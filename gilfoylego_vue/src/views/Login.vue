<template>
    <div class="d-flex justify-content-center pt-5">
        <b-form @submit="onSubmit">
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
                    type="password"
                    v-model="form.password"
                    required
                    placeholder="Lösenord"
                ></b-form-input>
            </div>
            <div class="form-group text-center">
                <button type="submit">Logga in</button>
            </div>
            <div>
                Inget konto? Skapa ett <router-link to="/registration">här</router-link>, utan kostnad!
            </div>
        </B-form>
    </div>
</template>

<script>

export default {
  data() {
    return {
      form: {
        username: '',
        password: '',
      }
    }
  },
    /*mounted() {
      this.springLogin();
    },*/
    methods: {
        async springLogin() {
            let username = this.form.username;
            let password = this.form.password;
            console.log(username + ' ' + password)
            const credentials =
            "username=" +
            encodeURIComponent(username) +
            "&password=" +
            encodeURIComponent(password);
            let response = await fetch("/rest/login", {
                method: "POST",
                redirect: "manual",
                headers: { "Content-Type": "application/x-www-form-urlencoded" },
                body: credentials
            });
            
                /*response = await fetch("http://localhost:8090/rest/activeuser");
                response = await response.json();
                console.log(response);*/


            if(response.url.includes('error')){
                console.log('Fel!')
            } else {
                console.log("Success")
                this.$store.state.isLoggedIn = true
                let response = await fetch("/rest/activeuser");
                response = await response.json();
                console.log(response);
            }
        },
        onSubmit(evt) {
            evt.preventDefault()
            //alert(JSON.stringify(this.form))
            this.springLogin()
        }
    }
}
</script>