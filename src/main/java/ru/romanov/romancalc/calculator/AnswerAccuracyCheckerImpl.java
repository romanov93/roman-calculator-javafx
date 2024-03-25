package ru.romanov.romancalc.calculator;

import ru.romanov.romancalc.alerts.AlertsManager;
import ru.romanov.romancalc.alerts.AlertsManagerImpl;
import ru.romanov.romancalc.enums.MathAction;

import java.math.BigInteger;

public class AnswerAccuracyCheckerImpl implements AnswerAccuracyChecker{

    private AlertsManager alertsManager = new AlertsManagerImpl();

    @Override
    public void checkForRoundingOfResult(
            long numeratorOfFirstInput,
            long numeratorOfSecondInput,
            MathAction mathOperationType) {

        double roundingOfResult = 0.0;
        switch (mathOperationType) {
            case DIVISION ->
                    roundingOfResult = findRoundingAfterDivision(numeratorOfFirstInput, numeratorOfSecondInput);
            case MULTIPLICATION ->
                    roundingOfResult = findRoundingAfterMultiplication(numeratorOfFirstInput, numeratorOfSecondInput);
        }

        System.out.println(numeratorOfFirstInput);
        System.out.println(numeratorOfSecondInput);
        System.out.println(roundingOfResult);
        System.out.println(convertDoubleToStringWith10DigitsAfterCommon(roundingOfResult));
        if (roundingOfResult != 0) {
            alertsManager.showRoundingAlert(convertDoubleToStringWith10DigitsAfterCommon(roundingOfResult));
        }

    }

    double findRoundingAfterMultiplication(long numeratorOfFirstInput, long numeratorOfSecondInput) {
        return BigInteger
                .valueOf(numeratorOfFirstInput)
                .multiply(BigInteger.valueOf(numeratorOfSecondInput))
                .remainder(BigInteger.valueOf(1728))
                .doubleValue()
                /2985984;
    }

    double findRoundingAfterDivision(long numeratorOfFirstInput, long numeratorOfSecondInput) {
        return ((double) (numeratorOfFirstInput * 1728) / numeratorOfSecondInput) % 1 / 1728;
    }

    String convertDoubleToStringWith10DigitsAfterCommon(double input) {
        return String.format("%.10f", input);
    }


}
