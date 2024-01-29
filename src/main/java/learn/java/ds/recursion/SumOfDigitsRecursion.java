package learn.java.ds.recursion;

public class SumOfDigitsRecursion {
    public static void main(String[] args) {
        int sumRes = sumUsingRec(123, 0);
        System.out.println("sumRes = " + sumRes);

        int sumRes2 = sumUsingRec(123, 0);
        System.out.println("sumRes2 = " + sumRes2);
    }

    private static int sumUsingRec(int n, int acc) {
        if (n <= 0) return acc;
        int lastNum = n % 10;
        int remaining = n / 10;
        return sumUsingRec(remaining, lastNum + acc);
    }

    private static int sumUsingRec2(int n) {
        if (n <= 0) return 0;
        return sumUsingRec2(n / 10) + n % 10;
    }
}
