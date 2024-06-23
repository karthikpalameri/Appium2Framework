package learn.java.ds.searching;

public class SearchInfiniteSizeArray {
    public static void main(String[] args) {

        int[] arr = {1, 10, 15, 20, 40, 60, 80, 100, 200, 500, 1000};
        int x = 100;

        int foundInIndex = search(arr, x);
        System.out.println("foundInIndex = " + foundInIndex);

    }

    private static int search(int[] arr, int x) {
        //increment i by multiple of 2

        //initial check with 0 as 0 cant be multiplied
        if (arr[0] == x)
            return 0;
        int i = 1;
        while (arr[i] < x) {
            i = i * 2;
        }
        return binarySearch4(arr, x, (i / 2) + 1, i - 1);
    }

    private static int binarySearch4(int[] arr, int x, int low, int high) {
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == x) {
                return mid;
            } else if (arr[mid] > x) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }
}
