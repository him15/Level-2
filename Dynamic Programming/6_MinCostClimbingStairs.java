class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        // return minCostClimbingStairs_Recursive(cost, n);
        // return minCostClimbingStairs_Memo(n, cost, dp);
        // return minCostClimbingStairs_DP(n, cost, dp);
        return minCostClimbingStairs_Optimize(n, cost);
    }
    
    public int minCostClimbingStairs_Recursive(int[] cost, int n){
        if(n <= 1){
            return cost[n];
        }
        int minCost = Integer.MAX_VALUE;
        if(n - 1 >= 0){
            minCost = Math.min(minCost, minCostClimbingStairs_Recursive(cost, n - 1));
        }
        if(n - 2 >= 0){
            minCost = Math.min(minCost, minCostClimbingStairs_Recursive(cost, n - 2));
        }
        return minCost + (n == cost.length ? 0 : cost[n]);
    }
    
    public int minCostClimbingStairs_Memo(int n, int[] cost, int[] dp){
        if(n <= 1){
            return dp[n] = cost[n];
        }
        if(dp[n] != -1){
            return dp[n];
        }
        
        int minCost = Integer.MAX_VALUE;
        if(n - 1 >= 0){
            minCost = Math.min(minCost, minCostClimbingStairs_Memo(n - 1, cost, dp));
        }
        if(n - 2 >= 0){
            minCost = Math.min(minCost, minCostClimbingStairs_Memo(n - 2, cost, dp));
        }
        return dp[n] = minCost + (n == cost.length ? 0 : cost[n]);
    }
    
    public int minCostClimbingStairs_DP(int N, int[] cost, int[] dp){
        for(int n = 0; n <= N; n++){
            if(n <= 1){
                dp[n] = cost[n];
                continue;
            }

            int minCost = Integer.MAX_VALUE;
            if(n - 1 >= 0){
                minCost = Math.min(minCost, dp[n - 1] /*minCostClimbingStairs_Memo(n - 1, cost, dp)*/ );
            }
            if(n - 2 >= 0){
                minCost = Math.min(minCost, dp[n - 2] /*minCostClimbingStairs_Memo(n - 2, cost, dp)*/ );
            }
            dp[n] = minCost + (n == cost.length ? 0 : cost[n]);
        }
        return dp[N];
    }
    
    public int minCostClimbingStairs_Optimize(int n, int[] cost){
        int a = cost[0];
        int b = cost[1];
        for(int i = 2; i <= n; i++){
            int minCost = Math.min(a, b) + (i == cost.length ? 0 : cost[i]);
            a = b;
            b = minCost;
        }
        return Math.min(a, b);
    }
}
