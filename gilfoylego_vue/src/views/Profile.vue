<template>
    <div>
        <div class="row">
            Användarnamn: {{$store.state.user.username}}
        </div>
        <div class="row">
            Tilltalsnamn: {{$store.state.user.firstName}}
        </div>
        <div class="row">
            Efternamn: {{$store.state.user.lastName}}
        </div>
        <div class="row">
            E-mail: {{$store.state.user.email}}
        </div>
        <div class="row">
            Adress: {{$store.state.user.address}}
        </div>
        <div class="row" v-for="(booking,index) in $store.state.user.bookings" :key="index">
            <div class="row" v-for="(roombooking,index) in booking.roomBookings" :key="index">
                <div class="row">{{roombooking.hotel}}: {{roombooking.roomtype}}, Vuxna: {{roombooking.adults}}, Barn: {{roombooking.children}}, {{roombooking.price}} kr</div>
            </div> 
        </div>
    </div>
</template>