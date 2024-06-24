package learn.java.ds.sorting;

import java.util.Arrays;

public class MergeFunctionOfMergeSortDemo {
    public static void main(String[] args) {
        int[] arr = new int[]{10, 20, 40, 20, 30};
        //                     0,  1,  2,  3,  4
        int low = 0;//starting index of 1st array
        int mid = 2;//ending index of 1st array
        int high = 4;//ending index of 2nd array
        mergeFunctionOfMergeSort(arr, low, mid, high);
    }

    private static void mergeFunctionOfMergeSort(int[] arr, int low, int mid, int high) {
        int n1 = mid - low + 1;
        int n2 = high - mid;
        System.out.println("size if 1st array n1 = " + n1);
        System.out.println("size if 1st array n2 = " + n2);

        //put these 2 in separate arrays left and right
        int[] left = new int[n1];
        int[] right = new int[n2];

        for (int i = 0; i < n1; i++) {
            left[i] = arr[low + i];
        }
        for (int i = 0; i < n2; i++) {
            right[i] = arr[mid + i + 1];
        }
        int i = 0, j = 0, k = 0;
        while (i < n1 && j < n2) {//terminate as soon as one of the subarray is exhausted!
            //example for tracing:
            //10, 20, 40
            //20, 30

            if (left[i] <= right[j]) {
                arr[k] = left[i];
                i++;//increment left pointer
                k++;
            } else {
                arr[k] = right[j];
                j++;//increment right pointer
                k++;
            }
        }
        System.out.println("before appending remaining elements ,arr = " + Arrays.toString(arr));
        //copy remaining left over array elements and append at last
        while (i < n1) {
            arr[k] = left[i];
            i++;
            k++;
        }
        while (j < n2) {
            arr[k] = right[j];
            j++;
            k++;
        }
        System.out.println("after appending remaining elements , arr = " + Arrays.toString(arr));
    }
}
