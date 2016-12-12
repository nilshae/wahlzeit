package org.wahlzeit.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class AbstractCoordinateTest {

    @Test
    public void testIsEqualSphericalCoordinates() {
        Coordinate coordinate1 = new SphericalCoordinate(50.2064932, -117.1873205, 6371);
        Coordinate coordinate2 = new SphericalCoordinate(50.2064932, -117.1873205, 6371);

        assertTrue(coordinate1.isEqual(coordinate2));
    }

    @Test
    public void testIsEqualCartesianCoordinates() {
        Coordinate coordinate1 = new CartesianCoordinate(200, -100, 6371);
        Coordinate coordinate2 = new CartesianCoordinate(200, -100, 6371);

        assertTrue(coordinate1.isEqual(coordinate2));
    }

    @Test
    public void testIsEqualDifferentTypes() {
        Coordinate coordinate1 = new CartesianCoordinate(6371, 0, 0);
        Coordinate coordinate2 = new SphericalCoordinate(0, 0, 6371);

        assertTrue(coordinate1.isEqual(coordinate2));
    }

    @Test
    public void testIsEqualDifferentCoordinatesTypes() {
        Coordinate coordinate1 = new SphericalCoordinate(50.2064932, -117.1873205, 6371);
        Coordinate coordinate2 = new CartesianCoordinate(200, -100, 6371);

        assertFalse(coordinate1.isEqual(coordinate2));
    }

    @Test
    public void testGetDistanceSphericalCoordinates() {
        Coordinate coordinate1 = new SphericalCoordinate(50.2064932, -117.1873205, 6371);
        Coordinate coordinate2 = new SphericalCoordinate(50.2064932, -117.2373205, 6371);

        double distance = coordinate1.getDistance(coordinate2);

        assertEquals(3.5, distance, 0.5);
    }

    @Test
    public void testGetDistanceCartesianCoordinates() {
        // This is only a simple test, because the getDistance() extensively
        // tested in SphericalCoordinateTest

        CartesianCoordinate coordinate1 = new CartesianCoordinate(6371, 0, 0);
        CartesianCoordinate coordinate2 = new CartesianCoordinate(0, 6371, 0);

        double distance = coordinate1.getDistance(coordinate2);

        assertEquals(9009.95, distance, 0.01);
    }

    @Test
    public void testGetDistanceDifferentTypes() {
        Coordinate coordinate1 = new CartesianCoordinate(6371, 0, 0);
        Coordinate coordinate2 = new SphericalCoordinate(0, 0, 6371);

        assertEquals(0, coordinate1.getDistance(coordinate2), 0);
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
        SphericalCoordinate coordinate2 = new SphericalCoordinate(50.0, 1.0, 6371);

        assertEquals(coordinate1.getDistance(coordinate2), coordinate2.getDistance(coordinate1), 0);
    }
}
