package learn.java.threadsdemo;

public class ThreadsDemoUsingThreadClass extends Thread {

    public static void main(String[] args) {
        ThreadsDemoUsingThreadClass obj1 = new ThreadsDemoUsingThreadClass();
        obj1.start(); //invoke thread using start method
    }

    public void run() {
        System.out.println("Thread started running...");
        System.out.println(Thread.currentThread().getName());
    }

}
