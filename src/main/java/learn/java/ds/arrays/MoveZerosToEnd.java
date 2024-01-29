package learn.java.ds.arrays;

import java.util.Arrays;
import java.util.Random;

public class MoveZerosToEnd {
    public static void main(String[] args) {
        int capactiy = 5;
        int[] arr = new int[capactiy];
        for (int i = 0; i < capactiy; i++) {
            if (i % 2 == 0) arr[i] = 0;
            else
                arr[i] = new Random().nextInt(10);
        }
        System.out.println("Before:: Arrays.toString(arr = " + Arrays.toString(arr));
        moveZeroToEnd2(arr, arr.length);
        System.out.println("After:: Arrays.toString(arr = " + Arrays.toString(arr));

    }

    private static void moveZeroToEnd2(int[] arr, int length) {
        int nonZeroCounterPointer = 0;
        for (int i = 0; i < length; i++) {
            if (arr[i] != 0) {
                swap(arr, i, nonZeroCounterPointer);
                nonZeroCounterPointer++;
            }

        }
    }

    private static void moveZeroToEnd(int[] arr, int length) {
        // 1,2,0,3,0,4
        for (int i = 0; i < length; i++) {
            if (arr[i] == 0) {
                for (int j = i + 1; j < length; j++) {
                    if (arr[j] != 0) {
                        swap(arr, j, i);
                        break;
                    }

                }
            }

        }
    }

    private static void swap(int[] arr, int j, int i) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
