package learn.java.ds.arrays;

public class MaximumLengthEvenOddSubArray {
    public static void main(String[] args) {
        int[] arr = {5, 10, 20, 6, 3, 8};
        findMaximumLengthEvenOddSubArray2(arr);
    }

    private static void findMaximumLengthEvenOddSubArray2(int[] arr) {
        int res = 1;
        int cur = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] % 2 == 0 && arr[i] % 2 != 0 || arr[i - 1] % 2 != 0 && arr[i] % 2 == 0) {
                cur++;
                res = Math.max(cur, res);
            } else {
                cur = 1; //reset sub array / starting position
            }
        }
        System.out.println("res = " + res);
    }

    private static void findMaximumLengthEvenOddSubArray(int[] arr) {
        int res = 1;
        for (int i = 0; i < arr.length; i++) {
            int cur = 1;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] % 2 == 0 && arr[j - 1] % 2 != 0 || arr[j] % 2 != 0 && arr[j - 1] % 2 == 0) {
                    cur++;
                } else {
                    break;
                }
                res = Math.max(res, cur);
            }
        }
        System.out.println("res = " + res);
    }
}
