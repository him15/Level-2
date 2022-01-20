class Solution{
    int mod = (int) 1e9 + 7;
    
    long countPS_recursive(String str, int i, int j){
        if(i >= j){
            return (i == j) ? 1 : 0;
        }
        long x = countPS_recursive(str, i, j - 1);
        long y = countPS_recursive(str, i + 1, j);
        long z = countPS_recursive(str, i + 1, j - 1);
        
        long count = 0;
        if(str.charAt(i) == str.charAt(j)){
            count = (x + y + 1) % mod;
        }else{
            count = (x + y - z + mod) % mod;
        }
        return count;
    }
    
    long countPS_Memo(String str, int i, int j, long[][] dp){
        if(i >= j){
            return dp[i][j] = (i == j) ? 1 : 0;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        long x = countPS_Memo(str, i, j - 1, dp);
        long y = countPS_Memo(str, i + 1, j, dp);
        long z = countPS_Memo(str, i + 1, j - 1, dp);
        
        long count = 0;
        if(str.charAt(i) == str.charAt(j)){
            count = (x + y + 1) % mod;
        }else{
            count = (x + y - z + mod) % mod;
        }
        return dp[i][j] = count;
    }
    
    long countPS_DP(String str, int I, int J, long[][] dp){
        int n = str.length();
        for(int gap = 0; gap < n; gap++){
            for(int i = 0, j = gap; j < n; i++, j++){
                if(i >= j){
                    dp[i][j] = (i == j) ? 1 : 0;
                    continue;
                }
                
                long x = dp[i][j - 1]; //countPS_Memo(str, i, j - 1, dp);
                long y = dp[i + 1][j]; //countPS_Memo(str, i + 1, j, dp);
                long z = dp[i + 1][j - 1]; //countPS_Memo(str, i + 1, j - 1, dp);
                
                long count = 0;
                if(str.charAt(i) == str.charAt(j)){
                    count = (x + y + 1) % mod;
                }else{
                    count = (x + y - z + mod) % mod;
                }
                dp[i][j] = count;
            }
        }
        return dp[I][J];
    }
    
    long countPS(String str){
        // Your code here
        int n = str.length();
        long[][] dp = new long[n][n];
        // for(long[] d : dp)  Arrays.fill(d, -1);  // mandatory for memo
        
        // return countPS_recursive(str, 0, n - 1);
        // return countPS_Memo(str, 0, n - 1, dp);
        return countPS_DP(str, 0, n - 1, dp);
    }
}
