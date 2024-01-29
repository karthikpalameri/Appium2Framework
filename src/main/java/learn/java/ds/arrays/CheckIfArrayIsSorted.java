package learn.java.ds.arrays;

public class CheckIfArrayIsSorted {
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 2},
                length = arr.length;
        boolean isSorted = checkIfArrayIsSorted2(arr, length);
        System.out.println("isSorted = " + isSorted);
    }

    private static boolean checkIfArrayIsSorted2(int[] arr, int length) {
        for (int i = 1; i < length; i++) {
            if (arr[i] < arr[i - 1]) {
                System.out.printf("%d > %d \n", arr[i], arr[i - 1]);
                return false;
            }
        }
        return true;
    }

    private static boolean checkIfArrayIsSorted(int[] arr, int length) {
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if (arr[j] < arr[i]) {
                    System.out.printf("%d > %d \n", arr[j], arr[i]);
                    return false;
                }
            }
        }
        return true;
    }
}
