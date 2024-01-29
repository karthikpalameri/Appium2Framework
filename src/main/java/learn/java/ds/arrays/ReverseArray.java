package learn.java.ds.arrays;

import java.util.Arrays;
import java.util.Random;

public class ReverseArray {
    public static void main(String[] args) {
        int capacity = 5;
        int[] arr = new int[capacity];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new Random().nextInt(10);
        }
        System.out.println("Before:: Arrays.toString(arr) = " + Arrays.toString(arr));
        reverseArray(arr, arr.length);
        System.out.println("After:: Arrays.toString(arr) = " + Arrays.toString(arr));
    }

    private static void reverseArray(int[] arr, int length) {
        int low = 0, high = length - 1;
        while (low < high) {
            swap(arr, low, high);
            low++;
            high--;
        }
    }

    private static void swap(int[] arr, int low, int high) {
        int temp = arr[low];
        arr[low] = arr[high];
        arr[high] = temp;

    }
}
