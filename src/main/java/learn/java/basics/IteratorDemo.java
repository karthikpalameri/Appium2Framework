package learn.java.basics;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IteratorDemo {
    public static void main(String[] args) {
        List<Integer> al1 = new ArrayList<>();
        al1.add(10);
        al1.add(20);
        Iterator<Integer> it = al1.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }

        testAddMethod();
        System.out.println();
        System.out.println();

    }

    private static void testAddMethod() {
        try {
            System.out.println();
            System.out.println();
           System.out.println("IteratorDemo.testAddMethod()");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
