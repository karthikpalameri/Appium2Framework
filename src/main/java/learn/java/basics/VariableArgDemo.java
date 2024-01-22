package learn.java.basics;

public class VariableArgDemo {
    public static void main(String... args) {
        String str = "test string";
        String str2 = "test string2";
        display(str, str2);
    }

    public static void display(String... args) {
        System.out.println("display invoked");
        for (String s : args) {
            System.out.println("s = " + s);
        }

    }
}
