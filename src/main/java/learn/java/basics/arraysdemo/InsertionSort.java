package learn.java.basics.arraysdemo;

public class InsertionSort {
    public static void main(String[] args) {
        InsertionSort is = new InsertionSort();
        int[] arr = {5, 4, 6, 3, 7};
        is.insertionSort(arr);

    }

    private void insertionSort(int[] arr) {
        // sort while inserting , run 2 for loops, 1 forward 1 backward
        for (int i = 1; i < arr.length; i++) { // leave starting , assume it as sorted
            int key = arr[i];//pick the key to check in sorted section
            for (int j = i; j >= 0 && arr[j] > key; j--) { // iterate backward
                //0, 1, 2, 3, 4
                //   k
                //   j
                //5, 4, 6, 3, 7

            }


        }
    }
}
