package questions;

public class stack388LongestAbsoluteFilePath {
	 public int lengthLongestPath(String input) {
	        int longest = 0;
	        int curlen = 0;
	        Stack<Pair<String,Integer>> stack = new Stack<>();
	        String[] map = input.split("\n");
	        for(String dir : map){
	            int level = 0;
	            while(dir.startsWith("\t")){
	                dir = dir.substring(1);
	                level++;
	            }
	            int len = dir.length();
	            while(stack.size() > level){
	                stack.pop();
	            }
	            int totallen = len;
	            if(!stack.isEmpty()) totallen += stack.peek().getValue() + 1;
	            if(dir.contains(".")) longest = Math.max(totallen, longest);
	            stack.add(new Pair(dir, totallen));
	        }
	        return longest;
	    }
}
