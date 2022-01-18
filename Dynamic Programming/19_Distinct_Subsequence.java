class Solution {
    public int numDistinct_Recursive(String s, String t, int n, int m){
        if(m == 0){
            return 1;
        }
        if(n == 0 && m == 0){
            return 1;
        }
        if(n == 0){
            return 0;
        }
        int count = 0;
        if(s.charAt(n - 1) == t.charAt(m - 1)){
            count += numDistinct_Recursive(s, t, n - 1, m - 1) + numDistinct_Recursive(s, t, n - 1, m);
        }else{
            count += numDistinct_Recursive(s, t, n - 1, m);
        }
        return count;
    }
    
    public int numDistinct_Memo(String s, String t, int n, int m ,int[][] dp){
        if(m == 0){
            return dp[n][m] = 1;
        }
        if(n < m){
            return dp[n][m] = 0;
        }
        if(dp[n][m] != -1){
            return dp[n][m];
        }
        int count = 0;
        if(s.charAt(n - 1) == t.charAt(m - 1)){
            count += numDistinct_Memo(s, t, n - 1, m - 1, dp) + numDistinct_Memo(s, t, n - 1, m, dp);
        }else{
            count += numDistinct_Memo(s, t, n - 1, m, dp);
        }
        return dp[n][m] = count;
    }
    
    public int numDistinct_DP(String s, String t, int N, int M ,int[][] dp){
        for(int n = 0; n <= N; n++){
            for(int m = 0; m <= M; m++){
                if(m == 0){
                    dp[n][m] = 1;
                    continue;
                }
                if(n < m){
                    dp[n][m] = 0;
                    continue;
                }
                int count = 0;
                if(s.charAt(n - 1) == t.charAt(m - 1)){
                    count += dp[n - 1][m - 1] + dp[n - 1][m]; //numDistinct_Memo(s, t, n - 1, m - 1, dp) + numDistinct_Memo(s, t, n - 1, m, dp);
                }else{
                    count += dp[n - 1][m]; //numDistinct_Memo(s, t, n - 1, m, dp);
                }
                dp[n][m] = count;
            }
        }
        return dp[N][M];
    }
    
    public int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();
        int[][] dp = new int[n + 1][m + 1];
        for(int[] d : dp){
            Arrays.fill(d, -1);
        }
        
        // return numDistinct_Recursive(s, t, n, m);
        // return numDistinct_Memo(s, t, n, m, dp);
        return numDistinct_DP(s, t, n, m, dp);
    }
}
