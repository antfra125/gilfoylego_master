package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Set;

@Entity
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "country_id")
    @JsonBackReference(value="city_country")
    private Country country;
    @Column
    private String name;
    @OneToMany(mappedBy = "city")
    @JsonManagedReference(value="hotel_city")
    private Set<Hotel> hotels;

    public Set<Hotel> getHotels() {
        return hotels;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCountry() {
        return country.getName();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}