package learn.java.ds.strings;

public class IsStringSubsequence {
    public static void main(String[] args) {
        String s1 = "abcdef";
        String s2 = "aef";
        isSubsequence(s1, s2);
    }

    private static boolean isSubsequence(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        if (n < m) {
            return false;
        }
        
        int j = 0;
        for (int i = 0; i < n && j < m; i++) {
            if (s1.charAt(i) == s2.charAt(j)) {
                j++;
            }
        }
        System.out.println("j == m " + (j == m));
        return j == m;
    }
}
