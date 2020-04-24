package com.example.demo.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;
    @ManyToOne
    @JoinColumn(name = "roomtype_id")
    private Roomtype roomtype;
    @Column
    private int sizem2;
    @Column
    private double price;
    @OneToMany(mappedBy = "room")
    private Set<RoomBooking> roomBookings;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getHotel() {
        return hotel.getName();
    }

    public String getRoomtype() {
        return roomtype.getName();
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
