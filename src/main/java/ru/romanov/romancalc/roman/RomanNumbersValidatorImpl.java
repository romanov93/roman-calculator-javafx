package ru.romanov.romancalc.roman;

import ru.romanov.romancalc.alerts.AlertsManager;
import ru.romanov.romancalc.calculator.MixedFraction;

import java.util.regex.Pattern;

public class RomanNumbersValidatorImpl implements RomanNumbersValidator{

    private static final Pattern PATTERN_OF_ROMAN_NUMBER_WITH_FRACTION_PART = Pattern.compile(
            "^(M̅){0,3}((C̅M̅)|(C̅D̅)|(D̅)?(C̅){0,3})((X̅C̅)|(X̅L̅)|(L̅)?(X̅){0,3})((MX̅)|(MV̅)|(V̅)?M{0,3})" +
                    "(C[MD]|D?C{0,3})(X[CL]|L?X{0,3})(I[XV]|V?I{0,3})S?•{0,5}Є?Ɔ?[Ƨƻ]?℈?»{0,5}$"
    );
    private final AlertsManager alertsManager;

    public RomanNumbersValidatorImpl(AlertsManager alertsManager) {
        this.alertsManager = alertsManager;
    }

    @Override
    public boolean isNumberValid(String romanNumber) {
        return PATTERN_OF_ROMAN_NUMBER_WITH_FRACTION_PART.matcher(romanNumber).matches();
    }

    @Override
    public boolean isArabicNumberPossibleConvertToRoman(MixedFraction fraction) {
        if (fraction.isNegative()) {
            alertsManager.showNegativeAlert();
            return false;
        }
        if (fraction.biggerThenMaxRomanValue()) {
            alertsManager.showBigSizeAlert(fraction.getFullPart());
            return false;
        }
        return true;
    }
}