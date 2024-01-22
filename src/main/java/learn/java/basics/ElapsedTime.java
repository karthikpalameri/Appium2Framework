package learn.java.basics;

public class ElapsedTime {
    public static void main(String[] args) throws InterruptedException {
        long start = System.currentTimeMillis();
        Thread.sleep(5 * 1000);//5sec
        long end = System.currentTimeMillis();
        long x = end - start;
        System.out.println("Difference in millis is = " + x);

    }
}
