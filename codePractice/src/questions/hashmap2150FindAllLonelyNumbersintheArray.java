package questions;

public class hashmap2150FindAllLonelyNumbersintheArray {
    public List<Integer> findLonely(int[] nums) {
        Map<Integer, Integer> map = new HashMap();
        for(int i = 0; i < nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        List<Integer> res = new ArrayList();
        for(int i = 0; i < nums.length; i++){
            if(map.get(nums[i]) == 1 && !map.containsKey(nums[i] - 1) && !map.containsKey(nums[i] + 1)) res.add(nums[i]);
        }
        return res;
    }
}
