package learn.java.ds.strings;

import java.util.*;

public class LeftMostRepeatingCharacter {
    public static final int CHAR = 256;

    public static void main(String[] args) {
        String str = "abfccbd";

        findLeftMostRepeatingCharacter(str);
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
