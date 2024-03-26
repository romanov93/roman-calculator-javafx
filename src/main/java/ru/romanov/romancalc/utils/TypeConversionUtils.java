package ru.romanov.romancalc.utils;

public class TypeConversionUtils {

    private TypeConversionUtils() {

    }

    public static String convertDoubleToStringWith10DigitsAfterCommon(double input) {
        return String.format("%.10f", input);
    }
}
