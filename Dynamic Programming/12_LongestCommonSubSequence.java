class Solution {
    public int longestCommonSubsequence_Recursive(String s1, String s2, int n, int m) {
        if(n == 0 || m == 0){
            return 0;
        }
        int count = 0;
        if(s1.charAt(n - 1) == s2.charAt(m - 1)){
            count += 1 + longestCommonSubsequence_Recursive(s1, s2, n - 1, m - 1);
        }else{
            count += Math.max(longestCommonSubsequence_Recursive(s1, s2, n, m - 1), longestCommonSubsequence_Recursive(s1, s2, n - 1, m));
        }
        return count;
    }
    
    public int longestCommonSubsequence_Memo(String s1, String s2, int n, int m, int[][] dp) {
        if(n == 0 || m == 0){
            return dp[n][m] = 0;
        }
        if(dp[n][m] != 0){
            return dp[n][m];
        }
        int count = 0;
        if(s1.charAt(n - 1) == s2.charAt(m - 1)){
            count += 1 + longestCommonSubsequence_Memo(s1, s2, n - 1, m - 1, dp);
        }else{
            count += Math.max(longestCommonSubsequence_Memo(s1, s2, n, m - 1, dp), longestCommonSubsequence_Memo(s1, s2, n - 1, m, dp));
        }
        return dp[n][m] = count;
    }
    
    public int longestCommonSubsequence_DP(String s1, String s2, int N, int M, int[][] dp) {
        for(int n = 0; n <= N; n++){
            for(int m = 0; m <= M; m++){
                if(n == 0 || m == 0){
                    dp[n][m] = 0;
                    continue;
                }
                int count = 0;
                if(s1.charAt(n - 1) == s2.charAt(m - 1)){
                    count += 1 + dp[n - 1][m - 1]; //longestCommonSubsequence_Memo(s1, s2, n - 1, m - 1, dp);
                }else{
                    // count += Math.max(longestCommonSubsequence_Memo(s1, s2, n, m - 1, dp), longestCommonSubsequence_Memo(s1, s2, n - 1, m, dp));
                    count += Math.max(dp[n][m - 1], dp[n - 1][m]);
                }
                dp[n][m] = count;
            }
        }
        return dp[N][M];
    }
    
    public int longestCommonSubsequence(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int[][] dp = new int[n + 1][m + 1];
        
        // return longestCommonSubsequence_Recursive(s1, s2, n, m);
        // return longestCommonSubsequence_Memo(s1, s2, n, m, dp);
        return longestCommonSubsequence_DP(s1, s2, n, m, dp);
    }
}
