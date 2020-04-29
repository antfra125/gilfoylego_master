package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    @JoinColumn(name = "city_id")
    @JsonBackReference(value="hotel_city")

    private City city;
    @Column
    private String name;
    @Column(name = "restaurant")
    private boolean hasRestaurant = false;
    @Column(name = "pool")
    private boolean hasPool = false;
    @Column(name = "kidsclub")
    private boolean hasKidsClub = false;
    @Column(name = "evening_entertainment")
    private boolean hasEveningEntertainment = false;
    @Column(name="meters_to_city_center")
    private int metersToCityCenter;
    @Column(name="meters_to_beach")
    private int metersToBeach;
    @Column(name="img_url")
    private String imgUrl;
    @Column
    private String description;
    @Column
    private double rating;
    @OneToMany(mappedBy = "hotel")
    @JsonManagedReference(value="room_hotel")
    private Set<Room> rooms;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Set<Room> getRooms() {
        return rooms;
    }

    public String getCity() {
        return city.getName();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isHasRestaurant() {
        return hasRestaurant;
    }

    public void setHasRestaurant(boolean hasRestaurant) {
        this.hasRestaurant = hasRestaurant;
    }

    public boolean isHasPool() {
        return hasPool;
    }

    public void setHasPool(boolean hasPool) {
        this.hasPool = hasPool;
    }

    public boolean isHasKidsClub() {
        return hasKidsClub;
    }

    public void setHasKidsClub(boolean hasKidsClub) {
        this.hasKidsClub = hasKidsClub;
    }

    public boolean isHasEveningEntertainment() {
        return hasEveningEntertainment;
    }

    public void setHasEveningEntertainment(boolean hasEveningEntertainment) {
        this.hasEveningEntertainment = hasEveningEntertainment;
    }

    public int getMetersToCityCenter() {
        return metersToCityCenter;
    }

    public void setMetersToCityCenter(int metersToCityCenter) {
        this.metersToCityCenter = metersToCityCenter;
    }

    public int getMetersToBeach() {
        return metersToBeach;
    }

    public void setMetersToBeach(int metersToBeach) {
        this.metersToBeach = metersToBeach;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }
}