package DynamicProgramming;

public class LongestCommonSubsequence {

    // Note: Recursion
    public static int lcs(String str1, String str2, int n, int m) {
        if(n == 0 || m == 0) {
            return 0;
        }

        if(str1.charAt(n-1) == str2.charAt(m-1)) {  // same
            return lcs(str1, str2, n-1, m-1) + 1;
        } else {  // diff
            int ans1 = lcs(str1, str2, n-1, m);
            int ans2 = lcs(str1, str2, n, m-1);
            return Math.max(ans1, ans2);
        }
    }

    // Note: Memoization
    public static int lcsMemo(String str1, String str2, int n, int m, int dp[][]) {
        if(n == 0 || m == 0) {
            return 0;
        }

        if(dp[n][m] != 0) {
            return dp[n][m];
        }

        if(str1.charAt(n-1) == str2.charAt(m-1)) {  // same
            return dp[n][m] = lcsMemo(str1, str2, n-1, m-1, dp) + 1;
        } else {  // diff
            int ans1 = lcsMemo(str1, str2, n-1, m, dp);
            int ans2 = lcsMemo(str1, str2, n, m-1, dp);
            return dp[n][m] = Math.max(ans1, ans2);
        }
    }

    // Note: Tabulation
    public static int lcsTab(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();
        int dp[][] = new int[n+1][m+1];  // Java initializes with 0 -> BC

        for(int i=1; i<n+1; i++) {
            for(int j=1; j<m+1; j++) {
                if(str1.charAt(i-1) == str2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        return dp[n][m]; 
    }

    public static void main(String[] args) {
        String str1 = "abcde";
        String str2 = "ace";

        int n = str1.length();
        int m = str2.length();
        int dp[][] = new int[n+1][m+1];
        System.out.println(lcsMemo(str1, str2, n, m, dp));

        System.out.println(lcsTab(str1, str2));
    }
}
