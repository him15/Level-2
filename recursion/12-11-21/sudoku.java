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
public static int nqueens_perm(boolean[][] board, int tq, int row, int col, String ans, boolean[] rows, boolean[] cols, boolean[] diag, boolean[] adiag){
		
		if(tq==0){
			System.out.println(ans);
			return 1;
		}

		if(col==board[0].length){
			row++;
			col=0;
		}

		if(row==board.length)	return 0;

		int count=0;
		if(!rows[row] && !cols[col] && !diag[row+col] && !adiag[row-col+board[0].length-1]){
			rows[row]=cols[col]=diag[row+col]=adiag[row-col+board[0].length-1]=true;
			count+=nqueens_perm(board, tq-1, 0, 0, ans+"("+row+", "+col+")", rows, cols, diag, adiag);
			rows[row]=cols[col]=diag[row+col]=adiag[row-col+board[0].length-1]=false;
		}
		
		count+=nqueens_perm(board, tq, row, col+1, ans, rows, cols, diag, adiag);
		return count;
	}

