package com.mycompany.app;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


/**
 * Unit test for Validity Checker
 */
public class ValidityCheckerTest {


    /**
     * Empty validity checker should always return true
     */
    @Test
    public void shouldAllowRandomStringWhenNotCheckingValidity() {
        ValidityChecker<Object> validity_checker = new ValidityChecker<>();
        assertTrue(validity_checker.performValidityChecks("A random string"));
    }

    /**
     * Empty validity checker should always return true
     */
    @Test
    public void shouldAllowNullWhenNotCheckingValidity() {
        ValidityChecker<Object> validity_checker = new ValidityChecker<>();
        assertTrue(validity_checker.performValidityChecks(null));
    }


    @Test
    public void shouldAllowValidSSN() {
        ValidityChecker<Object> checker = new ValidityChecker<>();
        checker.addValidityCheck(new NotNullCheck<>());
        checker.addValidityCheck(new SsnCheck<>());
        assertTrue(checker.performValidityChecks("197802022389"));
    }


    @Test
    public void shouldDenyInvalidSSN() {
        ValidityChecker<Object> validity_checker = new ValidityChecker<>();
        validity_checker.addValidityCheck(new NotNullCheck<>());
        validity_checker.addValidityCheck(new SsnCheck<>());
        assertFalse(validity_checker.performValidityChecks("RandomString"));
    }


}
