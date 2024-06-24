package learn.java.ds.sorting;

import java.util.Arrays;

public class MergeSortDemo {
    public static void main(String[] args) {
        int[] arr = new int[]{10, 20, 30, 10, 20};
        //                     0,  1,  2,  3,  4;
//        int low = 0;
//        int high = 4;
//        int mid = 2;
//        mergeFunction(arr, low, mid, high);
        mergeSort(arr, 0, 4);
        System.out.println("Arrays.toString(arr) = " + Arrays.toString(arr));
    }

    private static void mergeSort(int[] arr, int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;
            mergeSort(arr, low, mid);
            mergeSort(arr, mid + 1, high);
            mergeFunction(arr, low, mid, high);
        }
    }

    private static void mergeFunction(int[] arr, int low, int mid, int high) {
        //calculate size of left and right array
        int n1 = mid - low + 1;
        int n2 = high - mid;

        //split the 2 sorted array left and right
        int[] left = new int[n1];
        int[] right = new int[n2];

        for (int i = 0; i < n1; i++) {
            left[i] = arr[low + i];
        }
        for (int i = 0; i < n2; i++) {
            right[i] = arr[mid + 1 + i];
        }
        int i = 0, j = 0, k = low;
        while (i < n1 && j < n2) {
            if (left[i] <= right[j]) {
                arr[k] = left[i];
                i++;
                k++;
            } else {
                arr[k] = right[j];
                j++;
                k++;
            }
        }
        System.out.println("arr = " + Arrays.toString(arr));
        while (i < n1) {
            arr[k] = left[i];
            i++;
            k++;
        }
        while (j < n2) {
            arr[k] = right[j];
            k++;
            j++;
        }
        System.out.println("arr = " + Arrays.toString(arr));
    }
}
