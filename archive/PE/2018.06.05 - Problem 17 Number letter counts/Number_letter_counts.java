package main;

import utils.io.InputReader;
import utils.io.OutputWriter;

public class Number_letter_counts {

    static boolean flag;
    static StringBuilder builder = new StringBuilder();

    private static final String ZERO = "0";
    private static int[] decimalPlaces = {0, 1, 2, 3, 5, 7};
    private static String[] decimalPlacesInWords = {"", "", "hundred", "thousand", "lakh", "crore"};
    private static int[] powersOfTen = {(int) 1E0, (int) 1E1, (int) 1E2, (int) 1E3, (int) 1E5, (int) 1E7};

    private static String[] twoDecimalPlacesInWords = {"", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};
    private static String[] lessThanTwentyInWords = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};

    private static String modulo(String n, int mod) {
        int powOfTen = (int) Math.log10(mod);
        if (n.length() - powOfTen < 0) return n;
        return n.substring(n.length() - powOfTen);
    }

    private static String divide(String n, int divisor) {
        int powOfTen = (int) Math.log10(divisor);
        if (n.length() - powOfTen < 0) return "0";
        return n.substring(0, n.length() - powOfTen);
    }

    private static void numberInWords(String n) {
        String tmp = n;

        if (n.length() == 0) return;
        if (n.length() < 3) {
            int integer = Integer.valueOf(n);
            if (integer >= 20) {
                if (!twoDecimalPlacesInWords[integer / 10].equals("zero")) {
                    flag = true;
                    builder.append(twoDecimalPlacesInWords[integer / 10] + " ");
                }
                integer %= 10;
            }
            if (!lessThanTwentyInWords[integer].equals("zero")) {
                flag = true;
                builder.append(lessThanTwentyInWords[integer]);
            }
            return;
        }

        for (int i = decimalPlaces.length - 1; i > 1; i--) {
            if (!divide(n, powersOfTen[i]).equals(ZERO)) {
                flag = false;
                numberInWords(divide(n, powersOfTen[i]));
                if (flag || (builder.length() > 0 && i == decimalPlaces.length - 1))
                    builder.append(" " + decimalPlacesInWords[i] + " ");
            }
            n = modulo(n, powersOfTen[i]);
        }

        if (n.length() < 3) {
            int integer = Integer.valueOf(n);
            if (Integer.valueOf(tmp) > 100 && integer > 0) {
                builder.append("and ");
            }
            if (integer >= 20) {
                if (!twoDecimalPlacesInWords[integer / 10].equals("zero")) {
                    builder.append(twoDecimalPlacesInWords[integer / 10] + " ");
                }
                integer %= 10;
            }
            if (!lessThanTwentyInWords[integer].equals("zero")) {
                builder.append(lessThanTwentyInWords[integer]);
            }
        }
    }

    public void solve(int testNumber, InputReader reader, OutputWriter writer) {
        int frequency = 0;
        for (int i = 1; i <= 1000; i++) {
            numberInWords(String.valueOf(i));

            for (int j = 0; j < builder.length(); j++) {
                if (builder.charAt(j) != ' ') frequency++;
            }
            System.out.println(builder);
            builder = new StringBuilder();
        }
        numberInWords(String.valueOf(frequency));
        System.out.println("\nAns :: " + frequency + "\nIn words: " + builder);
    }
}
