//https://practice.geeksforgeeks.org/problems/minimum-number-of-deletions4610/1/#

class Solution {
    
    int lcsDp(String s1, String s2, int N, int M, int[][] dp) {
        for(int n = 0; n <= N; n++){
            for(int m = 0; m <= M; m++){
                if(n == 0 || m == 0){
                    dp[n][m] = 0;
                    continue;
                }
                int count = 0;
                if(s1.charAt(n - 1) == s2.charAt(m - 1)){
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
    
    
    String reverse(String s){
        StringBuilder sb = new StringBuilder(s);
        sb.reverse();
        return sb.toString();
    }
    
    int minDeletions(String s1, int n){
        // code here
        String s2 = reverse(s1);
        int m = s2.length();
        
        int[][] dp = new int[n + 1][m + 1];
        int lcs = lcsDp(s1, s2, n, m, dp);
        return n - lcs;
    }
}
