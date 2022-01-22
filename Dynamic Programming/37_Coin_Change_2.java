class Solution {
    public int change_Recursive(int tar, int[] arr, int idx) {
        if(idx >= arr.length){
            return 0;
        }
        if(tar == 0){
            return 1;
        }
        int count = 0;
        if(tar - arr[idx] >= 0){
            count += change_Recursive(tar - arr[idx], arr, idx);
        }
        count += change_Recursive(tar, arr, idx + 1);
        return count;
    }
    
    public int change_Memo(int tar, int[] arr, int idx, int[][] dp) {
        if(idx >= arr.length){
            return 0;
        }
        if(tar == 0){
            return dp[idx][tar] = 1;
        }
        if(dp[idx][tar] != (int)1e9){
            return dp[idx][tar];
        }
        int count = 0;
        if(tar - arr[idx] >= 0){
            count += change_Memo(tar - arr[idx], arr, idx, dp);
        }
        count += change_Memo(tar, arr, idx + 1, dp);
        return dp[idx][tar] = count;
    }
    
    public int change(int tar, int[] arr) {
        // return change_Recursive(tar, arr, 0);
        int n = arr.length;
        int[][] dp = new int[n + 1][tar + 1];
        for(int[] d : dp) Arrays.fill(d, (int)1e9);
        return change_Memo(tar, arr, 0, dp);
    }
}
