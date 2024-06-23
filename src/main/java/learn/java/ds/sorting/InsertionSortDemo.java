package learn.java.ds.sorting;

import java.util.Arrays;

public class InsertionSortDemo {
    public static void main(String[] args) {
        int[] arr = {20, 5, 40, 60, 10, 30};
        insertionSort(arr);
    }

    private static void insertionSort(int[] arr) {//2 pointers go opposite,take from right array and insert it in left array
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            System.out.println("arr[i] = " + arr[i]);
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
            System.out.println(Arrays.toString(arr));
            System.out.println();
        }
    }
}
