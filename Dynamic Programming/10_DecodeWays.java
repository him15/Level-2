class Solution {
    public int numDecodings(String s) {
        int[] dp = new int[s.length() + 1];
        Arrays.fill(dp, -1);
        
        // return numDecodings_Recursive(s, 0);
        // return numDecodings_Memo(s, 0, dp);
        // int ans = numDecodings_DP(s, 0, dp);
        // for(int val : dp)   System.out.print(val + " ");
        // return ans;
        return numDecodings_Opti(s);
    }
    
    
    public int numDecodings_Recursive(String s, int idx){
        if(idx == s.length()){
            return 1;
        }
        char ch1 = s.charAt(idx);
        if(ch1 == '0'){
            return 0;
        }
        int count = 0;
        count += numDecodings_Recursive(s, idx + 1);
        
        if(idx < s.length() - 1){
            char ch2 = s.charAt(idx + 1);
            int val = (ch1 - '0') * 10 + (ch2 - '0');
            if(val <= 26){
                count += numDecodings_Recursive(s, idx + 2);
            }
        }
        return count;
    }
    
    public int numDecodings_Memo(String s, int idx, int[] dp){
        if(idx == s.length()){
            return dp[idx] = 1;
        }
        if(dp[idx] != -1){
            return dp[idx];
        }
        
        char ch1 = s.charAt(idx);
        if(ch1 == '0'){
            return dp[idx] = 0;
        }
        int count = 0;
        count += numDecodings_Memo(s, idx + 1, dp);
        
        if(idx < s.length() - 1){
            char ch2 = s.charAt(idx + 1);
            int val = (ch1 - '0') * 10 + (ch2 - '0');
            if(val <= 26){
                count += numDecodings_Memo(s, idx + 2, dp);
            }
        }
        return dp[idx] = count;
    }
    
    public int numDecodings_DP(String s, int IDX, int[] dp){
        for(int idx = s.length(); idx >= 0 ; idx--){
            if(idx == s.length()){
                dp[idx] = 1;
                continue;
            }

            char ch1 = s.charAt(idx);
            if(ch1 == '0'){
                dp[idx] = 0;
                continue;
            }
            int count = 0;
            count += dp[idx + 1]; //numDecodings_Memo(s, idx + 1, dp);

            if(idx < s.length() - 1){
                char ch2 = s.charAt(idx + 1);
                int val = (ch1 - '0') * 10 + (ch2 - '0');
                if(val <= 26){
                    count += dp[idx + 2]; //numDecodings_Memo(s, idx + 2, dp);
                }
            }
            dp[idx] = count;
        }
        return dp[IDX];
    }
    
    public int numDecodings_Opti(String s){
        int a = 1;
        int b = 0;
        for(int idx = s.length() - 1; idx >= 0 ; idx--){
            int count = 0;

            char ch1 = s.charAt(idx);
            if(ch1 != '0'){
                count += a; //numDecodings_Memo(s, idx + 1, dp);

                if(idx < s.length() - 1){
                    char ch2 = s.charAt(idx + 1);
                    int val = (ch1 - '0') * 10 + (ch2 - '0');
                    if(val <= 26){
                        count += b; //numDecodings_Memo(s, idx + 2, dp);
                    }
                }
            }
            
            b = a;
            a = count;
        }
        return a;
    }
}
