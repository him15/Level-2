Another variation of LCS but this is in Integer ARRAY

//  https://leetcode.com/problems/uncrossed-lines/

class Solution {
    public int maxUncrossedLines_Recursive(int[] nums1, int[] nums2, int n, int m){
        if(n == 0 || m == 0){
            return 0;
        }
        int count = 0;
        if(nums1[n - 1] == nums2[m - 1]){
            count += 1 + maxUncrossedLines_Recursive(nums1, nums2, n - 1, m - 1);
        }else{
            count += Math.max(maxUncrossedLines_Recursive(nums1, nums2, n - 1, m), maxUncrossedLines_Recursive(nums1, nums2, n, m - 1));
        }
        return count;
    }
    
    public int maxUncrossedLines_Memo(int[] nums1, int[] nums2, int n, int m, int[][] dp){
        if(n == 0 || m == 0){
            return dp[n][m] = 0;
        }
        if(dp[n][m] != -1){
            return dp[n][m];
        }
        int count = 0;
        if(nums1[n - 1] == nums2[m - 1]){
            count += 1 + maxUncrossedLines_Memo(nums1, nums2, n - 1, m - 1, dp);
        }else{
            count += Math.max(maxUncrossedLines_Memo(nums1, nums2, n - 1, m, dp), maxUncrossedLines_Memo(nums1, nums2, n, m - 1, dp));
        }
        return dp[n][m] = count;
    }
    
    public int maxUncrossedLines_DP(int[] nums1, int[] nums2, int N, int M, int[][] dp) {
        for(int n = 0; n <= N; n++){
            for(int m = 0; m <= M; m++){
                if(n == 0 || m == 0){
                    dp[n][m] = 0;
                    continue;
                }
                int count = 0;
                if(nums1[n - 1] == nums2[m - 1]){
                    count += 1 + dp[n - 1][m - 1]; //longestCommonSubsequence_Memo(s1, s2, n - 1, m - 1, dp);
                }else{
                    // count += Math.max(longestCommonSubsequence_Memo(s1, s2, n, m - 1, dp), longestCommonSubsequence_Memo(s1, s2, n - 1, m, dp));
                    count += Math.max(dp[n][m - 1], dp[n - 1][m]);
                }
                dp[n][m] = count;
            }
        }
        return dp[N][M];
    }
    
    
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int[][] dp = new int[n + 1][m + 1];
        for(int[] d : dp)   Arrays.fill(d, -1);
        
        // return maxUncrossedLines_Recursive(nums1, nums2, n, m);
        // return maxUncrossedLines_Memo(nums1, nums2, n, m, dp);
        return maxUncrossedLines_DP(nums1, nums2, n, m, dp);
    }
}
