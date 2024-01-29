package learn.java.ds.simplemath;

public class GcdDemo {
    public static void main(String[] args) {
        int a = 100, b = 200;
        int gdcResult = gcdFun(a, b);
        System.out.println("gdcResult = " + gdcResult);
    }

    private static int gcdFun(int a, int b) {
        int min = Math.min(a, b);
        while (min > 0) {
            if (a % min == 0 || b % min == 0) {
                break;
            }
            min--;
        }
        return min;
    }
}
