package DynamicProgramming;

public class TargetSumSubset {

    // Memoized
    public static boolean isTrue(int nums[], int sum, int n, Boolean dp[][]) {
        if(n == 0) {
            if(sum == 0) {
                return true;
            } else {
                return false;
            }
        }

        if(dp[n][sum] != null) {
            return dp[n][sum];
        }

        if(nums[n-1] <= sum) {
            dp[n][sum] = isTrue(nums, sum-nums[n-1], n-1, dp) || isTrue(nums, sum, n-1, dp);
            return dp[n][sum];
        } else {
            return dp[n][sum] = isTrue(nums, sum, n-1, dp);
        }
    }

    public static boolean targetSumTab(int nums[], int sum) {
        int n = nums.length;
        boolean dp[][] = new boolean[n+1][sum+1];

        for(int i=0; i<dp.length; i++) {
            dp[i][0] = true;
        }

        for(int i=1; i<n+1; i++) {
            for(int j=1; j<sum+1; j++) {
                int v = nums[i-1];
                if(v <= j) {
                    dp[i][j] = dp[i-1][j-v] || dp[i-1][j];  // include || exclude
                } else {
                    dp[i][j] = dp[i-1][j];   // exclude
                }
            }
        }

        return dp[n][sum];
    }

    public static boolean targetSumMam(int nums[], int sum) {
        int n = nums.length;
        boolean dp[][] = new boolean[n+1][sum+1];

        for(int i=0; i<n+1; i++) {
            dp[i][0] = true;
        }

        for(int i=1; i<n+1; i++) {
            for(int j=1; j<sum+1; j++) {
                int v = nums[i-1];
                // include
                if(v <= j && dp[i-1][j-v]) {
                    dp[i][j] = true;
                }
                //exclude 
                else if(dp[i-1][j] == true){
                    dp[i][j] = true;                         
                }
            }
        }

        return dp[n][sum];
    }

    public static void main(String[] args) {
        int nums[] = {4,2,7,1,3};
        int sum = 20;
        Boolean dp[][] = new Boolean[nums.length+1][sum+1];

        System.out.println(isTrue(nums, sum, nums.length, dp));
        System.out.println(targetSumTab(nums, sum));
    }
}
