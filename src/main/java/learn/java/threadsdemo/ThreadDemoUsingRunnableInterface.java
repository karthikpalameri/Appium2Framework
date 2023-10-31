package learn.java.threadsdemo;

public class ThreadDemoUsingRunnableInterface implements Runnable {

    @Override
    public void run() {
        System.out.println("Thread is running...");
    }

    public static void main(String[] args) {
        ThreadDemoUsingRunnableInterface ob1 = new ThreadDemoUsingRunnableInterface();
        Thread t1 = new Thread(ob1, "My Thread");
        t1.start();
        System.out.println("t1.getName() = " + t1.getName());
    }
}
