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
