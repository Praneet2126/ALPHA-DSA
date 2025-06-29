package DynamicProgramming;

public class MinimumPartioning {
    public static int minimumDifference(int arr[]) {
        int n = arr.length;
        
        // Calculate total sum
        int sum = 0;
        for(int val : arr) {
            sum += val;
        }

        // Capacity -> set1
        int W = sum/2;

        // Tabulation Method:
        // Step 1: Create table
        int dp[][] = new int[n+1][W+1];

        // Step 2: Java init

        // Step 3: Filling
        for(int i=1; i<n+1; i++) {
            for(int j=1; j<W+1; j++) {
                if(arr[i-1] <= j) { // valid
                    int ans1 = arr[i-1] + dp[i-1][j-arr[i-1]];  // include
                    int ans2 = dp[i-1][j];  // exclude
                    dp[i][j] = Math.max(ans1, ans2);
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        int sum1 = dp[n][W];
        
        int sum2 = sum - sum1;
        return Math.abs(sum2 - sum1);
    }
    
    public static void main(String[] args) {
        int arr[] = {1,6,11,5};
        System.out.println(minimumDifference(arr));
    }
}
