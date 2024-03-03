package com.mycompany.app;

import org.apache.logging.log4j.Logger;

public interface Checkable<T> {
    boolean checkValidity(T data);

    void logNotValid();


}




