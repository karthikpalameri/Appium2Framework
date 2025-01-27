package learn.java.ds.strings;

public class ImprovedNaivePatternSearching {
    public static void main(String[] args) {
        String txt = "ABCEABEFABCD";
        String pat = "ABCD";
        patternSearch(txt.toCharArray(), pat.toCharArray());
    }

    private static void patternSearch(char[] txt, char[] pat) {
        int n = txt.length;
        int m = pat.length;

        for (int i = 0; i <= n - m; ) {
            int j;
            for (j = 0; j < m; j++) {
                if (pat[j] != txt[i + j]) {
                    break;
                }
            }
            System.out.println("traversed j till where char not match = " + j);

            if (j == m) {
                System.out.println("Pattern found at index " + i);
            }

            if (j == 0) {
                i++;
            } else {
                i = i + j;
            }

            System.out.println();
            System.out.println("txt[i] = " + txt[i]);
        }

    }

}
