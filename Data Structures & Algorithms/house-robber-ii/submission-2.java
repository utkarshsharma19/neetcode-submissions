class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];

        Integer[] memo1 = new Integer[n];
        Integer[] memo2 = new Integer[n];

        return Math.max(dfs(0, n - 2, nums, memo1),
                        dfs(1, n - 1, nums, memo2));
    }

    private int dfs(int i, int end, int[] nums, Integer[] memo) {
        if (i > end) return 0;
        if (memo[i] != null) return memo[i];

        memo[i] = Math.max(dfs(i + 1, end, nums, memo),
                           nums[i] + dfs(i + 2, end, nums, memo));
        return memo[i];
    }
}