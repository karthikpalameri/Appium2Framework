package learn.java.ds.simplemath;

public class FactorialRecursion {
    public static void main(String[] args) {
        int x = 5;
        int res = factRecurssive(x);
        System.out.println("res = " + res);

    }

    private static int factRecurssive(int n) {
        if (n == 0)
            return 1;
        return n * factRecurssive(n - 1);
    }
}
