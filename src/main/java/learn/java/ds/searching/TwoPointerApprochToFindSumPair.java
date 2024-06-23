package learn.java.ds.searching;

public class TwoPointerApprochToFindSumPair {
    public static void main(String[] args) {
        int[] arr = {2, 5, 8, 12, 30};
        int x = 17;
        boolean isPairPresent = isPair(arr, x);
        System.out.println("isPairPresent = " + isPairPresent);
    }

    private static boolean isPair(int[] arr, int x) {
        int i = 0, j = arr.length - 1;
        while (i < j) {
            if (arr[i] + arr[j] == x) {
                return true;
            } else if (arr[i] + arr[j] < x) {
                i++;
            } else {
                j--;
            }
        }
        return false;
    }
}
