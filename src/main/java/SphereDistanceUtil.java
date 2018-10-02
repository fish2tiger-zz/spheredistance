public class SphereDistanceUtil {
    private static final double AVG_RADIUS_OF_EARTH_KM = 6371;
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
}
