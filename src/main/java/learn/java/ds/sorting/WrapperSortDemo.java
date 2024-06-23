package learn.java.ds.sorting;

import java.util.Arrays;
import java.util.Collections;

public class WrapperSortDemo {
    public static void main(String[] args) {
        Integer[] arr = {1, 4, 2, 5};
        Arrays.sort(arr, Collections.reverseOrder());
        System.out.println("Arrays.asList(arr) = " + Arrays.asList(arr));
    }
}
