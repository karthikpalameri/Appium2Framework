package learn.java.ds.hashing;

import java.util.HashSet;

public class SubArraayWithSum0 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
//        boolean b = subArrayWithSum0(arr);
        boolean b = subArrayWithSum0_(arr);
        System.out.println("subArrayWithSum0 exists = " + b);
    }

    private static boolean subArrayWithSum0_(int[] arr) {
        int n = arr.length;
        int targetSum = 0;
        int preSum = 0;
        HashSet<Integer> hset = new HashSet<>();
        for (int i = 0; i < n; i++) {
            preSum += arr[i];
            if (hset.contains(preSum)) {
                return true;
            }
            if (preSum == targetSum) {
                return true;
            }
            hset.add(preSum);
        }

        return false;
    }

    private static boolean subArrayWithSum0(int[] arr) {

        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int currSum = 0;
            for (int j = i; j < n; j++) { //second element in the pair can be same, example subarray
                System.out.printf("%di-j%d\t", i, j);
                currSum += arr[j];
                System.out.print("currSum = " + currSum + "\t");

                if (currSum == 0) {
                    return true;
                } else
                    return false;
            }
            System.out.println();
        }
        return false;
    }
}
