package learn.java.ds.sorting;

import java.util.Arrays;
import java.util.Comparator;

class MyComparator implements Comparator<Point_> {
    @Override
    public int compare(Point_ p1, Point_ p2) {
        return p1.x - p2.x;
    }
}

class Point_ {
    int x, y;

    public Point_(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}

public class ComparatorSortingDemo {
    public static void main(String[] args) {
        Point_[] arr = new Point_[]{
                new Point_(10, 20),
                new Point_(3, 12),
                new Point_(5, 7),
        };
        Arrays.sort(arr, new MyComparator());//natural ordering or asc
        for (int i = 0; i < arr.length; i++) {
            System.out.println("arr[i] = " + arr[i]);
        }
    }
}
