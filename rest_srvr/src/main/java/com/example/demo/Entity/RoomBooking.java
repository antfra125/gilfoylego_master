package com.example.demo.Entity;

public class RoomBooking {
    int id;
    int dateIn;
    int dateOut;
    boolean allInclusive = false;
    boolean fullPension = false;
    boolean halfPension = false;
    boolean extraBed = false;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDateIn() {
        return dateIn;
    }

    public void setDateIn(int dateIn) {
        this.dateIn = dateIn;
    }

    public int getDateOut() {
        return dateOut;
    }

    public void setDateOut(int dateOut) {
        this.dateOut = dateOut;
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
