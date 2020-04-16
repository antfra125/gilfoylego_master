<template>
    <div class="d-flex justify-content-center pt-5">
        <form class="text-center">
            <div class="form-group">
                <input type="text" placeholder="Användarnamn/E-mail">
            </div>
            <div class="form-group">
                <input type="password" placeholder="Lösenord">
            </div>
            <div class="form-group">
                <button>Logga in</button>
            </div>
            <div>
                Inget konto? Skapa ett <router-link to="/registration">här</router-link>, utan kostnad!
            </div>
        </form>
    </div>
</template>