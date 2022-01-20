All code are same like LIS (Longest Increasing Subsequence) but the change is check (arr[j] < arr[j]) this is in LIS but here the array contains duplicate numbers so,
we are checking (arr[j] <= arr[i]) and it gives the Longest Increasing Subsequence and now in the end,
we are substracting that from arrays length to get the final deletion count

// extention question Minimum number of deletion to be performed to make an array sorted constrins are (-1e7 <= ele <= 1e7)
    public int Min_Deletion(int[] arr, int[] dp){
        int n = arr.length;
        int len = 0;
        for(int i = 0; i < n; i++){
            dp[i] = 1;
            for(int j = i - 1; j >= 0; j--){
                if(arr[j] <= arr[i]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            len = Math.max(len, dp[i]);
        }
        return n - len;
    }
