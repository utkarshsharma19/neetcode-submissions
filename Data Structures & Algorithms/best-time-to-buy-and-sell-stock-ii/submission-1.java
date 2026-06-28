class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        for (int i = 0; i < n; i++) {
            dp[i][0] = -1;
            dp[i][1] = -1;
        }

        return maxProfitHelper(prices, 0, dp, 0);
    }

    private int maxProfitHelper(int[] prices, int buy, int [][] memo, int index) {
        
        if(index == prices.length) {
            return 0;
        }
        if(memo[index][buy] != -1) {
            return memo[index][buy];
        }
        int profit = maxProfitHelper(prices, buy, memo, index + 1);
        if(buy == 0) {
          profit = Math.max(profit, -prices[index] + maxProfitHelper(prices, 1, memo, index + 1)); 
        } else {
           profit = Math.max(profit, prices[index] + maxProfitHelper(prices,0, memo, index + 1));
        }

        memo[index][buy] = profit;
    return profit;
    }
}