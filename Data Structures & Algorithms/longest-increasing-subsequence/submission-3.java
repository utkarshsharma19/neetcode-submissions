class Solution {
    int [][] memo;
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        memo = new int[n][n+1];
        for(int [] row: memo) {
            Arrays.fill(row, -1);
        }
    return dfs(0,-1,nums);
    }

    private int dfs(int current, int parent, int [] nums) {
        if(current==nums.length) {
            return 0;
        }

        if(memo[current][parent + 1] != -1) {
            return memo[current][parent + 1];
        }

        int LIS = dfs(current + 1, parent, nums);

        if( parent == -1 || nums[parent] < nums[current] ) {
            LIS = Math.max(LIS, 1 + dfs(current + 1, current, nums));
        }
        memo[current][parent + 1] = LIS;
        return LIS;
     }
}
