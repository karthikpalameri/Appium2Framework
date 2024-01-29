package learn.java.ds.recursion;

public class FactorialRecursion {
    public static void main(String[] args) {
        int res = factFun(3);
        System.out.println("res = " + res);
    }

    private static int factFun(int n) {
        if (n == 0 || n == 1)
            return 1;
        return n * factFun(n - 1);
    }
}

/*      fun(5)
            fun(4)
                fun(3)
                    fun(2)
                        fun(1)
                        return 1
                    return 2*1=3
                return 3*3=6
            return 4*6=24
        return 5*24= 120
 */