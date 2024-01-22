package learn.java.basics;

abstract class Demo1 {
    public abstract void display();
}

public class AnonymousInnerClassDemo {
    public static void main(String[] args) {

        Demo1 obj = new Demo1() {
            @Override
            public void display() {
                System.out.println("this is anonymouseInnerClass  ");
            }
        };
        obj.display();

    }
}


