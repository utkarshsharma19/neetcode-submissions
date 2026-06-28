class Solution {
    public int maxSubArray(int[] nums) {
        if(nums.length == 1) {
            return nums[0];
        }
        int curMax = 0;
        int max = nums[0];

        for(int i = 0; i < nums.length; i++) {
            if(curMax < 0) {
                curMax = 0;
            }
            curMax += nums[i];
            max = Math.max(curMax, max);
        }

        return max;
    }
}
