package learn.java.ds.sorting;

import java.util.Arrays;

public class SelectionSortDemo { //find the minimum element and move/swap to the 1st position
    public static void main(String[] args) {
        int[] arr = {3, 4, 2, 1, 5};
        selectionSort(arr);
    }

    private static void selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            System.out.println();
            int minIndex = i; //assume min index
            for (int j = i + 1; j < n; j++) {
                System.out.println("Comparing " + arr[i] + " with " + arr[j]);
                if (arr[j] < arr[minIndex]) {
                    System.out.println(" " + arr[j] + " < " + arr[minIndex]);

                    minIndex = j; //reassign minIndex
                    System.out.println("minIndex = " + minIndex);
                    System.out.println("minElement = " + arr[minIndex]);
                }
            }
            swap(arr, minIndex, i);
            System.out.println("arr = " + Arrays.toString(arr));
        }
    }

    private static void swap(int[] arr, int minIndex, int j) {
        System.out.println("swapping " + arr[minIndex] + " with " + arr[j]);
        int temp = arr[minIndex];
        arr[minIndex] = arr[j];
        arr[j] = temp;
    }
}
