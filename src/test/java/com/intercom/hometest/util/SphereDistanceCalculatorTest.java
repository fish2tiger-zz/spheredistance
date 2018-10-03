package com.intercom.hometest.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SphereDistanceCalculatorTest {
    double[] coordinatesP1 = {53.339428, -6.257664};
    double[] northPoleCoordinates = {90, 0};
    double[] southPoleCoordinates = {-90, 0};
    double earthCircumference = 2 * Math.PI * SphereDistanceCalculator.AVG_RADIUS_OF_EARTH_KM;

    @Test
    @DisplayName("poles distance")
    void testDistanceBetweenPoles() {

        double polesDistance = SphereDistanceCalculator.getGreatCircleDis(
                northPoleCoordinates[0], northPoleCoordinates[1],
                southPoleCoordinates[0], southPoleCoordinates[1]
        );

        double earthCircumferenceHalf = earthCircumference / 2;
        assertEquals(earthCircumferenceHalf, polesDistance, "poles distance should be half of the earth ");
    }

    @Test
    @DisplayName("same point distance")
    void testSamePoint() {
        double sphereDistance = SphereDistanceCalculator.getGreatCircleDis(
                coordinatesP1[0], coordinatesP1[1],
                coordinatesP1[0], coordinatesP1[1]
        );
        assertEquals(0, sphereDistance, "sphere distance should be 0 for same point");
    }
}
