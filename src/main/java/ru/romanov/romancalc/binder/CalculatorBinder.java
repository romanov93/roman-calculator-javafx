package ru.romanov.romancalc.binder;

import javafx.scene.control.Button;

public interface CalculatorBinder {

    void addBindingToCalculatorButtons();

    void cutLastDigitFromDisplay();

    void appendMathActionToDisplay(String action);

    void appendDigitToDisplay(Button button);

    void calculate();

    void showRandomQuote();

    void showNextQuote();
}
