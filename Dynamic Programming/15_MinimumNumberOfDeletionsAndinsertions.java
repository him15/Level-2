class Solution{
    
    public int lcsDp(String s1, String s2, int N, int M, int[][] dp) {
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
    
	public int minOperations(String s1, String s2){ 
	    // Your code goes here
	    int n = s1.length();
        int m = s2.length();
        int[][] dp = new int[n + 1][m + 1];
        int lcs = lcsDp(s1, s2, n, m, dp);
        /* (n - lcs) firstly we are converting the S1 into LCS and after that converting that LCS to S2 with (m - lcs), Actually we want the count of the minimum number of operations so we are calculating that with the help of (n - lcs) + (m - lcs)
	*/
        return (n - lcs) + (m - lcs);
	} 
}
