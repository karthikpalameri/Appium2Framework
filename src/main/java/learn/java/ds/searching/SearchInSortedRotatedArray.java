package learn.java.ds.searching;

public class SearchInSortedRotatedArray {
    public static void main(String[] args) {
        int[] arr = {10, 20, 40, 60, 5, 8};
//                   0,   1,  2,  3, 4, 5
//                            m
//                   l                  h
        int x = 5;
        int res = searchInSortedRotatedArray(arr, x);
        System.out.println("res = " + res);
    }

    private static int searchInSortedRotatedArray(int[] arr, int x) {
        int low = 0, high = arr.length - 1;

        while (low < high) {
            int mid = (low + high) / 2;
            if (arr[mid] == x) {
                return mid;
            }
            if (arr[low] <= arr[mid]) {//then its left half sorted
                if (x >= arr[low] && x < arr[high]) {
                    //readjust high
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {//then its right half sorted
                if (x > arr[mid] && x <= arr[high]) {
                    //readjust low
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }
}
