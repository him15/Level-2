class Solution {
    // LIS
    public int LIS_LR_DP(int[] arr){
        int n = arr.length;
        int[] dp = new int[n];
        int[] count = new int[n];
        
        int maxLen = 0;
        int maxCount = 0;
        
        for(int i = 0; i < n; i++){
            dp[i] = 1;
            count[i] = 1;
            for(int j = i - 1; j >= 0; j--){
                if(arr[j] < arr[i]){
                    if(dp[j] + 1 > dp[i]){
                        dp[i] = dp[j] + 1;
                        count[i] = count[j];
                    }
                    else if(dp[j] + 1 == dp[i]){
                        count[i] += count[j];
                    }
                }
            }
            
            if(dp[i] > maxLen){
                maxLen = dp[i];
                maxCount = count[i];
            }
            else if(dp[i] == maxLen){
                maxCount += count[i];
            }
        }
        return maxCount;
    }
    
    
    public int findNumberOfLIS(int[] arr) {
        return LIS_LR_DP(arr);
    }
}
