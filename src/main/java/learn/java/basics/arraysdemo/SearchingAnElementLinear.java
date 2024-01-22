package learn.java.basics.arraysdemo;

public class SearchingAnElementLinear {
    static int length = 5;

    public static void main(String[] args) {
        int[] arr = new int[5];
        for (int i = 0; i < length; i++) {
            arr[i] = i;
        }
        int i = linearSearch(arr, 1);
        if (i == -1)
            System.out.println("Element not found");
        else
            System.out.println("Element found at index = " + i);

    }

    private static int linearSearch(int[] arr, int val) {
        if (arr.length == 0)
            return -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == val)
                return i;
        }
        return -1;
    }
}
