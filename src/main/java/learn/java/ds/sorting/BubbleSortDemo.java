package learn.java.ds.sorting;

import java.util.Arrays;

public class BubbleSortDemo {
    public static void main(String[] args) {
        int[] arr = {4, 3, 5, 2, 6};
        bubbleSortFun(arr);
        System.out.println("Arrays.asList(arr) = ");
        System.out.println(
                Arrays.toString(arr));
    }

    private static void bubbleSortFun(int[] arr) {
        int n = arr.length;
        boolean swapped = false;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    swapIt(arr, j, j + 1);
                    swapped = true;
                }
            }
            if (swapped == false)
                break;
        }
    }

    private static void swapIt(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
