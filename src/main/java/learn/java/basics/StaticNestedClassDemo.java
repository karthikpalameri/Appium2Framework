package learn.java.basics;

public class StaticNestedClassDemo {
    int a = 10;

    public static class NestedStaticClass {
        public void displayDemo() { //cany access class instance var a cuz its non stat
            System.out.println("Static Inner Class demo");
        }
    }

    public static void main(String[] args) {

        StaticNestedClassDemo.NestedStaticClass obj = new StaticNestedClassDemo.NestedStaticClass();
        obj.displayDemo();
    }
}
