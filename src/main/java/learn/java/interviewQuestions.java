package learn.java;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.random.RandomGenerator;

public class interviewQuestions {
    public static void main(String[] args) {
        mergeTwoListInJava();
    }

    private static void mergeTwoListInJava() {
        ArrayList<Integer> l1 = new ArrayList<>(Collections.nCopies(2, 0));
        ArrayList<Integer> l2 = new ArrayList<>(Collections.nCopies(2, 1));

        ArrayList<Integer> finalList = new ArrayList<>();

        finalList.addAll(l1);
        finalList.addAll(l2);
        System.out.println("finalList = " + finalList);
    }

    private static void printDateInSpecificFormat() {
        String pattern = "mm-dd-yyyy hh:mm:ss";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        Date date = new Date();
        String formattedDate = simpleDateFormat.format(date);
        System.out.println("formattedDate = " + formattedDate);
    }

    private static void shuffleAnArray() {
        int[] arr = {3, 2, 4, 6, 7};
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            int randomIndexToSwap = random.nextInt(arr.length);
            System.out.println("randomIndexToSwap = " + randomIndexToSwap);
            int temp = arr[randomIndexToSwap];
            arr[randomIndexToSwap] = arr[i];
            arr[i] = temp;
        }
        System.out.println("randomized arr = " + Arrays.toString(arr));
    }

    private static void secondLargestNumberInAnArray() {
        int firstLargest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;
        System.out.println("firstLargest = " + firstLargest);
        System.out.println("secondLargest = " + secondLargest);
        int[] arr = {4, 6, 8, 9};
        for (int i : arr) {
            if (i > firstLargest) {
                //adjust 1st and second
                secondLargest = firstLargest;
                firstLargest = i;
            } else if (i > secondLargest) {
                //if not just assign it to 2nd largest
                secondLargest = i;
            }
        }
        System.out.println("firstLargest = " + firstLargest);
        System.out.println("secondLargest = " + secondLargest);

        int secondLargestUsingSteams = Arrays.stream(arr).boxed().sorted(Comparator.reverseOrder()).skip(1).findFirst().orElse(-1);
        System.out.println("secondLargestUsingSteams = " + secondLargestUsingSteams);
    }

    private static void sumOfAllIntegersInArray() {
        int[] array = {1, 2, 3, 4, 5};
        int sum = 0;
        for (int i : array) {
            sum = sum + i;
        }
        System.out.println("sum = " + sum);
        double reduce = Arrays.stream(array).asDoubleStream().reduce(0, Double::sum);
        System.out.println("reduce = " + reduce);
    }

    private static boolean twoArrayContainSameElements() {
        Integer[] a1 = {1, 2, 3};
        Integer[] a2 = {1, 2, 3};
        List<Integer> l1 = Arrays.asList(a1);
        List<Integer> l2 = Arrays.asList(a2);
        Set<Object> hs1 = new HashSet<>(l1);
        Set<Object> hs2 = new HashSet<>(l2);

        if (hs1.size() != hs2.size())
            return false;

        for (Object i : hs1) {
            if (!hs2.contains(i))
                return false;
        }
        System.out.println(true);
        return true;
    }

    private static void binarySearch1() {
//                   l         h
//                   0,1,2,3,4,5
        int[] arr = {1, 3, 5, 2, 6, 4};

        int key = 6;
        int foundAtIndx = binarySearchFunction(arr, 0, arr.length - 1, key);
        System.out.println("foundAtIndx = " + foundAtIndx);
    }

    private static int binarySearchFunction(int[] arr, int low, int high, int key) {
        while (low < high) {
            int mid = (low + high) / 2;
            if (arr[mid] == key)
                return mid;
            else if (arr[mid] < key)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return -1;
    }

    private static void factorialOfNum() {
        int n = 5;
        double res = 1;
        for (int i = n; i >= 1; i--) {
            System.out.println("i = " + i);
            res = res * i;
        }

        System.out.println("res = " + res);
    }

    private static void palindromeCheck2() {
        boolean result = true;
//                    0123
        String str = "racecar";
        int length = str.length();
        for (int i = 0; i < (length / 2); i++) {
            char leftPointer = str.charAt(i);
            System.out.println("charArrayLeftPointer = " + leftPointer);
            char rightPointer = str.charAt((length - i - 1));
            System.out.println("charArrayRightPointer = " + rightPointer); // this length -i-1 will traverse from back
            if (leftPointer != rightPointer) {
                result = false;
                break;
            }
        }
        System.out.println("result = " + result);
    }

    private static void sortAnArray() {
        int[] arr = {9, 4, 6, 7, 2};
        Arrays.sort(arr);
        System.out.println("arr = " + arr);
    }

    private static void removeLeadingAndTrailingSpaces() {
        String str = " this is space test  \t";
        String strip = str.strip();
        System.out.println("strip = " + strip);
    }

    private static void removeWhiteSpace() {
        String str = "this is test";
        StringBuilder sb = new StringBuilder();
        char[] charArray = str.toCharArray();

        for (char c : charArray) {
            if (!Character.isWhitespace(c)) {
                sb.append(c);
            }
        }
    }

    private static void palindromeCheck() {
        String str = "mom";
        String revString = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            revString = revString + (str.charAt(i));
        }
        System.out.println("revString = " + revString);

        if (revString.equals(str))
            System.out.println("IS Palindrome ->" + revString);
        else
            System.out.println("NOT Palindrome ->" + revString);

    }

    private static void fibonnaci() {
        int n = 10;
        //output = 0,1,1,2,3...
        int fib1 = 0;
        int fib2 = 1;
        int sum = 0;
        System.out.println(fib1);
        System.out.println(fib2);
        for (int i = 2; i < n; i++) {
            //shift 2 pointers to next
            sum = fib1 + fib2;
            System.out.println("=>" + sum);
            fib1 = fib2;
            fib2 = sum;
        }
    }

    private static boolean primeOrNot() {
        int n = 4;
        for (int i = 2; i <= n / 2; i++) {
            if (i % 2 == 0)
                return false;
        }
        return true;
    }
}
