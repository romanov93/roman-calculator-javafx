package ru.romanov.romancalc.calculator;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.assertj.core.api.Assertions.assertThat;

@TestMethodOrder(MethodOrderer.Random.class)
@TestInstance(value = TestInstance.Lifecycle.PER_CLASS)
public class CalculatorTest {

    private FractionCalculator calculator;

    @BeforeAll
    void prepareCalculator() {
        calculator = new FractionCalculatorImpl();
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/calculator-addition-test-data.csv", delimiter = ';', numLinesToSkip = 1)
    void additionTest(long number1FullPart, int number1FractionPart,
                      long number2FullPart, int number2FractionPart,
                      long expectedResultFullPart, int expectedResultFractionPart) {

        MixedFraction result = calculator.addict(
                new MixedFraction(number1FullPart, number1FractionPart),
                new MixedFraction(number2FullPart, number2FractionPart));

        assertThat(result.getFullPart()).isEqualTo(expectedResultFullPart);
        assertThat(result.getNumerator()).isEqualTo(expectedResultFractionPart);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/calculator-subtraction-test-data.csv", delimiter = ';', numLinesToSkip = 1)
    void subtractionTest(long number1FullPart, int number1FractionPart,
                         long number2FullPart, int number2FractionPart,
                         long expectedResultFullPart, int expectedResultFractionPart) {

        MixedFraction result = calculator.addict(
                new MixedFraction(number1FullPart, number1FractionPart),
                new MixedFraction(number2FullPart, number2FractionPart));

        assertThat(result.getFullPart()).isEqualTo(expectedResultFullPart);
        assertThat(result.getNumerator()).isEqualTo(expectedResultFractionPart);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/calculator-multiplication-test-data.csv", delimiter = ';', numLinesToSkip = 1)
    void multiplicationTest(long number1FullPart, int number1FractionPart,
                            long number2FullPart, int number2FractionPart,
                            long expectedResultFullPart, int expectedResultFractionPart) {

        MixedFraction result = calculator.addict(
                new MixedFraction(number1FullPart, number1FractionPart),
                new MixedFraction(number2FullPart, number2FractionPart));

        assertThat(result.getFullPart()).isEqualTo(expectedResultFullPart);
        assertThat(result.getNumerator()).isEqualTo(expectedResultFractionPart);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/calculator-division-test-data.csv", delimiter = ';', numLinesToSkip = 1)
    void divisionTest(long number1FullPart, int number1FractionPart,
                      long number2FullPart, int number2FractionPart,
                      long expectedResultFullPart, int expectedResultFractionPart) {

        MixedFraction result = calculator.addict(
                new MixedFraction(number1FullPart, number1FractionPart),
                new MixedFraction(number2FullPart, number2FractionPart));

        assertThat(result.getFullPart()).isEqualTo(expectedResultFullPart);
        assertThat(result.getNumerator()).isEqualTo(expectedResultFractionPart);
    }
}
