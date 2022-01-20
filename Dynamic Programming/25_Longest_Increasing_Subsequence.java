class Solution {
    // left to right
    public int LIS_LR_Reursive(int[] arr, int i) {
        // if(i == 0){
        //     return 1;   // return 1 -> because one indivisual element is the longest increasing subsequence at 0th idx
        // }
        int longestLength = 0;
        for(int j = i - 1; j >= 0; j--){
            if(arr[j] < arr[i]){
                int len = LIS_LR_Reursive(arr, j);
                longestLength = Math.max(longestLength, len);   
            }
        }
        return longestLength + 1;    // adding the current elements count into the answer
    }
    
    public int LIS_LR_Memo(int[] arr, int i, int[] dp) {
        // if(i == 0){
        //     return dp[i] = 1;   // return 1 -> because one indivisual element is the longest increasing subsequence at 0th idx
        // }
        if(dp[i] != 0){
            return dp[i];
        }
        
        int longestLength = 0;
        for(int j = i - 1; j >= 0; j--){
            if(arr[j] < arr[i]){
                int len = LIS_LR_Memo(arr, j, dp);
                longestLength = Math.max(longestLength, len);   
            }
        }
        return dp[i] = longestLength + 1;    // adding the current elements count into the answer
    }
    
    public int LIS_DP(int[] arr, int[] dp){
        int n = arr.length;
        int len = 0;
        for(int i = 0; i < n; i++){
            dp[i] = 1;
            for(int j = i - 1; j >= 0; j--){
                if(arr[j] < arr[i]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            len = Math.max(len, dp[i]);
        }
        return len;
    }
    
    public int LIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n + 1];
        int len = 0;
        for(int i = 0; i < n; i++){
            // len = Math.max(len, LIS_LR_Reursive(nums, i));
            // len = Math.max(len, LIS_LR_Memo(nums, i, dp));
        }
        // return len;
        return LIS_DP(nums, dp);
    }
    
    public int lengthOfLIS(int[] nums) {
        return LIS(nums);
    }
}
