package learn.java.ds.arrays;

public class MinimumConsecutiveFlipsToMakeAllSame {
  public static void main(String[] args) {
    int[] arr = new int[] {0, 1, 1, 0, 0, 1, 1, 0};// trick: 1st and last are same so flip 2nd grp always for minimum flips
    findMinimumFlips(arr);
  }

  private static void findMinimumFlips(int[] arr) {
    int n = arr.length;
    for (int i = 1; i < n; i++) {
      if (arr[i] != arr[i - 1]) {
        if (arr[i] != arr[0]) {
          System.out.println("from " + i);
        } else {
          System.out.println("to " + (i - 1));
        }
      }
    }
  }
}
