package learn.java.ds.arrays;

public class TrappingRainWaterArray {
    public static void main(String[] args) {
        int[] arr = {3, 0, 1, 2, 5};
        //           0, 1, 2, 3, 4
        findTrappingRainWater(arr);
    }

    private static void findTrappingRainWater(int[] arr) {
        int n = arr.length;
        int res = 0;
        for (int i = 1; i < n - 1; i++) {
            int lmax = arr[i];
            for (int j = 0; j < i; j++) {
                lmax = Math.max(lmax, arr[j]);
            }
            int rmax = arr[i];
            for (int j = i + 1; j < n; j++) {
                rmax = Math.max(rmax, arr[j]);
            }
            res = res + Math.min(lmax, rmax) - arr[i];
        }
        System.out.println("res = " + res);
    }
}
