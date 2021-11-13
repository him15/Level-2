import java.util.*;

public class Main{
    public static void main(String[] args){
        int n = 4, tq = 4;
        boolean[] rowS = new boolean[n];
        boolean[] colS = new boolean[n];
        boolean[] nDia = new boolean[2 * n - 1];
        boolean[] rDia = new boolean[2 * n - 1];
        
        // nQueenCombinationsUnOptimize(new boolean[n][m], tq, 0, 0, "");
        nQueenPermutationsUnOptmize(new boolean[n][n], tq, 0, 0, "");
        
        nQueenCombinationsOptimize(new boolean[n][n], tq, 0, 0, "", rowS, colS, nDia, rDia);
        
    }
    
    public static boolean isSafeToPlace(boolean[][] board, int row, int col){
        int n = board.length;
        int m = board[0].length;
        int[][] dir = {{0,-1}, {-1,0}, {-1,-1}, {-1,1}};
        
        for(int[] d : dir){
            int r = row, c = col;
            
            while(r >= 0 && r < n && c >= 0 && c < m){
                if(board[r][c]){
                    return false;
                }
                r += d[0];
                c += d[1];
            }
        }
        return true;
    }
    
    
    public static boolean isSafeToPlacePer(boolean[][] board, int row, int col){
        int n = board.length;
        int m = board[0].length;
        int[][] dir = {{0,-1}, {-1,0}, {-1,-1}, {-1,1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}};
        
        for(int[] d : dir){
            int r = row, c = col;
            
            while(r >= 0 && r < n && c >= 0 && c < m){
                if(board[r][c]){
                    return false;
                }
                r += d[0];
                c += d[1];
            }
        }
        return true;
    }
    
    
    public static void nQueenCombinationsUnOptimize(boolean[][] board, int tq, int row, int col, String ans){
        if(tq == 0){
            System.out.println(ans);
            return;
        }
        
        if(col == board[0].length){
            row++;
            col = 0;
        }
        
        if(row==board.length)   return;
        
        if(isSafeToPlace(board, row, col)){
            board[row][col] = true;
            nQueenCombinationsUnOptimize(board, tq - 1, row, col + 1, ans + "(" + row + "-" + col + ")" + " ");
            board[row][col] = false;
        }
        nQueenCombinationsUnOptimize(board, tq, row, col + 1, ans);
    }
    
    
    public static void nQueenPermutationsUnOptmize(boolean[][] board, int tq, int row, int col, String ans){
        if(tq == 0){
            System.out.println(ans);
            return;
        }
        if(col == board[0].length){
            row++;
            col = 0;
        }
        if(row == board.length){
            return;
        }
        
        if(isSafeToPlacePer(board, row, col)){
            board[row][col] = true;
            nQueenPermutationsUnOptmize(board, tq - 1, 0, 0, ans + "(" + row + "-" + col + ")" + " ");
            board[row][col] = false;
        }
        nQueenPermutationsUnOptmize(board, tq, row, col + 1, ans);
        
    }
    
    public static void nQueenCombinationsOptimizeSolution(boolean[][] board, int tq, int row, int col, String ans, boolean[] rowS, boolean[] colS, boolean[] nDia, boolean[] rDia){
        if(tq == 0){
			    System.out.println(ans);
			    return;
		    }

		    if(col == board[0].length){
			    row++;
			    col = 0;
		    }

		    if(row == board.length)	return;

		    if(!rows[row] && !cols[col] && !diag[row + col] && !adiag[row - col + board[0].length - 1]){
		  	    rows[row]= cols[col] = diag[row + col] = adiag[row - col + board[0].length - 1] = true;
			      nQueenCombinationsOptimizeSolution(board, tq - 1, row, col + 1, ans + "(" + row + ", " + col + ")", rowS, colS, nDia, rDia);
			      rows[row] = cols[col] = diag[row + col] = adiag[row - col + board[0].length - 1] = false;
		    }
		    nQueenCombinationsOptimizeSolution(board, tq, row, col+1, ans, rows, cols, diag, adiag);
    }
  
    public static int nqueens_perm(boolean[][] board, int tq, int row, int col, String ans, boolean[] rows, boolean[] cols, boolean[] diag, boolean[] adiag){
		
        if(tq == 0){
            System.out.println(ans);
            return 1;
        }

        if(col == board[0].length){
            row++;
            col = 0;
        }

        if(row == board.length)	return 0;

        int count = 0;
        if(!rows[row] && !cols[col] && !diag[row + col] && !adiag[row - col + board[0].length - 1]){
          rows[row] = cols[col] = diag[row + col] = adiag[row - col + board[0].length - 1] = true;
          count += nqueens_perm(board, tq - 1, 0, 0, ans + "(" + row + ", " + col +")", rows, cols, diag, adiag);
          rows[row] = cols[col] = diag[row + col] = adiag[row - col + board[0].length - 1] = false;
        }

        count+=nqueens_perm(board, tq, row, col+1, ans, rows, cols, diag, adiag);
        return count;
	}
    
}







//  Nqueen Branch and bound

import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    boolean[][] board = new boolean[n][n];
    boolean[] cols = new boolean[n];
    boolean[] ndia = new boolean[2 * n - 1];
    boolean[] rdia = new boolean[2 * n - 1];
    solve(board, 0, cols, ndia, rdia, "");
  }
  
  public static void solve(boolean[][] board, int row, boolean[] cols, boolean[] ndia, boolean[] rdia, String asf){
      int n = board.length;
      if(row == n){
          System.out.println(asf + ".");
          return;
      }
      
      for(int col = 0; col < n; col++){
          if(!cols[col] && !ndia[row + col] && !rdia[row - col + n - 1]){
              board[row][col] = true;
              cols[col] = true;
              ndia[row + col] = true;
              rdia[row - col + n - 1] = true;
              solve(board, row + 1, cols, ndia, rdia, asf + row + "-" + col + ", ");
              board[row][col] = false;
              cols[col] = false;
              ndia[row + col] = false;
              rdia[row - col + n - 1] = false;
              
          }
      }
  }

}

// leetcode 52
  
class Solution {
    public int totalNQueens(int n) {
        boolean[][] board = new boolean[n][n];
        boolean[] cols = new boolean[n];
        boolean[] ndia = new boolean[2 * n - 1];
        boolean[] rdia = new boolean[2 * n - 1];
        int ans = solve(board, 0, cols, ndia, rdia, "");
        return ans;
    }
    public int solve(boolean[][] board, int row, boolean[] cols, boolean[] ndia, boolean[] rdia, String asf){
      int n = board.length;
      if(row == n){
          return 1;
      }
      int count = 0;
      for(int col = 0; col < n; col++){
          if(!cols[col] && !ndia[row + col] && !rdia[row - col + n - 1]){
              board[row][col] = true;
              cols[col] = true;
              ndia[row + col] = true;
              rdia[row - col + n - 1] = true;
              count += solve(board, row + 1, cols, ndia, rdia, asf + row + "-" + col + ", ");
              board[row][col] = false;
              cols[col] = false;
              ndia[row + col] = false;
              rdia[row - col + n - 1] = false;
              
          }
      }
        return count;
  }
}
