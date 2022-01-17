class solution{
    public int longestCommonSubsequence_DP(String s1, String s2, int N, int M, int[][] dp) {
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
    
    public List<String> PrintLCS(String s1, String s2, int n, int m, int[][] dp){
        List<String> str = new ArrayList<>();
        int i = n;
        int j = m;
        while(i > 0 && j > 0){
            if(s1.charAt(i - 1) == s2.charAt(j - 1)){
                str.add(Character.toString(s1.charAt(i - 1)));
                i--;
                j--;
            }else{
                if(dp[i - 1][j] >= dp[i][j - 1]){
                    i--;
                }else{
                    j--;
                }
                
            }
        }
        return str;
    }

    public int longestCommonSubsequence(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int[][] dp = new int[n + 1][m + 1];
        
        // return longestCommonSubsequence_Recursive(s1, s2, n, m);
        // return longestCommonSubsequence_Memo(s1, s2, n, m, dp);
        
        int ans = longestCommonSubsequence_DP(s1, s2, n, m, dp);
        List<String> str = PrintLCS(s1, s2, n, m, dp);
        Collections.reverse(str);
        System.out.println(str);
        return ans;
    }
}
