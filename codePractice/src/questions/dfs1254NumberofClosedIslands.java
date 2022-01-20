package questions;

public class dfs1254NumberofClosedIslands {
	public int closedIsland(int[][] grid) {
        int count = 0;
        for(int i = 0; i < grid.length; i++)
            for(int j = 0; j < grid[0].length; j++)
                if(grid[i][j] == 0)
                    if(dfs(grid, i, j))
                        count++;
        return count;
    }
    
    public boolean dfs(int[][] grid, int r, int c){
        if(r < 0 || c < 0 || r >= grid.length || c >= grid[0].length)
            return false;
        if(grid[r][c] == 1)
            return true;
        grid[r][c] = 1;
        boolean a = dfs(grid, r + 1, c);
        boolean b = (dfs(grid, r - 1, c));
        boolean x = (dfs(grid, r, c + 1));
        boolean y = (dfs(grid, r, c - 1));
        return ((a && b) && (x && y));
    }
}
