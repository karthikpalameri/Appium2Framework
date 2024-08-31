package learn.java.ds.hashing;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class UnionOf2UnsortedArrays {
    public static void main(String[] args) {
        int[] arr1 = {10, 20, 30};
        int[] arr2 = {10, 20, 31};
        unionOf2SortedArrays(arr1, arr2);
    }

    private static void unionOf2SortedArrays(int[] arr1, int[] arr2) {
        Set<Integer> hset1 = Arrays.stream(arr1).boxed().collect(Collectors.toSet());
        Set<Integer> hset2 = Arrays.stream(arr2).boxed().collect(Collectors.toSet());
        System.out.println("hset1 = " + hset1);
        System.out.println("hset2 = " + hset2);
        Set<Integer> set = new HashSet<>();
        hset1.addAll(hset2);
        System.out.println("hset1 = " + hset1);
    }
}
