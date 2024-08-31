package learn.java.ds.hashing;

import java.util.HashSet;

public class CountDistinctElements {
    public static void main(String[] args) {
        int[] arr = {0, 1, 2, 3};
        //countDistinct(arr);
        countDistinct2(arr);
    }

    private static void countDistinct2(int[] arr) {
        HashSet<Integer> hashSet = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            hashSet.add(arr[i]);
        }
        System.out.println("count of distinct elements are hashSet.size() = " + hashSet.size());
    }

    private static void countDistinct(int[] arr) {
        int n = arr.length;
        int disctinctCounter = 0;
        for (int i = 0; i < n; i++) {
            boolean flag = false;
            for (int j = 0; j < i; j++) {
                System.out.println(i + "i-j" + j);
                if (arr[j] == arr[i]) {
                    flag = true;
                    break;
                }
                if (flag == true)
                    disctinctCounter++;
            }
            System.out.println("disctinctCounter = " + disctinctCounter);
        }
    }
}
