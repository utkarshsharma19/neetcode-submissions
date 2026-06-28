class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int right = 0;
        int left = 0;
        int n = nums.length;
        int minLen = Integer.MAX_VALUE;
        int sum = 0;
        while(right < n) {
            sum += nums[right];
            while(sum >= target) {
                minLen = Math.min(right - left + 1, minLen);
                sum -= nums[left];
                left++;
            }
        right++;
        }

        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
}