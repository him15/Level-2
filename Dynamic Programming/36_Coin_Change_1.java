https://leetcode.com/problems/coin-change/

class Solution {
    public int coinChange_Recursive(int[] arr, int tar) {
        if(tar == 0){
            return 0;
        }
        int minCoins = (int)1e8;
        for(int ele : arr){
            if(tar - ele >= 0){
                minCoins = Math.min(minCoins, coinChange_Recursive(arr, tar - ele) + 1);
            }
        }
        return minCoins;
    }
    
    public int coinChange_Memo(int[] arr, int tar, int[] dp) {
        if(tar == 0){
            return dp[tar] = 0;
        }
        if(dp[tar] != (int)1e9){
            return dp[tar];
        }
        int minCoins = (int)1e8;
        for(int ele : arr){
            if(tar - ele >= 0){
                minCoins = Math.min(minCoins, coinChange_Memo(arr, tar - ele, dp) + 1);
            }
        }
        return dp[tar] = minCoins;
    }
    
    public int coinChange_DP(int[] arr, int Tar, int[] dp) {
        for(int tar = 0; tar <= Tar; tar++){
            if(tar == 0){
                dp[tar] = 0;
                continue;
            }
            
            int minCoins = (int)1e8;
            for(int ele : arr){
                if(tar - ele >= 0){
                    minCoins = Math.min(minCoins, dp[tar - ele] + 1 /*coinChange_Memo(arr, tar - ele, dp) + 1*/);
                }
            }
            dp[tar] = minCoins;
        }
        return dp[Tar];
    }
    
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, (int)1e9);
        // int ans = coinChange_Recursive(coins, amount);
        // int ans = coinChange_Memo(coins, amount, dp);
        int ans = coinChange_DP(coins, amount, dp);
        
        return (ans != (int)1e8 ? ans : -1);
    }
}
