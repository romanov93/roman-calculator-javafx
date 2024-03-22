package ru.romanov.romancalc.roman;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mockito;
import ru.romanov.romancalc.alerts.AlertsManager;
import ru.romanov.romancalc.alerts.AlertsManagerImpl;
import ru.romanov.romancalc.calculator.MixedFraction;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestMethodOrder(MethodOrderer.Random.class)
@TestInstance(value = TestInstance.Lifecycle.PER_CLASS)
public class RomanNumbersValidatorTest {

    private RomanNumbersValidator romanNumbersValidator;

    private AlertsManager alertsManager;

    @BeforeAll
    void prepareValidator() {
        this.alertsManager = Mockito.mock(AlertsManagerImpl.class);
        romanNumbersValidator = new RomanNumbersValidatorImpl(alertsManager);
    }

    @ParameterizedTest
    @ValueSource(strings = {"SII", "IM", "CVVV", "S•ЄƆƧƻ℈»»»»»", "MDCCCL̅VI"})
    void resultOfValidationShouldBeFalseIfRomanNumberIncorrect(String wrongRomanNumber) {
        assertFalse(romanNumbersValidator.isNumberValid(wrongRomanNumber));
    }

    @ParameterizedTest
    @ValueSource(strings = {"L", "CCC", "Ƨ", "S•ЄƆƧ℈»»»»»", "M̅C̅X̅X̅X̅MIVS••ƻ"})
    void resultOfValidationShouldBeTrueIfRomanNumberCorrect(String correctRomanNumber) {
        assertTrue(romanNumbersValidator.isNumberValid(correctRomanNumber));
    }

    @ParameterizedTest
    @ValueSource(longs = {1, 2, 3999999})
    void arabicNumberCanBeConvertedToRoman(long fullPartOfFraction) {
        MixedFraction fraction = new MixedFraction(fullPartOfFraction, 0);
        assertTrue(romanNumbersValidator.isArabicNumberPossibleConvertToRoman(fraction));
    }

    @ParameterizedTest
    @ValueSource(longs = {4000000, -1, 39999999999L})
    void impossibleToConvertArabicNumberToRoman(long fullPartOfFraction) {
        MixedFraction fraction = new MixedFraction(fullPartOfFraction, 0);
        assertFalse(romanNumbersValidator.isArabicNumberPossibleConvertToRoman(fraction));
    }
}