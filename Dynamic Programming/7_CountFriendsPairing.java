class solution{
    static int mod = (int)1e9 + 7;
    
     
    public long countFriendsPairings(int n) { 
        //code here
        long[] dp = new long[n + 1];
        // return countFriendsPairings_Recursive(n, dp);
        // return countFriendsPairings_Memo(n, dp);
        return countFriendsPairings_DP(n, dp);
    }
    
    public long countFriendsPairings_Recursive(int n, long[] dp) { 
       //code here
       if(n <= 1){
           return 1;
       }
       long count = 0;
       if(n - 1 >= 0){
           count += countFriendsPairings_Recursive(n - 1, dp);
       }
       if(n - 2 >= 0){
           count += countFriendsPairings_Recursive(n - 2, dp) * (n - 1);
       }
       return count % mod;
    }
    
    public long countFriendsPairings_Memo(int n, long[] dp) { 
       //code here
       if(n <= 1){
           return dp[n] = 1;
       }
       if(dp[n] != 0){
           return dp[n];
       }
       long count = 0;
       if(n - 1 >= 0){
           count += countFriendsPairings_Memo(n - 1, dp);
       }
       if(n - 2 >= 0){
           count += countFriendsPairings_Memo(n - 2, dp) * (n - 1);
       }
       return dp[n] = count % mod;
    }
    
    public long countFriendsPairings_DP(int N, long[] dp) { 
       //code here
       for(int n = 0; n <= N; n++){
           if(n <= 1){
               dp[n] = 1;
               continue;
           }
           long count = 0;
           if(n - 1 >= 0){
               count += countFriendsPairings_Memo(n - 1, dp);
           }
           if(n - 2 >= 0){
               count += countFriendsPairings_Memo(n - 2, dp) * (n - 1);
           }
           dp[n] = count % mod;
       }
        return dp[N];       
    }
}
