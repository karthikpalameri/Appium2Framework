package learn.java.basics.arraysdemo;

import lombok.val;

import java.nio.charset.StandardCharsets;
import java.util.*;

public class StringsDemo {
    public static void main(String[] args) {
        //            0123456789
        String str = "azbcdefzzz";
        printAllSubStringOfAGivenString(str);

    }

    private static void printAllSubStringOfAGivenString(String str) {
        String input = "abcd";
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            String subStr = "";
            for (int j = i; j < input.length(); j++) {
//                System.out.print(j);
                subStr += input.charAt(j);
                list.add(subStr);
                System.out.print(subStr + "\n");
            }
            System.out.println();
        }
        System.out.println("list = " + list);
    }


    private static void removeAllOccurrencesOfACharacter2(String str) {
        char c = 'z';
        String res = str.replace(Character.toString(c), "");
        System.out.println("res = " + res);
    }

    private static void removeAllOcurrencesOfACharacter(String str) {
        char c = 'z';
        StringBuilder word = new StringBuilder(str);
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == c) {
                word.deleteCharAt(i);
            }
        }
        System.out.println("after removing chars res = " + word);
    }

    private static void insertCharactersInAStringAtCertainPosition(String str) {
        int[] stars = {0, 1, 2, 3, 4, 5, 6};
        StringBuilder res = new StringBuilder();
        int leftPointer = 0;
        for (int i = 0; i < str.length(); i++) {
            if (i < stars.length && i == stars[leftPointer]) { // check i with extracted index of stars array here and also check with starts length
                int star = stars[leftPointer];
                leftPointer++;
                res.append('*');
            }
            char c = str.charAt(i);
            res.append(c);
        }
        System.out.println("res = " + res);

    }

    private static void frequencyOfEachCharacter(String str) {
        Map<Character, Integer> map = new TreeMap<>();

        for (char c :
                str.toCharArray()) {
            Integer freq = map.getOrDefault(c, 0);
            map.put(c, freq + 1);
        }
        System.out.println("map = " + map);
    }

    private static void sortString(String str) {
        char[] charArray = str.toCharArray();

        Arrays.sort(charArray);

        System.out.println("new String(charArray) = " + new String(charArray));
    }

    private static void leftRotationOfString(String str, int d) {
        String res = str.substring(d, str.length()) + "-" + str.substring(0, d);
        System.out.println("res = " + res);
    }

    private static void reverseStringUsing2Pointers() {
        String str1 = "abc";
        int length = str1.length();
        char[] charArray = str1.toCharArray();

        for (int start = 0, end = length - 1; start < length; start++, end--) {
            //swap charArray[start] charArray[end]
            swap(charArray, start, end);
        }
        System.out.println("charArray = " + new String(charArray));
    }

    private static void swap(char[] charArray, int i, int j) {
        var temp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = charArray[i];
    }

    private static void reverseStringUsingStack() {
        String str1 = "abc";
        StringBuffer stringBuffer = new StringBuffer();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str1.length(); i++) {
            stack.push(str1.charAt(i));
        }
        for (int i = 0; i < str1.length(); i++) {
            Character pop = stack.pop();
            stringBuffer.append(pop);
        }
        System.out.println("stringBuffer = " + stringBuffer);
    }

    private static void stringBuilderToString() {
        StringBuilder test = new StringBuilder("test");
        String s = new String(test);
        System.out.println("s = " + s);
    }

    private static void stringBufferToString() {
        StringBuffer test = new StringBuffer("test");
        String s = new String(test);
        System.out.println("s = " + s);
    }

    private static void charArrayToString1() {
        char[] arr = {'A', 'B', 'C'};
        val s = new String(arr);
        System.out.println("s = " + s);
    }

    private static void byteToStringAndStringToByte() {
        String a = "ABCabc";//literal, reuses the same object if you try to create same string
        byte[] a1 = a.getBytes(StandardCharsets.UTF_8);
        System.out.println("a1 = " + Arrays.toString(a1));

        String s = new String(a1);//new keyword , always create a new object in heap memory
        System.out.println("s = " + s);
    }
}
