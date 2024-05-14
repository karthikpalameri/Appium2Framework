package learn.java.ds.searching;

public class IndexOfLastOccurrence {
    public static void main(String[] args) {
        int[] arr = {5, 10, 10, 10, 10, 20, 20};
        //           0   1   2   3   4   5   6
        int x = 10;
        int indexOfLastOccurrence = findIndexOfLastOccurrence(arr, x);
        System.out.println("indexOfLastOccurrence = " + indexOfLastOccurrence);
    }

    private static int findIndexOfLastOccurrence(int[] arr, int x) {
        int n = arr.length;
        int low = 0, high = n - 1;
        while (low <= high) {
            int mid = (low + high) / 2;//3
            if (arr[mid] < x) {
                low = mid + 1;
            } else if (arr[mid] > x) {
                high = mid - 1;
            } else {
                if (mid == n - 1 || arr[mid] != arr[mid + 1]) {
                    return mid;
                } else {
                    low = mid + 1;
                }
            }
        }

        return -1;
    }
}
