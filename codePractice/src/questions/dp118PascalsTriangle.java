package questions;

public class dp118PascalsTriangle {
	 public List<List<Integer>> generate(int numRows) {
	        int[][] dp = new int[numRows][numRows];
	        List<List<Integer>> res = new ArrayList();
	        for(int i = 0; i < numRows; i++){
	            dp[0][i] = 1;
	            dp[i][0] = 1;
	            res.add(new ArrayList());
	        }
	        
	        for(int i = 0; i < numRows; i++){
	            for(int j = 0; j < numRows - i; j++){
	                if(i != 0 && j != 0) dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
	                res.get(i + j).add(dp[i][j]);
	            }
	        }
	        return res;
	    }
}
