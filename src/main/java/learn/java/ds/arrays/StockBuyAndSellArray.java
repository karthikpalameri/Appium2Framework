package learn.java.ds.arrays;

public class StockBuyAndSellArray {
    public static void main(String[] args) {
        int[] arr = {1, 5, 3, 8, 12};
        findProfit(arr);
    }

    private static void findProfit(int[] arr) {
        int profit = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[i - 1]) {
                profit = profit + (arr[i] - arr[i - 1]);
            }
        }
        System.out.println("profit = " + profit);
    }
}
