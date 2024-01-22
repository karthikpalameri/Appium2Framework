package learn.java.basics.arraysdemo;

public class BinarySearch {

    public static void main(String[] args) {
        int[] arr = {0, 1, 2, 3, 4};
        BinarySearch bs = new BinarySearch();
        int index = bs.searchIndex(arr, 4);
        index = bs.searchIndex2(arr, 1, 0, arr.length - 1);

        if (index == -1)
            System.out.println("value not found");
        else
            System.out.println("value found at index " + index);
//        bs.searchIndex2(arr, 1, 0, arr.length - 1);

    }

    private int searchIndex2(int[] arr, int val, int start, int end) {
        if (start > end || arr.length == 0) {
            return -1;
        }
        int mid = (start + end) / 2;
        if (val == arr[mid])
            return mid;
        if (val < arr[mid])
            return searchIndex2(arr, val, start, mid - 1);
        else
            return searchIndex2(arr, val, mid + 1, end);

    }

    private int searchIndex(int[] arr, int val) {
        int left = 0, right = arr.length;
        while (left < right) {
            int mid = (left + right) / 2;

            if (arr[mid] == val)
                return mid;

            if (val < arr[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
}
