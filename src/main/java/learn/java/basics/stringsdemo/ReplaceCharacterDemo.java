package learn.java.basics.stringsdemo;

public class ReplaceCharacterDemo {
    public static void main(String[] args) {
        String s = "This is a test String";
        char[] c = s.toCharArray();
        for (int i = 0; i < c.length - 1; i++) {
            if (c[i] == 'T' || c[i] == 't')
                c[i] = ' ';
        }
//        System.out.println("c = " + Arrays.toString(c));
        System.out.println("c = " + c);
        System.out.println(c);
    }
}
