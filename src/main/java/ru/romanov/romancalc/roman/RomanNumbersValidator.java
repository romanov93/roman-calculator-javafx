package ru.romanov.romancalc.roman;

import ru.romanov.romancalc.calculator.MixedFraction;

public interface RomanNumbersValidator {
    boolean isNumberValid(String romanNumber);
    boolean isArabicNumberPossibleConvertToRoman(MixedFraction arabicNumber);
}
