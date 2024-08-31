package learn.java.ds.hashing;

import java.util.HashSet;

class IntersectionOf2UnsortedArrays {
    public static void main(String[] args) {
        int[] arr1 = {10, 20, 30};
        int[] arr2 = {10, 30};
//        intersectionOf2UnsortedArrays(arr1, arr2);
        intersectionOf2UnsortedArrays2(arr1, arr2);
    }

    private static void intersectionOf2UnsortedArrays2(int[] arr1, int[] arr2) {
        HashSet<Integer> hashSet = new HashSet<>();
        for (int i = 0; i < arr2.length; i++) {
            hashSet.add(arr2[i]);
        }
        for (int i = 0; i < arr2.length; i++) {
            if (hashSet.contains(arr2[i])) {
                System.out.println("arr2[i] = " + arr2[i]);
            }
        }
    }

    private static void intersectionOf2UnsortedArrays(int[] arr1, int[] arr2) {
        for (int i = 0; i < arr1.length; i++) {
            boolean flag = false;
            for (int j = 0; j < arr2.length; j++) {
                System.out.println(i + "i-j" + j);
                if (arr1[i] == arr2[j]) {
                    flag = true;
                    break;
                }
            }
            if (flag == true)
                System.out.println("Intersection element : " + arr1[i]);

        }
    }
}