package learn.java.basics.arraysdemo;

import learn.java.basics.Student;

import java.util.*;

public class ArrayDemo {

    private static int m;
    private static int n;

    public static void main(String[] args) {
        extracted();
    }

    private static void extracted() {

//        Student[] studentsArr = new Student[]{
//                new Student(1, "adam", 5),
//                new Student(3, "bbr", 1),
//                new Student(2, "ccat", 3),
//        };
        //index      0, 1, 2, 3, 4, 5, 6, 7
        int[] arr = {11, 5, 2, 9, 8, 3, 5, 2};
        findTheSmallestElementMissing(arr);
        System.out.println("arr = " + Arrays.toString(arr));
        System.out.println();
    }

    private static int findTheSmallestElementMissing(int[] arr) {
        int arr1[] = {0, 1, 2, 3, 4, 5, 6, 7, 10};
        m = 11;
        n = arr.length;

        int indexFound = findTheSmallestElementMissing(arr1, n, m);
        System.out.println("indexFound = " + indexFound);
        return indexFound;
    }

    private static int findTheSmallestElementMissing(int[] arr, int length, int m) {
        int[] temp = new int[m];
        for (int i = 0; i <= length; i++) {
            int indexToAlter = arr[i];
            temp[indexToAlter] = 1; //make it all 1 to distinguish
        }
        for (int i = 0; i < m; i++) {
            if (temp[i] == 0)
                return i;
        }
        return m;
    }

    private static void rearrangeAnArrayAccordingToGivenIndex2(int[] arr) {
        List<Integer> arrr = Arrays.asList(10, 11, 12);
        List<Integer> indx = Arrays.asList(1, 0, 2);

        ArrayList<Integer> tempList = new ArrayList<>(Collections.nCopies(arrr.size(), -1));
        for (int i = 0; i < arrr.size(); i++) {
            tempList.set(indx.get(i), arrr.get(i));
        }
        System.out.println("tempList = " + tempList);

    }

    private static void rearrangeAnArrayAccordingToGivenIndex(int[] arr1) {
        int[] arrr = {10, 11, 12};
        int[] indx = {1, 0, 2};

        int[] temp = new int[arrr.length];
        for (int i = 0; i < arrr.length; i++) {
            int indxToStore = indx[i];
            temp[indxToStore] = arrr[i];
        }
        System.out.println("temp = " + Arrays.toString(temp));

    }

    private static void rearrangeAnArrayPutPositiveNumbersAtEvenIndexAndNegativeAtOdd(int[] arr1) {
        int arr[] = {-1, 2, -3, 4, 5, 6, -7, 8, 9};
        int n = arr.length;

        int leftPointer = -1;
        int pivot = 0; //1st assume 0 and divide/partition  negative and postive
        for (int j = 0; j < n; j++) {
            if (arr[j] < pivot) {
                leftPointer++;
                swapArr(arr, leftPointer, j);
            }
        }

        int positivePointer = leftPointer + 1, negativePointer = 0;
        while (positivePointer < n && negativePointer < positivePointer) {
            System.out.println("arr = " + Arrays.toString(arr));
            swapArr(arr, positivePointer, negativePointer);
            positivePointer++;
            negativePointer += 2;
        }
        System.out.println("arr = " + Arrays.toString(arr));
        System.out.println();
    }

    private static void rearrangeAnArray(int[] arr1) {
        int[] arr = {-1, -1, 6, 1, 9, 3, 2, -1, 4, -1};
        int n = arr.length;
        List<Integer> res = new ArrayList<>(Collections.nCopies(n, -1)); //make a arraylist with all -1's
        for (int i = 0; i < n; i++) {
            if (arr[i] != -1) {
                res.set(arr[i], arr[i]); //here use set to give its position where to set
            }
        }
        System.out.println("res = " + res);
        System.out.println();
    }

    private static void findSubArrayWithGivenSum2DP(int[] arr1) {
        List<Integer> arr
                = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> subarray
                = findSubarrayWithGivenSum(arr, 5);
        if (subarray.isEmpty()) {
            System.out.println(
                    "No subarray with given sum found");
        } else {
            System.out.print("Subarray: [ ");
            for (int i : subarray) {
                System.out.print(i + " ");
            }
            System.out.println("]");
        }
    }

    public static List<Integer>
    findSubarrayWithGivenSum(List<Integer> arr, int sum) {
        List<Integer> subArr = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        int currentSum = 0;
        for (int i = 0; i < arr.size(); i++) {
            currentSum = currentSum + arr.get(i);
            //exit condition
            if (map.containsKey(currentSum - sum)) {
                subArr = arr.subList(
                        (map.get(currentSum - sum)) + 1, i + 1);
                break;//prevent further addition and storage in map
            }

            map.put(currentSum, i);
        }

        return subArr;
    }


    private static int findSubArrayWithGivenSum(int[] arr) {
        int sum = 10;
        int n = arr.length;
        int currentSum = arr[0];//assume
        int leftPointer = 0;
        for (int i = 1; i <= n; i++) {//start with leaving 1st
            if (currentSum == sum) {
                int p = i - 1;
                System.out.println(" it found between below 2 index");
                System.out.println("leftPointer = " + leftPointer);
                System.out.println("p = " + p);
                return 1;
            }
            while (currentSum > sum && leftPointer < i - 1) {
                currentSum = currentSum - arr[leftPointer];
                leftPointer++;
            }
            if (i < n) {
                currentSum = currentSum + arr[i];
            }
            System.out.println();
        }
        System.out.println("no subarray found ");
        return 0;
    }

    private static void findGreaterThanAllTheElementsToItsRight(int[] arr) {

        int i, j;
        for (i = 0; i < arr.length; i++) {
            for (j = i + 1; j < arr.length; j++) {
                if (arr[i] <= arr[j]) {
                    break;
                }
            }
            if (j == arr.length) //if pointer j is exhausted by reaching end then that the element
                System.out.println("arr[i] = " + arr[i]);
        }
    }

    private static void findElementWhichAppears1TimeUsingMap(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            Integer frequency = map.getOrDefault(arr[i], 0);
            map.put(arr[i], frequency + 1);
        }

        for (int i = 0; i < arr.length; i++) {
            if (map.get(arr[i]) == 1) {
                System.out.println(" ElementWhichAppears1Time = " + arr[i]);
            }
        }

//        for (Map.Entry<Integer, Integer> entries : map.entrySet()) {
//            System.out.println("entries = " + entries);
//        }
    }

    private static void printDistinctElementsInAnArray4UsingSet(int[] arr) {
//        O(n)
        HashSet<Integer> intSet = new HashSet<>();

        for (int i = 0; i < arr.length; i++) {
            if (!intSet.contains(arr[i])) {
                intSet.add(arr[i]);
                System.out.println("arr[i] = " + arr[i]);
            }
        }
    }

    private static void printDistinctElementsInAnArray3UsingTreeSet(int[] arr) {
// O(nlogn)
        TreeSet<Integer> ints = new TreeSet<>();
        for (int j : arr) {
            ints.add(j);
        }
        System.out.println("ints = " + ints);
        System.out.println();
    }

    private static void printDistinctElementsInAnArray2(int[] arr) {
        int n = arr.length;
        Arrays.sort(arr); //sort the array
        for (int i = 0; i < n; i++) {
            //if you find duplicate just increment index in loop
            while (i < n - 1 && arr[i] == arr[i + 1])
                i++;
            System.out.println("arr[i] = " + arr[i]);
        }
    }

    private static void quickSortFun2(int[] arr, int low, int high) {
        //exit condition
        if (low < high) {
            int pi = partition2(arr, low, high);
            quickSortFun2(arr, low, pi - 1);
            quickSortFun2(arr, pi + 1, high);
        }
    }

    private static int partition2(int[] arr, int low, int high) {
        int pivot = arr[high];
        int leftPointer = (low - 1);
        for (int j = low; j <= high; j++) {
            if (arr[j] < pivot) {
                leftPointer++;
                swapArr(arr, leftPointer, j);
            }
            System.out.println("j = " + j);
            System.out.println("leftPointer = " + leftPointer);
            System.out.println("arr = " + Arrays.toString(arr));
            System.out.println(" ===== ");
        }
        swapArr(arr, leftPointer + 1, high);
        System.out.println("arr = " + Arrays.toString(arr));
        return (leftPointer + 1);
    }

    private static void segregateEvenAndOdd(int[] arr) {
        int n = arr.length;
        int i = -1;

        for (int j = 0; j < n; j++) {
            if (arr[j] % 2 == 0) {
                i++;
                swapArr(arr, i, j);
                System.out.println("arr = " + Arrays.toString(arr));
            }
        }
        System.out.println("arr = " + Arrays.toString(arr));


    }

    private static int quickSortFun(int[] arr) {
        return quickSortFun(arr, 0, arr.length - 1);
    }

    private static int quickSortFun(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSortFun(arr, low, pi - 1);
            quickSortFun(arr, pi + 1, high);
        }
        return partition(arr, low, high);
    }

    private static int partition(int[] arr, int low, int high) {
        // Choosing the pivot
        int pivot = arr[high];

        // Index of smaller element and indicates
        // the right position of pivot found so far
        int leftPointer = (low - 1);

        for (int j = low; j <= high; j++) {

            // If current element is smaller than the pivot
            if (arr[j] < pivot) {
                // Increment index of smaller element
                leftPointer++;
                swapArr(arr, leftPointer, j);
            }
            System.out.println("arr = " + Arrays.toString(arr));
        }
        swapArr(arr, leftPointer + 1, high);
        System.out.println("arr = " + Arrays.toString(arr));
        return (leftPointer + 1);
    }

    private static void rearrangeArrayInMaxMixForm(int[] arr) {
        //convert primitive to Integer box
        Integer[] array = Arrays.stream(arr).boxed().toArray(Integer[]::new);
        Arrays.sort(array, Collections.reverseOrder());
        System.out.println("array = " + Arrays.toString(array));
//       s        l         l
//      {1, 2, 3, 4}
//       0, 1, 2, 3
        Integer[] temp = array.clone();
        int s = 0;
        int l = arr.length - 1;
        boolean flag = false;
        for (int i = 0; i < arr.length; i++) {
            if (flag) {
                arr[i] = temp[l];
                l--;
            } else {
                arr[i] = temp[s];
                s++;
            }
            flag = !flag;
        }
        System.out.println("array = " + Arrays.toString(arr));
    }

    private static void moveAllZerosToRightEndUsingPivotElement(int[] arr) {
//                     j
//                           i
//        {1, 5, 4, 6, 0, 0, 0}
//         0  1  2  3  4  5  6   n=7
//        1!=0 ; swap a[i] a[j]; {1,5,0,4,0,6,0}; inc j, j=1 ; inc i,i=1
//        5!=0 ; swap a[i] a[j]; {1,5,0,4,0,6,0}; inc j, j=2 ; inc i,i=2
//        0==0 ; no swap a[i] a[j]; {1,5,0,4,0,6,0}; no inc j, j=2, inc i,i=3
//        4!=0 ; swap a[i] a[j]; {1,5,4,0,0,6,0}; inc j,j=3 , inc i, i=4
//        0==0 ; no swap a[i] a[j]; {1,5,4,0,0,6,0}; no inc j, j=3, inc i,i=5
//        6!=0 ; swap a[i] a[j]; {1,5,4,6,0,0,0}; inc j,j=4 , inc i, i=5
        int n = arr.length;
        int leftPointer = 0; // this will travel to all non 0 elem length
        for (int i = 0; i < n; i++) {
            if (arr[i] != 0) {
                //swap
                swapArr(arr, i, leftPointer);
                leftPointer++;
            }
            System.out.println("arr = " + Arrays.toString(arr));
        }
    }

    private static void swapArr(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static int[] moveAllZerosToRightEnd(int[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                arr[count++] = arr[i];
            }
            System.out.println(Arrays.toString(arr));
            //trace
            // c=0 i=0 arr[0]=1 = arr[0]=1 {1,5,0,4}
            // c=1 i=1 arr[1]=5 = arr[1]=5 {1,5,0,4}
            // c=2 i=2
            // c=2 i=3 arr[2]=0 = arr[3]=4 {1,5,4,0}
        }
        while (count < arr.length)
            arr[count++] = 0;

        return arr;
    }

    private static Student findSecondLargestPriorityStudentUsingPriorityQueue(Student[] studentsArr) {
        PriorityQueue<Student> students = new PriorityQueue<>((a, b) -> (b.getPriority() > a.getPriority()) ? 1 : -1);
        for (Student student : studentsArr) {
            students.offer(student);
        }

        Student peek = students.peek();
        System.out.println("peek = " + peek);
        Student poll = students.poll();
        System.out.println("poll = " + poll);

        System.out.println("students = " + students);
        Student poll2 = students.poll();
        System.out.println("poll = " + poll2);
        return poll2;
    }

    private static void findSecondLargestUsingPriorityQueue(int[] arr) {

        PriorityQueue<Integer> ints = new PriorityQueue<>((a, b) -> Integer.compare(b, a));

        for (int i = 0; i < arr.length; i++) {
            ints.add(arr[i]);
        }
        Integer peek = ints.peek();
        System.out.println("peek = " + peek);
        Integer poll = ints.poll();
        System.out.println("poll = " + poll);
        System.out.println("ints = " + ints);

    }

    private static Integer findSecondLargestUsingTreeMap(int[] arr) {
        TreeMap<Integer, Integer> treeMap = new TreeMap<>((o1, o2) -> o2.compareTo(o1));
        for (int i = 0; i < arr.length; i++) {
            treeMap.put(arr[i], treeMap.getOrDefault(arr[i], 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : treeMap.entrySet()) {
            System.out.println(entry.getKey() + " ->" + entry.getValue());
        }
        Integer i = treeMap.entrySet().stream().skip(1).map(x -> x.getKey()).findFirst().orElseThrow(() -> new NoSuchElementException("No 2nd largest ele found!"));
        return i;
    }

    private static Integer findSecondLargestUsingTreeSet(int[] arr) {
//        List<Integer> list1 = Arrays.asList(1, 2, 3);
        Integer[] array1 = Arrays.stream(arr).boxed().toArray(value -> new Integer[value]);
        List<Integer> list = Arrays.asList(array1);
        TreeSet<Integer> integers = new TreeSet<>(list);

        Integer[] array = integers.toArray(Integer[]::new);
        System.out.println("array = " + Arrays.toString(array));
        return array[1];
    }

    private static int[] bubbleSort2(int[] arr) { //O(n^2) time complexity
        int length = arr.length;
        for (int i = 0; i < length - 1; i++) {
            for (int j = 1; j < length - i - 1; j++) {
                if (arr[j - 1] > arr[j]) {
                    // swap
                    int temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr;
    }

    private static int[] bubleSort(int[] arr) {
        int length = arr.length;
        for (int i = 0; i < length - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    //swap only consecutive
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            if (swapped == false)
                break;
        }
        return arr;
    }

    private static int[] selectionSort2(int[] arr) {
//        http://liveexample.pearsoncmg.com/liang/animation/web/SelectionSort.html
        for (int i = 0; i < arr.length - 1; i++) {
            int lowestIndex = i;
            for (int j = i + 1; j < arr.length; j++) { //leave the first elem and try to loop and find the lowest in remaining and swap it to first position
                if (arr[j] < arr[lowestIndex])
                    lowestIndex = j;
            }
            //swap
            int temp = arr[lowestIndex];
            arr[lowestIndex] = arr[i];
            arr[i] = temp;
        }
        return arr;
    }

    private static int binarySearchFun(int[] arr, int key) {
        int left = 0;
        int right = arr.length - 1;

        while (left < right) { //iterate from left pointer to right end pointer
            int mid = (left + right) / 2; //get the mid element by dividing by 2
            if (arr[mid] == key)
                return mid;//if found in mid return
            if (key > arr[mid])
                left = mid + 1;//adjust left pointer if key is greater
            else
                right = mid - 1;//adjust right pointer if key is less
        }

        return -1; //default return
    }

    private static int[] deleteElementFun(int[] arr, int index) {

        int length = arr.length;
        int i = index;
        while (i < length - 1) {
            arr[i] = arr[i + 1];
            i++;
        }
        int temp[] = new int[length - 1];
        for (int j = 0; j < temp.length; j++) {
            temp[j] = arr[j];
        }
        return temp;
    }

    private static int[] insertElementFun(int[] arr, int index, int value) {

        int length = arr.length;
        int temp = arr[length - 1];
        for (int i = length - 1; i >= index; i--) {
            arr[i] = arr[i - 1];
        }
        arr[index] = value;
        int tempArr[] = new int[arr.length + 1];
        for (int i = 0; i < length; i++) {
            tempArr[i] = arr[i];
        }
        tempArr[tempArr.length - 1] = temp;
        return tempArr;
    }

    private static int[] leftRotateArrayFun2(int[] arr, int d) {

        int a = 1;
        while (a <= d) {
            int temp = arr[0];
            for (int i = 0; i < arr.length - 1; i++) {
                arr[i] = arr[i + 1];
            }
            arr[arr.length - 1] = temp;
            a++;
        }

        return arr;
    }


    private static int[] leftRotateArrayFun1(int[] arr, int d) {
        int[] temp = new int[arr.length];
        int i = 0;
        for (int j = d; j < arr.length; j++) {
            temp[i] = arr[j];//store all d to end to temp
            i++;
        }
        for (int j = 0; j < d; j++) {
            temp[i] = arr[j];
            i++;
        }
        for (int j = 0; j < arr.length; j++) {
            arr[j] = temp[j];
        }
        return arr;
    }

    private static void reverseAnArray() {
        System.out.println();
        int[] arr = {2, 3, 1};

        int[] revArrRes = reverseArrayFun(arr, 0, 2);
        System.out.println("revArrRes = " + Arrays.toString(revArrRes));
    }

    private static int[] reverseArrayFun(int[] arr, int start, int end) {
        //0,1,2
        //1,2,3
        //s   e

        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;

            start++;
            end--;
        }
        return arr;
    }


    private static void basicArrayOperations() {
        try {
            //print array
            int[] intarr1 = new int[5];
            intarr1[0] = 0;
            intarr1[1] = 1;
            intarr1[2] = 2;
            System.out.println("intarr1 = " + Arrays.toString(intarr1));

            int[] intarr2 = new int[]{0, 2, 1, 3, 5};

            //arrays to java stream
            Arrays.stream(intarr2).forEach(System.out::println);

            //arrays to list and list to array
            List<int[]> list = Arrays.asList(intarr2);
            System.out.println("list = " + list);
            int[][] array = list.toArray(new int[0][0]);
            System.out.println("array.toString() = " + Arrays.toString(array));


            //demo of Arrays.binarySearch (primitive type data)
            Arrays.sort(intarr2);
            System.out.println("sorted intarr2 = " + intarr2);
            int index = Arrays.binarySearch(intarr2, 5);
            System.out.println("index = " + index);


            Student[] studentsArray1 = {
                    new Student(1, "sam"),
                    new Student(5, "lkj"),
                    new Student(3, "tim")
            };

            //find a student object using Arrays.binarySearch ( on Objects type )
            //step 1 sort
            Arrays.sort(studentsArray1, (a, b) -> a.getId() - b.getId());
            System.out.println("studentsArray1.toString() = " + Arrays.toString(studentsArray1));
            //step 2 search
            int indexFound = Arrays.binarySearch(studentsArray1, new Student(59, ""), Comparator.comparingInt(Student::getId));
            if (indexFound >= 0)
                System.out.println("indexFound = " + indexFound);
            else
                System.out.println("searching object not found");


            //Arrays.compare
            int[] intArr1 = {1, 2, 3};
            int[] intArr2 = new int[]{1, 2, 3};
            int compare = Arrays.compare(intArr1, intArr2);
            System.out.println("compare = " + compare);

            //Arrays.copyOf(arr,newLength)
            int[] intArrr1 = {1, 2, 3};
            int[] intArrr1Copy = Arrays.copyOf(intArrr1, intArrr1.length);
            System.out.println("intArrr1Copy = " + intArrr1Copy);

            //Arrays.copyOfRange(arr,start,end)
            int intArrrr1[] = {10, 20, 15, 22, 35};
            int[] subArray = Arrays.copyOfRange(intArrrr1, 0, 1);
            System.out.println("subArray = " + Arrays.toString(subArray));

            // Get the Arrays
            int intArr_[] = {10, 20, 15, 22, 35};
            int intArr1_[] = {10, 15, 22};
            // To compare both arrays
            System.out.println("The element mismatched at index: "
                    + Arrays.mismatch(intArr_, intArr1_));

            System.out.println();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
