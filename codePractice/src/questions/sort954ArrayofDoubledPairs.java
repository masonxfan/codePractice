package questions;

public class sort954ArrayofDoubledPairs {
	 public boolean canReorderDoubled(int[] arr) {
	        Queue<Integer> q = new LinkedList();
	        Arrays.sort(arr);
	        for(int i = 0; i < arr.length && arr[i] <= 0; i++){
	            int multi2 = 2 * arr[i];
	            if(!q.isEmpty() && q.peek() == multi2){
	                q.poll();
	            }else{
	                q.add(arr[i]);
	            }
	        }
	        if(q.size() != 0) return false;
	        for(int i = arr.length - 1; i >= 0 && arr[i] > 0; i--){
	            int multi2 = 2 * arr[i];
	            if(!q.isEmpty() && q.peek() == multi2){
	                q.poll();
	            }else{
	                q.add(arr[i]);
	            }
	        }
	        return q.size() == 0;
	    }
}
