package learn.java.basics.arraysdemo;

public class ArraysBasics {
    static int count = 0;
    static int length = 5;

    public static void main(String[] args) throws Exception {
        int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
            insertElementToArray(arr, i);
        }
        displayArray(arr);
        insertElementAtStart(arr, 10);
        displayArray(arr);
        insertAtPosition(arr, 1, 20);
        displayArray(arr);
        deleteFromEnd();
        displayArray(arr);
        deleteValueFromArray(arr, 0);
        displayArray(arr);
        deleteFromPosition(arr, 2);
        displayArray(arr);
    }

    private static void deleteFromPosition(int[] arr, int index) {
        for (int i = index; i < length; i++) {
            arr[i] = arr[i + 1];
        }
        length--;
    }

    private static void deleteValueFromArray(int[] arr, int value) throws Exception {
        if (length <= 0) {
            throw new Exception("Array is empty");
        }
        int i;
        for (i = 0; i < length; i++) {
            if (arr[i] == value)
                break;
        }
        if (i == length) {
            System.out.println("value : " + value + "not found");
            return;
        }
        for (int j = i; j < length; j++) {
            arr[j] = arr[j + 1];
        }
        length--;
    }

    private static void deleteFromEnd() {
        if (length == 0)
            return;
        length--;
    }


    private static void insertElementToArray(int[] arr, int i) {
        arr[count++] = i;
    }

    private static void insertElementAtStart(int[] arr, int data) {
        for (int i = length - 1; i > 0; i--) {
            arr[i] = arr[i - 1];
        }
        arr[0] = data;
    }

    private static void insertAtPosition(int[] arr, int position, int data) {
        for (int i = length - 1; i > position; i--) {
            arr[i] = arr[i - 1];
        }
        arr[position] = data;
    }

    private static void displayArray(int[] arr) {
        for (int i = 0; i < length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
