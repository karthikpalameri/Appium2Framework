package learn.java.ds.arrays;

import java.util.Arrays;

public class DeleteOperationInArray {
    public static void main(String[] args) {
        int capacity = 10;
        int[] arr = new int[capacity];
        int n = 3;
        for (int i = 0; i < n; i++) {
            arr[i] = i + 1;
        }
        System.out.println("Before insert" + Arrays.toString(arr));
        int key = 1;
        deleteOperationArray(arr, n, capacity);
        System.out.println("After insert" + Arrays.toString(arr));
    }

    private static int deleteOperationArray(int[] arr, int n, int capacity) {
        int i;
        for (i = 0; i < n; i++) {
            arr[i] = arr[i + 1];
        }
        if (i == n) {
            System.out.println("Unable to find the element");
            return n;
        }
        return (n - 1);
    }
}
