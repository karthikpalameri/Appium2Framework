package learn.java.ds.arrays;

import java.util.Arrays;

public class InsertOperartionInArray {
    public static void main(String[] args) {
        int capacity = 10;
        int[] arr = new int[capacity];
        int n = 3;
        for (int i = 0; i < n; i++) {
            arr[i] = i + 1;
        }
        int x = 4;
        System.out.println("Before insert" + Arrays.toString(arr));
        int indx = 1;
        insertOperationArray(arr, n, capacity, x, indx);
        System.out.println("After insert" + Arrays.toString(arr));
    }

    private static void insertOperationArray(int[] arr, int n, int capacity, int x, int indx) {
        if (capacity == n) {
            System.out.println("Capacity full unable to insert");
            return;
        }

        for (int i = n - 1; i >= indx; i--) {
            arr[i + 1] = arr[i];
        }
        arr[indx] = x;
    }
}
