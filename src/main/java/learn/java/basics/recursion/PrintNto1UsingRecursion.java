package learn.java.basics.recursion;

public class PrintNto1UsingRecursion {
    private static void fun(int n) {
        if (n == 0)
            return;
        System.out.println("n = " + n);
        fun(n - 1);
    }

    public static void main(String[] args) {
        fun(5);
    }
}
