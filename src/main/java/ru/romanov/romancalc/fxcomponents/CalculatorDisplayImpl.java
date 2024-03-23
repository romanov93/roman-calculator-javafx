package ru.romanov.romancalc.fxcomponents;

import javafx.scene.control.TextField;


public class CalculatorDisplayImpl extends TextField implements CalculatorDisplay {

    @Override
    public String getFullInput() {
        return getText();
    }

    @Override
    public String[] getInputNumbers() {
        String input = getFullInput();
        String[] inputNumbers = new String[2];
        if      (input.contains("-"))
            inputNumbers = input.split("-");
        else if (input.contains("+"))
            inputNumbers = input.split("\\+");
        else if (input.contains(":"))
            inputNumbers = input.split(":");
        else if (input.contains("×"))
            inputNumbers = input.split("×");
        return inputNumbers;
    }

    @Override
    public String getLastInputNumberWithNewDigit(String newDigit) {
        if (containsMathAction())
            return getInputNumbers()[1] + newDigit;
        else
            return getFullInput() + newDigit;
    }

    @Override
    public boolean lastInputSymbolIsAction() {
        String input = getFullInput();
        if (input.isEmpty())
            return false;
        char lastInputChar = input.charAt(input.length() - 1);
        return lastInputChar == '+' || lastInputChar == '-' || lastInputChar == ':' || lastInputChar == '×';
    }

    @Override
    public boolean containsMathAction() {
        String input = getFullInput();
        return input.contains("+") || input.contains("-") || input.contains(":") || input.contains("×");
    }

    @Override
    public boolean bothNumbersAlreadyInput() {
        String input = getFullInput();
        if (input.isEmpty()) return false;
        String inputAction = getInputAction();
        char lastChar = input.charAt(input.length() - 1);
        if (inputAction.isEmpty() || inputAction.charAt(0) == lastChar) {
            return false;
        }
        return true;
    }

    @Override
    public String getInputAction() {
        String input = getFullInput();

        if      (input.contains("-")) return "-";
        else if (input.contains("+")) return "+";
        else if (input.contains(":")) return ":";
        else if (input.contains("×")) return "×";
        else return "";
    }
}
