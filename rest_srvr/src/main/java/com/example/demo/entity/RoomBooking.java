package com.example.demo.entity;

import com.example.demo.entity.keys.RoomBookingId;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "room_booking")
@IdClass(RoomBookingId.class)
public class RoomBooking {
    @Id
    @ManyToOne
    @JoinColumn(name = "booking_id")
    Booking booking;
    @Id
    @ManyToOne
    @JoinColumn(name = "room_id")
    Room room;
    @Id
    @Column(name="date_in")
    private LocalDate dateCheckin;
    @Id
    @Column (name="date_out")
    private LocalDate dateCheckout;
    @Column(name="all_inclusive")
    private boolean allInclusive = false;
    @Column(name="full_pension")
    private boolean fullPension = false;
    @Column(name="half_pension")
    private boolean halfPension = false;
    @Column(name="extra_bed")
   private  boolean extraBed = false;

    public String getRoom() {
        return room.getRoomtype();
    }

    public String getBooking() {
        return booking.getUser();
    }

    public LocalDate getDateCheckin() {
        return dateCheckin;
    }

    public void setDateCheckin(LocalDate dateIn) {
        this.dateCheckin = dateIn;
    }

    public LocalDate getDateCheckout() {
        return dateCheckout;
    }

    public void setDateCheckout(LocalDate dateOut) {
        this.dateCheckout = dateOut;
    }

    public boolean isAllInclusive() {
        return allInclusive;
    }

    public void setAllInclusive(boolean allInclusive) {
        this.allInclusive = allInclusive;
    }

    public boolean isFullPension() {
        return fullPension;
    }

    public void setFullPension(boolean fullPension) {
        this.fullPension = fullPension;
    }

    public boolean isHalfPension() {
        return halfPension;
    }

    public void setHalfPension(boolean halfPension) {
        this.halfPension = halfPension;
    }

    public boolean isExtraBed() {
        return extraBed;
    }

    public void setExtraBed(boolean extraBed) {
        this.extraBed = extraBed;
    }
}