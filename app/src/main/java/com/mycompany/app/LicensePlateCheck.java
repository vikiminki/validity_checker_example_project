package com.mycompany.app;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static java.lang.String.format;

public class LicensePlateCheck<T> implements Checkable<T> {

    private final Logger logger = LogManager.getLogger(LicensePlateCheck.class.getName());

    public LicensePlateCheck() {
    }

    ;

    @Override
    public boolean checkValidity(T data) {
        // Trivially false if:
        // * data is not a string
        // * data is an empty string
        // * data consists of only whitespace or escape characters
        // * length of string (without whitespace) is not 6 characters
        if (!(data instanceof String) || (((String) data).isBlank()) || !(((String) data).replaceAll("\\s", "").length() == 6)) {
            return false;
        }

        String string = ((String) data).replaceAll("\\s", "").toUpperCase();

        // Check if first 3 chars are alphabetic, following 2 are numeric and last char is either
        return formatIsCorrect(string);
    }

    @Override
    public void logNotValid() {
        this.logger.error(format("Data did not pass %s\n", LicensePlateCheck.class.getName()));
    }

    private boolean formatIsCorrect(String string) {
        return string.matches("[A-Z]{3}[0-9]{2}([A-Z]|[0-9])");
    }

}
