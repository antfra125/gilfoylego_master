package com.example.demo.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@IdClass(RoomBookingId.class)
public class RoomBooking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Id
    @Column(name="booking_id")
    private long bookingId;
    @Id
    @Column(name="date_in")
    private LocalDate dateIn;
    @Id
    @Column (name="date_out")
    private LocalDate dateOut;
    @Column(name="all_inclusive")
    private boolean allInclusive = false;
    @Column(name="full_pension")
    private boolean fullPension = false;
    @Column(name="half_pension")
    private boolean halfPension = false;
    @Column(name="extra_bed")
   private  boolean extraBed = false;

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

    public LocalDate getDateIn() {
        return dateIn;
    }

    public void setDateIn(LocalDate dateIn) {
        this.dateIn = dateIn;
    }

    public LocalDate getDateOut() {
        return dateOut;
    }

    public void setDateOut(LocalDate dateOut) {
        this.dateOut = dateOut;
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