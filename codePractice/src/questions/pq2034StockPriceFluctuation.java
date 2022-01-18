package questions;

public class pq2034StockPriceFluctuation {
	  PriorityQueue<Pair<Integer,Integer>> maxQueue=null;
	    PriorityQueue<Pair<Integer,Integer>> minQueue=null;
	    Map<Integer,Integer> map=null;
	    int lastestTimeStamp=0;
	    public StockPrice() {
	     maxQueue = new PriorityQueue<Pair<Integer,Integer>>((p1,p2) ->
	                                                         p2.getValue()-p1.getValue());
	         minQueue = new PriorityQueue<Pair<Integer,Integer>>((p1,p2)->
	                                                         p1.getValue()-p2.getValue()); 
	        map = new HashMap();
	    }
	    
	    public void update(int timestamp, int price) {
	        lastestTimeStamp = Math.max(lastestTimeStamp,timestamp);
	        map.put(timestamp,price);
	        maxQueue.add(new Pair<Integer,Integer>(timestamp,price));
	        minQueue.add(new Pair<Integer,Integer>(timestamp,price));

	    }
	    
	    public int current() {
	        return map.get(lastestTimeStamp);
	    }
	    
	    public int maximum() {
	     
	        while(!map.get(maxQueue.peek().getKey()).equals(maxQueue.peek().getValue())){
	          maxQueue.poll();  
	        }
	        return maxQueue.peek().getValue();
	    }
	    
	    public int minimum() {
	      while(!map.get(minQueue.peek().getKey()).equals(minQueue.peek().getValue())){
	          minQueue.poll();  
	        }
	        return minQueue.peek().getValue();   
	    }
}
