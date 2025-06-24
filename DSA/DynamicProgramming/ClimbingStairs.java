package DynamicProgramming;

public class ClimbingStairs {

    // Note: Recursive Approach - O(2^n)
    public static int ways(int n) {
        if(n == 0) return 1;
        if(n < 0) return 0;

        return ways(n-1) + ways(n-2);
    }
    
    // Note: Memoization - O(n)
    public static int waysMemo(int n, int dp[]) {
        if(n == 0) return 1;
        if(n < 0) return 0;

        if(dp[n] != 0) {
            return dp[n];
        }

        dp[n] = waysMemo(n-1,dp) + waysMemo(n-2,dp); 
        return dp[n];
    }

    // Note: Variation 2 - O(3^n)
    public static int ways3(int n) {
        if(n == 0) return 1;
        if(n < 0) return 0;

        return ways3(n-1) + ways3(n-2) + ways3(n-3);   // Needs Memoization (easy)
    }

    // Note: Tabulation - O(n)
    public static int waysTab(int n) {
        int dp[] = new int[n+1];
        dp[0] = 1;
        
        for(int i=1; i<dp.length; i++) {
            if(i == 1) {
                dp[i] = dp[i-1] + 0;
            } else {
                dp[i] = dp[i-1] + dp[i-2];
            }
        }

        return dp[n];
    }
    
    public static void main(String[] args) {
        int n = 5;
        int dp[] = new int[n+1];
        System.out.println("Memo ans = "+waysMemo(n,dp));
        System.out.println("Tab ans = "+waysTab(n));
    }
}
