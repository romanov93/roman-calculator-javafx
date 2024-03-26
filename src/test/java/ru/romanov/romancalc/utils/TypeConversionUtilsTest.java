package ru.romanov.romancalc.utils;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static ru.romanov.romancalc.utils.TypeConversionUtils.convertDoubleToStringWith10DigitsAfterCommon;

@TestMethodOrder(MethodOrderer.Random.class)
public class TypeConversionUtilsTest {


    @ParameterizedTest
    @CsvSource(value = {
            "3.3489797668038406E-7; 0,0000003349",
            "8.037551440329219E-6; 0,0000080376",
    }, delimiter = ';')
    void convertDoubleToStringWith10DigitsAfterCommonTest(double inputDouble, String expectedResult) {

        String resultOfConversion = convertDoubleToStringWith10DigitsAfterCommon(inputDouble);

        assertThat(resultOfConversion).isEqualTo(expectedResult);
    }
}
