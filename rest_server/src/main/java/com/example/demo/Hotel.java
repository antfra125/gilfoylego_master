package com.example.demo;

public class Hotel {
    int id;
    String name;
    boolean hasRestaurant = false;
    boolean hasPool = false;
    boolean hasKidsClub = false;
    boolean hasNightEntertainment = false;
    int mToCity;
    int mToBeach;
    double rating;
    String description;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public boolean isHasNightEntertainment() {
        return hasNightEntertainment;
    }

    public void setHasNightEntertainment(boolean hasNightEntertainment) {
        this.hasNightEntertainment = hasNightEntertainment;
    }

    public int getMToCity() {
        return mToCity;
    }

    public void setMToCity(int mToCity) {
        this.mToCity = mToCity;
    }

    public int getMToBeach() {
        return mToBeach;
    }

    public void setMToBeach(int mToBeach) {
        this.mToBeach = mToBeach;
    }
}
