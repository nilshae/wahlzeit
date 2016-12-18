package org.wahlzeit.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Test class for {@link Location}.
 */
public class LocationTest {

    @Test
    public void testConstructor() {
        Coordinate testCoordinate = SphericalCoordinate.getInstance(0.0, 0.0, 6371);
        Location testLocation = new Location(testCoordinate);

        assertEquals(testCoordinate, testLocation.getCoordinate());
    }
}