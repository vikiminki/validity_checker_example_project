package com.mycompany.app;

import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;


public class NotNullCheckTest {


    @Test
    public void shouldAllowString() {
        NotNullCheck<String> validity_checker = new NotNullCheck<>();
        assertTrue(validity_checker.checkValidity("Not null"));
    }

    @Test
    public void shouldAllowInt() {
        NotNullCheck<Integer> validity_checker = new NotNullCheck<>();
        assertTrue(validity_checker.checkValidity(1));
    }


    @Test
    public void shouldDenyNull() {
        NotNullCheck<?> validity_checker = new NotNullCheck<>();
        assertFalse(validity_checker.checkValidity(null));
    }
}
