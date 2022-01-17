class Solution {
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
    
    public String PrintSCS(String s1, String s2, int n, int m, int[][] dp){
        int l = (n + m - dp[n][m]);
        System.out.println(l);
        char[] arr = new char[l];
        int i = n;
        int j = m;
        while(i > 0 && j > 0){
            if(s1.charAt(i - 1) == s2.charAt(j - 1)){
                arr[--l] = s1.charAt(i - 1);
                i--;
                j--;
            }else{
                if(dp[i][j - 1] >= dp[i - 1][j]){
                    arr[--l] = s2.charAt(j - 1);
                    j--;
                }else{
                    arr[--l] = s1.charAt(i - 1);
                    i--;
                }
            }
        }
        while(i > 0){
            arr[--l] = s1.charAt(i - 1);
            i--;
        }
        while(j > 0){
            arr[--l] = s2.charAt(j - 1);
            j--;
        }
        
        return new String(arr);
    }
    
    public String shortestCommonSupersequence(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int[][] dp = new int[n + 1][m + 1];
        int lcs = lcsDp(s1, s2, n, m, dp);
        
        for(int i = 0; i <= n; i++){
            for(int j = 0; j <= m; j++){
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        
        
        return PrintSCS(s1, s2, n, m, dp);
    }
}
