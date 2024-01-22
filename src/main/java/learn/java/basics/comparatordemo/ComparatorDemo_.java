package learn.java.basics.comparatordemo;

import java.util.Comparator;


public class ComparatorDemo_ implements Comparator<Emp> {
    @Override
    public int compare(Emp o1, Emp o2) {
        if (o1.age == o2.age) return 0;
        else if (o1.age > o2.age) return 1;
        else return -1;
    }
}
