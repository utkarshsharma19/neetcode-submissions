class Solution {
    Integer[][] memo;

    public int maxProfit(int[] prices) {
        memo = new Integer[prices.length][2];
        return dfs(prices, 0, 1);
    }

    private int dfs(int[] prices, int index, int canBuy) {
        if (index == prices.length) {
            return 0;
        }

        if (memo[index][canBuy] != null) {
            return memo[index][canBuy];
        }

        int skip = dfs(prices, index + 1, canBuy);
        int ans;

        if (canBuy == 1) {
            int buy = -prices[index] + dfs(prices, index + 1, 0);
            ans = Math.max(buy, skip);
        } else {
            int sell = prices[index];
            ans = Math.max(sell, skip);
        }

        memo[index][canBuy] = ans;
        return ans;
    }
}