package com.example.demo.entity;

import java.io.Serializable;
import java.time.LocalDate;

/*en samlingsklass för compound-primary key till RoomBooking,
* för att kunna ha flera @Id som primärnycklar*/
public class RoomBookingId implements Serializable {


    private long id;
    private long bookingId;
    private long roomId;
    private LocalDate dateCheckin;
    private LocalDate dateCheckout;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getBookingId() {
        return bookingId;
    }

    public void setBookingId(long bookingId) {
        this.bookingId = bookingId;
    }

    public long getRoomId() {
        return roomId;
    }

    public void setRoomId(long roomId) {
        this.roomId = roomId;
    }

    public LocalDate getDateCheckin() {
        return dateCheckin;
    }

    public void setDateCheckin(LocalDate dateCheckin) {
        this.dateCheckin = dateCheckin;
    }

    public LocalDate getDateCheckout() {
        return dateCheckout;
    }

    public void setDateCheckout(LocalDate dateCheckout) {
        this.dateCheckout = dateCheckout;
    }
}
