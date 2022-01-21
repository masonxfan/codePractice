package questions;

public class dfs529Minesweeper {
	int m, n;
    char[][] updated;
    public char[][] updateBoard(char[][] board, int[] click) {
        m = board.length;
        n = board[0].length;
        updated = board;
        dfs(click);
        return updated;
        
    }
    
    public void dfs(int[] click){
        int r = click[0];
        int c = click[1];
        if(updated[r][c] == 'M'){
            updated[r][c] = 'X';
            return;
        }
        if(updated[r][c] == 'E'){
            if(adjacentMines(click) == '0'){
                updated[r][c] = 'B';
                retrieveNext(click);
            } 
            else updated[r][c] = adjacentMines(click);
        }
    }
    
    public void retrieveNext(int[] click){
        int r = click[0];
        int c = click[1];
        for(int i = r == 0 ? 0 : r - 1; i <= r + 1 && i < m; i++){
            for(int j = c == 0 ? 0 : c - 1; j <= c + 1 && j < n; j++){
                dfs(new int[] {i,j});
            }
        }
    }
    
    
    public char adjacentMines(int[] click){
        int r = click[0];
        int c = click[1];
        char count = '0';
        for(int i = r == 0 ? 0 : r - 1; i <= r + 1 && i < m; i++){
            for(int j = c == 0 ? 0 : c - 1; j <= c + 1 && j < n; j++){
                if(updated[i][j] == 'M') count++;
                //System.out.println(updated[i][j] + " " + count);
            }
        }
        return (char) count;
    }
}
