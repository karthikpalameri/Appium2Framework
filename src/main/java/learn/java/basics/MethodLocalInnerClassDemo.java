package learn.java.basics;

public class MethodLocalInnerClassDemo {
    int a = 10;

    public void demo() {
        class InnerClassDemo_ { //class inside a method
            public void displayInstanceVar() {//has access to outer class instance variable a
                System.out.println("inner class has access to instance var a = " + a);
            }
        }
        //creating obj inside this method itself
        InnerClassDemo_ obj1 = new InnerClassDemo_();
        obj1.displayInstanceVar();
    }

    public static void main(String[] args) {
        MethodLocalInnerClassDemo obj1 = new MethodLocalInnerClassDemo();
        obj1.demo();
    }
}


