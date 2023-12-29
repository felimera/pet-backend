package com.petproject.appcustomer.infrastructure.util;

public class Constants {

    private Constants() {
        throw new IllegalStateException(Constants.class.toString());
    }

    public static final String REGULARPHRASE_BIRTHDATE = "^\\d{4}\\-(0[1-9]|1[012])\\-(0[1-9]|[12][0-9]|3[01])$";
}
