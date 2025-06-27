package DynamicProgramming;

public class EditDistance {

    // Note: Recursion + Memoization
    public static int editDistance(String str1, String str2, int n, int m, int dp[][]) {
        if(n == 0) {
            return m;
        }

        if(m == 0) {
            return n;
        }

        if(dp[n][m] != 0) {
            return dp[n][m];
        }
        
        if(str1.charAt(n-1) == str2.charAt(m-1)) {
            return dp[n][m] = editDistance(str1, str2, n-1, m-1, dp);
        } else {
            int addChoice = editDistance(str1, str2, n, m-1, dp) + 1;
            int deleteChoice = editDistance(str1, str2, n-1, m, dp) + 1;
            int replaceChoice = editDistance(str1, str2, n-1, m-1, dp) + 1;
            return dp[n][m] = Math.min(addChoice, Math.min(deleteChoice, replaceChoice));
        }
    }

    // Note: Tabulation
    public static int editDistanceTab(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();
        int dp[][] = new int[n+1][m+1];

        // Init
        for(int i=0; i<n+1; i++) {
            dp[i][0] = i;
        }
       
        for(int j=0; j<m+1; j++) {
            dp[0][j] = j;
        }

        // logic
        for(int i=1; i<n+1; i++) {
            for(int j=1; j<m+1; j++) {
                if(str1.charAt(i-1) == str2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    int add = dp[i][j-1] + 1;
                    int delete = dp[i-1][j] + 1;
                    int replace = dp[i-1][j-1] + 1;
                    dp[i][j] = Math.min(add, Math.min(delete, replace));
                }
            }
        }
        
        return dp[n][m]; 
    }
    
    public static void main(String[] args) {
        String str1 = "intention";
        String str2 = "execution";
        int n = str1.length();
        int m = str2.length();
        int dp[][] = new int[n+1][m+1];

        System.out.println(editDistance(str1, str2, n, m, dp));
        System.out.println(editDistanceTab(str1, str2));
    }
}
