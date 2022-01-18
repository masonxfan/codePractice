package questions;

public class hashmap792NumberofMatchingSubsequences {
    Map<Character, List<Integer>> map = new HashMap();
    public int numMatchingSubseq(String s, String[] words) {
        int ans = 0;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(map.containsKey(c)){
                List<Integer> list = map.get(c);
                list.add(i);
                map.put(c, list);
            }else{
                List<Integer> list = new ArrayList();
                list.add(i);
                map.put(c, list);
            }
        }
        for(String word : words){
            if(isSub(word)) ans++;
        }
        return ans;
    }
    
    public boolean isSub(String word){
        int latest = -1;
        for(int i = 0; i < word.length(); i++){
            int former = latest;
            char c = word.charAt(i);
            if(!map.containsKey(c)) return false;
            List<Integer> list = map.get(c);
            for(int next : list){
                if(next > latest){
                    latest = next;
                    break;
                }
            }
            if(former == latest) return false;
        }
        return true;
    }
}
