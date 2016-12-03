package org.wahlzeit.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class CartesianCoordinateTest {

    @Test
    public void testConstructor() {
        CartesianCoordinate coordinate = new CartesianCoordinate(-6371, 0, 0);

        assertEquals(-6371, coordinate.getX(), 0);
        assertEquals(0, coordinate.getY(), 0);
        assertEquals(0, coordinate.getZ(), 0);
    }

    @Test
    public void testGetCartesianCoordinates() {
        Coordinate coordinate = new CartesianCoordinate(0, 0, 6371);

        double x = coordinate.cartesianX();
        double y = coordinate.cartesianY();
        double z = coordinate.cartesianZ();

        assertEquals(0, x, 0);
        assertEquals(0, y, 0);
        assertEquals(6371, z, 0);
    }
}