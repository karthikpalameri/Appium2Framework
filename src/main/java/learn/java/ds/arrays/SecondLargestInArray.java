package learn.java.ds.arrays;

public class SecondLargestInArray {
    public static void main(String[] args) {
        int[] arr = {1, 0, 0, 4, 3};
        secondLargestInArray2(arr, arr.length);
    }

    private static void secondLargesInArray3(int[] arr, int length) {
        int firstLargestIndex = 0;
        int secondLargestIndex = -1;
        for (int i = 1; i < length; i++) {
            if (arr[i] > arr[firstLargestIndex]) {
                secondLargestIndex = firstLargestIndex;
                firstLargestIndex = i;
            } else if (arr[i] != arr[firstLargestIndex]) {
                if (secondLargestIndex == -1 || arr[i] > arr[secondLargestIndex]) {
                    secondLargestIndex = i;
                }
            }
        }
    }


    private static void secondLargestInArray2(int[] arr, int length) {
        int firstLargestIndex = 0;
        int secondLargestIndex = -1;
        for (int i = 1; i < length; i++) {
            if (arr[i] > arr[firstLargestIndex]) {
                System.out.printf("%d > %d ", arr[i], arr[firstLargestIndex]);
                secondLargestIndex = firstLargestIndex;
                firstLargestIndex = i;
            } else if (arr[i] != arr[firstLargestIndex]) {
                System.out.printf("%d != %d ", arr[i], arr[firstLargestIndex]);
                if (secondLargestIndex == -1 || arr[i] > arr[secondLargestIndex]) {
                    secondLargestIndex = i;
                }
            }
        }
        System.out.println("firstLargestIndex = " + firstLargestIndex);
        System.out.println("secondLargestIndex = " + secondLargestIndex);
        System.out.println("arr[firstLargestIndex] = " + arr[firstLargestIndex]);
        System.out.println("arr[secondLargestIndex] = " + arr[secondLargestIndex]);
    }

    private static int secondLargestInArray(int[] arr, int length) {
        int firstLargestIndexElement = firstLargestIndexInArray(arr, length);
        int res = -1;
        for (int i = 0; i < length; i++) {
            if (arr[i] > arr[firstLargestIndexElement]) {
                if (res == -1)
                    res = arr[i];
                else if (arr[i] > arr[res]) {
                    res = arr[i];
                }
            }
        }
        System.out.println("res = " + res);
        System.out.println("arr[res] = " + arr[res]);
        return arr[res];
    }

    private static int firstLargestIndexInArray(int[] arr, int length) {
        int firstLargestIndex = 0;
        for (int i = 0; i < length; i++) {
            if (arr[i] > arr[firstLargestIndex])
                firstLargestIndex = i;
        }
        System.out.println("firstLargestIndex = " + firstLargestIndex);
        System.out.println("arr[firstLargestIndex] = " + arr[firstLargestIndex]);
        return firstLargestIndex;
    }
}
