package learn.java.ds.arrays;

public class SubArrayWithGivenSumExistOrNot {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
//                   0,1,2,3,4
        int sum = 9;
        findSubArrayWithGivenSumExistOrNot2(arr, sum);
    }

    private static boolean findSubArrayWithGivenSumExistOrNot2(int[] arr, int sum) {
        int n = arr.length;

        int start = 0, curr = 0;
        for (int end = 0; end < n; end++) {
            curr += arr[end];
            while (curr > sum) {
                curr -= arr[start];
                start++;
            }
            if (sum == curr)
                return true;
        }
        return false;
    }

    private static boolean findSubArrayWithGivenSumExistOrNot(int[] arr, int sum) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int curr = 0;
            for (int j = 1; j < n; j++) {
                curr += arr[i] + arr[j];
                if (curr == sum) {
                    return true;
                }
            }
        }
        return false;
    }
}
