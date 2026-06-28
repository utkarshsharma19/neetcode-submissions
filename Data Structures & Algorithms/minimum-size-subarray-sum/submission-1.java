class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int right = 0;
        int left = 0;
        int sum = 0;
        int minLen = Integer.MAX_VALUE;
        HashMap<Integer, Integer> map = new HashMap<>();
        while(right < nums.length) {
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