package learn.java.ds.arrays;

public class MaximumCircularSubArraySum {
    public static void main(String[] args) {
        int[] arr = new int[]{-1, 2, 3, 4};
        findMaxCircularSubArraySum(arr);
    }

    private static int findMaxCircularSubArraySum(int[] arr) {
        int n = arr.length;
        int res = arr[0];
        for (int i = 0; i < n; i++) {
            int currMax = arr[i];
            int currSUm = arr[i];
            for (int j = 1; j < n; j++) {
                int index = (i + j) % n;
                currSUm += arr[index];
                currMax = Math.max(currMax, currSUm);
                System.out.println("index = " + index);
                System.out.println("arr[index] = " + arr[index]);
            }
            res = Math.max(res, currMax);
            System.out.println();
        }
        System.out.println("res = " + res);
        return res;
    }
}
