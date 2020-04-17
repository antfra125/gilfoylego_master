package com.example.demo.entity;

import java.io.Serializable;
import java.time.LocalDate;

public class RoomBookingId implements Serializable {
    private long id;
    private long bookingId;
    private LocalDate dateIn;
    private LocalDate dateOut;

    public RoomBookingId(long id, long booking_id, LocalDate date_in, LocalDate date_out){
        this.id=id;
        this.bookingId=bookingId;
        this.dateIn=dateIn;
        this.dateOut=dateOut;
    }
}
