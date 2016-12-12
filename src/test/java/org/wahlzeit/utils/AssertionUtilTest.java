package org.wahlzeit.utils;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.wahlzeit.utils.AssertionUtil.*;

public class AssertionUtilTest {

    @Test (expected = IllegalArgumentException.class)
    public void testAssertIsNotNull() throws IllegalArgumentException {
        assertIsNotNull(null);
    }

}