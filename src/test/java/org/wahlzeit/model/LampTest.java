package org.wahlzeit.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Test class for {@link Lamp}.
 */
public class LampTest {
    Lamp testLamp;
    LampType testType;

    @Before
    public void setUp() {
        testType = new LampType("Test Lamp 2.0", LampType.Material.METAL, LampType.Kind.HANGING_LAMP, false);
        testLamp = new Lamp(testType);
    }

    @Test
    public void testConstructor() {
        assertEquals(testType, testLamp.getType());
        Integer testId = testLamp.hashCode();
        assertEquals(testId, testLamp.getId());
    }
}
