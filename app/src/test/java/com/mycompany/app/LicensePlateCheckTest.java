package com.mycompany.app;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class LicensePlateCheckTest {


    @Test
    public void shouldAllowStandardValidLicensePlate() {
        LicensePlateCheck<String> validity_checker = new LicensePlateCheck<>();
        assertTrue(validity_checker.checkValidity("USZ971"));
    }


    @Test
    public void shouldAllowNewTypeValidLicensePlate() {
        LicensePlateCheck<String> validity_checker = new LicensePlateCheck<>();
        assertTrue(validity_checker.checkValidity("ABC99D"));
    }


    @Test
    public void shouldAllowValidLicensePlateWithSpaces() {
        LicensePlateCheck<String> validity_checker = new LicensePlateCheck<>();
        assertTrue(validity_checker.checkValidity("USZ 971"));
    }


    @Test
    public void shouldAllowLicensePlateWithAnyWhitespace() {
        LicensePlateCheck<String> validity_checker = new LicensePlateCheck<>();
        assertTrue(validity_checker.checkValidity(" ABC 989 "));
    }


    @Test
    public void shouldAllowLicensePlateWithLowercaseLetters() {
        LicensePlateCheck<String> validity_checker = new LicensePlateCheck<>();
        assertTrue(validity_checker.checkValidity("abc989"));
    }


    @Test
    public void shouldDenyAllAlphabeticLicensePlate() {
        LicensePlateCheck<String> validity_checker = new LicensePlateCheck<>();
        assertFalse(validity_checker.checkValidity("ABCDEF"));
    }


    @Test
    public void shouldDenyAllNumericLicensePlate() {
        LicensePlateCheck<String> validity_checker = new LicensePlateCheck<>();
        assertFalse(validity_checker.checkValidity("111111"));
    }


    @Test
    public void shouldDenyTooShortLicensePlate() {
        LicensePlateCheck<String> validity_checker = new LicensePlateCheck<>();
        assertFalse(validity_checker.checkValidity("ABC11"));
    }


    @Test
    public void shouldDenyInvalidLicensePlate() {
        LicensePlateCheck<String> validity_checker = new LicensePlateCheck<>();
        assertFalse(validity_checker.checkValidity("ABCA98"));
    }


}
