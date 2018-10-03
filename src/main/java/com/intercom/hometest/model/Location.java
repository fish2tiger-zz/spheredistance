package com.intercom.hometest.model;

/**
 * The Location class represents the geo-coordinates of
 * any subjects on earth.
 */
public class Location {
    private double latitude;
    private double longitude;

    public Location() {
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

    @Override
    public String toString() {
        return "Location { " +
                " latitude= " + latitude +
                ", longitude=" + longitude +
                '}';
    }
}
