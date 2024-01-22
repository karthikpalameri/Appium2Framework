package learn.java.basics;

class OuterDemo {
    public class InnerDemo {
        public void display() {
            System.out.println("this is inner class");
        }
    }

    private class InnerDemo2 {
        public void display() {
            System.out.println("this is inner class2");
        }
    }

    public void display() {
        InnerDemo2 obj1 = new InnerDemo2();
        obj1.display();
    }
}

public class InnerClassDemo {
    public static void main(String[] args) {
        OuterDemo obj1 = new OuterDemo();
        obj1.display();

        OuterDemo.InnerDemo obj2 = obj1.new InnerDemo();
        obj2.display();
    }
}
