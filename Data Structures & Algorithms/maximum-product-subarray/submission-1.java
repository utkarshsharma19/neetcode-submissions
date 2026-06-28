class Solution {
    public int maxProduct(int[] nums) {
        int res = nums[0];
        int curMin = 1;
       int curMax = 1;
        for(int num: nums) {
            int temp = curMax * num;
            curMax = Math.max(Math.max(num * curMax, num * curMin), num);
            curMin = Math.min(Math.min(temp, num * curMin), num);
            res = Math.max(res, curMax);
        }

        return res;
    }
}
