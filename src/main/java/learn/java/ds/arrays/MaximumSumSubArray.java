package learn.java.ds.arrays;

public class MaximumSumSubArray {
    public static void main(String[] args) {
        int[] arr = {1, -2, 3, -1, 2}; //input
//        {3,-1,2};//output
        findMaximumSumSubArray(arr);
    }

    private static void findMaximumSumSubArray(int[] arr) {
        int res = arr[0];

        for (int i = 0; i < arr.length; i++) {
            int curr = 0;
            for (int j = i; j < arr.length; j++) {
                curr = curr + arr[j];
                res = Math.max(curr, res);
            }
        }
        System.out.println("res = " + res);
    }
}
