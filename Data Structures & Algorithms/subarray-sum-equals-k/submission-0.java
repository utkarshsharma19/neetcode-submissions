class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        int res = 0;
        int prefixSum = 0;
        for(int i = 0; i < nums.length; i++) {
             prefixSum += nums[i];
            int diff = prefixSum - k;
            res += map.getOrDefault(diff, 0);
            map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
        }

        return res;
    }
}