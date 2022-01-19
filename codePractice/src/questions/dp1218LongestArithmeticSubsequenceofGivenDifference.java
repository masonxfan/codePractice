package questions;

public class dp1218LongestArithmeticSubsequenceofGivenDifference {
    public int longestSubsequence(int[] arr, int difference) {
        int n = arr.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        Map<Integer, Integer> map = new HashMap();
        int ans = 0;
        for(int i = 0; i < n; i++){
            int former = arr[i] - difference;
            if(map.containsKey(former)){
                dp[i] = Math.max(dp[map.get(former)] + 1, dp[i]);
            }
            map.put(arr[i], i);
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}
