class Solution {
    public int tribonacci(int n) {
        int[] dp = new int[n + 1];
        // return tribonacci_recursive(n);
        // return tribonacci_Memo(n, dp);
        return tribonacci_DP(n, dp);
    }
    
    public int tribonacci_recursive(int n){
        if(n == 0){
            return 0;
        }
        if(n == 1 || n == 2){
            return 1;
        }
        int trib = tribonacci_recursive(n - 1) + tribonacci_recursive(n - 2) + tribonacci_recursive(n - 3);
        return trib;
    }
    
    public int tribonacci_Memo(int n, int[] dp){
        if(n == 0){
            return dp[n] = 0;
        }
        if(n == 1 || n == 2){
            return dp[n] = 1;
        }
        if(dp[n] != 0){
            return dp[n];
        }
        int trib = 0;
        if(n - 1 >= 0){
            trib += tribonacci_Memo(n - 1, dp);
        }
        if(n - 2 >= 0){
            trib += tribonacci_Memo(n - 2, dp);
        }
        if(n - 3 >= 0){
            trib += tribonacci_Memo(n - 3, dp);
        }
        return dp[n] = trib;
    }
    
    public int tribonacci_DP(int N, int[] dp){
        for(int n = 0; n <= N; n++){
            if(n == 0){
                dp[n] = 0;
                continue;
            }
            if(n == 1 || n == 2){
                dp[n] = 1;
                continue;
            }
            
            int trib = 0;
            if(n - 1 >= 0){
                trib += dp[n - 1]; //tribonacci_Memo(n - 1, dp);
            }
            if(n - 2 >= 0){
                trib += dp[n - 2]; //tribonacci_Memo(n - 2, dp);
            }
            if(n - 3 >= 0){
                trib += dp[n - 3]; //tribonacci_Memo(n - 3, dp);
            }
            dp[n] = trib;
        }
        return dp[N];
    }
}
