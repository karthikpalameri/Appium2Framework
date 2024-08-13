package learn.java.ds.hashing;

import java.util.ArrayList;
import java.util.LinkedList;

public class Chaining {
    public static void main(String[] args) {
        ChainingDemo chainingDemo = new ChainingDemo(5);
        chainingDemo.insert(10);
        chainingDemo.delete(10);
    }


}

class ChainingDemo {
    int capacity;
    ArrayList<LinkedList<Integer>> table;

    ChainingDemo(int capacity) {
        this.capacity = capacity;
        table = new ArrayList<>(capacity);

        for (int i = 0; i < capacity; i++) {
            table.add(new LinkedList<>());
        }
    }

    void insert(int key) {
        int i = key % capacity;
        table.get(i).add(key); //got to the index and then access the indexed LinkedList
        System.out.println("after insertion in the table = " + table);
    }

    void delete(int key) {
        int i = key % capacity;
        table.get(i).remove((Integer) key); //we do not want to remove at index , we want to remove a particular object here so Integer Object casting done here
        System.out.println("after deletion in the after deletion in the table = " + table);
    }
}
