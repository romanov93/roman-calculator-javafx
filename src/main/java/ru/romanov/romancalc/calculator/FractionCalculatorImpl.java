package ru.romanov.romancalc.calculator;

import ru.romanov.romancalc.alerts.AlertsManager;
import ru.romanov.romancalc.alerts.AlertsManagerImpl;

import java.math.BigInteger;

import static ru.romanov.romancalc.enums.MathAction.DIVISION;
import static ru.romanov.romancalc.enums.MathAction.MULTIPLICATION;

public class FractionCalculatorImpl implements FractionCalculator {

    private final AnswerAccuracyChecker answerAccuracyChecker = new AnswerAccuracyCheckerImpl();

    @Override
    public MixedFraction addict(MixedFraction input1, MixedFraction input2) {
        long numeratorOfFirstInput = convertFractionToImproperAndGetNumerator(input1);
        long numeratorOfSecondInput = convertFractionToImproperAndGetNumerator(input2);
        long numeratorOfImproperFraction = numeratorOfFirstInput + numeratorOfSecondInput;
        return convertImproperFractionToMixedFraction(numeratorOfImproperFraction);
    }

    @Override
    public MixedFraction subtract(MixedFraction input1, MixedFraction input2) {
        long numeratorOfFirstInput = convertFractionToImproperAndGetNumerator(input1);
        long numeratorOfSecondInput = convertFractionToImproperAndGetNumerator(input2);
        long numeratorOfImproperFraction = numeratorOfFirstInput - numeratorOfSecondInput;
        return convertImproperFractionToMixedFraction(numeratorOfImproperFraction);
    }

    @Override
    public MixedFraction divide(MixedFraction input1, MixedFraction input2) {
        long numeratorOfFirstInput = convertFractionToImproperAndGetNumerator(input1);
        long numeratorOfSecondInput = convertFractionToImproperAndGetNumerator(input2);
        long numeratorOfImproperFraction =
                (numeratorOfFirstInput * input1.getDenominator()) / numeratorOfSecondInput;

        answerAccuracyChecker.checkForRoundingOfResult(numeratorOfFirstInput, numeratorOfSecondInput, DIVISION);

        return convertImproperFractionToMixedFraction(numeratorOfImproperFraction);
    }

    @Override
    public MixedFraction multiply(MixedFraction input1, MixedFraction input2) {
        long numeratorOfFirstInput = convertFractionToImproperAndGetNumerator(input1);
        long numeratorOfSecondInput = convertFractionToImproperAndGetNumerator(input2);
        long numeratorOfImproperFraction = BigInteger
                .valueOf(numeratorOfFirstInput)
                .multiply(BigInteger.valueOf(numeratorOfSecondInput))
                .divide(BigInteger.valueOf(1728))
                .longValue();

        answerAccuracyChecker.checkForRoundingOfResult(numeratorOfFirstInput, numeratorOfSecondInput, MULTIPLICATION);

        return convertImproperFractionToMixedFraction(numeratorOfImproperFraction);
    }

    private long convertFractionToImproperAndGetNumerator(MixedFraction fraction) {
        return (fraction.getFullPart() * fraction.getDenominator()) + fraction.getNumerator();
    }

    private MixedFraction convertImproperFractionToMixedFraction(long numeratorOfImproperFraction) {
        long fullPartOfMixedFraction = numeratorOfImproperFraction / 1728;
        int numeratorOfMixedFraction = (int) (numeratorOfImproperFraction % 1728);
        return new MixedFraction(fullPartOfMixedFraction, numeratorOfMixedFraction);
    }
}