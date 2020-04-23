package com.example.demo.entity.keys;

import java.io.Serializable;
import java.time.LocalDate;

/*en samlingsklass för compound-primary key till RoomBooking,
* för att kunna ha flera @Id som primärnycklar*/
public class RoomBookingId implements Serializable {
    private long bookingId;
    private long roomId;
    private LocalDate dateCheckin;
    private LocalDate dateCheckout;

}
