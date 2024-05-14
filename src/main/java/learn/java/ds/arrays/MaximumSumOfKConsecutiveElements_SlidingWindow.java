package learn.java.ds.arrays;

public class MaximumSumOfKConsecutiveElements_SlidingWindow {
    public static void main(String[] args) {
        int[] arr = {10, 5, -2, 20, 1};
//                    0, 1,  2,  3, 4
//                               k
//                               i
        int k = 3;
        findMaximumSumOfKConsecutiveElements2(arr, k);
    }

    private static void findMaximumSumOfKConsecutiveElements2(int[] arr, int k) {
        //Sliding window technique
        int n = arr.length;
        int curr = 0;
        for (int i = 0; i < k; i++) {
            curr += arr[i];
        }
        int res = curr;
        for (int i = k; i < n; i++) {
            curr = (curr + arr[i]) - arr[i - k]; // add next element of window and remove last element of window
            res = Math.max(res, curr);
        }
        System.out.println("res = " + res);
    }

    private static void findMaximumSumOfKConsecutiveElements(int[] arr, int k) {
        int n = arr.length;
        int res = Integer.MIN_VALUE;
        for (int i = 0; i + k - 1 < n; i++) {
            int curr = 0;
            for (int j = 0; j < k; j++) {
//                System.out.println("i = " + i);
//                System.out.println("j = " + j);
//                System.out.println("arr[i+j] = " + arr[i + j]);
                curr += arr[i + j];
                res = Math.max(res, curr);
            }
        }
        System.out.println("res = " + res);
    }

}
