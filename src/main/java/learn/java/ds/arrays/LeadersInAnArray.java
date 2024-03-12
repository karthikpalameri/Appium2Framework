package learn.java.ds.arrays;

import java.util.Arrays;
import java.util.Random;

public class LeadersInAnArray {
    public static void main(String[] args) {
        int capacity = 5;
        int[] arr = new int[capacity];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new Random().nextInt(10);
        }
        System.out.println("Before:: Arrays.toString(arr) = " + Arrays.toString(arr));
        getLeadersInArray2(arr, arr.length);
    }

    private static void getLeadersInArray2(int[] arr, int length) {
        int current_leader = arr[length - 1];
        for (int i = length - 2; i >= 0; i--) {
            System.out.printf("%d > %d\n", arr[i], current_leader);
            if (arr[i] > current_leader) {
                System.out.println("leaderElement arr[i] =" + arr[i]);
                current_leader = arr[i];
            }
        }
    }

    private static void getLeadersInArray(int[] arr, int length) {
        for (int i = 0; i < arr.length; i++) {
            boolean flag = false;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] <= arr[j]) {
                    flag = true;
                    break;
                }
            }
            if (flag == false) {
                System.out.println("LeaderInArray ELement arr[i] = " + arr[i]);
            }
        }
    }
}
