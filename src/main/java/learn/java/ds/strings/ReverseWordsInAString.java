package learn.java.ds.strings;

public class ReverseWordsInAString {
    public static void main(String[] args) {
        String str = "Hello World this is test";
        reverseWordsInAString(str.toCharArray());
    }

    private static void reverseWordsInAString(char[] str) {
        int n = str.length;
        int start = 0;
        for (int end = 0; end < n; end++) {
            if (str[end] == ' ') {
                reverse(str, start, end - 1);
                start = end + 1;
            }
        }
        reverse(str, start, n - 1);
        reverse(str, 0, n - 1);
        System.out.println(String.valueOf(str));
    }

    private static void reverse(char[] str, int start, int end) {
        while (start < end) {
            swapChar(str, start, end);
            start++;
            end--;
        }
    }

    private static void swapChar(char[] str, int startIndex, int endIndex) {
        char temp = str[startIndex];
        str[startIndex] = str[endIndex];
        str[endIndex] = temp;
    }
}
