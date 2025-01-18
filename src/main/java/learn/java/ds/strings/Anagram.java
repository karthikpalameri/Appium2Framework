package learn.java.ds.strings;

public class Anagram {
    public static void main(String[] args) {
        String s1 = "aba";
        String s2 = "aab";
        isAnagram(s1, s2);
    }

    private static boolean isAnagram(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        int[] count = new int[256];
        for (int i = 0; i < s1.length(); i++) {
            count[s1.charAt(i)]++;
            count[s2.charAt(i)]--;
        }
        for (int i = 0; i < s1.length(); i++) {
            if (count[i] != 0)
                return false;
        }
        return true;
    }
}