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
}