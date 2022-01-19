package questions;

public class dp727MinimumWindowSubsequence {
	  
    int m = s1.length();
    int n = s2.length();
    
    int[][] dp = new int[n][m];
    
    for(int[] row: dp)Arrays.fill(row, -1);
    
    for(int i=0; i<m ; i++){
        if(s1.charAt(i) == s2.charAt(0))
            dp[0][i] = 1;
        else if(i>0 && dp[0][i-1]!=-1 )  dp[0][i] = 1+ dp[0][i-1];
    }
    
    for(int i =1; i< n; i++){
        for(int j =1; j<m; j++){
            
            if(s1.charAt(j) == s2.charAt(i) && dp[i-1][j-1]!=-1){
                dp[i][j] = 1 + dp[i-1][j-1];
            }else if(dp[i][j-1] !=-1) dp[i][j] = 1+dp[i][j-1];
        }
    }
    
    int minLength = Integer.MAX_VALUE;
    String result = "";
    
    for(int i =0 ; i< m ; i++){
        if(dp[n-1][i] != -1 && dp[n-1][i] < minLength){
            minLength = dp[n-1][i];
            result = s1.substring(i - dp[n-1][i] +1 , i+1);
        }
    }
    
    return result;
}
}
