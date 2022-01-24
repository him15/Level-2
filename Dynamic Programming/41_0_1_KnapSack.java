https://practice.geeksforgeeks.org/problems/0-1-knapsack-problem0945/1/#

class Solution { 
    //Function to return max value that can be put in knapsack of capacity W.
    
    static int KnapSack_Recursive(int W, int[] wt, int[] val, int n){
        if(n == 0 || W == 0){
            return 0;
        }
        int maxProfit = 0;
        if(wt[n - 1] <= W){
            maxProfit = Math.max(val[n - 1] + KnapSack_Recursive(W - wt[n - 1], wt, val, n - 1), KnapSack_Recursive(W, wt, val, n - 1));
        }
        else if(wt[n - 1] > W){
            maxProfit = KnapSack_Recursive(W, wt, val, n - 1);
        }
        return maxProfit;
    }
    
    static int KnapSack_Memo(int W, int[] wt, int[] val, int n, int[][] dp){
        if(n == 0 || W == 0){
            return dp[n][W] = 0;
        }
        if(dp[n][W] != -1){
            return dp[n][W];
        }
        int maxProfit = 0;
        if(wt[n - 1] <= W){
            maxProfit = Math.max(val[n - 1] + KnapSack_Memo(W - wt[n - 1], wt, val, n - 1, dp), KnapSack_Memo(W, wt, val, n - 1, dp));
        }
        else if(wt[n - 1] > W){
            maxProfit = KnapSack_Memo(W, wt, val, n - 1, dp);
        }
        return dp[n][W] = maxProfit;
    }
    
    static int KnapSack_DP(int w, int[] wt, int[] val, int N, int[][] dp){
        for(int n = 0; n <= N; n++){
            for(int W = 0; W <= w; W++){
                if(n == 0 || W == 0){
                    dp[n][W] = 0;
                    continue;
                }
                int maxProfit = 0;
                if(wt[n - 1] <= W){
                    // maxProfit = Math.max(val[n - 1] + KnapSack_Memo(W - wt[n - 1], wt, val, n - 1, dp), KnapSack_Memo(W, wt, val, n - 1, dp));
                    maxProfit = Math.max(val[n - 1] + dp[n - 1][W - wt[n - 1]], dp[n - 1][W]);
                }
                else if(wt[n - 1] > W){
                    // maxProfit = KnapSack_Memo(W, wt, val, n - 1, dp);
                    maxProfit = dp[n - 1][W];
                }
                dp[n][W] = maxProfit;
            }
        }
        return dp[N][w];
    }
    
    static int knapSack(int W, int wt[], int val[], int n) { 
         // your code here 
         int[][] dp = new int[n + 1][W + 1];
         for(int[] d : dp)  Arrays.fill(d, -1);
        //  return KnapSack_Recursive(W, wt, val, n);
        // return KnapSack_Memo(W, wt, val, n, dp);
        return KnapSack_DP(W, wt, val, n, dp);
    } 
}
