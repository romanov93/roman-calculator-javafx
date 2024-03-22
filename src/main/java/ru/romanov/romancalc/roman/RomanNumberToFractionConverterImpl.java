package ru.romanov.romancalc.roman;

import ru.romanov.romancalc.calculator.MixedFraction;

import java.util.HashMap;
import java.util.Map;

public class RomanNumberToFractionConverterImpl implements RomanToFraction{

    private final Map<Character, Integer> romanDigitsAndValues = getRomanDigitsAndValues();

    private final Map<Character, Integer> romanFractionDigitsAndValues = getRomanFractionDigitsAndValues();

    @Override
    public MixedFraction convertRomanNumberToFraction(String romanNumber) {
        if (romanNumber.equals("nulla"))
            return MixedFraction.zeroFraction();

        String romanFractionPart = getFractionPart(romanNumber);
        String romanFullPart = romanNumber.replace(romanFractionPart, "");

        long fullPartOfFraction = fullRomanNumberToArabicNumber(romanFullPart);
        int numeratorOfFraction = fractionRomanNumberToArabicFractionNumerator(romanFractionPart);

        return new MixedFraction(fullPartOfFraction, numeratorOfFraction);
    }

    private long fullRomanNumberToArabicNumber(String input) {
        if (input.length() == 0) return 0;
        String convertable = replaceDigitsWithSpecialSymbolsToSimpleDigits(input);

        long result = 0;
        for (int i = 0; i < convertable.length() - 1; i++) {
            char currentDigit = convertable.charAt(i);
            char nextDigit = convertable.charAt(i+1);
            if(romanDigitsAndValues.get(currentDigit) < romanDigitsAndValues.get(nextDigit))
                result -= romanDigitsAndValues.get(currentDigit);
            else
                result += romanDigitsAndValues.get(currentDigit);
        }
        return result + romanDigitsAndValues.get(convertable.charAt(convertable.length() - 1));
    }

    private int fractionRomanNumberToArabicFractionNumerator(String input) {
        if (input.length() == 0) return 0;

        int divider = 0;
        for (int i = 0 ; i < input.length() ; i++) {
            divider += romanFractionDigitsAndValues.get(input.charAt(i));
        }
        return divider;
    }

    private String getFractionPart(String input) {
        return input
                .replace("I", "").replace("V", "").replace("X", "")
                .replace("L", "").replace("C", "").replace("D", "")
                .replace("M", "").replace("̅", "");
    }

    public String replaceDigitsWithSpecialSymbolsToSimpleDigits(String input) {
        return input
                .replace("V̅", "v").replace("X̅", "x")
                .replace("L̅", "l").replace("C̅", "c")
                .replace("D̅", "d").replace("M̅", "m");
    }

    private Map<Character, Integer> getRomanDigitsAndValues() {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        map.put('v', 5000);
        map.put('x', 10000);
        map.put('l', 50000);
        map.put('c', 100000);
        map.put('d', 500000);
        map.put('m', 1000000);
        return map;
    }

    private Map<Character, Integer> getRomanFractionDigitsAndValues() {
        Map<Character, Integer> map = new HashMap<>();
        map.put('S', 864);
        map.put('•', 144);
        map.put('Є', 72);
        map.put('Ɔ', 36);
        map.put('Ƨ', 24);
        map.put('ƻ', 12);
        map.put('℈', 6);
        map.put('»', 1);
        return map;
    }
}
