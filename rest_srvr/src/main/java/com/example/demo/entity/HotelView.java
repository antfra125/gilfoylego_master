package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name="hotelview")
public class HotelView{
    @Id
    long id;
    @Column
    String name;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getCityId() {
        return cityId;
    }

    public void setCityId(long cityId) {
        this.cityId = cityId;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public long getCountryId() {
        return countryId;
    }

    public void setCountryId(long countryId) {
        this.countryId = countryId;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public boolean isRestaurant() {
        return restaurant;
    }

    public void setRestaurant(boolean restaurant) {
        this.restaurant = restaurant;
    }

    public boolean isPool() {
        return pool;
    }

    public void setPool(boolean pool) {
        this.pool = pool;
    }

    public boolean isKidsclub() {
        return kidsclub;
    }

    public void setKidsclub(boolean kidsclub) {
        this.kidsclub = kidsclub;
    }

    public boolean isEveningEntertainment() {
        return eveningEntertainment;
    }

    public void setEveningEntertainment(boolean eveningEntertainment) {
        this.eveningEntertainment = eveningEntertainment;
    }

    public int getmToCity() {
        return mToCity;
    }

    public void setmToCity(int mToCity) {
        this.mToCity = mToCity;
    }

    public int getmToBeach() {
        return mToBeach;
    }

    public void setmToBeach(int mToBeach) {
        this.mToBeach = mToBeach;
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

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

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


}
