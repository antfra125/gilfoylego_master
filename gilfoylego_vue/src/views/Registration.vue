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
                <input type="text" class="form-control" placeholder="E-mail">
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