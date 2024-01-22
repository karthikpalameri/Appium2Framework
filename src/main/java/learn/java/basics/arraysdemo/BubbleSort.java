package learn.java.basics.arraysdemo;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        BubbleSort bs = new BubbleSort();
        int[] arr = {5, 7, 3, 1, 2};
        arr = bs.bubbleSort(arr);
        System.out.println("Arrays.toString(arr) = " + Arrays.toString(arr)); //Arrays.toString(arr);
    }

    private int[] bubbleSort(int[] arr) {
        //0,1
        if (arr.length == 0 || arr.length == 1)
            return arr;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        return arr;
    }

}
