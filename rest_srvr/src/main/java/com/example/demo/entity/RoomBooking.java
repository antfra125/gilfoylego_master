package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "room_booking")
//@IdClass(RoomBookingId.class)
public class RoomBooking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    @JoinColumn(name = "booking_id")
    @JsonBackReference(value="roombooking_booking")
    private Booking booking;
    @ManyToOne
    @JsonBackReference(value="room_roombooking")
    @JoinColumn(name = "room_id")
    private Room room;
    @Transient
    private String hotel;
    @Transient
    private String hotelName;
    @Transient
    private String roomtype;
    @Column(name="date_in")
    private LocalDate dateCheckin;
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
    @Column
    private int adults;
    @Column
    private int children;
    @Column
    private int price;

    public RoomBooking(){

    }
    public RoomBooking(Room r, Booking b){
        this.room = r;
        this.booking = b;
    }

    public String getHotelName() {
        return this.room.getHotel().getName();
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getAdults() {
        return adults;
    }

    public void setAdults(int adults) {
        this.adults = adults;
    }

    public int getChildren() {
        return children;
    }

    public void setChildren(int children) {
        this.children = children;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public long getRoom() {
        return room.getId();
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Long getHotel() {
        return this.room.getHotel().getId();
    }

    public String getRoomtype() {
        return this.room.getRoomtype();
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