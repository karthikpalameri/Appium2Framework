package learn.java.ds.arrays;

public class MaximumDifferenceInArray {
    public static void main(String[] args) {
        int[] arr = {2, 3, 10, 6, 1, 4, 5};
        findMaxDifference2(arr);
    }

    private static void findMaxDifference2(int[] arr) {
        int minVal = arr[0];
        int res = arr[1] - arr[0];
        for (int i = 0; i < arr.length - 1; i++) {
            minVal = Math.min(minVal, arr[i]);
            System.out.printf("Math.min(%d,%d)\n", minVal, arr[i]);
            System.out.printf("minVal : %d\n", minVal);

            res = Math.max(res, arr[i] - minVal);
        }
        System.out.println("minVal = " + minVal);
        System.out.println("res = " + res);
    }

    private static void findMaxDifference(int[] arr) {
        int maxDifference = arr[0] - arr[1];
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                int toCheck = arr[j] - arr[i];
                maxDifference = Math.max(maxDifference, toCheck);
                System.out.printf("Math.max(%d ,%d ) is %d\n", maxDifference, toCheck, maxDifference);
            }
        }
        System.out.println("maxDifference = " + maxDifference);
    }
}
