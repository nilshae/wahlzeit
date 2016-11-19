package org.wahlzeit.model;

import org.junit.ClassRule;
import org.junit.Test;
import org.junit.rules.RuleChain;
import org.junit.rules.TestRule;
import org.wahlzeit.testEnvironmentProvider.LocalDatastoreServiceTestConfigProvider;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertThat;

/**
 * Test class for {@link LampPhotoFactory}.
 */
public class LampPhotoFactoryTest {

    // this rule chain is needed to instantiate a Photo in a test environment
    @ClassRule
    public static TestRule ruleChain = RuleChain.outerRule(new LocalDatastoreServiceTestConfigProvider());

    @Test
    public void testCreatePhoto() {
        LampPhotoFactory testFactory = new LampPhotoFactory();

        Photo testPhoto = testFactory.createPhoto();
        assertThat(testPhoto, instanceOf(LampPhoto.class));
    }

    @Test
    public void testCreatePhotoWithId() {
        LampPhotoFactory testFactory = new LampPhotoFactory();

        PhotoId id = new PhotoId(11);
        Photo testPhoto = testFactory.createPhoto(id);
        assertThat(testPhoto, instanceOf(LampPhoto.class));
    }

    @Test
    public void testInstanceOf() {
        PhotoFactory testFactory = new LampPhotoFactory();
        PhotoFactory instance = testFactory.getInstance();

        assertThat(instance, instanceOf(LampPhotoFactory.class));
    }


}
