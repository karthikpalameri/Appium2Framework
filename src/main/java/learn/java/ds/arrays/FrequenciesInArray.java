package learn.java.ds.arrays;

public class FrequenciesInArray {
    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 3, 3, 3};
        findFrequencies(arr);


    }

    private static void findFrequencies(int[] arr) {
        int freq = 1;
        int length = arr.length;
        int i = 1;
        while (i < length) {
            while (i < length && arr[i] == arr[i - 1]) {
                freq++;
                i++;
            }
            System.out.println("arr[i-1] = " + arr[i - 1]);
            System.out.println("freq = " + freq);
            i++;
            freq = 1;
        }
    }
}
