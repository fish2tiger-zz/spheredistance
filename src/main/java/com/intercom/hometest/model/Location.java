package com.intercom.hometest.model;

public class Location {
    protected double latitude;
    protected double longitude;

    public Location(){

    }

    public Location(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public double getLatitude() {
        return latitude;
    }
}
