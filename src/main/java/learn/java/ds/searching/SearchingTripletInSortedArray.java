package learn.java.ds.searching;

public class SearchingTripletInSortedArray {
    public static void main(String[] args) {
        int[] arr = {2, 5, 10, 15, 18};
        int x = 17;
        int si = 0;
        boolean tripletFound = isTripletFound(arr, x);
        System.out.println("tripletFound = " + tripletFound);
//        boolean isPairFound = findPair(arr, x, si);
//        System.out.println("isPairFound = " + isPairFound);

    }

    private static boolean isTripletFound(int[] arr, int x) {
        for (int i = 0; i < arr.length - 2; i++) {
            if (isPair(arr, x - arr[i], i + 1)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isPair(int[] arr, int x, int si) {
        int i = si, j = arr.length - 1;
        while (i < j) {
            if (arr[i] + arr[j] == x) {
                return true;
            } else if (arr[i] + arr[j] < x) {
                i++;
            } else {
                j--;
            }
        }
        return false;
    }
}
