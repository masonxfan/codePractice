package questions;

public class hashmap159LoggerRateLimiter {
    Map<String, Integer> map;
    public Logger() {
        map = new HashMap();
        
    }
    
    public boolean shouldPrintMessage(int timestamp, String message) {
        if(!map.containsKey(message)){
            map.put(message, timestamp);
            return true;
        }else{
            if(map.get(message) + 10 <= timestamp){
                map.put(message, timestamp);
                return true;
            }else{
                return false;
            }
        }
    }
}
