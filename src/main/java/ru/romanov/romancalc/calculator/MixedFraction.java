package ru.romanov.romancalc.calculator;

public class MixedFraction {

    private final long fullPart;

    private final int numerator;

    private final static int DENOMINATOR = 1728;

    public MixedFraction(long fullPart, int numerator) {
        this.fullPart = fullPart;
        this.numerator = numerator;
    }

    public boolean isZero() {
        return fullPart == 0 && numerator == 0;
    }

    public boolean isNegative() {
        return getFullPart() < 0 || (getFullPart() == 0 && getNumerator() < 0);
    }

    public boolean biggerThenMaxRomanValue() {
        return getFullPart() > 3999999;
    }

    public static MixedFraction zeroFraction() {
        return new MixedFraction(0 ,0);
    }

    public int getNumerator() {
        return numerator;
    }

    public long getFullPart() {
        return fullPart;
    }

    public int getDenominator() {
        return DENOMINATOR;
    }
}