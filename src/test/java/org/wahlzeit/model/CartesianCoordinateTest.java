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
}