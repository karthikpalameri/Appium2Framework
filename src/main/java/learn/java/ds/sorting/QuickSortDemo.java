package learn.java.ds.sorting;

import java.util.Arrays;

public class QuickSortDemo {
    public static void main(String[] args) {
        int[] arr = {8, 4, 7, 9, 3, 10, 5};
        quickSortIt(arr, 0, arr.length - 1);
    }

    private static void quickSortIt(int[] arr, int l, int h) {
        if (l < h) {
            int p = lomutoPartition(arr, l, h);
            quickSortIt(arr, l, p - 1);
            quickSortIt(arr, p + 1, h);
        }
        System.out.println("Quick Sort trace : Arrays.toString(arr) = " + Arrays.toString(arr));
    }

    private static int lomutoPartition(int[] arr, int l, int h) {
        int pivot = arr[h];
        int i = -1;
        int n = arr.length;
        for (int j = 0; j < n; j++) {
            if (arr[j] < pivot) {
                i++;
                swapIt(arr, i, j);
            }
        }
        i++;
        swapIt(arr, i, h);
//        System.out.println("lomuto res: " + Arrays.toString(arr));
        return i; //return the pivot index
    }

    private static void swapIt(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
