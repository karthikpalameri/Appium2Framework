package learn.java.basics.threadsdemo.morexamples;

import com.github.gumtreediff.client.Run;

public class RunnableThreadDemo implements Runnable {

    @Override
    public void run() {
        System.out.println("running task..");
        System.out.println("Thread.currentThread().getName() = " + Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        System.out.println("Going inside main method , Thread.currentThread().getName() = " + Thread.currentThread().getName());
        Thread thread = new Thread(new RunnableThreadDemo());
        thread.start();
        System.out.println("Finish Main Thread , Thread.currentThread().getName() = " + Thread.currentThread().getName());
    }
}


