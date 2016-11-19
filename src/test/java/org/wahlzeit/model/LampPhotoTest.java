package org.wahlzeit.model;

import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.rules.RuleChain;
import org.junit.rules.TestRule;
import org.wahlzeit.testEnvironmentProvider.LocalDatastoreServiceTestConfigProvider;

import static junit.framework.TestCase.assertEquals;

/**
 * Test class for {@link LampPhoto}.
 */
public class LampPhotoTest {

    // this rule chain is needed to instantiate a Photo in an test environment
    @ClassRule
    public static TestRule ruleChain = RuleChain.outerRule(new LocalDatastoreServiceTestConfigProvider());

    LampPhoto testPhoto;

    @Before
    public void setUp() {
        testPhoto = new LampPhoto();
    }

    @Test
    public void testConstructor() {
        assertEquals(LampPhoto.Material.OTHER, testPhoto.getMaterial());
        assertEquals(LampPhoto.Type.NOT_DEFINED, testPhoto.getType());
        assertEquals(false, testPhoto.isVintage());
    }

    @Test
    public void testSetMaterial() {
        testPhoto.setMaterial(LampPhoto.Material.METAL);
        assertEquals(LampPhoto.Material.METAL, testPhoto.getMaterial());
    }

    @Test
    public void testSetType() {
        testPhoto.setType(LampPhoto.Type.FLOOR_LAMP);
        assertEquals(LampPhoto.Type.FLOOR_LAMP, testPhoto.getType());
    }

     @Test
    public void testSetVintage() {
        testPhoto.setVintage(true);
        assertEquals(true, testPhoto.isVintage());
    }
}
