package questions;

public class twopointer777SwapAdjacentinLRString {
	 public boolean canTransform(String start, String end) {
		    
		    if (start.replace("X", "").length() != end.replace("X", "").length()) {
		      return false;
		    }
		    
		    int len = start.length();
		    int j = 0;
		    for (int i = 0; i < len; i++) {
		      
		      if (start.charAt(i) == 'L') {
		        // find the next 'L' position in "end"
		        while (j < len && end.charAt(j) != 'L') j += 1;
		                
		        // index of next 'L' in "end" > index of 'L' in "start", it's impossible to convert start to end.
		        // For example:
		        // start = "..L...."
		        // end   = "....L.."
		        if (j > i) return false;
		        
		        j += 1;
		      }       
		      
		      if (start.charAt(i) == 'R') {
		        // find the next 'R' position in "end"
		        while (j < len && end.charAt(j) != 'R') j += 1;
		        
		        // index of next 'R' in "end" < index of 'R' in "start", it's impossible to convert start to end.
		        // For example:
		        // start = "....R..."
		        // end   = "..R....."
		        if (j < i) return false;
		        
		        j += 1;
		      }      
		    }
		    
		    return true;
		  }
}
