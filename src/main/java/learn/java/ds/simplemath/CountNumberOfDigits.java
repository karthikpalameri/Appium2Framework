package learn.java.ds.simplemath;

public class CountNumberOfDigits {
    public static void main(String[] args) {
        int x = 789;
        int count = countDigit(x);
        System.out.println("count = " + count);
    }

    private static int countDigit(int x) {
        int counter = 0;
        while (x > 0) {
            x = x / 10;
            counter++;
        }
        return counter;
    }
}
