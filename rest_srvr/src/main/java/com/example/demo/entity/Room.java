package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    @JsonBackReference(value="room_hotel")
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;
    @ManyToOne
    @JoinColumn(name = "roomtype_id")
    @JsonBackReference(value="room_roomtype")
    private Roomtype roomtype;
    @Column
    private int sizem2;
    @Column
    private double price;
    @OneToMany(mappedBy = "room")
    @JsonManagedReference(value="room_roombooking")
    private Set<RoomBooking> roomBookings;
    @Transient
    private String roomtypeName;


    public String getRoomtypeName() {
        return this.roomtype.getName();
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Hotel getHotel() {
        return this.hotel;
    }

    public String getRoomtype() {
        return roomtype.getName();
    }

    public Set<RoomBooking> getRoomBookings() {
        return roomBookings;
    }

    public int getSizem2() {
        return sizem2;
    }

    public void setSizem2(int sizem2) {
        this.sizem2 = sizem2;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
