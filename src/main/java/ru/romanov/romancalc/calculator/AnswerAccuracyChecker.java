package ru.romanov.romancalc.calculator;

import ru.romanov.romancalc.enums.MathAction;

public interface AnswerAccuracyChecker {
    void checkForRoundingOfResult(long numeratorOfFirstInput,
                                  long numeratorOfSecondInput,
                                  MathAction mathOperationType);
}
