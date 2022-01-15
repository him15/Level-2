class Solution {
    public int climbStairs(int n) {
        int [] dp = new int[n + 1];
        // return climbStairs_recursive(n);
        // return climbStairs_Memo(n, dp);
        return climbStairs_DP(n, dp);
    }
    
    public int climbStairs_recursive(int n){
        if(n == 0){
            return 1;
        }
        int count = 0;
        if(n - 1 >= 0){
            count += climbStairs_recursive(n - 1);
        }
        if(n - 2 >= 0){
            count += climbStairs_recursive(n - 2);
        }
        return count;
    }
    
    public int climbStairs_Memo(int n, int[] dp){
        if(n == 0){
            return dp[n] = 1;
        }
        if(dp[n] != 0){
            return dp[n];
        }
        
        int count = 0;
        if(n - 1 >= 0){
            count += climbStairs_Memo(n - 1, dp);
        }
        if(n - 2 >= 0){
            count += climbStairs_Memo(n - 2, dp);
        }
        return dp[n] = count;
    }
    
    public int climbStairs_DP(int N, int[] dp){
        for(int n = 0; n <= N; n++){
            if(n == 0){
                dp[n] = 1;
                continue;
            }

            int count = 0;
            if(n - 1 >= 0){
                count += dp[n - 1]; //climbStairs_Memo(n - 1, dp);
            }
            if(n - 2 >= 0){
                count += dp[n - 2]; //climbStairs_Memo(n - 2, dp);
            }
            dp[n] = count;
        }
        return dp[N];
    }
}
