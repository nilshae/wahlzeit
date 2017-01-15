package org.wahlzeit.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Test class for {@link LampType}.
 */
public class LampTypeTest {
    LampType testType;

    @Before
    public void setUp() {
        testType = new LampType("IKEA Lamp 2.0", LampType.Material.METAL, LampType.Kind.HANGING_LAMP, false);
    }

    @Test
    public void testConstructor() {
        assertEquals("IKEA Lamp 2.0", testType.getModelName());
        assertEquals(LampType.Material.METAL, testType.getMaterial());
        assertEquals(LampType.Kind.HANGING_LAMP, testType.getKind());
        assertEquals(false, testType.isVintage());
    }

    @Test
    public void createInstanceTest() {
        Lamp lamp = testType.createInstance();

        assertEquals("IKEA Lamp 2.0", lamp.getType().getModelName());
        assertEquals(LampType.Material.METAL, lamp.getType().getMaterial());
        assertEquals(LampType.Kind.HANGING_LAMP, lamp.getType().getKind());
        assertEquals(false, lamp.getType().isVintage());
    }



    @Test
    public void addSubTypeTest() {
        LampType subType = new LampType("IKEA Lamp 4.0", LampType.Material.WOOD, LampType.Kind.FLOOR_LAMP, true);

        testType.addSubType(subType);

        assertTrue(subType.isSubTypeOf(testType));
        assertEquals(testType, subType.getSuperType());
    }

    @Test
    public void isSubTypeOfSubTypeTest() {
        LampType subType = new LampType("IKEA Lamp 4.0", LampType.Material.WOOD, LampType.Kind.FLOOR_LAMP, true);

        testType.addSubType(subType);

        assertFalse(testType.isSubTypeOf(subType));
    }

    @Test
    public void isSubTypeOfSuperTypeTest() {
        LampType superType = new LampType("IKEA Lamp 4.0", LampType.Material.WOOD, LampType.Kind.FLOOR_LAMP, true);

        superType.addSubType(testType);

        assertTrue(testType.isSubTypeOf(superType));
    }

    @Test
    public void isSubTypeOfNotRelatedTypeTest() {
        LampType otherType = new LampType("IKEA Lamp 4.0", LampType.Material.WOOD, LampType.Kind.FLOOR_LAMP, true);

        assertFalse(testType.isSubTypeOf(otherType));
    }

    @Test
    public void hasInstanceTest() {
        LampType otherType = new LampType("IKEA Lamp 4.0", LampType.Material.WOOD, LampType.Kind.FLOOR_LAMP, true);
        Lamp otherLamp = otherType.createInstance();

        Lamp testTypeLamp = testType.createInstance();

        assertTrue(testType.hasInstance(testTypeLamp));
        assertFalse(testType.hasInstance(otherLamp));
    }
}
