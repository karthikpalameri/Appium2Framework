package learn.java.ds.sorting;

import java.util.Arrays;

public class WrapperSortEvenAndOdd {
    public static void main(String[] args) {
        Integer[] arr = {1, 4, 2, 5};
        Arrays.sort(arr, (o1, o2) -> o1 % 2 - o2 % 2);
        System.out.println("Arrays.asList(arr) = " + Arrays.asList(arr));
    }
}
