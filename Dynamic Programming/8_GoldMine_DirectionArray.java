class Solution{
    static int maxGold(int n, int m, int M[][]){
        // code here
        int[][] dir = {{-1, 1},{0, 1},{1, 1}};
        int[][] dp = new int[n][m];
        for(int[] d : dp){
            Arrays.fill(d, -1);
        }
        int maxGold = 0;
        for(int i = 0; i < n; i++){
            // maxGold = Math.max(maxGold, goldMine_recursive(i, 0, M, dir));
            // maxGold = Math.max(maxGold, goldMine_Memo(i, 0, M, dp, dir));
            maxGold = Math.max(maxGold, goldMine_DP(i, 0, M, dp, dir));
        }
        return maxGold;
    }
    
    static int goldMine_recursive(int r, int c, int[][] mat, int[][] dir){
        if(c == mat[0].length - 1){
            return mat[r][c];
        }
        int maxGold = 0;
        for(int[] d : dir){
            int x = r + d[0];
            int y = c + d[1];
            if(x >= 0 && x < mat.length){
                maxGold = Math.max(maxGold, goldMine_recursive(x, y, mat, dir));
            }
        }
        
        return maxGold + mat[r][c];
    }
    
    
    static int goldMine_Memo(int r, int c, int[][] mat, int[][] dp, int[][] dir){
        if(c == mat[0].length - 1){
            return dp[r][c] = mat[r][c];
        }
        if(dp[r][c] != -1){
            return dp[r][c];
        }
        int maxGold = 0;
        for(int[] d : dir){
            int x = r + d[0];
            int y = c + d[1];
            if(x >= 0 && x < mat.length){
                maxGold = Math.max(maxGold, goldMine_Memo(x, y, mat, dp, dir));
            }
        }
        
        return dp[r][c] = maxGold + mat[r][c];
    }
    
    static int goldMine_DP(int R, int C, int[][] mat, int[][] dp, int[][] dir){
        for(int c = mat[0].length - 1; c >= 0; c--){
            for(int r = mat.length - 1; r >= 0; r--){
                if(c == mat[0].length - 1){
                    dp[r][c] = mat[r][c];
                    continue;
                }
                int maxGold = 0;
                for(int[] d : dir){
                    int x = r + d[0];
                    int y = c + d[1];
                    if(x >= 0 && x < mat.length){
                        maxGold = Math.max(maxGold, dp[x][y] /*goldMine_Memo(x, y, mat, dp, dir)*/ );
                    }
                }
                
                dp[r][c] = maxGold + mat[r][c];
            }
        }
        return dp[R][C];
    }
    
}
