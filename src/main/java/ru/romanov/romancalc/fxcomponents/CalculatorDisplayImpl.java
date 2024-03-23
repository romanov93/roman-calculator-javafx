package ru.romanov.romancalc.fxcomponents;

import javafx.scene.control.TextField;
import ru.romanov.romancalc.enums.Action;

public class CalculatorDisplayImpl extends TextField implements CalculatorDisplay {


    @Override
    public String[] getInputNumbers() {
        return new String[0];
    }

    @Override
    public Action getInputMathAction() {
        return null;
    }

    @Override
    public String getFullInput() {
        return null;
    }

    @Override
    public String getLastInputNumberWithNewDigit(String newDigit) {
        return null;
    }
}
