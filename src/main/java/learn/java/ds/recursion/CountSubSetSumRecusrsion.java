package learn.java.ds.recursion;

public class CountSubSetSumRecusrsion {
    public static void main(String[] args) {
        int[] arr = {10, 20, 15};
        int n = arr.length;
        int sum = 25;
        int count = countSubSet(arr, n, sum);
        System.out.println("count = " + count);
    }

    private static int countSubSet(int[] arr, int n, int sum) {
        if (n == 0) {
            return sum == 0 ? 1 : 0;
        }
        return countSubSet(arr, n - 1, sum) +
                countSubSet(arr, n - 1, sum - arr[n - 1]);
    }
}
