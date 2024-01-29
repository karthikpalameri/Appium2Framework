package learn.java.ds.recursion;

public class RopeCuttingProblemRecursion {
    public static void main(String[] args) {
        int n = 23, a = 11, b = 9, c = 12;
        int res = maxPieces(n, a, b, c);
        System.out.println("res = " + res);
    }

    private static int maxPieces(int n, int a, int b, int c) {
        if (n == 0)
            return 0;
        if (n < 0)
            return -1;
        int temp1 = maxPieces(n - a, a, b, c);
        int temp2 = maxPieces(n - b, a, b, c);
        int temp3 = maxPieces(n - c, a, b, c);
        int pieces = Math.max(temp1, Math.max(temp2, temp3));

        if (pieces == -1)
            return -1;
        return pieces + 1;
    }
}
/*
                               n=23
                 n=12          n=14          n=11
            n=1   n=3  n=0  n=3 n=5 n=2   n=0 n=2 n=1
       -ve-ve-ve - - -
 */
/*
                                n=5 a=2, b=5, c=1
                                n=5
                   3             0          4
                1 -2 2       -2 -5 -1    2  -1  3
             --0 --- 0-1              0 - 1 ---     1  - 2
                      --0.                 --0        --0  0-1
                                                     --- --- --0
 */
