package learn.java.basics.threadsdemo.morexamples;

public class ExtendThreadClassDemo extends Thread {

    @Override
    public void run() {
        super.run();
        System.out.println("Thread Execution start..");
        System.out.println("Thread.currentThread().getName() = " + Thread.currentThread().getName());
        System.out.println("Thread Execution end..");
    }

    public static void main(String[] args) {
        System.out.println("Going inside main method , Thread.currentThread().getName() = " + Thread.currentThread().getName());
        ExtendThreadClassDemo extendThreadClassDemo = new ExtendThreadClassDemo();
        extendThreadClassDemo.start();
        System.out.println("End of main method , Thread.currentThread().getName() = " + Thread.currentThread().getName());
    }
}
