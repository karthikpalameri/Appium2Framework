package learn.java.ds.sorting;

public class FindKthSmallestElement {
    public static void main(String[] args) {
        int[] arr = {1, 9, 2, 8, 3};
        int k = 1;
        int kthSmallestElement = findKthSmallestElement(arr, k);
        System.out.println("kthSmallestElement = " + kthSmallestElement);
    }

    private static int findKthSmallestElement(int[] arr, int k) {
        int n = arr.length;
        int l = 0;
        int h = n - 1;
        int pivot = arr[h];
        while (l <= h) {
            int p = lomutoPartitionIt(arr, l, h);
            if (p == k - 1) {
                return k;
            } else if (p > k - 1) {
                h = p - 1;
            } else {
                l = p + 1;
            }
        }
        return -1;
    }

    private static int lomutoPartitionIt(int[] arr, int l, int h) {
        int pivot = arr[h];
        int i = l - 1;
        for (int j = 0; j < h - 1; j++) {
            if (arr[j] < pivot) {
                i++;
                swapItFun(arr, i, j);
            }
        }
        i++;
        swapItFun(arr, i, h);
        System.out.println("i = " + i);
        return i;
    }

    private static void swapItFun(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
