package org.wahlzeit.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Test class for {@link Location}.
 */
public class LocationTest {

    @Test
    public void testConstructor() {
        Coordinate testCoordinate = new SphericalCoordinate(0.0, 0.0, 6371);
        Location testLocation = new Location(testCoordinate);

        assertEquals(testCoordinate, testLocation.getCoordinate());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidLocation() {
        Location testLocation = new Location(null);
    }
}