Extesion of LCS

class Solution {
    public int maxDotProduct_Recursive(int[] nums1, int[] nums2, int n, int m) {
        if(n == 0 || m == 0){
            return -(int)1e7;
        }
        int val = nums1[n - 1] * nums2[m - 1];
        
        int acceptedCall = maxDotProduct_Recursive(nums1, nums2, n - 1, m - 1) + val;
        int a = maxDotProduct_Recursive(nums1, nums2, n - 1, m);
        int b = maxDotProduct_Recursive(nums1, nums2, n, m - 1);
        
        return Math.max(Math.max(acceptedCall, val), Math.max(a, b));
    }
    
    public int maxDotProduct_Memo(int[] nums1, int[] nums2, int n, int m, int[][] dp) {
        if(n == 0 || m == 0){
            return dp[n][m] = -(int)1e7;
        }
        if(dp[n][m] != -(int)1e8){
            return dp[n][m];
        }
        
        int val = nums1[n - 1] * nums2[m - 1];
        
        int acceptedCall = maxDotProduct_Memo(nums1, nums2, n - 1, m - 1, dp) + val;
        int a = maxDotProduct_Memo(nums1, nums2, n - 1, m, dp);
        int b = maxDotProduct_Memo(nums1, nums2, n, m - 1, dp);
        
        return dp[n][m] = Math.max(Math.max(acceptedCall, val), Math.max(a, b));
    }
    
    
    public int maxDotProduct_DP(int[] nums1, int[] nums2, int N, int M, int[][] dp) {
        for(int n = 0; n <= N; n++){
            for(int m = 0; m <= M; m++){
                if(n == 0 || m == 0){
                    dp[n][m] = -2000;
                    continue;
                }

                int val = nums1[n - 1] * nums2[m - 1];

                int acceptedCall = dp[n - 1][m - 1] + val; //maxDotProduct_Memo(nums1, nums2, n - 1, m - 1, dp) + val;
                int a = dp[n - 1][m];  //maxDotProduct_Memo(nums1, nums2, n - 1, m, dp);
                int b = dp[n][m - 1]; //maxDotProduct_Memo(nums1, nums2, n, m - 1, dp);

                dp[n][m] = Math.max(Math.max(acceptedCall, val), Math.max(a, b));
            }
        }
        return dp[N][M];
    }
    
    public int maxDotProduct(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int[][] dp = new int[n + 1][m + 1];
        for(int[] d : dp){
            Arrays.fill(d, -(int)1e8);
        }
        // return maxDotProduct_Recursive(nums1, nums2, n, m);
        // return maxDotProduct_Memo(nums1, nums2, n, m, dp);
        return maxDotProduct_DP(nums1, nums2, n, m, dp);
    }
}
