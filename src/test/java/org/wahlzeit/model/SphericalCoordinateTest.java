package org.wahlzeit.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Test class for {@link SphericalCoordinate}.
 */
public class SphericalCoordinateTest {

    @Test
    public void testConstructor() {
        SphericalCoordinate coordinate = SphericalCoordinate.getInstance(90, 170, 6371);

        assertEquals(90, coordinate.getLatitude(), 0);
        assertEquals(170, coordinate.getLongitude(), 0);
        assertEquals(6371, coordinate.getRadius(), 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testUpperBoundLatitude() {
        Coordinate coordinate = SphericalCoordinate.getInstance(100, 160, 6371);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testLowerBoundLatitude() {
        Coordinate coordinate = SphericalCoordinate.getInstance(-100, 160, 6371);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testUpperBoundLongitude() {
        Coordinate coordinate = SphericalCoordinate.getInstance(50, 200, 6371);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testLowerBoundLongitude() {
        Coordinate coordinate = SphericalCoordinate.getInstance(50, -200, 6371);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNegativeRadius() {
        Coordinate coordinate = SphericalCoordinate.getInstance(50, -100, -6371);
    }

    @Test
    public void testGetCartesianCoordinates() {
        Coordinate coordinate = SphericalCoordinate.getInstance(0, 0, 6371);

        double x = coordinate.cartesianX();
        double y = coordinate.cartesianY();
        double z = coordinate.cartesianZ();

        assertEquals(0, x, 0);
        assertEquals(0, y, 0);
        assertEquals(6371, z, 0);
    }
}