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
public class AnswerAccuracyCheckerTest {

    private AnswerAccuracyCheckerImpl answerAccuracyChecker;

    @BeforeAll
    void prepareAnswerAccuracyChecker() {
        answerAccuracyChecker = new AnswerAccuracyCheckerImpl();
    }

    @ParameterizedTest
    @CsvSource (value = {
            "1, 8640, 1.1574074074074075E-4",
            "8640000, 8640, 0",
            "144, 172800, 2.546296296296296E-4"
    })
    void findRoundingAfterDivisionTest(long numeratorOfFirstInput, long numeratorOfSecondInput, double expectedRounding) {

        double rounding = answerAccuracyChecker
                .findRoundingAfterDivision(numeratorOfFirstInput, numeratorOfSecondInput);

        assertThat(rounding).isEqualTo(expectedRounding);
    }

    @ParameterizedTest
    @CsvSource (value = {
            "1, 1, 3.3489797668038406E-7",
            "8640, 864, 0",
            "6, 36, 7.233796296296296E-5"
    })
    void findRoundingAfterMultiplicationTest(long numeratorOfFirstInput,
                                             long numeratorOfSecondInput,
                                             double expectedRounding) {

        double rounding = answerAccuracyChecker
                .findRoundingAfterMultiplication(numeratorOfFirstInput, numeratorOfSecondInput);

        assertThat(rounding).isEqualTo(expectedRounding);
    }

    @ParameterizedTest
    @CsvSource (value = {
            "3.3489797668038406E-7; 0,0000003349",
            "8.037551440329219E-6; 0,0000080376",
    }, delimiter = ';')
    void convertDoubleToStringWith10DigitsAfterCommonTest(double inputDouble, String expectedResult) {

        String resultOfConversion = answerAccuracyChecker.convertDoubleToStringWith10DigitsAfterCommon(inputDouble);

        assertThat(resultOfConversion).isEqualTo(expectedResult);
    }


}
