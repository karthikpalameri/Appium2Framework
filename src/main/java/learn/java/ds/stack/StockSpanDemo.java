package learn.java.ds.stack;

public class StockSpanDemo {

    public static void main(String[] args) {
        int[] arr = {18, 12, 13, 14, 11, 16};

        stockSpanNaive(arr);
    }

    private static void stockSpanNaive(int[] arr) {
        int size = arr.length;
        //  18, 12, 13, 14, 11, 16
        //  i
        //  j

        for (int i = 0; i < size; i++) {
            int span = 1;
            for (int j = i - 1; j >= 0 && arr[j] <= arr[i]; j--) {
                span++;
            }
            System.out.println("span = " + span);
        }

    }
}
