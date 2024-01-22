package learn.java.basics.comparatordemo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class testComparatorDemo {
    public static void main(String[] args) {
        List<Emp> l1 = new ArrayList<>();
        l1.add(new Emp("kk", 111));
        l1.add(new Emp("xyzo", 21));

//        Collections.sort(l1, new ComparatorDemo_());

        Collections.sort(l1, (o1, o2) -> o2.age - o1.age);
        for (Emp e : l1)
            System.out.println(e);

    }
}
