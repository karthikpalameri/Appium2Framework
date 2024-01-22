package learn.java.basics.simplemath;

public class TrailingZerosInFactorial {
    public static void main(String[] args) {
        int n = 5;
        trailingZerosInFact(n);
    }

    private static void trailingZerosInFact(int n) {
        int fact = fact(n);
        int numberOfTrailingZeros = tailingZerosInNumber(fact);
        System.out.println("numberOfTrailingZeros = " + numberOfTrailingZeros);
    }

    private static int tailingZerosInNumber(int fact) {
        int temp = fact, counter = 0;
        while (temp % 10 == 0) {
            counter++;
            temp = temp / 10;//removes last digit
        }
        return counter;
    }

    private static int fact(int n) {
        int res = 1;
        for (int i = 2; i <= n; i++) {
            res = res * i;
        }
        System.out.println("fib of " + n + " is : " + res);
        return res;
    }
}
