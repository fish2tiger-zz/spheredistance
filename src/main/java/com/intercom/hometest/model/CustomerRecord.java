package com.intercom.hometest.model;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * The CustomerRecord class represents the each customer and encapsulate
 * the information about their location, name and id.
 */
public class CustomerRecord implements Comparable<CustomerRecord> {
    private String user_id;
    private String name;
    private double latitude;
    private double longitude;
    private Location location;

    public CustomerRecord(String user_id, String customerName, double latitude, double longitude) {
        this.user_id = user_id;
        this.name = customerName;
        this.latitude = latitude;
        this.longitude = longitude;
        this.location = new CustomerLocation(latitude, longitude);
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
        // Gson serialization won't set this variable
        if (location == null)
            return new Location(latitude, longitude);
        return this.location;
    }

    @Override
    public String toString() {
        return "CustomerRecord {" +
                "user_id='" + user_id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    public static void main(String[] args) {
        List<String> list = Arrays.asList("1", "18", "5", "2");
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() != o2.length())
                    return (o1.length() - o2.length());
                else
                    return o1.compareTo(o2);
            }
        });
        System.out.println(list);
    }

    @Override
    public int compareTo(CustomerRecord o) {
        if (this.user_id.length() != o.user_id.length())
            return this.user_id.length() - o.user_id.length();
        else
            return this.user_id.compareTo(o.user_id);
    }
}

