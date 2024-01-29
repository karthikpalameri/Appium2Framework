package learn.java.ds.arrays;


import java.util.Arrays;


public class LeftRotateArrayByDElements {
    public static void main(String[] args) {
        int d = 2;
        int[] arr = {1, 2, 3, 4, 5};
        //           0, 1, 2, 3, 4
        System.out.println("Before::" + Arrays.toString(arr));
        leftRotateArrayByDElements2(arr, arr.length, d);
        System.out.println("After::" + Arrays.toString(arr));

    }

    private static void leftRotateArrayByDElements2(int[] arr, int length, int d) {
        reverse(arr, 0, d - 1);
        reverse(arr, d, length - 1);
        reverse(arr, 0, length - 1);
    }

    private static void reverse(int[] arr, int low, int high) {
        while (low < high) {
            swap(arr, low, high);
            low++;
            high--;
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static void leftRotateArrayByDElements(int[] arr, int length, int d) {
        int[] temp = new int[d];
        for (int i = 0; i < d; i++) {
            temp[i] = arr[i];
        }
        for (int i = d; i < length; i++) {
            arr[i - d] = arr[i];
//            2-2=0; 3-2=1; 4-2=2; 5-2=3;
        }
        for (int i = 0; i < d; i++) {
            arr[(length - d) + i] = temp[i];
        }
    }
}
