package com.intercom.hometest.util;

import com.intercom.hometest.model.Location;

public class SphereDistanceUtil {
    private static final double AVG_RADIUS_OF_EARTH_KM = 6371;

    /**
     * Calculate the shortest distance between two points on the surface of
     * sphere using spherical law of cosines.
     *
     * @param x1 latitude for point1
     * @param y1 longitude for point1
     * @param x2 latitude for point2
     * @param y2 longitude for point2
     * @return sphere distance in kilometer
     */
    public static double getGreatCircleDis(double x1, double y1, double x2, double y2){
        // convert degrees to radians
        double x1Radian = Math.toRadians(x1);
        double y1Radian = Math.toRadians(y1);
        double x2Radian = Math.toRadians(x2);
        double y2Radian = Math.toRadians(y2);
        //Compute great distance using law of cosines
        double angle1 = Math.acos(Math.sin(x1Radian) * Math.sin(x2Radian)
                + Math.cos(x1Radian) * Math.cos(x2Radian) * Math.cos(Math.abs(y1Radian - y2Radian)));

        return angle1*AVG_RADIUS_OF_EARTH_KM;
    }

    /**
     *
     * @param range max distance between center and subject
     * @param center the center object with latitude/longitude info
     * @param subject the subject object with latitude/longitude info
     * @return true if within the range, otherwise false
     */
    public static final boolean isWithinRange(double range, Location center, Location subject){
        return getGreatCircleDis(center.getLatitude(), center.getLongitude(), subject.getLatitude(), subject.getLongitude()) <= range;
    }

}
