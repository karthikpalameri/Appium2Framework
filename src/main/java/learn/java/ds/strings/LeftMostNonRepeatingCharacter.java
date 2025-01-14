package learn.java.ds.strings;

public class LeftMostNonRepeatingCharacter {
    private static final int CHAR = 256;

    public static void main(String[] args) {
        String str = "aabcde";
        findLeftMostNonRepeatingCharacter(str);
    }

    private static int findLeftMostNonRepeatingCharacter(String str) {
        int[] arr = new int[CHAR];
        for (int i = 0; i < str.length(); i++) {
            arr[str.charAt(i)]++;
        }
        for (int i = 0; i < str.length(); i++) {
            if (arr[str.charAt(i)] == 1) {
                System.out.println("index of first non repeating character = " + i);
                return i;
            }
        }
        return -1;
    }
}
