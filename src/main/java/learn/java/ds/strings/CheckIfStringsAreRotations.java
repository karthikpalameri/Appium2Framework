package learn.java.ds.strings;

public class CheckIfStringsAreRotations {
    public static void main(String[] args) {
        String str1 = "ABCD";
        String str2 = "CDAB";

        //concatenate to itself ABCDABCD and try to find
        //                        CDAB

        boolean b = areRotations(str1, str2);
        System.out.println("isPresent = " + b);

    }

    private static boolean areRotations(String str1, String str2) {

        if (str2.length() != str1.length()) return false;

        String concatinatedString = str1 + str1;
        if (concatinatedString.indexOf(str2) > 0) {
            return true;
        }
        return false;
    }
}
