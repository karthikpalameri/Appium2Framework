package learn.java.ds.recursion;

public class PalindromeRecursion {
    public static void main(String[] args) {
        String str = "abba";
        int start = 0, end = str.length() - 1;
        boolean abba = isPalin(str, start, end);
        System.out.println("abba = " + abba);
    }

    private static boolean isPalin(String n, int start, int end) {
        if (start >= end)
            return true;
        return n.charAt(start) == n.charAt(end) && isPalin(n, start + 1, end - 1);
    }
}
