package com.mycompany.app;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class ValidityChecker<T> {

    private final List<Checkable<?>> checksToPerform = new ArrayList<>();
    private final Logger logger = LogManager.getLogger(ValidityChecker.class.getName());

    public ValidityChecker() {
    }

    ;

    public void addValidityCheck(Checkable<?> validityCheck) {
        if (validityCheck != null) {
            this.checksToPerform.add(validityCheck);
        }
    }

    public boolean performValidityChecks(T data) {

        boolean valid = true;
        for (Checkable validityCheck : this.checksToPerform) {
            if (!validityCheck.checkValidity(data)) {
                validityCheck.logNotValid();
                valid = false;
            }
        }
        if (!valid) {
            this.logger.error("One or more validity checks did not pass");
        }
        return valid;
    }


}
