package questions;

public class binary74Searcha2DMatrix {
	  public boolean searchMatrix(int[][] matrix, int target) {
	        int n = matrix.length;
	        int m = matrix[0].length;
	        int x = n - 1;
	        int y = 0;
	        while(x >= 0 && y < m){
	            if(matrix[x][y] == target) return true;
	            else if(matrix[x][y] > target) x--;
	            else if(matrix[x][y] < target) y++;
	        }
	        return false;
	    }
}
