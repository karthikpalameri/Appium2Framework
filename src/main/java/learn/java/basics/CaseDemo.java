package learn.java.basics;

public class CaseDemo {
    static final double pi;

    static {
        pi = 3.142;
    }

    public static void main(String[] args) {

        char c = 'B';
        switch (c) {
            case 'A':
                System.out.println("grade A ");
                break;

            case 'B':
                System.out.println("grade B ");

            case 'C':
                System.out.println("grade C ");

            case 'D':
                System.out.println("grade D ");
                break;

            default:
                System.out.println("Default");
        }
    }
}
