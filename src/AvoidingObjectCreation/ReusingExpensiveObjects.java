package AvoidingObjectCreation;

import java.util.regex.Pattern;

public class ReusingExpensiveObjects {
    public static void main(String[] args) {
        String myNumber = "MMCXLIV";
        System.out.println(RomanNumerals.isRomanNumeral(myNumber));
    }
}

class RomanNumerals {
    private static final Pattern ROMAN = Pattern.compile(
            "^M{0,4}(CM|CD|D?C{0,3})(XC|XL|L?X{0,3})(IX|IV|V?I{0,3})$"
    );

    static boolean isRomanNumeral(String s) {
        return ROMAN.matcher(s).matches();
    }
}
