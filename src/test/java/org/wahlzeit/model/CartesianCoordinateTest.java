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
    public void testOnXAxisConvertToSpherical() {
        CartesianCoordinate cartesianCoordinate = new CartesianCoordinate(6371, 0, 0);
        SphericalCoordinate sphericalCoordinate = new SphericalCoordinate(0, 90, 6371);

        SphericalCoordinate convertedCoordinate = cartesianCoordinate.convertToSpherical();

        assertEquals(sphericalCoordinate.getLongitude(), convertedCoordinate.getLongitude(), 0);
        assertEquals(sphericalCoordinate.getLatitude(), convertedCoordinate.getLatitude(), 0);
    }

    @Test
    public void testOnYAxisConvertToSpherical() {
        CartesianCoordinate cartesianCoordinate = new CartesianCoordinate(0, 6371, 0);
        SphericalCoordinate sphericalCoordinate = new SphericalCoordinate(90, 90, 6371);

        SphericalCoordinate convertedCoordinate = cartesianCoordinate.convertToSpherical();

        assertEquals(sphericalCoordinate.getLongitude(), convertedCoordinate.getLongitude(), 0);
        assertEquals(sphericalCoordinate.getLatitude(), convertedCoordinate.getLatitude(), 0);
    }

    @Test
    public void testOnZAxisConvertToSpherical() {
        CartesianCoordinate cartesianCoordinate = new CartesianCoordinate(0, 0, 6371);
        SphericalCoordinate sphericalCoordinate = new SphericalCoordinate(0, 0, 6371);

        SphericalCoordinate convertedCoordinate = cartesianCoordinate.convertToSpherical();

        assertEquals(sphericalCoordinate.getLongitude(), convertedCoordinate.getLongitude(), 0);
        assertEquals(sphericalCoordinate.getLatitude(), convertedCoordinate.getLatitude(), 0);
    }
}