package questions;

public class twopointer2149RearrangeArrayElementsbySign {
    public int[] rearrangeArray(int[] nums) {
        int n = nums.length;
        int[] negative = new int[n / 2];
        int[] positive = new int[n / 2];
        int idxn = 0, idxp = 0;
        for(int i = 0; i < n; i++){
            if(nums[i] < 0) negative[idxn++] = nums[i];
            if(nums[i] > 0) positive[idxp++] = nums[i];
        }
        int[] ans = new int[n];
        for(int i = 0; i < n / 2; i++){
            ans[2 * i] = positive[i];
            ans[2 * i + 1] = negative[i];
        }
        return ans;
    }
}
