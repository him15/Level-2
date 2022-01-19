class Solution {
    public int minDistance_Recursive(String word1, String word2, int n, int m) {
        if(n == 0 || m == 0){
            return (n != 0 ? n : m);
        }
        int insert = minDistance_Recursive(word1, word2, n, m - 1);
        int delete = minDistance_Recursive(word1, word2, n - 1, m);
        int replace = minDistance_Recursive(word1, word2, n - 1, m - 1);
        
        int count = 0;
        if(word1.charAt(n - 1) == word2.charAt(m - 1)){
            count += replace;
        }else{
            count += Math.min(Math.min(insert, delete), replace) + 1;
        }
        return count;
    }
    
    public int minDistance_Memo(String word1, String word2, int n, int m, int[][] dp) {
        if(n == 0 || m == 0){
            return dp[n][m] = (n != 0 ? n : m);
        }
        if(dp[n][m] != -1){
            return dp[n][m];
        }
        int insert = minDistance_Memo(word1, word2, n, m - 1, dp);
        int delete = minDistance_Memo(word1, word2, n - 1, m, dp);
        int replace = minDistance_Memo(word1, word2, n - 1, m - 1, dp);
        
        int count = 0;
        if(word1.charAt(n - 1) == word2.charAt(m - 1)){
            count += replace;
        }else{
            count += Math.min(Math.min(insert, delete), replace) + 1;
        }
        return dp[n][m] = count;
    }
    
    public int minDistance_DP(String word1, String word2, int N, int M, int[][] dp) {
        for(int n = 0; n <= N; n++){
            for(int m = 0; m <= M; m++){
                if(n == 0 || m == 0){
                    dp[n][m] = (n != 0 ? n : m);
                    continue;
                }
                
                int insert = dp[n][m - 1]; //minDistance_Memo(word1, word2, n, m - 1, dp);
                int delete = dp[n - 1][m]; //minDistance_Memo(word1, word2, n - 1, m, dp);
                int replace = dp[n - 1][m - 1]; //minDistance_Memo(word1, word2, n - 1, m - 1, dp);

                int count = 0;
                if(word1.charAt(n - 1) == word2.charAt(m - 1)){
                    count += replace;
                }else{
                    count += Math.min(Math.min(insert, delete), replace) + 1;
                }
                dp[n][m] = count;
            }
        }
        return dp[N][M];
    }
    
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int[][] dp = new int[n + 1][m + 1];
        for(int[] d : dp)   Arrays.fill(d, -1);
        
        // return minDistance_Recursive(word1, word2, n, m);
        // return minDistance_Memo(word1, word2, n, m, dp);
        return minDistance_DP(word1, word2, n, m, dp);
    }
}
