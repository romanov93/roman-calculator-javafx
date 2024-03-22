package ru.romanov.romancalc.roman;

import ru.romanov.romancalc.alerts.AlertsManager;
import ru.romanov.romancalc.calculator.MixedFraction;

public class RomanNumbersValidatorImpl implements RomanNumbersValidator{

    private final AlertsManager alertsManager;

    public RomanNumbersValidatorImpl(AlertsManager alertsManager) {
        this.alertsManager = alertsManager;
    }

    @Override
    public boolean isNumberValid(String romanNumber) {
        return false;
    }

    @Override
    public boolean isArabicNumberPossibleConvertToRoman(MixedFraction arabicNumber) {
        return false;
    }
}
