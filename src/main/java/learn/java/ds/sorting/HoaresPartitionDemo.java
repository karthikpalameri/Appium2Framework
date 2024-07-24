package learn.java.ds.sorting;

import java.util.Arrays;

public class HoaresPartitionDemo {
  public static void main(String[] args) {
    int[] arr = {5,3,8,4,2,7,1,10};
    hoaresPartition(arr,0,7);

  }

  private static void hoaresPartition(int[] arr,int l, int h) {
    int pivot  = arr[l];
    int i = l-1;
    int j = h+1;
    while (true){
      do{
        i++;
      }while (arr[i]<pivot);
      do{
        j--;
      }while (arr[j]>pivot);
      if(i>=j)
        break;
      swapIt(arr,i,j);
    }
    System.out.println("After Hoares Partition Arrays = " + Arrays.toString(arr));
  }

  private static void swapIt(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }
}
