package com.project.appmedia.util;

public class CadenaUtil {

    private CadenaUtil() {
        throw new IllegalStateException(CadenaUtil.class.toString());
    }

    public static String convertTrueFalse(Boolean value) {
        return value.equals(Boolean.TRUE) ? Constants.T : Constants.F;
    }
}
