package learn.java.ds.arrays;

public class MajorityElementInArray {
  public static void main(String[] args) {
    int[] arr = new int[] {1, 2, 3, 1, 1, 1, 1, 1};
    int majorityElementIndex = findMajorityElement(arr);
    System.out.println("majorityElementIndex = " + majorityElementIndex);
    System.out.println("arr[majorityElementIndex] = " + arr[majorityElementIndex]);
  }

  private static int findMajorityElement(int[] arr) {
    int n = arr.length;
    System.out.println(" size of array = " + n);
    for (int i = 0; i < n; i++) {
      int count = 1;
      for (int j = i + 1; j < n; j++) {
        if(arr[i] == arr[j]){
          count++;
          if(count>n/2){
            return i;
          }
        }
      }
    }
    return -1;
  }
}
