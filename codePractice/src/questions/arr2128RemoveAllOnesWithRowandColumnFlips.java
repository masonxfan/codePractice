package questions;

public class arr2128RemoveAllOnesWithRowandColumnFlips {
    public boolean removeOnes(int[][] grid) {
        int m = grid.length;
        int n= grid[0].length;
        for(int i = 0; i < n; i++){
            if(grid[0][i] == 1){
                for(int j = 0; j < m; j++){
                    grid[j][i] = grid[j][i] == 1 ? 0 : 1;
                }
            }
        }
        for(int i = 1; i < m; i++){
            int sum = 0;
            for(int j = 0; j < n; j++){
                sum += grid[i][j];
            }
            if(sum != 0 && sum != n) return false;
        }
        return true;
    }
}
