package learn.java.ds.searching;

import java.util.Arrays;

public class CycleSortDemo {
    public static void main(String[] args) {
        int[] arr = {20, 40, 50, 10, 30};
        cycleSortDemo(arr);
    }

    private static void cycleSortDemo(int[] arr) {
        int n = arr.length;
        for (int cs = 0; cs < n - 1; cs++) {
            int item = arr[cs];
            int pos = cs; // pos should be equal to cycle start at start and when cycle ends
            for (int i = cs + 1; i < n; i++) {
                if (arr[i] < item) {
                    pos++;
                }
            }
            item = swapItt(arr, pos, item);
            System.out.println("Arrays.toString(arr) = " + Arrays.toString(arr));
            while (pos != cs) { //position should be equal to cycle start to complete full cycle
                //reset position to cycle start, so we can find the correct position for the current item
                pos = cs;
                for (int i = cs + 1; i < n; i++) {
                    if (arr[i] < item) {
                        pos++;
                    }
                }
                item = swapItt(arr, pos, item);
                System.out.println("Arrays.toString(arr) = " + Arrays.toString(arr));
            }
        }
    }

    private static int swapItt(int[] arr, int i, int item) {
        int temp = arr[i];
        arr[i] = item;
        item = temp;
        return item;
    }
}
