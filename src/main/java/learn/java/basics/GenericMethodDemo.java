package learn.java.basics;

public class GenericMethodDemo {
    public static void main(String... arg) {
        Integer[] a1 = {1, 2, 3};
        Character[] c1 = {'a', 'b', 'c'};
        String[] s1 = {"This", "test"};
        genericPrintArray(a1);
        genericPrintArray(c1);
        genericPrintArray(s1);
    }

    private static <T> void genericPrintArray(T[] a1) {
        for (T ele : a1) {
            System.out.println(ele);
        }
    }
}
