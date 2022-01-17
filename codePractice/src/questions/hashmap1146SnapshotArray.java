package questions;

public class hashmap1146SnapshotArray {

    int snap_id;
    List<Map<Integer, Integer>> delta;
    int[] arr;
    public SnapshotArray(int length) {
        arr = new int[length];
        snap_id = 0;
        delta = new ArrayList<>();
        //delta has zero size till now, create one entry
        delta.add(new HashMap<>());
    }
    
    public void set(int index, int val) {
        delta.get(snap_id).put(index, val);
    }
    
    public int snap() {
        delta.add(new HashMap<>());
        return snap_id++;
    }
    
    public int get(int index, int snap_id) {
        for(int i=snap_id; i>=0; i--){
            if(delta.get(i).containsKey(index))return delta.get(i).get(index);
        }
        return 0; //no change found in all prev snapIds as well, must be 0
    }
}
}
