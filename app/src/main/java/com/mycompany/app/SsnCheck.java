package com.mycompany.app;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static java.lang.String.format;

public class SsnCheck<T> implements Checkable<T> {

    private final Logger logger = LogManager.getLogger(SsnCheck.class.getName());

    public SsnCheck() {
    }


    @Override
    public boolean checkValidity(T data) {
        // Trivially false if:
        // * data is not a string
        // * data is an empty string
        // * data consists of only whitespace
        // * length of string (after trim of whitespace/dash) is not 12 characters
        if (!(data instanceof String) || (((String) data).isBlank()) || !(((String) data).replaceAll("[\\s\\-]", "").length() == 12)) {
            return false;
        }
        String string = ((String) data).replaceAll("[\\s\\-]", "");

        return formatIsCorrect(string) && controlNumberIsCorrect(string);
    }


    @Override
    public void logNotValid() {
        this.logger.error(format("Data did not pass %s\n", SsnCheck.class.getName()));

    }


    private boolean formatIsCorrect(String string) {
        return string.matches("(19|20)[0-9]{10}");
    }

    private boolean controlNumberIsCorrect(String string) {
        int sum = 0;

        for (int i = 2; i < string.length() - 1; i++) {
            int c = Character.getNumericValue(string.charAt(i));

            int multiplying_factor = 1;
            if (i % 2 == 0) {
                multiplying_factor = 2;
            }
            int multiplied_nr = c * multiplying_factor;

            if (multiplied_nr > 10) {
                multiplied_nr = (multiplied_nr - 10) + 1;
            }
            sum += multiplied_nr;
        }

        int control_nr = Character.getNumericValue(string.charAt(string.length() - 1));

        return (control_nr == (10 - (sum % 10)) % 10);
    }
}
