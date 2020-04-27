package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "hotelview")
public class HotelView {
    @Id
    long id;
    @Column
    String name;
    @Column(name = "cityID")
    long cityId;
    @Column
    String City;
    @Column(name = "countryID")
    long countryId;
    @Column
    String country;
    @Column
    boolean restaurant;
    @Column
    boolean pool;
    @Column
    boolean kidsclub;
    @Column(name = "evening_entertainment")
    boolean eveningEntertainment;
    @Column(name = "meters_to_city_center")
    int mToCity;
    @Column(name = "meters_to_beach")
    int mToBeach;
    @Column(name = "img_url")
    String imgUrl;
    @Column
    String description;
    @Column
    Double rating;

    public long getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public long getCityId() {
        return cityId;
    }

    public String getCity() {
        return City;
    }

    public long getCountryId() {
        return countryId;
    }

    public String getCountry() {
        return country;
    }

    public boolean isRestaurant() {
        return restaurant;
    }

    public boolean isPool() {
        return pool;
    }

    public boolean isKidsclub() {
        return kidsclub;
    }

    public boolean isEveningEntertainment() {
        return eveningEntertainment;
    }


    public int getmToCity() {
        return mToCity;
    }

    public int getmToBeach() {
        return mToBeach;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public String getDescription() {
        return description;
    }

    public Double getRating() {
        return rating;
    }

}
