package learn.java.basics.simplemath;

public class PalindromeCheck {
    public static void main(String[] args) {
        int x = 121;
        boolean b = checkPal(x);
        System.out.println(x + " isPalindrome = " + b);
    }

    private static boolean checkPal(int x) {
        int temp = x;
        int rev = 0;
        while (temp > 0) {
            System.out.println("--");
            System.out.println("temp = " + temp);
            int ld = temp % 10;//1
            System.out.println("ld = " + ld);
            rev = rev * 10 + ld;// 0*10+1=1
            System.out.println("rev = " + rev);
            temp = temp / 10; // 121/10 = 12
            System.out.println("temp = " + temp);
        }
        if (x == rev) return true;
        return false;
    }
}
