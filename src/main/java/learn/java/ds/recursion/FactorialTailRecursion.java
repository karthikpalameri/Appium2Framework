package learn.java.ds.recursion;

public class FactorialTailRecursion {
    public static void main(String[] args) {
        int res = factFun(5, 1);
        System.out.println("res = " + res);
    }

    private static int factFun(int n, int k) {
        if (n == 0 || n == 1)
            return k;
        return factFun(n - 1, k * n);
    }
}
/*
        fun(5,1)
            fun(4,1*5=5)
                fun(3,5*4=20)
                    fun(2,20*3=60)
                        fun(1,60*2=120)
                        return 120
                    return 120
                return 120
            return 120
        return 120
 */