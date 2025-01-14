package learn.java.ds.strings;

import java.util.Arrays;

public class LeftMostRepeatingCharacter {
    public static final int CHAR = 256;

    public static void main(String[] args) {
        String str = "abfccbd";

        findLeftMostRepeatingCharacter2(str);
    }

    private static int findLeftMostRepeatingCharacter2(String str) {
        boolean[] arr = new boolean[CHAR];
        int res = -1;

        for (int i = str.length() - 1; i >= 0; i--) {
            if (arr[str.charAt(i)] == false) {
                arr[str.charAt(i)] = true;
            } else {
                res = i;
            }
        }
        System.out.println("res = " + res);
        return res;
    }

    private static void findLeftMostRepeatingCharacter(String str) {
        int[] findIndex = new int[CHAR];
        Arrays.fill(findIndex, -1); // inbuilt function to fill
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < str.length(); i++) {
            int firstIndex = findIndex[str.charAt(i)];
            if (firstIndex == -1) {
                findIndex[str.charAt(i)] = i;
            } else {
                res = Math.min(res, firstIndex);
            }
        }
        res = (res == Integer.MIN_VALUE) ? -1 : res;
        System.out.println("res = " + res);
        System.out.println("Arrays.toString(findIndex) = " + Arrays.toString(findIndex));
    }
}
