package questions;

public class hashmap2007FindOriginalArrayFromDoubledArray {
	public int[] findOriginalArray(int[] changed) {
        if(changed.length%2 == 1) return new int[]{};
        int zero = 0;
        for(int c:changed) {
            if(c == 0) zero++;
        }
        if(zero%2!=0) return new int[]{};

        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int c: changed) {
            map.put(c, map.getOrDefault(c,0)+1); // counting the freq of each element
        }
        List<Integer> map_list = new ArrayList<>(map.keySet());
        Collections.sort(map_list);
        for(int i: map_list ){
            // the freq of the smallest number cannot be greater than the freq of the number which is double of it
            if(map.get(i) > map.getOrDefault(i * 2,0))
                return new int[]{};
            for(int j = 0; j < map.get(i); j++) {
                list.add(i);
                map.merge(i*2, -1, Integer::sum);
            }
        }
        int[] ans = list.stream().mapToInt(i->i).toArray();
        return ans;
    }
}
