package Backtracking;

public class Subsets {
    public static void findSubsets(String str, int i, String ans) {
        //base
        if(i == str.length()) {
            if(ans.length() == 0) {
                System.out.print("null");
            } else {
                System.out.println(ans);
            }
            return;
        }

        //backtracking
        //yes choice
        findSubsets(str, i+1, ans+str.charAt(i));

        //No choice
        findSubsets(str, i+1, ans);
    }

    public static void main(String[] args) {
        findSubsets("abc", 0, "");
    }
}
