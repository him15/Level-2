https://practice.geeksforgeeks.org/problems/subset-sum-problem-1611555638/1/#

class Solution{
    static int isSubset_MEMO(int n, int[] arr, int tar, int[][] dp){
        if(n == 0 || tar == 0){
            return dp[n][tar] = (tar == 0 ? 1 : 0);
        }
        if(dp[n][tar] != -1){
            return dp[n][tar];
        }
        boolean res = false;
        if(tar - arr[n - 1] >= 0){
            res = res || (isSubset_MEMO(n - 1, arr, tar - arr[n - 1], dp) == 1);
        }
        res = res || (isSubset_MEMO(n - 1, arr, tar, dp) == 1);
        return dp[n][tar] = res ? 1 : 0;
    }

    static Boolean isSubsetSum(int N, int arr[], int sum){
        int[][] dp = new int[N + 1][sum + 1];
        for(int[] d : dp) Arrays.fill(d, -1);
        int ans = isSubset_MEMO(N, arr, sum, dp);
        return ans == 1 ? true : false;
    }
}
