package questions;

public class dp1937MaximumNumberofPointswithCost {
	public long maxPoints(int[][] points) {

	    long[] tempRowPoints = new long [points[0].length];
	    long result = 0;
	    
	    for(int i=0; i< points.length; i++) {
	        for(int j=0; j<points[0].length; j++) {
	            tempRowPoints[j] += points[i][j];
	        }
	        for(int j = 1; j < points[0].length; j++) {
	            tempRowPoints[j] = Math.max(tempRowPoints[j], tempRowPoints[j-1] - 1);
	        }
	        
	        for(int j = points[0].length-2; j >= 0; j--) {
	           tempRowPoints[j] = Math.max(tempRowPoints[j], tempRowPoints[j+1] - 1); 
	        }
	    }
	    for(int k = 0; k<tempRowPoints.length; k++) {
	        result = Math.max(tempRowPoints[k], result);
	    }
	    return result;
	}
}
