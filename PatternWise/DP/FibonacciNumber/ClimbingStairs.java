package PatternWise.DP.FibonacciNumber;

public class ClimbingStairs {
    public static int climbStairs(int n, int[] dp) {
        if(n == 0) {
            return 1;
        }

        if(n < 0) {
            return 0;
        }

        if(dp[n] != 0) {
            return dp[n];
        }

        return dp[n] = climbStairs(n-1, dp) + climbStairs(n-2, dp);
    }
    
    public static void main(String[] args) {
        int n = 2;
        int[] dp = new int[n+1];
        System.out.println(climbStairs(n, dp));
    }
}
