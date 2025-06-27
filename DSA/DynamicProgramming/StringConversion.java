package DynamicProgramming;

public class StringConversion {

    // Note: Method 1
    public static int convertString(String str1, String str2, int n, int m, int dp[][]) {
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
            return dp[n][m] = convertString(str1, str2, n-1, m-1, dp);
        } else {
            int addChoice = convertString(str1, str2, n, m-1, dp) + 1;
            int deleteChoice = convertString(str1, str2, n-1, m, dp) + 1;
            return dp[n][m] = Math.min(addChoice, deleteChoice);
        }
    }

    // Note: Method 2
    public static int method2(String str1, String str2) {
        int lcs = lcs(str1, str2);

        int xDel = str1.length() - lcs;
        int yAdd = str2.length() - lcs;

        return xDel + yAdd;
    }

    public static int lcs(String str1, String str2) {
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
        String word1 = "abcdef";
        String word2 = "aceg";
        int dp[][] = new int[word1.length()+1][word2.length()+1];
        System.out.println(convertString(word1, word2, word1.length(), word2.length(), dp));

        System.out.println(method2(word1, word2));
    }
}
