package com.example.demo.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @OneToMany(mappedBy = "booking")
    private Set<RoomBooking> roomBookings;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUser() {
        return user.getEmail();
    }

    public Set<RoomBooking> getRoomBookings() {
        return roomBookings;
    }
}
