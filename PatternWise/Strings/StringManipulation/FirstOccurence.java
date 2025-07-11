package PatternWise.Strings.StringManipulation;

public class FirstOccurence {

    // This is one by one string check.
    public static int strStr(String haystack, String needle) {
        int n = haystack.length();
        int m = needle.length();

        for(int i=0; i<n; i++) {
            if(haystack.substring(i, i+m).equals(needle)) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        String haystack = "leetcode";
        String needle = "code";

        System.out.println(strStr(haystack, needle));
    }
}
