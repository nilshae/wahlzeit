package org.wahlzeit.model;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.wahlzeit.model.persistence.PersistenceTestSuite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        AccessRightsTest.class,
        CoordinateTest.class,
        FlagReasonTest.class,
        GenderTest.class,
        GuestTest.class,
        LampPhotoFactoryTest.class,
        LampPhotoManagerTest.class,
        LampPhotoTest.class,
        Location.class,
        PhotoFilterTest.class,
        PersistenceTestSuite.class,
        TagsTest.class,
        UserStatusTest.class,
        ValueTest.class
})

public class ModelTestSuite {
    // the class is empty, because it's only used as a holder for the above annotations
}