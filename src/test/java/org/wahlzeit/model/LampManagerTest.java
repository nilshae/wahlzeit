package org.wahlzeit.model;

import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.rules.RuleChain;
import org.junit.rules.TestRule;
import org.wahlzeit.testEnvironmentProvider.LocalDatastoreServiceTestConfigProvider;

import static org.hamcrest.core.IsInstanceOf.instanceOf;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

/**
 * Test class for {@link LampManager}.
 */
public class LampManagerTest {
    private LampManager testManager;

    @ClassRule
    public static TestRule ruleChain = RuleChain.outerRule(new LocalDatastoreServiceTestConfigProvider());

    @Before
    public void setUp() {
        testManager = LampManager.getInstance();
    }

    @Test
    public void testInstanceOf() {
        assertThat(testManager, instanceOf(LampManager.class));
    }

    @Test
    public void testCreateLamp() {
        Lamp lamp = testManager.createLamp("IKEA Lamp 1.0", LampType.Material.METAL, LampType.Kind.FLOOR_LAMP, true);

        assertEquals("IKEA Lamp 1.0", lamp.getType().getModelName());
        assertEquals(LampType.Material.METAL, lamp.getType().getMaterial());
        assertEquals(LampType.Kind.FLOOR_LAMP, lamp.getType().getKind());
        assertEquals(true, lamp.getType().isVintage());

        assertThat(testManager, instanceOf(LampManager.class));
    }


}
