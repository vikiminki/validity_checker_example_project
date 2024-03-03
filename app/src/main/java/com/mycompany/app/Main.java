package com.mycompany.app;
import com.mycompany.app.LicensePlateCheck.*;

public class Main {

    public static void main (String []args) {
        ValidityChecker validity_checker = new ValidityChecker<>();
        validity_checker.addValidityCheck(new NotNullCheck<>());
        validity_checker.addValidityCheck(new SsnCheck<>());
        validity_checker.addValidityCheck(new LicensePlateCheck<>());
        validity_checker.performValidityChecks("USZ971");
    }
}
