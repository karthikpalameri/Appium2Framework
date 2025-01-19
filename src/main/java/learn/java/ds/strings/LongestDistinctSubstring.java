package learn.java.ds.strings;

public class LongestDistinctSubstring {
    private static final int CHAR = 256;

    public static void main(String[] args) {
        String str = "ababcdeab";
        findLongestDistinctSubstring(str);
    }

    private static void findLongestDistinctSubstring(String str) {
        int n = str.length();
        int res = 0;
        for (int i = 0; i < n; i++) {
            System.out.println("outerloop...");
            boolean[] visited = new boolean[CHAR];
            for (int j = i; j < n; j++) {
                System.out.println("innnerloop...");
                System.out.println("i = " + i);
                System.out.println("j = " + j);
                System.out.println("str.charAt(j)->" + str.charAt(j));
                if (visited[str.charAt(j)] == true)
                    break;
                else {
                    System.out.println();
                    System.out.println("j-i+1=" + (j - i + 1));
                    res = Math.max(res, (j - i + 1));
                    visited[str.charAt(j)] = true;
                }
            }
            System.out.println("---");
        }
        System.out.println("res = " + res);
    }
}
