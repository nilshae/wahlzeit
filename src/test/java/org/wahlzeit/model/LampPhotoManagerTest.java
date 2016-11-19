package org.wahlzeit.model;

import org.junit.ClassRule;
import org.junit.Test;
import org.junit.rules.RuleChain;
import org.junit.rules.TestRule;
import org.wahlzeit.testEnvironmentProvider.LocalDatastoreServiceTestConfigProvider;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertThat;

/**
 * Test class for {@link LampPhotoManager}.
 */
public class LampPhotoManagerTest {

    // this rule chain is needed to instantiate a Photo in a test environment
    @ClassRule
    public static TestRule ruleChain = RuleChain.outerRule(new LocalDatastoreServiceTestConfigProvider());

    @Test
    public void testInstanceOf() {
        PhotoManager testManager = new LampPhotoManager();
        PhotoManager instance = testManager.getInstance();

        assertThat(instance, instanceOf(LampPhotoManager.class));
    }
}
