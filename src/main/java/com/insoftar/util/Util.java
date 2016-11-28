package com.insoftar.util;

import com.mifmif.common.regex.Generex;

public class Util {

    public static String generateRandomAlphabeticString(int length) {
        Generex generex = new Generex("[A-Za-z]{1," + length + "}");
        return generex.random();
    }

    public static String generateRandomAlphanumericString(int length) {
        Generex generex = new Generex("[A-Za-z0-9]{1," + length + "}");
        return generex.random();
    }

    public static String generateRandomNumericString(int length) {
        Generex generex = new Generex("[0-9]{" + length + "}");
        return generex.random();
    }

}