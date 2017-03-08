package com.rizkimufrizal.belajar.retrofit.helper;

/**
 * Created by rizkimufrizal on 3/8/17.
 */

public class ConvertEmptyStringToStringPlus {
    public static String toStringPlus(String emptyString) {
        return emptyString.replaceAll(" ", "+");
    }
}
