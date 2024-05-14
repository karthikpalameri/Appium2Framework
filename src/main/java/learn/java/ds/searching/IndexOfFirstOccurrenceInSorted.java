package learn.java.ds.searching;

public class IndexOfFirstOccurrenceInSorted {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        //           0, 1, 2, 3, 4
        int n = arr.length;
        int x = 2;
        int indexOfFirstOccurenceInSorted = findIndexOfFirstOccurenceInSorted(arr, n, x);
        System.out.println("indexOfFirstOccurenceInSorted = " + indexOfFirstOccurenceInSorted);
    }

    private static int findIndexOfFirstOccurenceInSorted(int[] arr, int n, int x) {
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = (low + high) / 2; // 2
            if (arr[mid] > x) {
                high = mid - 1;
            } else if (arr[mid] < x) {
                low = mid + 1;
            } else {
                if ((mid == 0 || (arr[mid - 1] != arr[mid]))) {
                    return mid;
                } else {
                    return mid - 1;
                }
            }
        }
        return -1;
    }
}
