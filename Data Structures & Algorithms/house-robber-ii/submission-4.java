class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        Integer[] memo1 = new Integer[n];
        Integer[] memo2 = new Integer[n];

        return Math.max(robHelper(nums, 0, n - 2, memo1), robHelper(nums, 1, n - 1, memo2));

    }

    private int robHelper(int [] nums, int index, int end, Integer[] memo) {
        if( index > end )  {
            return 0;
        }
        if(memo[index] != null) {
            return memo[index];
        }
        memo[index] = Math.max(robHelper(nums, index + 1, end, memo), nums[index] + robHelper( nums, index + 2, end, memo ));

        return memo[index];
    }
}
