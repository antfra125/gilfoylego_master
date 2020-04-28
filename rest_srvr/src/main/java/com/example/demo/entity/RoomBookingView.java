package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "room_booking_view")
public class RoomBookingView {
    @Id
    @Column(name = "room_booking_id")
    long roomBookingId;

    @Column(name ="room_id")
    long roomId;

    public long getRoomId() {
        return roomId;
    }

    public long getRoomBookingId() {
        return roomBookingId;
    }

    public String getRoomtypeName() {
        return roomtypeName;
    }

    public String getHotelName() {
        return hotelName;
    }

    public LocalDate getDateCheckin() {
        return dateCheckin;
    }

    public LocalDate getDateCheckout() {
        return dateCheckout;
    }

    @Column(name = "roomtype_name")
    String roomtypeName;
    @Column(name = "hotel_name")
    String hotelName;
    @Column(name = "date_checkin")
    LocalDate dateCheckin;
    @Column(name = "date_checkout")
    LocalDate dateCheckout;
}
