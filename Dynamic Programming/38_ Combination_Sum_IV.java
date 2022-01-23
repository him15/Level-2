https://leetcode.com/problems/combination-sum-iv/

class Solution {
    public int combinationSum4_Recursive(int[] arr, int idx, int tar) {
        if (idx >= arr.length) {
          return 0;
        }
        if (tar == 0) {
          return 1;
        }
        int count = 0;
        if (tar - arr[idx] >= 0) {
          count += combinationSum4_Recursive(arr, 0, tar - arr[idx]);
        }
        count += combinationSum4_Recursive(arr, idx + 1, tar);
        return count;
    }
    
    public int combinationSum4_Memo(int[] arr, int idx, int tar, int[] dp) {
        if (idx >= arr.length) {
          return 0;
        }
        if (tar == 0) {
          return dp[idx] = 1;
        }
        if(dp[tar] != -1){
            return dp[tar];
        }
        int count = 0;
        if (tar - arr[idx] >= 0) {
          count += combinationSum4_Memo(arr, 0, tar - arr[idx], dp);
        }
        count += combinationSum4_Memo(arr, idx + 1, tar, dp);
        return dp[tar] = count;
    }
    
    public int combinationSum4(int[] arr, int tar) {
        // return combinationSum4_Recursive(arr, 0, tar);
        int n = arr.length;
        int[] dp = new int[tar + 1];
        Arrays.fill(dp, -1);
        return combinationSum4_Memo(arr, 0, tar, dp);
    }
}
