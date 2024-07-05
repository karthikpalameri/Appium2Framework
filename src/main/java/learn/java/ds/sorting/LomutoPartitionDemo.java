package learn.java.ds.sorting;

import java.util.Arrays;

public class LomutoPartitionDemo {
  public static void main(String[] args) {
    int[] arr = {10, 80, 30, 90, 40, 50, 70};
//                0,  1,  2,  3,  4,  5,  6
    lomutoPartition(arr, 0, 6);
  }

  private static void lomutoPartition(int[] arr, int l, int h) {
    int pivot = arr[h];
    int i = l-1; //left window partition

    for (int j = 0; j < h - 1; j++) {
      if (arr[j] < pivot){
        i++;//increment the left window and swap
        swapIt(arr,i,j);
      }
    }
    System.out.println("Result before repositioning pivot:" + Arrays.toString(arr));
    //now bring the pivot to its correct position
   swapIt(arr,i+1,h);
    System.out.println("Result after repositioning pivot:" + Arrays.toString(arr));
  }

  private static void swapIt(int[] arr, int i, int j) {
    System.out.println("Before Swapping :" + Arrays.toString(arr));
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
    System.out.println("After Swapping :" + Arrays.toString(arr));
  }
}
