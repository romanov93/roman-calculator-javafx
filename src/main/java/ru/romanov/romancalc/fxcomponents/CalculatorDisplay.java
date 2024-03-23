package ru.romanov.romancalc.fxcomponents;

import ru.romanov.romancalc.enums.Action;

public interface CalculatorDisplay {
    String[] getInputNumbers();

    Action getInputMathAction();

    String getFullInput();

    String getLastInputNumberWithNewDigit(String newDigit);
}
