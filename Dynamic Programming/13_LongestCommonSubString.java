class Solution{
    int longestCommonSubstr_Recursive(String S1, String S2, int n, int m, int c){
        if(n == 0 || m == 0){
            return c;
        }
        int count = c;
        if(S1.charAt(n - 1) == S2.charAt(m - 1)){
            count = longestCommonSubstr_Recursive(S1, S2, n - 1, m - 1, c + 1);
        }
        else{
            count = Math.max(count, Math.max(longestCommonSubstr_Recursive(S1, S2, n - 1, m, 0), longestCommonSubstr_Recursive(S1, S2, n, m - 1, 0)));
        }
        return count;
    }
    
    int longestCommonSubstr_DP(String s1, String s2, int N, int M, int[][] dp){
        int maxLength = 0;
        for(int n = 0; n <= N; n++){
            for(int m = 0; m <= M; m++){
                if(n == 0 || m == 0){
                    dp[n][m] = 0;
                    continue;
                }
                if(s1.charAt(n - 1) == s2.charAt(m - 1)){
                    dp[n][m] = 1 + dp[n - 1][m - 1];
                    maxLength = Math.max(maxLength, dp[n][m]);
                }else{
                    dp[n][m] = 0;
                }
            }
        }
        return maxLength;
    }
    
    int longestCommonSubstr(String S1, String S2, int n, int m){
        // code here
        int[][] dp = new int[n + 1][m + 1];
        for(int[] d : dp){
            Arrays.fill(d, -1);
        }
        // return longestCommonSubstr_Recursive(S1, S2, n, m, 0);
        return longestCommonSubstr_DP(S1, S2, n, m, dp);
    }
}
