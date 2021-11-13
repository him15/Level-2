import java.util.*;

public class Main {

public boolean isSafeToPlace(char[][] board, int num, int r, int c) {
		
		for(int j = 0; j < 9; ++j) {
			if(board[r][j] - '0' == num) {
				return false;
			}
		}
		
		for(int i = 1; i <= 9; i++) {
			if(board[i][c] - '0' == num) {
				return false;
			}
		}
		
		r = ( r / 3 ) * 3;
		c = ( c / 3 ) * 3;
		
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				if(board[ r + i ][ c + j ] - '0' == num) {
					return false;
				}
			}
		}
		
		return true;
	}
    
    public boolean solveSudoku(char[][] board, int idx, ArrayList<Integer> cells){
        if(idx == cells.size()){
            return true;
        }
        
        int r = cells.get(idx) / 9 , c = cells.get(idx) % 9;
        
        for(int num = 1; num <= 9; num++){
            if(isSafeToPlace(board, num, r, c)){
                board[r][c] = (char)('0' + num);
                if(solveSudoku(board, idx + 1, cells)){
                    return true;
                }
                board[r][c] = '.';
            }
        }
        
        return false;
        
    }
    
    public void solveSudoku(char[][] board){
        ArrayList<Integer> cells = new ArrayList<>();
        
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(board[i][j] == '.'){
                    cells.add( i * 9 + j );
                }
            }
        }
        
        solveSudoku(board, 0, cells);
    }
}


// leetcode 37
class Solution {
    
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
