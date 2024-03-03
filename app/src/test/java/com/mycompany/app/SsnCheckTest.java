package com.mycompany.app;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class SsnCheckTest {


    @Test
    public void shouldAllowValidSsn() {
        SsnCheck<String> validity_checker = new SsnCheck<>();
        assertTrue(validity_checker.checkValidity("197802022389"));
    }


    @Test
    public void shouldAllowValidSsnWithDash() {
        SsnCheck<String> validity_checker = new SsnCheck<>();
        assertTrue(validity_checker.checkValidity("19820411-2380"));
    }


    @Test
    public void shouldDenyNullSsn() {
        SsnCheck<String> validity_checker = new SsnCheck<>();
        assertFalse(validity_checker.checkValidity(null));
    }


    @Test
    public void shouldDenyTooShortSsn() {
        SsnCheck<String> validity_checker = new SsnCheck<>();
        assertFalse(validity_checker.checkValidity("190338282"));
    }


    @Test
    public void shouldDenyTooLongSsn() {
        SsnCheck<String> validity_checker = new SsnCheck<>();
        assertFalse(validity_checker.checkValidity("19033823477678582"));
    }


    @Test
    public void shouldDenyNonNumericSsn() {
        SsnCheck<String> validity_checker = new SsnCheck<>();
        assertFalse(validity_checker.checkValidity("19780202aaaa"));
    }


    @Test
    public void shouldDenyWrongControlNumber() {
        SsnCheck<String> validity_checker = new SsnCheck<>();
        assertFalse(validity_checker.checkValidity("197802022383"));
    }


}
