package learn.java.ds.arrays;

import java.util.Arrays;
import java.util.Random;

public class LargestElementInArray {
    private static int[] arr;

    public static void main(String[] args) {
        int capacity = 5;
        int[] arr = new int[capacity];
        for (int i = 0; i < capacity; i++) {
            int i1 = new Random().nextInt(10);
            arr[i] = i1;
        }
        System.out.println("Before:: Arrays.toString(arr) = " + Arrays.toString(arr));
        int largestIndex = findLargestInArray2(arr, arr.length);
        System.out.println("largest = " + arr[largestIndex]);
    }

    private static int findLargestInArray2(int[] arr, int length) {
        int largestIndex = 0;
        for (int i = 1; i < arr.length - 1; i++) {
            if (arr[i] > arr[largestIndex]) {
                largestIndex = i;
            }
        }
        System.out.println("largestIndex = " + largestIndex);
        System.out.println("arr[largestIndex] = " + arr[largestIndex]);
        return largestIndex;
    }

    private static int findLargestInArray(int[] arr, int n) {
        for (int i = 0; i < n; i++) {
            boolean flag = true;
            for (int j = 0; j < n; j++) {
                System.out.printf("%d > %d \n", arr[j], arr[i]);
                if (arr[j] > arr[i]) {
//                    System.out.println(String.format("%d>%d", arr[j], arr[i]));
                    flag = false;
                    break;
                }
            }
            if (flag == true) {
                return i;
            }
        }
        return -1;
    }
}
