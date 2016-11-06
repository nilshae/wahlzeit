package org.wahlzeit.services;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.wahlzeit.services.mailing.EmailServiceTest;
import org.wahlzeit.services.mailing.MailingTestSuite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        EmailServiceTest.class,
        MailingTestSuite.class,
        LogBuilderTest.class
})

public class ServicesTestSuite {
    // the class is empty, because it's only used as a holder for the above annotations
}