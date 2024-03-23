package ru.romanov.romancalc.fxcomponents;

public interface CalculatorDisplay {
    String[] getInputNumbers();

    String getFullInput();

    String getLastInputNumberWithNewDigit(String newDigit);

    boolean lastInputSymbolIsAction();

    boolean containsMathAction();

    boolean bothNumbersAlreadyInput();

    String getInputAction();
}
