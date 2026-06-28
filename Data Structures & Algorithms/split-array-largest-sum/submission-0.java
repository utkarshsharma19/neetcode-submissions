
class Solution {
    HashMap<String, Integer> map;

    public int splitArray(int[] nums, int k) {
        map = new HashMap<>();
        return splitArrayHelper(nums, k, 0);
    }

    public int splitArrayHelper(int[] nums, int k, int i) {
        String key = i + "," + k;
        if (map.containsKey(key)) {
            return map.get(key);
        }

        // If only 1 subarray left, take all remaining elements
        if (k == 1) {
            int sum = 0;
            for (int idx = i; idx < nums.length; idx++) {
                sum += nums[idx];
            }
            return sum;
        }

        int currSum = 0;
        int ans = Integer.MAX_VALUE;

        // j is where the first split ends
        // need to leave at least (k - 1) elements for remaining groups
        for (int j = i; j <= nums.length - k; j++) {
            currSum += nums[j];

            int next = splitArrayHelper(nums, k - 1, j + 1);
            int largest = Math.max(currSum, next);

            ans = Math.min(ans, largest);
        }

        map.put(key, ans);
        return ans;
    }
}