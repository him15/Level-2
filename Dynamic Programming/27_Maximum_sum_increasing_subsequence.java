https://practice.geeksforgeeks.org/problems/maximum-sum-increasing-subsequence4749/1/#


class Solution{
    public int LIS_LR_DP(int[] arr, int[] dp){
        int n = arr.length;
        int maxIncLength = 0;
        for(int i = 0; i < n; i++){
            dp[i] = arr[i];
            for(int j = i - 1; j >= 0; j--){
                if(arr[j] < arr[i]){
                    dp[i] = Math.max(dp[i], dp[j] + arr[i]);
                }
            }
            maxIncLength = Math.max(maxIncLength, dp[i]);
        }
        return maxIncLength;
    }
    
	public int maxSumIS(int arr[], int n) {  
	    //code here.
	    int[] dp = new int[n];
	    return LIS_LR_DP(arr, dp);
	}  
}
