package learn.java.ds.recursion;

public class GenerateSubSetRecursion {
    public static void main(String[] args) {
        String str = "ABC", curr = "";
        int i = 0;
        generateSubSet(str, curr, i);
    }

    private static void generateSubSet(String str, String curr, int i) {
        if (str.length() == i) {
            System.out.println(curr);
            return;
        }

        generateSubSet(str, curr, i + 1);
        generateSubSet(str, curr + str.charAt(i), i + 1);

    }
}
