package questions;

public class dfs130SurroundedRegions {
	   char[][] board;
	    int m, n;
	    public void solve(char[][] board) {
	        this.board = board;
	        this.m = board.length;
	        this.n = board[0].length;
	        for(int i = 0; i < m; i++){
	            if(board[i][0] == 'O') dfs(i, 0);
	            if(board[i][n - 1] == 'O') dfs(i, n - 1);
	        }
	        for(int i = 0; i < n; i++){
	            if(board[0][i] == 'O') dfs(0, i);
	            if(board[m - 1][i] == 'O') dfs(m - 1, i);
	        }
	        
	        for(int i = 0; i < m; i++){
	            for(int j = 0; j < n; j++){
	                if(board[i][j] == 'O') board[i][j] = 'X';
	                if(board[i][j] == 'E') board[i][j] = 'O';
	            }
	        }
	    }
	    
	    public void dfs(int x, int y){
	        if(board[x][y] != 'O') return;
	        board[x][y] = 'E';
	        if(x > 0) dfs(x - 1, y);
	        if(x < m - 1) dfs(x + 1, y);
	        if(y > 0) dfs(x, y - 1);
	        if(y < n - 1) dfs(x, y + 1);
	    }
}
