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
    
    public String reverse(String s){
        StringBuilder sb = new StringBuilder(s);
        sb.reverse();
        return sb.toString();
    }
        
    public int longestPalindromeSubseq(String s1) {
        int n = s1.length();
        String s2 = reverse(s1);
        int m = s2.length();
        
        int[][] dp = new int[n + 1][m + 1];
        int lcs = lcsDp(s1, s2, n, m, dp);
        return lcs;
    }
}


A N O T H E R   A P P R O A C H
// ---------------------------------------------------------------------------------------------------------------------------------------------------------------
class Solution {
    public int longestPalindromeSubseq_Recursive(String s, int i, int j) {
        if(i >= j){
            return (i == j) ? 1 : 0;
        }
        int count = 0;
        if(s.charAt(i) == s.charAt(j)){
            count += longestPalindromeSubseq_Recursive(s, i + 1, j - 1) + 2;
        }else{
            count += Math.max(longestPalindromeSubseq_Recursive(s, i + 1, j), longestPalindromeSubseq_Recursive(s, i, j - 1));
        }
        return count;
    }
    
    public int longestPalindromeSubseq_Memo(String s, int i, int j, int[][] dp) {
        if(i >= j){
            return dp[i][j] = (i == j) ? 1 : 0;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        int count = 0;
        if(s.charAt(i) == s.charAt(j)){
            count += longestPalindromeSubseq_Memo(s, i + 1, j - 1, dp) + 2;
        }else{
            count += Math.max(longestPalindromeSubseq_Memo(s, i + 1, j, dp), longestPalindromeSubseq_Memo(s, i, j - 1, dp));
        }
        return dp[i][j] = count;
    }
    
    public int longestPalindromeSubseq_DP(String s, int I, int J, int[][] dp) {
        int n = s.length();
        for(int gap = 0; gap < n; gap++){
            for(int i = 0, j = gap; j < n; i++, j++){
                if(i >= j){
                    dp[i][j] = (i == j) ? 1 : 0;
                    continue;
                }
                if(s.charAt(i) == s.charAt(j)){
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                }else{
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[I][J];
    }
    
    public String printLPS(String s){
        int n = s.length();
        String[][] dp = new String[n][n];
        for(String[] ss : dp){
            Arrays.fill(ss, "");
        }
        for(int gap = 0; gap < n; gap++){
            for(int i = 0, j = gap; j < n; i++, j++){
                if(i == j){
                    dp[i][j] = s.charAt(i) + "";
                    continue;
                }
                if(s.charAt(i) == s.charAt(j)){
                    dp[i][j] = s.charAt(i) + dp[i + 1][j - 1] + s.charAt(j);
                }else{
                    dp[i][j] = (dp[i + 1][j].length() > dp[i][j - 1].length() ? dp[i + 1][j] : dp[i][j - 1]);
                }
            }
        }
        return dp[0][n - 1];
    }
    
    public ArrayList<String> printLPS_Recursive(String s, int i, int j, int[][] dp){
        if(i > j){
            ArrayList<String> bans = new ArrayList<>();
            bans.add("");
            return bans;
        }
        ArrayList<String> rr = new ArrayList<>();
        if(s.charAt(i) == s.charAt(j)){
            rr = printLPS_Recursive(s, i + 1, j - 1, dp);
            
        }else if{
            
        }
         
        
    }
    
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        // for(int[] d : dp){
        //     Arrays.fill(d, - 1);   // requires for memo because 0 is the part of our answer
        // }
        // return longestPalindromeSubseq_Recursive(s, 0, n - 1);
        // return longestPalindromeSubseq_Memo(s, 0, n - 1, dp);
        int ans = longestPalindromeSubseq_DP(s, 0, n - 1, dp);
        // String str = printLPS(s);
        printLPS_Recursive(s, 0, n - 1, dp);
        System.out.println(str);
        return ans;
    }
}
