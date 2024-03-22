package ru.romanov.romancalc.roman;

import ru.romanov.romancalc.calculator.MixedFraction;

import java.util.HashMap;
import java.util.Map;

public class FractionToRomanNumberConverterImpl implements FractionToRoman{

    private final Map<Character, Integer> romanFractionsAndValues = getRomanFractionsAndValuesMap();

    @Override
    public String convertFractionToRomanNumber(MixedFraction arabicNumber) {
        if (arabicNumber.isZero()) return "nulla";

        String romanFullPartOfNumber = fullPartToRoman((int) arabicNumber.getFullPart());
        String romanFractionPartOfNumber = fractionPartToRoman(arabicNumber.getNumerator());

        return romanFullPartOfNumber + romanFractionPartOfNumber;
    }

    private String fullPartToRoman(int full) {
        if (full == 0) return "";
        String[] M100 = {"", "M̅", "M̅M̅", "M̅M̅M̅"};
        String[] C100 = {"", "C̅", "C̅C̅", "C̅C̅C̅", "C̅D̅", "D̅", "D̅C̅", "D̅C̅C̅", "D̅C̅C̅C̅", "C̅M̅"};
        String[] X100 = {"", "X̅", "X̅X̅", "X̅X̅X̅", "X̅L̅", "L̅", "L̅X̅", "L̅X̅X̅", "L̅X̅X̅X̅", "X̅C̅"};
        String[] M =    {"", "M", "MM", "MMM", "MV̅", "V̅", "V̅M", "V̅MM", "V̅MMM", "MX̅"};
        String[] C =    {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String[] X =    {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String[] I =    {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};

        StringBuilder sb = new StringBuilder();
        sb.append(M100[full/1000000])
                .append(C100[full%1000000/100000])
                .append(X100[full%100000/10000])
                .append(M[full%10000/1000])
                .append(C[(full%1000)/100])
                .append(X[(full%100)/10])
                .append(I[full%10]);

        return sb.toString();
    }

    private String fractionPartToRoman(int numerator) {
        if (numerator == 0) return "";

        char[] fractionDigits = {'S', '•', 'Є', 'Ɔ', 'Ƨ', 'ƻ', '℈', '»'};
        StringBuilder sb = new StringBuilder();

        for (int i = 0 ; i < fractionDigits.length ; i++) {
            char currentChar = fractionDigits[i];
            int value = romanFractionsAndValues.get(currentChar);
            while (numerator >= value) {
                sb.append(currentChar);
                numerator -= value;
            }
        }
        return sb.toString();
    }

    private Map<Character, Integer> getRomanFractionsAndValuesMap() {
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
