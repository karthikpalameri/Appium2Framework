package learn.java.ds.searching;

public class FloorSquareRootSearch {
    public static void main(String[] args) {
        int x = 10;
        sqRootFloor(x);
    }

    private static int sqRootFloor(int x) {
//        1,2,3,4,5,6,7,8,9,10
//        l         h
//                m
        int low = 1, high = x, ans = -1;
        while (low < high) {
            int mid = (low + high) / 2;
            int midSquare = mid * mid;
            if (midSquare == x)
                return mid;
            else if (midSquare > x) {
//                readjust high
                high = mid - 1;
            } else {
//                readjust low
                low = mid + 1;
                ans = mid;
            }
        }
        return ans;
    }
}
