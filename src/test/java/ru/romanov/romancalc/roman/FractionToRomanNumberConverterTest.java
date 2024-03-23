package ru.romanov.romancalc.roman;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.mockito.Mockito;
import ru.romanov.romancalc.alerts.AlertsManager;
import ru.romanov.romancalc.alerts.AlertsManagerImpl;
import ru.romanov.romancalc.calculator.MixedFraction;

import static org.assertj.core.api.Assertions.assertThat;

@TestMethodOrder(MethodOrderer.Random.class)
@TestInstance(value = TestInstance.Lifecycle.PER_CLASS)
public class FractionToRomanNumberConverterTest {

    private FractionToRoman arabicToRomanConverter;

    @BeforeAll
    void prepareConverter() {
        arabicToRomanConverter = new FractionToRomanNumberConverterImpl();
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/numbers-converter-test-data.csv", delimiter = ';', numLinesToSkip = 1)
    void resultAfterConversionShouldBeCorrect(
            String expectedRomanResult, long fullPartOfFraction, int numeratorOfFraction) {

        MixedFraction fraction = new MixedFraction(fullPartOfFraction, numeratorOfFraction);

        String romanResult = arabicToRomanConverter.convertFractionToRomanNumber(fraction);
        assertThat(romanResult).isEqualTo(expectedRomanResult);
    }
}
