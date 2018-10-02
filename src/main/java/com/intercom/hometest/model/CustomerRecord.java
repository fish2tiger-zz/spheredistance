package com.intercom.hometest.model;

public class CustomerRecord implements Comparable<String>{
    private String user_id;
    private String name;
    private Location location;

    public CustomerRecord(String user_id, String customerName, double latitude, double longitude) {
        this.user_id = user_id;
        this.name = customerName;
        this.location = new CustomerLocation( latitude, longitude);
    }

    public String getCustomerName() {
        return name;
    }

    public void setCustomerName(String customerName) {
        this.name = customerName;
    }

    public String getUser_id() {
        return user_id;
    }

    public Location getLocation() {
        return location;
    }

    @Override
    public int compareTo(String o) {
        return 0;
    }

    @Override
    public String toString() {
        return "CustomerRecord{" +
                "user_id='" + user_id + '\'' +
                ", name='" + name + '\'' +
                ", location=" + location +
                '}';
    }
}

