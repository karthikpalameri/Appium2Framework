package learn.java.basics.stringsdemo;

import java.util.Arrays;

public class StringsDemo {
    public static void main(String[] args) {
        String s1 = "abc";
        String s2 = s1;
        s1 = "xyz";
        String s3 = new String("abc");
        System.out.println("s1 = " + s1);
        System.out.println("s2 = " + s2);
        System.out.println("s2.equals(s3) = " + s2.equals(s1));

        String s4 = "abc";
        String s5 = "xyz";
        System.out.println("s4.compareToIgnoreCase(s5) = " + s4.compareToIgnoreCase(s5));

        System.out.println("s4.charAt(1) = " + s4.charAt(1));

        System.out.println("s4.contentEquals(\"abc\") = " + s4.contentEquals("abc"));
        //The String#equals() not only compares the String's contents, but also checks if the other object is also an instance of a String. The String#contentEquals() only compares the contents (the character sequence) and does not check if the other object is also an instance of String. It can be anything as long as it is an implementation of CharSequence which covers

        char[] arr = {'a', 'b', 'c'};
        String s6 = new String(arr);
        System.out.println("s6 = " + s6);

        System.out.println("String.copyValueOf(arr,1,2) = " + String.copyValueOf(arr, 1, 2));

        System.out.println("s6.endsWith('bc') = " + s6.endsWith("bc"));

        String s7 = "ABC";
        byte[] bytes = s7.getBytes();
        for (int i = 0; i < bytes.length; i++) {
            System.out.println("bytes[i] = " + bytes[i]);
        }

        String s8 = "ABC XYZ";
        char[] dst = new char[s8.length()];
        s8.getChars(0, 1, dst, 0);
        System.out.println("s8 = " + s8);
        System.out.println("dst = " + Arrays.toString(dst));

        System.out.println("s8.hashCode() = " + s8.hashCode());
        System.out.println("s8.indexOf(\"XYZ\",3) = " + s8.indexOf("XYZ", 3));


        System.out.println("s8.matches(\"(.*)XYZ(.*)\") = " + s8.matches("(.*)XYZ(.*)"));
        System.out.println(s8.matches("(ABC)(.*)"));

        String s9 = "Test String";
        System.out.println("s9.replace(\"t\",\" \") = " + s9.replace("t", " ")); // non regex replace

        String s10 = "This is test string of test123";
        System.out.println(s10.replaceAll("[\\W\\d]", "_"));

        System.out.println("Arrays.toString(s10.split(\" \")) = " + Arrays.toString(s10.split(" ")));
        System.out.println("Arrays.toString(s10.split(\" \", 2)) = " + Arrays.toString(s10.split(" ", 2)));//limit the array boxes

        System.out.println("s10.startsWith(\"ABC\") = " + s10.startsWith("This"));

        System.out.println("s10.substring(0,5) = " + s10.substring(0, 5));
        System.out.println("s10.toLowerCase() = " + s10.toLowerCase());
        System.out.println("s10.trim() = " + s10.trim());
        int a = 10;
        System.out.println("String.valueOf(a) = " + String.valueOf(a));
    }
}
