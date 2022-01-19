class Solution {
    public int isMatch_Recursive(String s, String p, int n, int m) {
        if(n == 0 || m == 0){
            if(n == 0 && m == 0){
                return 1;
            }
            if(m == 1 && p.charAt(m - 1) == '*'){
                return 1;
            }
            else{
                return 0;
            }
        }
        char ch1 = s.charAt(n - 1);
        char ch2 = p.charAt(m - 1);
        
        if(ch1 == ch2 || ch2 == '?'){
            return isMatch_Recursive(s, p, n - 1, m - 1);
        }
        else if(ch2 == '*'){
            boolean res = false;
            res = res || (isMatch_Recursive(s, p, n - 1, m) == 1);   // map a character
            res = res || (isMatch_Recursive(s, p, n, m - 1) == 1);   // map a empty string
            
            return res ? 1 : 0;
        }
        else{
            return 0;
        }
    }
    
    public int isMatch_Memo(String s, String p, int n, int m, int[][] dp) {
        if(n == 0 || m == 0){
            if(n == 0 && m == 0){
                return dp[n][m] = 1;
            }
            if(m == 1 && p.charAt(m - 1) == '*'){
                return dp[n][m] = 1;
            }
            else{
                return dp[n][m] = 0;
            }
        }
        
        if(dp[n][m] != -1){
            return dp[n][m];
        }
        
        char ch1 = s.charAt(n - 1);
        char ch2 = p.charAt(m - 1);
        
        if(ch1 == ch2 || ch2 == '?'){
            return dp[n][m] = isMatch_Memo(s, p, n - 1, m - 1, dp);
        }
        else if(ch2 == '*'){
            boolean res = false;
            res = res || (isMatch_Memo(s, p, n - 1, m, dp) == 1);   // map a character
            res = res || (isMatch_Memo(s, p, n, m - 1, dp) == 1);   // map a empty string
            
            return dp[n][m] = res ? 1 : 0;
        }
        else{
            return dp[n][m] = 0;
        }
    }
    
    public int isMatch_DP(String s, String p, int N, int M, int[][] dp) {
        for(int n = 0; n <= N; n++){
            for(int m = 0; m <= M; m++){
                if(n == 0 || m == 0){
                    if(n == 0 && m == 0){
                        dp[n][m] = 1;
                        continue;
                    }
                    if(m == 1 && p.charAt(m - 1) == '*'){
                        dp[n][m] = 1;
                        continue;
                    }
                    else{
                        dp[n][m] = 0;
                        continue;
                    }
                }

                char ch1 = s.charAt(n - 1);
                char ch2 = p.charAt(m - 1);

                if(ch1 == ch2 || ch2 == '?'){
                    dp[n][m] = dp[n - 1][m - 1]; // isMatch_Memo(s, p, n - 1, m - 1, dp);
                }
                else if(ch2 == '*'){
                    boolean res = false;
                    res = res || (dp[n - 1][m] == 1); //(isMatch_Memo(s, p, n - 1, m, dp) == 1);   // map a character
                    res = res || (dp[n][m - 1] == 1); //(isMatch_Memo(s, p, n, m - 1, dp) == 1);   // map a empty string

                    dp[n][m] = res ? 1 : 0;
                }
                else{
                    dp[n][m] = 0;
                }
            }
        }
        return dp[N][M];
    }
    
    public String compressedStars(String s){
        if(s.length() == 0) return "";
        StringBuilder sb = new StringBuilder();
        sb.append(s.charAt(0));
        int i = 1;
        while(i < s.length()){
            while(i < s.length() && sb.charAt(sb.length() - 1) == '*' && s.charAt(i) == '*'){
                i++;
            }
            if(i < s.length())  sb.append(s.charAt(i));
            i++;
        }
        return sb.toString();
    }
    
    public boolean isMatch(String s, String p) {
        int n = s.length();
        
        p = compressedStars(p);
        int m = p.length();
        
        int[][] dp = new int[n + 1][m + 1];
        for(int[] d : dp)   Arrays.fill(d, -1);
        
        // return isMatch_Recursive(s, p, n, m) == 1;
        // return isMatch_Memo(s, p, n, m, dp) == 1;
        return isMatch_DP(s, p, n, m, dp) == 1;
    }
}
