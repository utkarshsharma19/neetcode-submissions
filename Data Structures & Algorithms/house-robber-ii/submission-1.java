class Solution {
    int[] dp1;
    int[] dp2;

    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        dp1 = new int[nums.length];
        dp2 = new int[nums.length];

        Arrays.fill(dp1, -1);
        Arrays.fill(dp2, -1);

        int case1 = dfs(nums, 0, nums.length - 2, dp1); // include 0, exclude last
        int case2 = dfs(nums, 1, nums.length - 1, dp2); // exclude 0, allow last

        return Math.max(case1, case2);
    }

    private int dfs(int[] nums, int i, int end, int[] dp) {
        if (i > end) {
            return 0;
        }

        if (dp[i] != -1) {
            return dp[i];
        }

        dp[i] = Math.max(
            dfs(nums, i + 1, end, dp),
            nums[i] + dfs(nums, i + 2, end, dp)
        );

        return dp[i];
    }
}