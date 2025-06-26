package DynamicProgramming;

public class RodCutting {
    public static int maxProfit(int length[], int price[], int rodLength, int n, int dp[][]) {
        if(n == 0 || rodLength == 0) {
            return 0;
        }

        if(dp[n][rodLength] != -1) {
            return dp[n][rodLength];
        }

        if(length[n-1] <= rodLength) {
            int incProfit = price[n-1] + maxProfit(length, price, rodLength-length[n-1], n, dp);
            int excProfit = maxProfit(length, price, rodLength, n-1, dp);
            return dp[n][rodLength] = Math.max(incProfit, excProfit);
        } else {
            return dp[n][rodLength] = maxProfit(length, price, rodLength, n-1, dp);
        }
    }

    public static int maxProfitTab(int length[], int price[], int rodLength) {
        int n = price.length;
        int dp[][] = new int[n+1][rodLength+1];

        for(int i=1; i<n+1; i++) {
            for(int j=1; j<rodLength+1; j++) {
                if(length[i-1] <= j) {
                    dp[i][j] = Math.max(price[i-1] + dp[i][j-length[i-1]], dp[i-1][j]);
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        return dp[n][rodLength];
    }
    
    public static void main(String[] args) {
        int length[] = {1,2,3,4,5,6,7,8};
        int price[] = {1,5,8,9,10,17,17,20};
        int rodLength = 8;

        int dp[][] = new int[price.length+1][rodLength+1];
        for(int i=0; i<dp.length; i++) {
            for(int j=0; j<dp[0].length; j++) {
                dp[i][j] = -1;
            }
        }

        System.out.println(maxProfit(length, price, rodLength, price.length, dp));
        System.out.println(maxProfitTab(length, price, rodLength));
    }
}
