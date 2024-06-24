package learn.java.ds.sorting;

public class UnionOfSortedElements {
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 2, 2, 3, 3, 3, 4};
        int[] arr2 = {0, 1, 5};
        unionOfSortedElements(arr1, arr2);
    }

    private static void unionOfSortedElements(int[] arr1, int[] arr2) {
        int n1 = arr1.length;
        int n2 = arr2.length;
        int i = 0, j = 0;
        while (i < n1 && j < n2) {
            if (i > 0 && arr1[i] == arr1[i - 1]) {
                i++;
                continue;
            }
            if (j > 0 && arr2[j] == arr2[j - 1]) {
                j++;
                continue;
            }
            if (arr1[i] < arr2[j]) {
                System.out.println("arr1[i]= " + arr1[i]);
                i++;
            } else if (arr2[j] < arr1[i]) {
                System.out.println("arr2[j] = " + arr2[j]);
                j++;
            } else {
                System.out.println("arr1[i] = " + arr1[i]);
                i++;
                j++;
            }
        }
        while (i < n1) {
            System.out.println("arr1[i] = " + arr1[i]);
            i++;
        }
        while (j < n2) {
            System.out.println("arr2[j] = " + arr2[j]);
            j++;
        }
    }
}
