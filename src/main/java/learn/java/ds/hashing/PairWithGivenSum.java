package learn.java.ds.hashing;

import java.util.HashSet;
import java.util.Set;

public class PairWithGivenSum {
    public static void main(String[] args) {
        int[] arr = {0, 1, 2, 3, 4, 5};
        int targetSum = 9;
//        pairWithGivenSum(arr, targetSum);
        boolean b = pairWithGivenSum2(arr, targetSum);
        System.out.println("b = " + b);
    }

    private static boolean pairWithGivenSum2(int[] arr, int targetSum) {
        Set<Integer> set = new HashSet<>();
        for (int x : arr) {
            int complement = targetSum - x;
            if (set.contains(complement)) {
                System.out.println("x = " + x);
                System.out.println("complement : " + complement);
                return true;
            } else {
                set.add(x);
            }
        }
        return false;
    }

    private static void pairWithGivenSum(int[] arr, int targetSum) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) { // no duplicate pairs
                System.out.println(i + "i - j" + j);
                if (arr[j] + arr[i] == targetSum)
                    System.out.println("(" + arr[i] + "," + arr[j] + ")");
            }
        }

    }
}
