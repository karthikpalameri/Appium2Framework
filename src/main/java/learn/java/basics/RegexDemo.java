package learn.java.basics;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexDemo {
    public static void main(String[] args) {
        //1 way
        Pattern pattern = Pattern.compile(".c");//. matches single character
        Matcher matcher = pattern.matcher("bc");
        boolean matches = matcher.matches();
        System.out.println("matches = " + matches);

        //2ndway
        boolean matches1 = Pattern.compile(".m").matcher("am").matches();
        System.out.println("matches1 = " + matches1);
        //3rd way
        boolean matches2 = Pattern.matches(".m", "abc");
        System.out.println("matches2 = " + matches2);

        System.out.println(Pattern.matches("[amn]", "acd"));
        System.out.println(Pattern.matches("[amn]", "a"));//among a or m or n
        System.out.println(Pattern.matches("[^amn]", "a"));//any char leaving a,m,n
        System.out.println(Pattern.matches("[a-zA-C]", "D"));//any char which range between a-z , A-C

        System.out.println(Pattern.matches("K[a-z]{6}", "Karthik"));//7 char which range between a-z , A-C
        System.out.println(Pattern.matches("T[a-z]{1,}", "Test"));//any char which range between a-z , A-C


    }
}
