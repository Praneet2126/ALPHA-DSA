package DynamicProgramming;

public class LongestCommonSubstring {
    public static int lcSubstr(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();

        // Java initialization
        int dp[][] = new int[n+1][m+1];

        int max = 0;

        for(int i=1; i<n+1; i++) {
            for(int j=1; j<m+1; j++) {
                if(str1.charAt(i-1) == str2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                    max = Math.max(max, dp[i][j]);
                } else {
                    dp[i][j] = 0;
                }
            }
        }

        return max;
    }
    
    public static void main(String[] args) {
        String str1 = "ABCDGH";
        String str2 = "ABCDHR";

        System.out.println(lcSubstr(str1, str2));
    }
}
