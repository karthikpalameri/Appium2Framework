package learn.java.ds.arrays;

import java.util.Arrays;

public class LeftRotateArrayByOne {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        System.out.println("Before::Arrays.toString(arr = " + Arrays.toString(arr));
        leftRotateArrayByOne(arr, arr.length);
        System.out.println("After::Arrays.toString(arr = " + Arrays.toString(arr));
    }

    private static void leftRotateArrayByOne(int[] arr, int length) {
        int temp = arr[0];
        for (int i = 1; i < length; i++) {
            arr[i - 1] = arr[i];
        }
        arr[length - 1] = temp;
    }
}
