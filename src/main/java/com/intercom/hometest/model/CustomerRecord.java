package com.intercom.hometest.model;

public class CustomerRecord {
    private String customerName;
    private double latitude;
    private double longitude;

    public CustomerRecord(String customerName, double latitude, double longitude) {
        this.customerName = customerName;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
}
