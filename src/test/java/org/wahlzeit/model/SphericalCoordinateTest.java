package org.wahlzeit.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Test class for {@link SphericalCoordinate}.
 */
public class SphericalCoordinateTest {

    @Test
    public void testConstructor() {
        SphericalCoordinate coordinate = new SphericalCoordinate(90, 170, 6371);

        assertEquals(90, coordinate.getLatitude(), 0);
        assertEquals(170, coordinate.getLongitude(), 0);
        assertEquals(6371, coordinate.getRadius(), 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testUpperBoundLatitude() {
        Coordinate coordinate = new SphericalCoordinate(100, 160, 6371);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testLowerBoundLatitude() {
        Coordinate coordinate = new SphericalCoordinate(-100, 160, 6371);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testUpperBoundLongitude() {
        Coordinate coordinate = new SphericalCoordinate(50, 200, 6371);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testLowerBoundLongitude() {
        Coordinate coordinate = new SphericalCoordinate(50, -200, 6371);
    }

    @Test
    public void testGetDistance() {
        Coordinate coordinate1 = new SphericalCoordinate(50.2064932, -117.1873205, 6371);
        Coordinate coordinate2 = new SphericalCoordinate(50.2064932, -117.2373205, 6371);

        double distance = coordinate1.getDistance(coordinate2);

        assertEquals(3.5, distance, 0.5);
    }

    @Test
    public void testGetDistanceSameLocation() {
        Coordinate coordinate1 = new SphericalCoordinate(1.0, 1.0, 6371);
        SphericalCoordinate coordinate2 = new SphericalCoordinate(1.0, 1.0, 6371);

        double distance = coordinate1.getDistance(coordinate2);

        assertEquals(0.0, distance, 0);
    }

    @Test
    public void testGetDistanceCommutative() {
        SphericalCoordinate coordinate1 = new SphericalCoordinate(1.0, 1.0, 6371);
        SphericalCoordinate coordinate2 = new SphericalCoordinate(1.0, 1.0, 6371);

        assertEquals(coordinate1.getDistance(coordinate2), coordinate2.getDistance(coordinate1), 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetDistanceInvalidArgument() {
        Coordinate coordinate1 = new SphericalCoordinate(1.0, 1.0, 6371);
        coordinate1.getDistance(null);
    }
}