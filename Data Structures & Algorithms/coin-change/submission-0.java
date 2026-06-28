class Solution {
    int[] dp;

    public int coinChange(int[] coins, int amount) {
        dp = new int[amount + 1];
        Arrays.fill(dp, -2); 
        int ans = dfs(coins, amount);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    private int dfs(int[] coins, int amount) {
        if (amount == 0) return 0;
        if (amount < 0) return Integer.MAX_VALUE;

        if (dp[amount] != -2) return dp[amount];

        int res = Integer.MAX_VALUE;

        for (int coin : coins) {
            int next = dfs(coins, amount - coin);
            if (next != Integer.MAX_VALUE) {
                res = Math.min(res, 1 + next);
            }
        }

        dp[amount] = res;
        return res;
    }
}