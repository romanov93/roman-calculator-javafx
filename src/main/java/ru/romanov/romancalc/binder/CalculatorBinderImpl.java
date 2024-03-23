package ru.romanov.romancalc.binder;

import javafx.scene.control.Button;
import ru.romanov.romancalc.alerts.AlertsManager;
import ru.romanov.romancalc.alerts.AlertsManagerImpl;

import ru.romanov.romancalc.calculator.FractionCalculator;
import ru.romanov.romancalc.calculator.FractionCalculatorImpl;
import ru.romanov.romancalc.calculator.MixedFraction;
import ru.romanov.romancalc.fxcomponents.CalculatorDisplayImpl;
import ru.romanov.romancalc.quotes.LatinQuotesStorage;
import ru.romanov.romancalc.quotes.LatinQuotesStorageImpl;
import ru.romanov.romancalc.quotes.Quote;
import ru.romanov.romancalc.roman.*;
import ru.romanov.romancalc.view.CalculatorForm;
import ru.romanov.romancalc.view.InfoWindow;
import ru.romanov.romancalc.view.QuoteForm;

public class CalculatorBinderImpl implements CalculatorBinder{

    private final CalculatorForm calculatorForm;
    private final QuoteForm quoteForm;
    private final AlertsManager alertsManager = new AlertsManagerImpl();
    private final RomanNumbersValidator validator = new RomanNumbersValidatorImpl(alertsManager);
    private final RomanToFraction romanToFractionConverter = new RomanNumberToFractionConverterImpl();
    private final FractionToRoman fractionToRomanConverter = new FractionToRomanNumberConverterImpl();
    private final LatinQuotesStorage quotesStorage = new LatinQuotesStorageImpl();

    private final FractionCalculator calculator = new FractionCalculatorImpl();

    public CalculatorBinderImpl(CalculatorForm calculatorForm, QuoteForm quoteForm) {
        this.calculatorForm = calculatorForm;
        this.quoteForm = quoteForm;
    }

    @Override
    public void addBindingToCalculatorButtons() {
        showRandomQuote();
        calculatorForm.getNextQuote().setOnAction(click -> showNextQuote());
        for (Button button : calculatorForm.getButtonsWithDigits())
            button.setOnAction(click -> appendDigitToDisplay(button));
        calculatorForm.getClean().setOnAction(click -> calculatorForm.getDisplay().setText(""));
        calculatorForm.getCut().setOnAction(click -> cutLastDigitFromDisplay());
        calculatorForm.getInfo().setOnAction(click -> new InfoWindow().show());
        calculatorForm.getAddition().setOnAction(click -> appendMathActionToDisplay("+"));
        calculatorForm.getDivision().setOnAction(click -> appendMathActionToDisplay(":"));
        calculatorForm.getSubtraction().setOnAction(click -> appendMathActionToDisplay("-"));
        calculatorForm.getMultiplication().setOnAction(click -> appendMathActionToDisplay("×"));
        calculatorForm.getAnswer().setOnAction(click -> calculate());
    }

    @Override
    public void cutLastDigitFromDisplay() {
        String input = calculatorForm.getDisplay().getFullInput();
        CalculatorDisplayImpl display = calculatorForm.getDisplay();

        if (input.isEmpty()) return;
        if (input.contains("=")) {
            display.setText(input.split("=")[0]);
            return;
        }
        char lastInputChar = input.charAt(input.length() - 1);
        if (lastInputChar == '̅')
            display.setText(input.substring(0, input.length() - 2));
        else
            display.setText(input.substring(0, input.length() - 1));

    }

    @Override
    public void appendMathActionToDisplay(String action) {
        String input = calculatorForm.getDisplay().getFullInput();
        CalculatorDisplayImpl display = calculatorForm.getDisplay();

        if (input.isEmpty() || input.contains("nulla")) {
            return;
        }
        if (input.contains("=") && input.charAt(input.length() - 1) != '=') {
            display.setText(input.split("=")[1] + action);
            return;
        }
        if (display.lastInputSymbolIsAction()) {
            display.setText(input.substring(0, input.length() - 2) + action);
        }
        display.appendText(action);
    }

    @Override
    public void appendDigitToDisplay(Button button) {
        String input = calculatorForm.getDisplay().getFullInput();
        CalculatorDisplayImpl display = calculatorForm.getDisplay();

        if (input.contains("=") || input.isEmpty()) {
            display.setText(button.getText());
            return;
        }
        if (display.lastInputSymbolIsAction()) {
            display.appendText(button.getText());
            return;
        }
        String lastNumberWithNewDigit = display.getLastInputNumberWithNewDigit(button.getText());
        boolean numberValid = validator.isNumberValid(lastNumberWithNewDigit);
        if (!numberValid) {
            alertsManager.showWrongNumberFormatAlert(lastNumberWithNewDigit);
            return;
        }
        display.appendText(button.getText());
    }

    @Override
    public void calculate() {
        String input = calculatorForm.getDisplay().getFullInput();
        CalculatorDisplayImpl display = calculatorForm.getDisplay();

        if (input.contains("=") || !display.bothNumbersAlreadyInput()) {
            return;
        }
        String[] inputRomanNumbers = display.getInputNumbers();
        MixedFraction fraction1 = romanToFractionConverter.convertRomanNumberToFraction(inputRomanNumbers[0]);
        MixedFraction fraction2 = romanToFractionConverter.convertRomanNumberToFraction(inputRomanNumbers[1]);
        MixedFraction resultFraction = null;
        if      (input.contains("-")) resultFraction = calculator.subtract(fraction1, fraction2);
        else if (input.contains("+")) resultFraction = calculator.addict(fraction1, fraction2);
        else if (input.contains(":")) resultFraction = calculator.divide(fraction1, fraction2);
        else if (input.contains("×")) resultFraction = calculator.multiply(fraction1, fraction2);
        boolean resultCanBeConvertedToRoman = validator.isArabicNumberPossibleConvertToRoman(resultFraction);
        if (!resultCanBeConvertedToRoman) return;
        String romanResult = fractionToRomanConverter.convertFractionToRomanNumber(resultFraction);
        display.appendText("=" + romanResult);
    }

    @Override
    public void showRandomQuote() {
        Quote randomQuote = quotesStorage.getRandomQuote();
        quoteForm.getQuote().setText(randomQuote.getLatinText());
        quoteForm.getTranslate().setText(randomQuote.getTranslate());
    }

    @Override
    public void showNextQuote() {
        Quote nextQuote = quotesStorage.getNextQuote();
        quoteForm.getQuote().setText(nextQuote.getLatinText());
        quoteForm.getTranslate().setText(nextQuote.getTranslate());
    }
}
