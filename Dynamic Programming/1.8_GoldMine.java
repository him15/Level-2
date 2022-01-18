class Solution{
    static int maxGold(int n, int m, int M[][]){
        // code here
        // int[][] dir = {{-1, 1},{0, 1},{1, 1}};
        int[][] dp = new int[n][m];
        for(int[] d : dp){
            Arrays.fill(d, -1);
        }
        int maxGold = 0;
        for(int i = 0; i < n; i++){
            // maxGold = Math.max(maxGold, goldMine_recursive(i, 0, M));
            // maxGold = Math.max(maxGold, goldMine_Memo(i, 0, M, dp));
            maxGold = Math.max(maxGold, goldMine_DP(i, 0, M, dp));
        }
        return maxGold;
    }
    
    static int goldMine_recursive(int r, int c, int[][] mat){
        if(c == mat[0].length - 1){
            return mat[r][c];
        }
        int maxGold = 0;
        if(r - 1 >= 0){
            maxGold = Math.max(maxGold, goldMine_recursive(r - 1, c + 1, mat));
        }
        maxGold = Math.max(maxGold, goldMine_recursive(r, c + 1, mat));
        if(r + 1 < mat.length){
            maxGold = Math.max(maxGold, goldMine_recursive(r + 1, c + 1, mat));
        }
        
        return maxGold + mat[r][c];
    }
    
    
    static int goldMine_Memo(int r, int c, int[][] mat, int[][] dp){
        if(c == mat[0].length - 1){
            return dp[r][c] = mat[r][c];
        }
        if(dp[r][c] != 0){
            return dp[r][c];
        }
        
        int maxGold = 0;
        if(r - 1 >= 0){
            maxGold = Math.max(maxGold, goldMine_Memo(r - 1, c + 1, mat, dp));
        }
        maxGold = Math.max(maxGold, goldMine_Memo(r, c + 1, mat, dp));
        if(r + 1 < mat.length){
            maxGold = Math.max(maxGold, goldMine_Memo(r + 1, c + 1, mat, dp));
        }
        
        return dp[r][c] = maxGold + mat[r][c];
    }
    
    static int goldMine_DP(int R, int C, int[][] mat, int[][] dp){
        for(int c = mat[0].length - 1; c >= 0; c--){
            for(int r = mat.length - 1; r >= 0; r--){
                if(c == mat[0].length - 1){
                    dp[r][c] = mat[r][c];
                    continue;
                }
                
                int maxGold = 0;
                if(r - 1 >= 0){
                    maxGold = Math.max(maxGold, dp[r - 1][c + 1] /*goldMine_Memo(r - 1, c + 1, mat, dp)*/);
                }
                maxGold = Math.max(maxGold, dp[r][c + 1] /*goldMine_Memo(r, c + 1, mat, dp)*/);
                if(r + 1 < mat.length){
                    maxGold = Math.max(maxGold, dp[r + 1][c + 1] /*goldMine_Memo(r + 1, c + 1, mat, dp)*/);
                }
                
                dp[r][c] = maxGold + mat[r][c];
            }
        }
        return dp[R][C];
    }
}
