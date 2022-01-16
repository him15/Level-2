class Solution {
    int mod = (int)1e9 + 7;
    
    public long numDecodings_Recursive(String s, int idx) {
        if(idx == s.length()){
            return 1;
        }
        long count = 0;
        char ch1 = s.charAt(idx);
        if(ch1 == '0'){
            return 0;
        }
        else if(ch1 == '*'){  // **  *n
            count = (count % mod + 9 * numDecodings_Recursive(s, idx + 1) % mod) % mod;
            if(idx < s.length() - 1){
                char ch2 = s.charAt(idx + 1);
                // **---------------------------------
                if(ch2 == '*'){
                    count = (count % mod + 15 * numDecodings_Recursive(s, idx + 2) % mod) % mod;
                }
                // *n---------------------------------
                else if(ch2 >= '0' && ch2 <= '6'){
                    count = (count % mod + 2 * numDecodings_Recursive(s, idx + 2) % mod) % mod;
                }
                else if(ch2 > '6'){
                    count = (count % mod + numDecodings_Recursive(s, idx + 2) % mod) % mod;
                }
            }
        }
        else{   // nn   n*
            count = (count % mod + numDecodings_Recursive(s, idx + 1) % mod) % mod;
            
            if(idx < s.length() - 1){
                char ch2 = s.charAt(idx + 1);
                // nn---------------------------------
                if(ch2 != '*'){
                    int num = (ch1 - '0') * 10 + (ch2 - '0');
                    if(num <= 26){
                        count = (count % mod + numDecodings_Recursive(s, idx + 2) % mod) % mod;
                    }
                }
                // n*---------------------------------
                else if(ch2 == '*'){
                    if(s.charAt(idx) == '1'){
                        count = (count % mod + 9 * numDecodings_Recursive(s, idx + 2) % mod) % mod;
                    }
                    else if(s.charAt(idx) == '2'){
                        count = (count % mod + 6 * numDecodings_Recursive(s, idx + 2) % mod) % mod;
                    }
                }
            }
        }
        return count;
    }
    
    public long numDecodings_Memo(String s, int idx, long[] dp) {
        if(idx == s.length()){
            return dp[idx] = 1;
        }
        if(dp[idx] != -1){
            return dp[idx];
        }
        long count = 0;
        char ch1 = s.charAt(idx);
        if(ch1 == '0'){
            return dp[idx] = 0;
        }
        else if(ch1 == '*'){  // **  *n
            count = (count % mod + 9 * numDecodings_Memo(s, idx + 1, dp) % mod) % mod;
            if(idx < s.length() - 1){
                char ch2 = s.charAt(idx + 1);
                // **---------------------------------
                if(ch2 == '*'){
                    count = (count % mod + 15 * numDecodings_Memo(s, idx + 2, dp) % mod) % mod;
                }
                // *n---------------------------------
                else if(ch2 >= '0' && ch2 <= '6'){
                    count = (count % mod + 2 * numDecodings_Memo(s, idx + 2, dp) % mod) % mod;
                }
                else if(ch2 > '6'){
                    count = (count % mod + numDecodings_Memo(s, idx + 2, dp) % mod) % mod;
                }
            }
        }
        else{   // nn   n*
            count = (count % mod + numDecodings_Memo(s, idx + 1, dp) % mod) % mod;
            
            if(idx < s.length() - 1){
                char ch2 = s.charAt(idx + 1);
                // nn---------------------------------
                if(ch2 != '*'){
                    int num = (ch1 - '0') * 10 + (ch2 - '0');
                    if(num <= 26){
                        count = (count % mod + numDecodings_Memo(s, idx + 2, dp) % mod) % mod;
                    }
                }
                // n*---------------------------------
                else if(ch2 == '*'){
                    if(s.charAt(idx) == '1'){
                        count = (count % mod + 9 * numDecodings_Memo(s, idx + 2, dp) % mod) % mod;
                    }
                    else if(s.charAt(idx) == '2'){
                        count = (count % mod + 6 * numDecodings_Memo(s, idx + 2, dp) % mod) % mod;
                    }
                }
            }
        }
        return dp[idx] = count;
    }
    
    public long numDecodings_DP(String s, int IDX, long[] dp) {
        for(int idx = s.length(); idx >= 0; idx--){
            
            if(idx == s.length()){
                dp[idx] = 1;
                continue;
            }
            long count = 0;
            char ch1 = s.charAt(idx);
            if(ch1 == '0'){
                dp[idx] = 0;
                continue;
            }
            else if(ch1 == '*'){  // **  *n
                count = (count % mod + 9 * numDecodings_Memo(s, idx + 1, dp) % mod) % mod;
                if(idx < s.length() - 1){
                    char ch2 = s.charAt(idx + 1);
                    // **---------------------------------
                    if(ch2 == '*'){
                        count = (count % mod + 15 * numDecodings_Memo(s, idx + 2, dp) % mod) % mod;
                    }
                    // *n---------------------------------
                    else if(ch2 >= '0' && ch2 <= '6'){
                        count = (count % mod + 2 * numDecodings_Memo(s, idx + 2, dp) % mod) % mod;
                    }
                    else if(ch2 > '6'){
                        count = (count % mod + numDecodings_Memo(s, idx + 2, dp) % mod) % mod;
                    }
                }
            }
            else{   // nn   n*
                count = (count % mod + numDecodings_Memo(s, idx + 1, dp) % mod) % mod;

                if(idx < s.length() - 1){
                    char ch2 = s.charAt(idx + 1);
                    // nn---------------------------------
                    if(ch2 != '*'){
                        int num = (ch1 - '0') * 10 + (ch2 - '0');
                        if(num <= 26){
                            count = (count % mod + numDecodings_Memo(s, idx + 2, dp) % mod) % mod;
                        }
                    }
                    // n*---------------------------------
                    else if(ch2 == '*'){
                        if(s.charAt(idx) == '1'){
                            count = (count % mod + 9 * numDecodings_Memo(s, idx + 2, dp) % mod) % mod;
                        }
                        else if(s.charAt(idx) == '2'){
                            count = (count % mod + 6 * numDecodings_Memo(s, idx + 2, dp) % mod) % mod;
                        }
                    }
                }
            }
            dp[idx] = count;
        }
        return dp[IDX];
    }
    
    public long numDecodings_Opti(String s) {
        long a = 1;
        long b = 0;
        for(int idx = s.length() - 1; idx >= 0; idx--){
            
            long count = 0;
            char ch1 = s.charAt(idx);
            if(ch1 == '0'){
                count = 0;
            }
            else if(ch1 == '*'){  // **  *n
                count = (count % mod + 9 * a /*numDecodings_Memo(s, idx + 1, dp)*/ % mod) % mod;
                if(idx < s.length() - 1){
                    char ch2 = s.charAt(idx + 1);
                    // **---------------------------------
                    if(ch2 == '*'){
                        count = (count % mod + 15 * b /*numDecodings_Memo(s, idx + 2, dp)*/ % mod) % mod;
                    }
                    // *n---------------------------------
                    else if(ch2 >= '0' && ch2 <= '6'){
                        count = (count % mod + 2 * b /*numDecodings_Memo(s, idx + 2, dp)*/ % mod) % mod;
                    }
                    else if(ch2 > '6'){
                        count = (count % mod + b /*numDecodings_Memo(s, idx + 2, dp)*/ % mod) % mod;
                    }
                }
            }
            else{   // nn   n*
                count = (count % mod + a /*numDecodings_Memo(s, idx + 1, dp)*/ % mod) % mod;

                if(idx < s.length() - 1){
                    char ch2 = s.charAt(idx + 1);
                    // nn---------------------------------
                    if(ch2 != '*'){
                        int num = (ch1 - '0') * 10 + (ch2 - '0');
                        if(num <= 26){
                            count = (count % mod + b /*numDecodings_Memo(s, idx + 2, dp)*/ % mod) % mod;
                        }
                    }
                    // n*---------------------------------
                    else if(ch2 == '*'){
                        if(s.charAt(idx) == '1'){
                            count = (count % mod + 9 * b /*numDecodings_Memo(s, idx + 2, dp)*/ % mod) % mod;
                        }
                        else if(s.charAt(idx) == '2'){
                            count = (count % mod + 6 * b /*numDecodings_Memo(s, idx + 2, dp)*/ % mod) % mod;
                        }
                    }
                }
            }
            b = a;
            a = count;
        }
        return a;
    }
    
    public int numDecodings(String s) {
        long[] dp = new long[s.length() + 1];
        Arrays.fill(dp, -1);
        
        // long ans = numDecodings_Recursive(s, 0);
        // long ans = numDecodings_Memo(s, 0, dp);
        // long ans = numDecodings_DP(s, 0, dp);
        long ans = numDecodings_Opti(s);
        // for(long val : dp)   System.out.print(val + " ");
        return (int)ans;
    }
}
