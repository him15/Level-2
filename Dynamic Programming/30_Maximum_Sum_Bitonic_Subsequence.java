class Compute {
    
    // LIS - Longest Increasing Subsequence 
    public static int[] LIS_LR(int[] arr){
        int n = arr.length;
        int[] dp = new int[n];
        for(int i = 0; i < n; i++){
            dp[i] = arr[i];
            for(int j = i - 1; j >= 0; j--){
                if(arr[j] < arr[i]){
                    dp[i] = Math.max(dp[i], dp[j] + arr[i]);
                }
            }
        }
        return dp;
    }
    
    // LDS - Longest Decreasing Subsequence
    public static int[] LIS_RL(int[] arr){
        int n = arr.length;
        int[] dp = new int[n];
        for(int i = n - 1; i >= 0; i--){
            dp[i] = arr[i];
            for(int j = i + 1; j < n; j++){
                if(arr[j] < arr[i]){
                    dp[i] = Math.max(dp[i], dp[j] + arr[i]);
                }
            }
        }
        return dp;
    }
    
    
    public static int LongestBitonicSequence(int[] nums) {
        int n = nums.length;
        int[] LIS = LIS_LR(nums);
        int[] LDS = LIS_RL(nums);
        
        int len = 0;
        for(int i = 0; i < n; i++){
            len = Math.max(len, LIS[i] + LDS[i] - nums[i]);
        }
        return len;
    }
    
    public static int maxSumBS(int arr[], int n) {
        return LongestBitonicSequence(arr);
    }
}
