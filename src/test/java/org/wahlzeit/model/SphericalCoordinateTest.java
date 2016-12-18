package org.wahlzeit.model;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Test class for {@link SphericalCoordinate}.
 */
public class SphericalCoordinateTest {
    @Test
    public void testEquals() {
        SphericalCoordinate firstCoordinate = SphericalCoordinate.getInstance(90, 170, 6371);
        SphericalCoordinate secondCoordinate = SphericalCoordinate.getInstance(90, 170, 6371);

        assertTrue(firstCoordinate.equals(secondCoordinate));
        assertTrue(secondCoordinate.equals(firstCoordinate));
        assertTrue(firstCoordinate == secondCoordinate);
    }

    @Test
    public void testEqualsNot() {
        SphericalCoordinate firstCoordinate = SphericalCoordinate.getInstance(90, 170, 6371);
        SphericalCoordinate secondCoordinate = SphericalCoordinate.getInstance(10, 170, 6371);

        assertFalse(firstCoordinate.equals(secondCoordinate));
        assertFalse(secondCoordinate.equals(firstCoordinate));
        assertFalse(firstCoordinate == secondCoordinate);
    }

    @Test
    public void testHashCode() {
        SphericalCoordinate firstCoordinate = SphericalCoordinate.getInstance(90, 170, 6371);
        SphericalCoordinate secondCoordinate = SphericalCoordinate.getInstance(90, 170, 6371);
        SphericalCoordinate thirdCoordinate = SphericalCoordinate.getInstance(10, 170, 6371);

        assertEquals(firstCoordinate.hashCode(), secondCoordinate.hashCode());
        assertEquals(firstCoordinate.hashCode(), firstCoordinate.hashCode());
        assertNotEquals(firstCoordinate.hashCode(), thirdCoordinate.hashCode());
    }

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