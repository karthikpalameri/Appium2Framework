package learn.java.ds.sorting;

import java.util.Arrays;

public class SortAnArrayWith3TypesOfElements_DutchNationalFlagAlgo {
    public static void main(String[] args) {
        int[] arr = {0, 1, 2, 1, 1, 2};
        sortAnArrayWith3TypesOfElements_DutchNationalFlagAlgo(arr);

    }

    private static void sortAnArrayWith3TypesOfElements_DutchNationalFlagAlgo(int[] arr) {
        int n = arr.length;
        int l = 0;
        int m = 0;
        int h = n - 1;

        while (m <= h) {
            if (arr[m] == 0) {
                swapItt(arr, m, l);
                l++;
                m++;
            } else if (arr[m] == 1) {
                m++;
            } else {
                swapItt(arr, m, h);
                h--;
            }
        }
        System.out.println("Sorted array having 3 elements , Arrays.toString(arr) = " + Arrays.toString(arr));
    }

    private static void swapItt(int[] arr, int m, int l) {
        int temp = arr[m];
        arr[m] = arr[l];
        arr[l] = temp;
    }
}
