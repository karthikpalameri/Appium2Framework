package learn.java.ds.simplemath;

public class Factorial {
    public static void main(String[] args) {
        int fact = factCalc(4);
        System.out.println("fact = " + fact);
    }

    private static int factCalc(int i) {
        int res = 1;
        for (int j = 1; j <= i; j++) {
            res = res * j;
        }
        return res;
    }
}
