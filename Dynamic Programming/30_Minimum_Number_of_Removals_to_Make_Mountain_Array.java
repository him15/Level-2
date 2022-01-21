class Solution {
    // LIS
    public int[] LIS_LR(int [] arr){
        int n = arr.length;
        int[] dp = new int[n];
        for(int i = 0; i < n; i++){
            dp[i] = 1;
            for(int j = i - 1; j >= 0; j--){
                if(arr[j] < arr[i]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);   
                }
            }
        }
        return dp;
    }
    
    // LDS
    public int[] LIS_RL(int [] arr){
        int n = arr.length;
        int[] dp = new int[n];
        for(int i = n - 1; i >= 0; i--){
            dp[i] = 1;
            for(int j = i + 1; j < n; j++){
                if(arr[j] < arr[i]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);   
                }
            }
        }
        return dp;
    }
    
    public int minimumMountainRemovals(int[] nums) {
        int n = nums.length;
        int[] LIS = LIS_LR(nums);
        int[] LDS = LIS_RL(nums);
        int len = 0;
        for(int i = 0; i < n; i++){
            if(LIS[i] > 1 && LDS[i] > 1){
                len = Math.max(len, LIS[i] + LDS[i] - 1);   
            }
        }
        return n - len;
    }
}
