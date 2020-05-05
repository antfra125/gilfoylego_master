package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonBackReference(value="booking_user")
    private User user;
    @OneToMany(mappedBy = "booking")
    @JsonManagedReference(value="roombooking_booking")
    private Set<RoomBooking> roomBookings;

    public Booking(){

    }
    public Booking(User u){
        this.user = u;
    }
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getUser() {
        return user.getEmail();
    }

    public Set<RoomBooking> getRoomBookings() {
        return roomBookings;
    }
}
