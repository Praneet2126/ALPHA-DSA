package DynamicProgramming;

import java.util.Arrays;

public class CatalanNumber {

    // Note: Recursion
    public static int catalan(int n) {
        if(n == 0 || n == 1) {
            return 1;  
        } 

        int ans = 0;
        for(int i=0; i<n; i++) {
            ans += catalan(i) * catalan(n-i-1);
        }
        return ans;
    }

    // Note: Memoization
    public static long catalanMemo(int n, long dp[]) {
        if(n == 0 || n == 1) {
            return 1;  
        } 

        if(dp[n] != -1) {
            return dp[n];
        }

        long ans = 0;
        for(int i=0; i<n; i++) {
            ans += catalanMemo(i,dp) * catalanMemo(n-i-1,dp);
        }
        dp[n] = ans;
        return ans;
    }

    // Note: Tabulation
    public static int catalanTab(int n) {
        int dp[] = new int[n+1];
        
        // Init
        dp[0] = dp[1] = 1;

        // Filling
        for(int i=2; i<n+1; i++) {
            for(int j=0; j<i; j++) {
                dp[i] += dp[j] * dp[i-j-1];
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        int n = 10;
        long dp[] = new long[n+1];
        Arrays.fill(dp,-1);
        System.out.println(catalanMemo(n, dp));

        System.out.println(catalanTab(n));
    }
}
