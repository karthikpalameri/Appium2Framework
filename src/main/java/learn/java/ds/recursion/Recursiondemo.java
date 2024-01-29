package learn.java.ds.recursion;

public class Recursiondemo {
    public static void main(String[] args) {
        int n = 5;
//        int binRes =
        getBinary(n);
//        System.out.println("binRes = " + binRes);
    }

    private static void getBinary(int n) {
        //term condition
        if (n == 0)
            return;
        getBinary(n / 2);//gB(5) p(1) done ->gB(2) p(0) done->gB(1) p(1) done-> gB(0) return
        n = n % 2;
        System.out.print(n);

    }
}
