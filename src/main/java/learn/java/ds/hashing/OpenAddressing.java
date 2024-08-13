package learn.java.ds.hashing;

import java.util.Arrays;

public class OpenAddressing {
    public static void main(String[] args) {
        MyMainHash myMainHash = new MyMainHash(5);
        boolean search = myMainHash.search(1);
        System.out.println("search = " + search);
        System.out.println("myHash.insert(10) = " + myMainHash.insert(10));
        boolean search10 = myMainHash.search(10);
        System.out.println("search = " + search10);
        System.out.println("myHash.delete(10) = " + myMainHash.delete(10));
    }
}

class MyMainHash {
    int[] arr;
    int cap, size;

    MyMainHash(int c) {
        cap = c;
        size = 0;
        arr = new int[cap];
        for (int i = 0; i < cap; i++)
            arr[i] = -1;
        System.out.println("Arrays.toString(arr) = " + Arrays.toString(arr));
    }

    int hash(int key) {
        return key % cap;
    }

    boolean search(int key) {
        int h = hash(key);
        int i = h;
        while (arr[i] != -1) { //keep iterating until you find -1
            if (arr[i] == key)
                return true;//if found return true;
            i = (i + 1) % cap; //circularly increment just by adding %cap
            if (i == h) // if i meets back after circling back then return false
                return false;
        }
        return false; //default return false
    }

    boolean insert(int key) {
        if (size == cap) {
            System.out.println("Capacity is full , size == cap = " + (size == cap));
            return false;
        }
        int h = hash(key);
        int i = h;
        while (arr[i] != -1 && arr[i] != 2 && arr[i] != key) { //keep looping until all of these conditions are true
            i = (i + 1) % cap;
        }
        if (arr[i] == key) {
            return false;
        } else {
            arr[i] = key;
            size++;
            System.out.println("Inserted into the Map , Arrays.toString(arr) = " + Arrays.toString(arr));
            return true;
        }
    }

    boolean delete(int key) {
        int h = hash(key);
        int i = h;
        while (arr[i] != -1) {
            if (arr[i] == key) {
                arr[i] = -2;
                System.out.println("Arrays.toString(arr) = " + Arrays.toString(arr));
                return true;
            }
            i = (i + 1) % cap;
            if (i == h) {
                return false;
            }
        }
        return false;
    }
}
