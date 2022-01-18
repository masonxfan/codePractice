package questions;

public class slidingwindow1610MaximumNumberofVisiblePoints {
	   public int visiblePoints(List<List<Integer>> points, int angle, List<Integer> location) {
	        int same = 0;
	        List<Double> angles = new ArrayList();
	        for(List<Integer> point : points){
	            double deltax = point.get(0) - location.get(0);
	            double deltay = point.get(1) - location.get(1);
	            if(deltax == 0 && deltay == 0) same++;
	            else angles.add(getAngle(deltax, deltay));
	        }
	        if(angles.size() == 0) return same;
	        Collections.sort(angles);
	        double from = angles.get(0);
	        double to = from + angle;
	        int start = 0;
	        int max = 0;
	        int ans = 0;
	        
	        for(int i = 0; i < angles.size(); i++){
	            if(angles.get(i) < angle){
	                angles.add(angles.get(i) + 360);
	            }else{
	                break;
	            }
	        }
	        
	        for(int i = 0; i < angles.size(); i++){
	            //System.out.println(angles.get(i));
	            while(angles.get(i) > to && angles.get(i) - angles.get(start) > angle){
	                start++;
	                max--;
	                to = angles.get(start) + angle;
	                //System.out.println("to:" + to);
	            }
	            if(angles.get(i) <= to){
	                max++;
	            }
	            //System.out.println(max);
	            ans = Math.max(max, ans);
	        }
	        return ans + same;
	    }
	    
	    public double getAngle(double deltax, double deltay){
	        return ((Math.atan2(deltay, deltax) / Math.PI) + 1) * 180;
	    }
}
