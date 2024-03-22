package ru.romanov.romancalc.roman;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import ru.romanov.romancalc.calculator.MixedFraction;

import static org.assertj.core.api.Assertions.assertThat;

@TestMethodOrder(MethodOrderer.Random.class)
@TestInstance(value = TestInstance.Lifecycle.PER_CLASS)
public class RomanNumberToFractionConverterTest {

    private RomanToFraction romanToArabicConverter;

    @BeforeAll
    void prepareConverter() {
        romanToArabicConverter = new RomanNumberToFractionConverterImpl();
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/numbers-converter-test-data.csv", delimiter = ';', numLinesToSkip = 1)
    void romanNumberConversionToFractionTest(
            String romanNumber, long expectedFullPartOfNumber, int expectedNumeratorOfFraction) {

        MixedFraction fraction = romanToArabicConverter.convertRomanNumberToFraction(romanNumber);

        assertThat(fraction.getFullPart()).isEqualTo(expectedFullPartOfNumber);
        assertThat(fraction.getNumerator()).isEqualTo(expectedNumeratorOfFraction);
    }


}
