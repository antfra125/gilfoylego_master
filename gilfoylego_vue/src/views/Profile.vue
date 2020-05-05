<template>
    <div class="container">
        <div class="row">
            <span><strong>Användarnamn:</strong> {{$store.state.user.username}}</span>
        </div>
        <div class="row">
            <span><strong>Namn:</strong>  {{$store.state.user.firstName}} {{$store.state.user.lastName}}</span>
        </div>
        <div class="row">
            <span><strong>E-mail:</strong> {{$store.state.user.email}}</span>
        </div>
        <div class="row">
            <span><strong>Adress:</strong> {{$store.state.user.address}}</span>
        </div>
        <div class="row pt-4">
            <strong>Bokningar:</strong>
        </div>
        <div class="row ml-3" v-for="(booking,index) in $store.state.user.bookings" :key="index">
            <div class="row w-100" v-for="(roombooking,index) in booking.roomBookings" :key="index">
                <div class="row">
                    <span>
                        {{roombooking.dateCheckin}}-{{roombooking.dateCheckout}} 
                        {{roombooking.hotelName}}: {{roombooking.roomtype}}
                        , Extrasäng:  <span v-show="roombooking.extraBed"> Ja</span><span v-show="!roombooking.extraBed"> Nej</span>
                        <span v-show="roombooking.allInclusive">, Förmån: All Inclusice</span>
                        <span v-show="roombooking.fullPension">, Förmån: Helpension</span>
                        <span v-show="roombooking.halfPension">, Förmån: Halvpension</span>
                        <span v-show="!roombooking.halfPension && !roombooking.allInclusive && !roombooking.fullPension">, Förmån: Ingen</span>
                        , Vuxna: {{roombooking.adults}}
                        , Barn: {{roombooking.children}}
                        , {{roombooking.price}} kr
                    </span>
                </div>
            </div> 
        </div>
    </div>
</template>