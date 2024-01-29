package learn.java.ds.recursion;

public class SumOfNaturalNumbersRecursion {
    public static void main(String[] args) {
        int res = sumOfNaturalNum(5);
        System.out.println("sumOfNaturalNum = " + res);

        int res2 = sumOfNaturalNumUsingTailRecursion(5, 0);
        System.out.println("sumOfNaturalNumUsingTailRecrsionOptimized = " + res2);

    }

    private static int sumOfNaturalNumUsingTailRecursion(int n, int accumulator) {
        if (n == 0) return accumulator;
        return sumOfNaturalNumUsingTailRecursion(n - 1, accumulator + n);

    }
    /*
            fun(5)
                fun(4,0+5=5)
                    fun(3,5+4=9)
                        fun(2,9+3=12)
                            fun(1,12+2=14)
                                fun(0,14+1=15)
                                return 15
                            return 15
                        return 15
                    return 15
                return 15
            return 15
     */

    private static int sumOfNaturalNum(int n) {
        if (n == 0)
            return 0;
        return n + sumOfNaturalNum(n - 1);
    }
}
