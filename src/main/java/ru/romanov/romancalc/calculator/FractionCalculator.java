package ru.romanov.romancalc.calculator;

public interface FractionCalculator {
    MixedFraction addict(MixedFraction input1, MixedFraction input2);
    MixedFraction subtract(MixedFraction input1, MixedFraction input2);
    MixedFraction multiply(MixedFraction input1, MixedFraction input2);
    MixedFraction divide(MixedFraction input1, MixedFraction input2);

}