package ru.romanov.romancalc.binder;

import javafx.scene.control.Button;
import ru.romanov.romancalc.alerts.AlertsManager;
import ru.romanov.romancalc.alerts.AlertsManagerImpl;

import ru.romanov.romancalc.quotes.LatinQuotesStorage;
import ru.romanov.romancalc.quotes.LatinQuotesStorageImpl;
import ru.romanov.romancalc.roman.*;
import ru.romanov.romancalc.view.CalculatorForm;
import ru.romanov.romancalc.view.QuoteForm;

public class CalculatorBinderImpl implements CalculatorBinder{

    private final CalculatorForm calculatorForm;
    private final QuoteForm quoteForm;
    private final AlertsManager alertsManager = new AlertsManagerImpl();
    private final RomanNumbersValidator validator = new RomanNumbersValidatorImpl(alertsManager);
    private final RomanToFraction romanToFractionConverter = new RomanNumberToFractionConverterImpl();
    private final FractionToRoman fractionToRomanConverter = new FractionToRomanNumberConverterImpl();
    private final LatinQuotesStorage quotesStorage = new LatinQuotesStorageImpl();

    public CalculatorBinderImpl(CalculatorForm calculatorForm, QuoteForm quoteForm) {
        this.calculatorForm = calculatorForm;
        this.quoteForm = quoteForm;
    }

    @Override
    public void addBindingToCalculatorButtons() {

    }

    @Override
    public void cutLastDigitFromDisplay() {

    }

    @Override
    public void appendMathActionToDisplay(String action) {

    }

    @Override
    public void appendDigitToDisplay(Button button) {

    }

    @Override
    public void calculate() {

    }

    @Override
    public void showRandomQuote() {

    }

    @Override
    public void showNextQuote() {

    }
}
