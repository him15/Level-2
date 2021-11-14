// bit solution
// import java.io.*;
import java.util.*;


    public class Main {         
    
    public static class pair{
        int row;
        int col;
        public pair(int row, int col){
            this.row = row;
            this.col = col;
        }
    }
    public static void display(int[][] board){
        for(int i = 0; i < board.length; i++){
        for(int j = 0; j < board[0].length; j++){
            System.out.print(board[i][j] + " ");
        }
        System.out.println();
    }
  }

  public static boolean sudokuSolver(int[][] arr, int idx, ArrayList<pair> cells, int[] rows, int[] cols, int[][] mat){
      if(idx == cells.size()){
          return true;
      }
      int r = cells.get(idx).row;
      int c = cells.get(idx).col;
    //   for(int num = 1; num <= 9; num++){
    //       if(!rows[r][num] && !cols[c][num] && !mat[r / 3][c / 3][num]){
    //           arr[r][c] = num;
    //           rows[r][num] = cols[c][num] = mat[r / 3][c / 3][num] = true;
    //           if(sudokuSolver(arr, idx + 1, cells, rows, cols, mat)){
    //               return true;
    //           }
              
    //           rows[r][num] = cols[c][num] = mat[r / 3][c / 3][num] = false;
    //       }
    //   }
    //   return false;
    for(int num = 1; num <= 9; num++){
        int mask = (1 << num);
        if((rows[r] & mask) == 0 && (cols[c] & mask) == 0 && (mat[r/ 3][c / 3] & mask) == 0){
            arr[r][c] = num;
            rows[r] ^= mask;
            cols[c] ^= mask;
            mat[r / 3][c / 3] ^= mask;
            if(sudokuSolver(arr, idx + 1, cells, rows, cols, mat)){
                return true;
            }
            arr[r][c] = 0;
            rows[r] ^= mask;
            cols[c] ^= mask;
            mat[r / 3][c / 3] ^= mask;
        }
    }
    return false;
  }

  public static void solveSudoku(int[][] board) {
      ArrayList<pair> cells = new ArrayList<>();
    //   boolean[][] rows = new boolean[9][10];
    //   boolean[][] cols = new boolean[9][10];
    //   boolean[][][] mat = new boolean[3][3][10];
        int[] rows = new int[10];
        int[] cols = new int[10];
        int[][] mat = new int[3][3];

      for(int i = 0; i < 9; i++){
          for(int j = 0; j < 9; j++){
              if(board[i][j] == 0){
                  cells.add(new pair(i, j));
              }else{
                  int num = board[i][j];
                  int mask = (1 << num);
                  rows[i] ^= mask;
                  cols[j] ^= mask;
                  mat[i / 3][j / 3] ^= mask;
              }
          }
      }

      sudokuSolver(board, 0, cells, rows,cols, mat);
      display(board);
  }

  public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    int[][] arr = new int[9][9];
    for (int i = 0; i < 9; i++) {
      for (int j = 0; j < 9; j++) {
        arr[i][j] = scn.nextInt();
      }
    }

    solveSudoku(arr);
  }
}











class Solution {
//     public boolean isSafeToPlace(char[][] board, int num, int r, int c) {
		
// 		for(int j = 0; j < 9; ++j) {
// 			if(board[r][j] - '0' == num) {
// 				return false;
// 			}
// 		}
		
// 		for(int i = 0; i < 9; i++) {
// 			if(board[i][c] - '0' == num) {
// 				return false;
// 			}
// 		}
		
// 		r = ( r / 3 ) * 3;
// 		c = ( c / 3 ) * 3;
		
// 		for(int i = 0; i < 3; i++) {
// 			for(int j = 0; j < 3; j++) {
// 				if(board[ r + i ][ c + j ] - '0' == num) {
// 					return false;
// 				}
// 			}
// 		}
		
// 		return true;
// 	}
    
    public boolean solveSudoku(char[][] board, int idx, ArrayList<Integer> cells, boolean[][] rows, boolean[][] cols, boolean[][][] mat){
        if(idx == cells.size()){
            return true;
        }
        
        int r = cells.get(idx) / 9 , c = cells.get(idx) % 9;
        
        for(int num = 1; num <= 9; num++){
            if(!rows[r][num] && !cols[c][num] && !mat[r / 3][c / 3][num]){
                board[r][c] = (char)('0' + num);
                rows[r][num] = cols[c][num] = mat[r / 3][c / 3][num] = true;
                if(solveSudoku(board, idx + 1, cells, rows, cols, mat)){
                    return true;
                }
                
                board[r][c] = '.';
                rows[r][num] = cols[c][num] = mat[r / 3][c / 3][num] = false;
            }
        }
        
        return false;
        
    }
    
    public void solveSudoku(char[][] board){
        ArrayList<Integer> cells = new ArrayList<>();
        boolean[][] rows = new boolean[9][10];
        boolean[][] cols = new boolean[9][10];
        boolean[][][] mat = new boolean[3][3][10];
        
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(board[i][j] == '.'){
                    cells.add( i * 9 + j );
                }else{
                    int num = board[i][j] -'0';
                    rows[i][num] = true;
                    cols[j][num] = true;
                    mat[i / 3][j/ 3][num] = true;
                }
            }
        }
        
        
        
        solveSudoku(board, 0, cells, rows, cols, mat);
    }
}
