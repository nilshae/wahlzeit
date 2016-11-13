package org.wahlzeit.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Test class for {@link Location}.
 */
public class LocationTest {

    @Test
    public void testConstructor() {
        Coordinate testCoordinate = new Coordinate(0.0, 0.0);
        Location testLocation = new Location(testCoordinate);

        assertEquals(testLocation.getCoordinate(), testCoordinate);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidLocation() {
        Location testLocation = new Location(null);
    }
}