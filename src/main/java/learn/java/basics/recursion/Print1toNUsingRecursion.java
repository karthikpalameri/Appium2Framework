package learn.java.basics.recursion;

public class Print1toNUsingRecursion {
    public static void main(String[] args) {
        print1toNfun(5);
    }

    private static void print1toNfun(int n) {
        if (n == 0) return;
        print1toNfun(n - 1);
        System.out.println("n = " + n);
    }
}

/* trace
 n=5 fun(5)
        fun(4)
            fun(3)
                fun(2)
                    fun(1)
                        fun(0)
                        sout(1)
                    sout(2)
                sout(3)
            sout(4)
        sout(5)
 */
