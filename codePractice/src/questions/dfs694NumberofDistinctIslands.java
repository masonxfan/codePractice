package questions;

public class dfs694NumberofDistinctIslands {
	 Set<String> set = new HashSet();
	    int[][] grid;
	    int m, n;
	    public int numDistinctIslands(int[][] grid) {
	        this.grid = grid;
	        this.m = grid.length;
	        this.n = grid[0].length;
	        
	        for(int i = 0; i < m; i++){
	            for(int j = 0; j < n; j++){
	                if(grid[i][j] == 1){
	                    List<int[]> comb = new ArrayList();
	                    findIsland(i, j, i, j, comb);
	                    String key = shape(comb);
	                    set.add(key);
	                }
	            }
	        }
	        return set.size();
	        
	    }
	    
	    public void findIsland(int i, int j, int x, int y, List<int[]> comb){
	        if(grid[x][y] == 1){
	            grid[x][y] = 2;
	            comb.add(new int[] {x - i, y - j});
	            if(x > 0)  findIsland(i, j, x - 1, y, comb);
	            if(x < m - 1)  findIsland(i, j, x + 1, y, comb);
	            if(y > 0)  findIsland(i, j, x, y - 1, comb);
	            if(y < n - 1)  findIsland(i, j, x, y + 1, comb);
	        }
	    }
	    
	    public String shape(List<int[]> comb){
	        String res = "";
	        for(int[] cur : comb){
	           res += cur[0] + "-" + cur[1] + ".";
	        }
	        return res;
	    }
}
