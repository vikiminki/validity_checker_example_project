package com.mycompany.app;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static java.lang.String.format;

public class NotNullCheck<T> implements Checkable<T> {

    private final Logger logger = LogManager.getLogger(NotNullCheck.class.getName());

    public NotNullCheck() {
    }


    @Override
    public boolean checkValidity(T data) {
        return data != null;

    }

    public void logNotValid() {
        this.logger.error(format("Data did not pass %s", NotNullCheck.class.getName()));
    }

}
