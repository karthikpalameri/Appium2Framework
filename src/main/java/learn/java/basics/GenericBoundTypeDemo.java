package learn.java.basics;

public class GenericBoundTypeDemo {
    public static <T extends Comparable<T>> T check(T a, T b, T c) {
        T max = a;
        if (b.compareTo(max) > 0) {
            max = b;
        }
        if (c.compareTo(max) > 0) {
            max = c;
        }
        return max;
    }

    public static void main(String[] args) {
        Integer check = check(1, 4, 2);
        System.out.println(check);
        String check1 = check("y", "x", "z");
        System.out.println(check1);
    }
}
