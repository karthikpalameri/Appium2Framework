package learn.java.ds.arrays;

public class MaximuxConsecutive1s {
    public static void main(String[] args) {
        int[] arr = {0, 1, 1, 1, 0, 1};
        findMaximuxConsecutive1s(arr);
    }

    private static void findMaximuxConsecutive1s(int[] arr) {
        int res = 0, count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                count = 0;
            } else {
                count++;
                res = Math.max(count, res);
            }

        }
        System.out.println("res = " + res);

    }
}
