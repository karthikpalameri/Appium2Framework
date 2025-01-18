package learn.java.ds.strings;

import java.util.Arrays;

public class AnagramSearch {
    private static final int CHAR = 256;

    public static void main(String[] args) {
        String text = "abacdef";
//                     0123456
        String pattern = "acd";
//                        012
        isPresent(text, pattern);
    }

    private static boolean isPresent(String text, String pattern) {
        int[] textArr = new int[CHAR];
        int[] pattArr = new int[CHAR];

        for (int i = 0; i < pattern.length(); i++) {
            textArr[text.charAt(i)]++;
            pattArr[pattern.charAt(i)]++;
        }

        System.out.println("textArr = " + Arrays.toString(textArr));
        System.out.println("pattArr = " + Arrays.toString(pattArr));

        for (int i = pattern.length(); i < text.length(); i++) {
            if (Arrays.equals(textArr, pattArr)) {
                System.out.println("anagram found at index i = " + (i - pattern.length()) + "to " + (i - 1));
                System.out.println("Arrays.toString(textArr) = " + Arrays.toString(textArr));
                System.out.println("Arrays.toString(pattArr) = " + Arrays.toString(pattArr));

                return true;
            }
            textArr[text.charAt(i)]++;//3;4;5;6;
            textArr[text.charAt(i - pattern.length())]--;//3-3=0;4-3=1;5-3=2;6-3=3

        }

        return false;
    }
}
