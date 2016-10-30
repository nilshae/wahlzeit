package org.wahlzeit.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Test class for {@link Coordinate}.
 */
public class CoordinateTest {

    @Test
    public void testConstructor() {
        Coordinate coordinate = new Coordinate(100, 200);

        assertEquals(coordinate.getLatitude(), 100, 0);
        assertEquals(coordinate.getLongitude(), 200, 0);
    }

    @Test
    public void testGetDistance() {
        Coordinate coordinate1 = new Coordinate(50.2064932, -117.1873205);
        Coordinate coordinate2 = new Coordinate(50.2064932, -117.2373205);

        double distance = coordinate1.getDistance(coordinate2);

        assertEquals(distance, 3.5, 0.5);
    }

    @Test
    public void testGetDistanceSameLocation() {
        Coordinate coordinate1 = new Coordinate(1.0, 1.0);
        Coordinate coordinate2 = new Coordinate(1.0, 1.0);

        double distance = coordinate1.getDistance(coordinate2);

        assertEquals(distance, 0.0, 0);
    }

    @Test
    public void testGetDistanceCommutative() {
        Coordinate coordinate1 = new Coordinate(1.0, 1.0);
        Coordinate coordinate2 = new Coordinate(1.0, 1.0);

        assertEquals(coordinate1.getDistance(coordinate2), coordinate2.getDistance(coordinate1), 0);
    }
}