package org.wahlzeit.model.persistence;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        AbstractAdapterTest.class,
        DatastoreAdapterTest.class,
        GcsAdapterTest.class
})

public class PersistenceTestSuite {
    // the class is empty, because it's only used as a holder for the above annotations
}