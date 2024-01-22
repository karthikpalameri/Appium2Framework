package learn.java.basics.stringsdemo;

public class PrintFirstCharacterOfEveryWord {
    public static void main(String[] args) {
        String s = " Hello world this is test!";
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ' ' && (i == 0 || s.charAt(i - 1) == ' ')) {
                System.out.println("s.charAt(i) = " + s.charAt(i));
            }
        }
    }
}
