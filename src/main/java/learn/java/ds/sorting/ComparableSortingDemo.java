package learn.java.ds.sorting;

import java.util.Arrays;

class Point implements Comparable<Point> {
    int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Point point) {
        return this.x - point.x;
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}

public class ComparableSortingDemo {
    public static void main(String[] args) {
        Point[] arr = new Point[]{
                new Point(10, 20),
                new Point(3, 12),
                new Point(5, 7),
        };
        Arrays.sort(arr);//natural ordering or asc
//        Arrays.sort(arr, Collections.reverseOrder());
        for (int i = 0; i < arr.length; i++) {
            System.out.println("arr[i] = " + arr[i]);
        }
    }
}
