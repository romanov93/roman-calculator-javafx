package ru.romanov.romancalc.calculator;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

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
    @CsvSource(value = {
            "1, 0, 0, 1, 1, 1",
            "3, 2, 4, 88, 7, 90",
            "5, 1727, 0, 1, 6, 0",
            "3999999, 1727, 3999999, 1727, 7999999, 1726",
            "5, 864, 5, 865, 11, 1"
    })
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
    @CsvSource(value = {
            "7, 7, 7, 7, 0, 0",
            "5, 0, 0, 1, 4, 1727",
            "1, 1, 1, 0, 0, 1",
            "3999999, 864, 99, 1727, 3999899, 865",
            "1, 0, 2, 0, -1, 0"
    })
    void subtractionTest(long number1FullPart, int number1FractionPart,
                         long number2FullPart, int number2FractionPart,
                         long expectedResultFullPart, int expectedResultFractionPart) {

        MixedFraction result = calculator.subtract(
                new MixedFraction(number1FullPart, number1FractionPart),
                new MixedFraction(number2FullPart, number2FractionPart));

        assertThat(result.getFullPart()).isEqualTo(expectedResultFullPart);
        assertThat(result.getNumerator()).isEqualTo(expectedResultFractionPart);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "1, 0, 1, 0, 1, 0",
            "3999999, 0, 0, 864, 1999999, 864",
            "25, 6, 100, 144, 2502 , 744",
            "3000000, 0, 3000000, 0, 9000000000000, 0",
            "1234, 56, 78, 90, 96318, 1382"
    })
    void multiplicationTest(long number1FullPart, int number1FractionPart,
                            long number2FullPart, int number2FractionPart,
                            long expectedResultFullPart, int expectedResultFractionPart) {

        MixedFraction result = calculator.multiply(
                new MixedFraction(number1FullPart, number1FractionPart),
                new MixedFraction(number2FullPart, number2FractionPart));

        assertThat(result.getFullPart()).isEqualTo(expectedResultFullPart);
        assertThat(result.getNumerator()).isEqualTo(expectedResultFractionPart);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "5, 864, 1, 0, 5, 864",
            "5, 432, 0, 864, 10, 864",
            "999, 0, 3, 0, 333, 0",
            "22, 864, 11, 432, 2, 0",
            "3999999, 1727, 421, 1, 9501, 301"
    })
    void divisionTest(long number1FullPart, int number1FractionPart,
                      long number2FullPart, int number2FractionPart,
                      long expectedResultFullPart, int expectedResultFractionPart) {

        MixedFraction result = calculator.divide(
                new MixedFraction(number1FullPart, number1FractionPart),
                new MixedFraction(number2FullPart, number2FractionPart));

        assertThat(result.getFullPart()).isEqualTo(expectedResultFullPart);
        assertThat(result.getNumerator()).isEqualTo(expectedResultFractionPart);
    }
}
