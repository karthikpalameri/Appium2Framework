package learn.java.basics.simplemath;

public class LcmDemo {
    public static void main(String[] args) {
        int a = 4, b = 6;
        int lcmResult = lcmFun(a, b);
        System.out.println("lcmResult = " + lcmResult);
    }

    private static int lcmFun(int a, int b) {
        int max = Math.max(a, b);
        while (max > 0) {
            if (max % a == 0 && max % b == 0) {
                break;
            }
            max++;
        }
        return max;
    }
}
