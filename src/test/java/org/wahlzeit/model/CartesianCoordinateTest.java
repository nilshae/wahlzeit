package org.wahlzeit.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class CartesianCoordinateTest {
    @Test
    public void testEquals() {
        CartesianCoordinate firstCoordinate = CartesianCoordinate.getInstance(0, 0, 6371);
        CartesianCoordinate secondCoordinate = CartesianCoordinate.getInstance(0, 0, 6371);

        assertTrue(firstCoordinate.equals(secondCoordinate));
        assertTrue(secondCoordinate.equals(firstCoordinate));
        assertTrue(firstCoordinate == secondCoordinate);
    }

    @Test
    public void testEqualsNot() {
        CartesianCoordinate firstCoordinate = CartesianCoordinate.getInstance(0, 0, 6371);
        CartesianCoordinate secondCoordinate = CartesianCoordinate.getInstance(10, 0, 6371);

        assertFalse(firstCoordinate.equals(secondCoordinate));
        assertFalse(secondCoordinate.equals(firstCoordinate));
        assertFalse(firstCoordinate == secondCoordinate);
    }

    @Test
    public void testHashCode() {
        CartesianCoordinate firstCoordinate = CartesianCoordinate.getInstance(0, 0, 6371);
        CartesianCoordinate secondCoordinate = CartesianCoordinate.getInstance(0, 0, 6371);
        CartesianCoordinate thirdCoordinate = CartesianCoordinate.getInstance(10, 0, 6371);

        assertEquals(firstCoordinate, secondCoordinate);
        assertEquals(firstCoordinate, firstCoordinate);
        assertNotEquals(firstCoordinate, thirdCoordinate);
    }

    @Test
    public void testConstructor() {
        CartesianCoordinate coordinate = CartesianCoordinate.getInstance(-6371, 0, 0);

        assertEquals(-6371, coordinate.getX(), 0);
        assertEquals(0, coordinate.getY(), 0);
        assertEquals(0, coordinate.getZ(), 0);
    }

    @Test
    public void testGetCartesianCoordinates() {
        Coordinate coordinate = CartesianCoordinate.getInstance(0, 0, 6371);

        double x = coordinate.cartesianX();
        double y = coordinate.cartesianY();
        double z = coordinate.cartesianZ();

        assertEquals(0, x, 0);
        assertEquals(0, y, 0);
        assertEquals(6371, z, 0);
    }
}