package learn.java.ds.searching;

public class BinarySearchRecursive {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int low = 0, high = arr.length - 1;
        int x = 2;
        int index = binarySearchRecursive(arr, low, high, x);
        System.out.println("index = " + index);
    }

    private static int binarySearchRecursive(int[] arr, int low, int high, int x) {
        if (low > high)
            return -1;
        int mid = (high + low) / 2;
        if (arr[mid] == x)
            return mid;
        else if (arr[mid] > x)
            return binarySearchRecursive(arr, low, mid - 1, x);
        else
            return binarySearchRecursive(arr, mid + 1, high, x);
    }
}
