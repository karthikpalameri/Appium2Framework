package learn.java.ds.sorting;

public class FindIntersectionOf2SortedArrays {
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 2, 2, 3};
        //            0, 1, 2, 3
        int[] arr2 = {0, 1, 2};
        //            0, 1, 2

//        intersection(arr1, arr2);
        intersection2(arr1, arr2);

    }

    private static void intersection2(int[] arr1, int[] arr2) {
        int n1 = arr1.length;
        int n2 = arr2.length;
        int i = 0;
        int j = 0;
        while (i < n1 && j < n2) {
            if (i > 0 && arr1[i] == arr1[i - 1]) {//if previous and current elem are same inc and continue
                i++;
                continue;
            }
            if (arr1[i] < arr2[j]) {
                i++;
            } else if (arr2[j] < arr1[i]) {
                j++;
            } else {//both are equal
                System.out.println("arr1[i] = " + arr1[i]);
                i++;
                j++;
            }
        }
        //dont need to traverse remaining elements in arr1 and arr2 as intersection is only needed
    }

    private static void intersection(int[] arr1, int[] arr2) {
        int n1 = arr1.length;
        int n2 = arr2.length;
        for (int i = 0; i < n1; i++) {
            if (i > 0 && arr1[i] == arr1[i - 1]) {
                continue;
            }
            for (int j = 0; j < n2; j++) {
                if (arr1[i] == arr2[j]) {
//                    System.out.println("arr1[i] == arr2[j]" + arr1[i] + "==" + arr2[j]);
                    System.out.println("Intersection element :" + arr1[i]);
                }
            }
        }
    }
}
