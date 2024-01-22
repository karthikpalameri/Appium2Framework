package learn.java.basics.stringsdemo;

public class TrimStringDemo {
    public static void main(String[] args) {
        String s = "i  ";
        char[] c = s.toCharArray();
        int start = 0, end = c.length - 1;
        int count;
        for (int i = 0; i < c.length; i++) {
            if (c[i] != ' ') {
                start = i;
                break;
            }
        }
        for (int i = c.length - 1; i >= start; i--) {
            if (c[i] != ' ') {
                end = i;
                break;
            }
        }
        count = end - start + 1;

        System.out.println("start = " + start);
        System.out.println("end = " + end);
        String s1 = new String(c, start, count);
        System.out.println("s1 = " + s1);
    }
}
